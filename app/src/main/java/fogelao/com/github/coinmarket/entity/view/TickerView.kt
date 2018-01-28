package fogelao.com.github.coinmarket.entity.view

import java.io.Serializable


data class TickerView(
        val id: String,
        val name: String,
        val symbol: String,
        val rank: Int,
        val priceUsd: Double,
        val priceBtc: Double,
        val percentChange_24h: Double
) :Serializable{
    fun get24hVec() = percentChange_24h > 0
}