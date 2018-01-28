package fogelao.com.github.coinmarket.model.data.api.hisapi

import fogelao.com.github.coinmarket.entity.api.HistoryItem
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface HistoryApi {
    companion object {
        const val BASE_URL = "https://rest.coinapi.io/"
        private const val API_KEY = "ECC054E0-5254-4E9A-A2C6-7CEA7950C6FC"
    }


    @GET("/v1/ohlcv/{symbol_id}/history?apikey=$API_KEY")
    fun getHistory(
            @Path("symbol_id") symbolId: String = "BITSTAMP_SPOT_BTC_USD",
            @Query("period_id") periodId: String = "1DAY",
            @Query("time_start") timeStart: String = "2017-01-21T00:00:00",
            @Query("limit") limit: String = "7"
    ): Single<List<HistoryItem>>

}