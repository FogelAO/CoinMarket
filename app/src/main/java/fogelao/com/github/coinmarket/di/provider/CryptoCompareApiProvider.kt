package fogelao.com.github.coinmarket.di.provider

import com.google.gson.Gson
import fogelao.com.github.coinmarket.model.network.CoinApi
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Provider

/**
 * @author Fogel Artem on 03-Jul-18.
 */
class CryptoCompareApiProvider @Inject constructor(private val gson: Gson) : Provider<CoinApi> {
  override fun get(): CoinApi = Retrofit.Builder()
      .baseUrl(CoinApi.BASE_URL)
      .addConverterFactory(GsonConverterFactory.create(gson))
      .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
      .build()
      .create(CoinApi::class.java)
}