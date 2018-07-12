package fogelao.com.github.coinmarket.model.repository.coin

import fogelao.com.github.coinmarket.model.network.ChartApi
import fogelao.com.github.coinmarket.model.network.CoinApi
import fogelao.com.github.coinmarket.model.network.CoinmarketCapApi
import fogelao.com.github.coinmarket.model.network.entity.EntityResponse
import fogelao.com.github.coinmarket.model.network.entity.ListResponse
import fogelao.com.github.coinmarket.model.network.entity.chart.ChartResponse
import fogelao.com.github.coinmarket.model.network.entity.coin.Price
import fogelao.com.github.coinmarket.model.network.entity.market_cap.coin.MarketCapCoin
import fogelao.com.github.coinmarket.model.network.entity.social.SocialResponse
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * @author Fogel Artem on 14.05.2018.
 */
class CoinRepository @Inject constructor(
    private val api: CoinApi,
    private val coinMarketCap: CoinmarketCapApi,
    private val chartApi: ChartApi
) {

  fun getAll(currency: String): Single<List<MarketCapCoin>> = coinMarketCap.getAll(currency)
      .subscribeOn(Schedulers.io())
      .observeOn(AndroidSchedulers.mainThread())

  fun getChart(currency: String, timeStart: Long, timeEnd: Long): Single<ChartResponse> = chartApi.get(currency, timeStart, timeEnd)
      .subscribeOn(Schedulers.io())
      .observeOn(AndroidSchedulers.mainThread())

  fun getPrice(symbol: String, quote: String): Single<ListResponse<Price>> = api.getPrice(symbol, quote)
      .subscribeOn(Schedulers.io())
      .observeOn(AndroidSchedulers.mainThread())

  fun getSocial(id: Int): Single<EntityResponse<SocialResponse>> = api.getSocial(id)
      .subscribeOn(Schedulers.io())
      .observeOn(AndroidSchedulers.mainThread())

}