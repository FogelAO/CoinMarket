package fogelao.com.github.coinmarket.model.network

import fogelao.com.github.coinmarket.model.network.entity.EntityResponse
import fogelao.com.github.coinmarket.model.network.entity.ListResponse
import fogelao.com.github.coinmarket.model.network.entity.MapResponse
import fogelao.com.github.coinmarket.model.network.entity.coin.Coin
import fogelao.com.github.coinmarket.model.network.entity.coin.Price
import fogelao.com.github.coinmarket.model.network.entity.social.SocialResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author Fogel Artem on 14.05.2018.
 */
interface CoinApi {

    @GET("api/data/coinlist/")
    fun getAll(): Single<MapResponse<Coin>>

    @GET("api/data/price/")
    fun getPrice(@Query("fsym") symbol: String, @Query("tsyms") quote: String): Single<ListResponse<Price>>


    //TODO:
    @GET("api/data/socialstats/")
    fun getSocial(@Query("id") id: Int): Single<EntityResponse<SocialResponse>>
}