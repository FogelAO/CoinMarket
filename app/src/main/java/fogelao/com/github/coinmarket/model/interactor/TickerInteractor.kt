package fogelao.com.github.coinmarket.model.interactor

import fogelao.com.github.coinmarket.entity.api.TickerApi
import fogelao.com.github.coinmarket.entity.view.TickerView
import fogelao.com.github.coinmarket.model.repository.TickerRepository
import io.reactivex.Single
import javax.inject.Inject


class TickerInteractor @Inject constructor(private val tickerRepository: TickerRepository) {

    fun getAllTickers(): Single<List<TickerView>> = tickerRepository.getAllTickers()
            .map { t -> t.map { interactToView(it) } }

    fun refreshAllTickers(): Single<List<TickerView>> = tickerRepository.refreshAllTickers()
            .map { t -> t.map { interactToView(it) } }


    private fun interactToView(tickerApi: TickerApi): TickerView {
        val (_, id, name, symbol, rank, priceUsd, priceBtc, _, percentChange_24h) = tickerApi

        return TickerView(id, name, symbol, rank, priceUsd, priceBtc, percentChange_24h)
    }
}