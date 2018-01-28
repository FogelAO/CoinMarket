package fogelao.com.github.coinmarket.model.data.api.coinmarket

import fogelao.com.github.coinmarket.entity.api.TickerApi
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path


interface CoinMarketApi {
    companion object {
        const val BASE_URL = "https://api.coinmarketcap.com/"
    }

    @GET("v1/ticker/")
    fun getAllTickers(): Single<List<TickerApi>>

    @GET("v1/ticker/{id}/")
    fun getTickerById(@Path("id") id: String): Single<TickerApi>

}