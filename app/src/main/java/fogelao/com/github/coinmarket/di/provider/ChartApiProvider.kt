package fogelao.com.github.coinmarket.di.provider

import com.google.gson.Gson
import fogelao.com.github.coinmarket.model.network.ChartApi
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Provider

/**
 * @author Fogel Artem on 03-Jul-18.
 */
class ChartApiProvider @Inject constructor(private val gson: Gson) : Provider<ChartApi> {

  override fun get(): ChartApi = Retrofit.Builder()
      .baseUrl(ChartApi.BASE_URL)
      .addConverterFactory(GsonConverterFactory.create(gson))
      .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
      .build()
      .create(ChartApi::class.java)
}