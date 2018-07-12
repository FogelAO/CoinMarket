package fogelao.com.github.coinmarket.model.network

import fogelao.com.github.coinmarket.model.network.entity.chart.ChartResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * @author Fogel Artem on 03-Jul-18.
 */
interface ChartApi {
  companion object {
    const val BASE_URL = "https://graphs2.coinmarketcap.com/"
  }

  @GET("/currencies/{currency}/{timeStart}/{timeEnd}/")
  fun get(
      @Path("currency") currency: String = "ripple",
      @Path("timeStart") timeStart: Long,
      @Path("timeEnd") timeEnd: Long
  ): Single<ChartResponse>

}