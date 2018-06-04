package fogelao.com.github.coinmarket.model.repository.coin

import fogelao.com.github.coinmarket.model.network.CoinApi
import fogelao.com.github.coinmarket.model.network.entity.EntityResponse
import fogelao.com.github.coinmarket.model.network.entity.ListResponse
import fogelao.com.github.coinmarket.model.network.entity.MapResponse
import fogelao.com.github.coinmarket.model.network.entity.coin.Coin
import fogelao.com.github.coinmarket.model.network.entity.coin.Price
import fogelao.com.github.coinmarket.model.network.entity.social.SocialResponse
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * @author Fogel Artem on 14.05.2018.
 */
class CoinRepository @Inject constructor(private val api: CoinApi) {

    fun getAll(): Single<MapResponse<Coin>> = api.getAll()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    fun getPrice(symbol: String, quote: String): Single<ListResponse<Price>> = api.getPrice(symbol, quote)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    fun getSocial(id: Int): Single<EntityResponse<SocialResponse>> = api.getSocial(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

}