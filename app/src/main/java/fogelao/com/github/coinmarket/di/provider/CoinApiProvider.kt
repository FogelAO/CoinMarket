package fogelao.com.github.coinmarket.di.provider

import com.google.gson.Gson
import fogelao.com.github.coinmarket.di.qualifier.ApiEndpoint
import fogelao.com.github.coinmarket.model.network.CoinApi
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Provider

/**
 * @author Fogel Artem on 14.05.2018.
 */
class CoinApiProvider @Inject constructor(
        @ApiEndpoint private val endPoint: String,
        private val gson: Gson) : Provider<CoinApi> {

    override fun get(): CoinApi = Retrofit.Builder()
            .baseUrl(endPoint)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(CoinApi::class.java)
}