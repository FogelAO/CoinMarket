package fogelao.com.github.coinmarket.entity.api.graph

import com.google.gson.annotations.SerializedName


data class GraphItem(
        @SerializedName("0")
        val time: Long,
        @SerializedName("1")
        val price: Double
)