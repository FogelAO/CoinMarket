package fogelao.com.github.coinmarket.model.network.entity.chart

import com.google.gson.annotations.SerializedName

/**
 * @author Fogel Artem on 03-Jul-18.
 */
data class Chart(
    @SerializedName("0")
    val time:Long,
    @SerializedName("1")
    val value:Float
)