package fogelao.com.github.coinmarket.model.data.api.coinmarket

import fogelao.com.github.coinmarket.entity.api.graph.GraphResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path


interface GraphApi {
    companion object {
        const val BASE_URL = "https://graphs2.coinmarketcap.com/"
    }

    @GET("currencies/{symbol_id}/{start}/{end}/")
    fun getGraphData(
            @Path("symbol_id") symbolId: String,
            @Path("start") start: Long,
            @Path("end") end: Long

    ): Single<GraphResponse>
}