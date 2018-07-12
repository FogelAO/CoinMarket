package fogelao.com.github.coinmarket.model.network

import fogelao.com.github.coinmarket.model.network.entity.market_cap.coin.MarketCapCoin
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author Fogel Artem on 02-Jul-18.
 */
interface CoinmarketCapApi {
  companion object {
    const val BASE_URL = "https://api.coinmarketcap.com/"
  }

  @GET("v1/ticker/?limit=1400")
  fun getAll(@Query("convert") currency: String): Single<List<MarketCapCoin>>
}