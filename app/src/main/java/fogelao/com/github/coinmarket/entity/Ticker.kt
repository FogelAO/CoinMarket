package fogelao.com.github.coinmarket.entity

import com.google.gson.annotations.SerializedName


data class Ticker(
        val id: String,
        val name: String,
        val symbol: String,
        val rank: Int,
        val priceUsd: Double,
        val priceBtc: Double,
        @SerializedName("percent_change_1h")
        val percentChange_1h: String,
        @SerializedName("percent_change_24h")
        val percentChange_24h: String,
        @SerializedName("percent_change_7d")
        val percentChange_7d: String
)