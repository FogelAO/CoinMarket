package fogelao.com.github.coinmarket.di.provider

import com.google.gson.Gson
import fogelao.com.github.coinmarket.model.network.CoinmarketCapApi
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Provider

/**
 * @author Fogel Artem on 14.05.2018.
 */
class CoinMarketCapApiProvider @Inject constructor(private val gson: Gson) : Provider<CoinmarketCapApi> {

  override fun get(): CoinmarketCapApi = Retrofit.Builder()
      .baseUrl(CoinmarketCapApi.BASE_URL)
      .addConverterFactory(GsonConverterFactory.create(gson))
      .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
      .build()
      .create(CoinmarketCapApi::class.java)
}