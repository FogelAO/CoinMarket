package fogelao.com.github.coinmarket.presentation.ticker

import android.util.Log
import com.arellomobile.mvp.InjectViewState
import fogelao.com.github.coinmarket.di.DI
import fogelao.com.github.coinmarket.model.interactor.HistoryInteractor
import fogelao.com.github.coinmarket.presentation.global.BasePresenter
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat
import javax.inject.Inject


@InjectViewState
class TickerPresenter : BasePresenter<TickerView>() {
    companion object {
        val TAG = TickerPresenter::class.java.simpleName
    }

    @Inject
    lateinit var historyInteractor: HistoryInteractor

    lateinit var ticker: fogelao.com.github.coinmarket.entity.view.TickerView

    override fun onFirstViewAttach() {
        DI.componentManager().appComponent.inject(this)
    }

    fun getHistory(quoteId: String = "USD", periodId: String, timeStart: DateTime) {
        historyInteractor
                .getHistory(
                        getSymbolId(baseId = ticker.symbol),
                        periodId,
                        getTimeStart(timeStart)
                )
                .doOnSubscribe { viewState.showProgress(true) }
                .doAfterTerminate { viewState.showProgress(false) }
                .subscribe(
                        { viewState.showHistoryData(it) },
                        { viewState.showMessage(it.message ?: "Error"); Log.w(TAG, it) }
                )
                .connect()
    }

    fun refresh() {
        viewState.showRefreshing(false)
    }


    private fun getSymbolId(exchangeId: String = "BITSTAMP", baseId: String = "BTC", quoteId: String = "USD") =
            exchangeId + "_SPOT_" + baseId + "_" + quoteId


    private fun getTimeStart(timeStart: DateTime): String {
        val patternFormat = DateTimeFormat.forPattern("yyyy-MM-dd")

        return timeStart.toString(patternFormat)
    }

}