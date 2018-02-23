package fogelao.com.github.coinmarket.model.repository

import fogelao.com.github.coinmarket.entity.api.HistoryItem
import fogelao.com.github.coinmarket.entity.api.TickerApi
import fogelao.com.github.coinmarket.entity.api.graph.GraphResponse
import fogelao.com.github.coinmarket.model.data.api.coinmarket.CoinMarketApi
import fogelao.com.github.coinmarket.model.data.api.coinmarket.GraphApi
import fogelao.com.github.coinmarket.model.data.api.hisapi.HistoryApi
import fogelao.com.github.coinmarket.model.data.storage.Prefs
import fogelao.com.github.coinmarket.model.data.storage.ticker.TickerDAO
import fogelao.com.github.coinmarket.model.system.SchedulersProvider
import io.reactivex.Observable
import io.reactivex.Single
import org.joda.time.DateTime
import org.joda.time.LocalDate
import javax.inject.Inject


class TickerRepository @Inject constructor(
        private val tickerApi: CoinMarketApi,
        private val historyApi: HistoryApi,
        private val graphApiApi: GraphApi,
        private val tickerDB: TickerDAO,
        private val prefs: Prefs,
        private val schedulers: SchedulersProvider
) {


    companion object {
        val TAG: String = TickerRepository::class.java.simpleName
    }

    private var date: DateTime? = null

    fun getAllTickers(): Single<List<TickerApi>> {

        return if (checkDate()) {
            //TODO: Запрос был сгодня => нужно взять данные из бд

            getAllTickersFromDB()

        } else {
            //TODO: Нужно сходить на бекенд и обновить дату.

            getAllTickersFromApi()
        }

    }

    fun refreshAllTickers(): Single<List<TickerApi>> = tickerApi.getAllTickers()
            .subscribeOn(schedulers.io())
            .doOnSuccess { saveToDBAndUpdateTime(it) }
            .observeOn(schedulers.ui())

    fun getHistory(symbolId: String, periodId: String, timeStart: String): Single<List<HistoryItem>> = historyApi.getHistory(symbolId, periodId, timeStart)
            .subscribeOn(schedulers.io())
            .observeOn(schedulers.ui())

    fun getGraphData(symbolId: String, start: Long, end: Long): Single<GraphResponse> = graphApiApi.getGraphData(symbolId, start, end)
            .subscribeOn(schedulers.io())
            .observeOn(schedulers.ui())

    private fun checkDate(): Boolean {
        if (date == null) {
            val tmp = prefs.lastUpdate
            if (tmp != 0L) {
                date = DateTime(tmp) //Устанавливаем новую дату из бд
            } else {
                return false //Нет записей о дате в дб
            }
        }

        if (LocalDate.now().compareTo(LocalDate(date)) == 0) {
            if (DateTime.now().hourOfDay() == date!!.hourOfDay())
                return true // Данные актуальны
        }

        return false
    }

    private fun saveToDBAndUpdateTime(tickerApis: List<TickerApi>) {
        tickerDB.deleteAll()
        tickerDB.saveAll(tickerApis)
        date = DateTime.now()
        prefs.lastUpdate = System.currentTimeMillis()

    }

    private fun getAllTickersFromApi() = tickerApi.getAllTickers()
            .subscribeOn(schedulers.io())
            .doOnSuccess { saveToDBAndUpdateTime(it) }
            .observeOn(schedulers.ui())

    private fun getAllTickersFromDB(): Single<List<TickerApi>> {
        val disk = tickerDB.getAllObservable()
                .subscribeOn(schedulers.io())
                .observeOn(schedulers.ui())
                .toObservable()

        val network = tickerApi.getAllTickers()
                .subscribeOn(schedulers.io())
                .observeOn(schedulers.ui())
                .toObservable()
                .doOnNext { data -> saveToDBAndUpdateTime(data) }

        return Observable.concat(disk, network).firstOrError()
    }


    fun test_getObservable() {
        val disk = tickerDB.getAllObservable().toObservable()
        val network = tickerApi.getAllTickers().toObservable()

        val source = Observable.concat(disk, network).firstOrError()

        val networkWithSave = network.doOnNext { data -> saveToDBAndUpdateTime(data) }

    }

}