package fogelao.com.github.coinmarket.entity.api

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "ticker")
data class TickerApi(
        @PrimaryKey(autoGenerate = true)
        var uid: Long = 0,
        var id: String = "",
        var name: String = "",
        var symbol: String = "",
        var rank: Int = 0,
        @SerializedName("price_usd")
        var priceUsd: Double = 0.0,
        @SerializedName("price_btc")
        var priceBtc: Double = 0.0,
        @SerializedName("percent_change_1h")
        var percentChange_1h: Double = 0.0,
        @SerializedName("percent_change_24h")
        var percentChange_24h: Double = 0.0,
        @SerializedName("percent_change_7d")
        var percentChange_7d: Double = 0.0
) {
    fun get24hVec() = percentChange_24h > 0
}