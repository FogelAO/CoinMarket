package fogelao.com.github.coinmarket.model.network.entity.chart

import com.google.gson.annotations.SerializedName

/**
 * @author Fogel Artem on 03-Jul-18.
 */
class ChartResponse(
    @SerializedName("price_usd")
    val usdPrice: List<List<String>>
)