package fogelao.com.github.coinmarket.entity.api

import com.google.gson.annotations.SerializedName
import org.joda.time.DateTime
import java.sql.Timestamp


data class HistoryItem(
        @SerializedName("time_period_start")
        val startTime: Timestamp,
        @SerializedName("time_period_end")
        val endTime: Timestamp,
        @SerializedName("time_open")
        val timeOpen:Timestamp,
        @SerializedName("price_high")
        val priceHigh: Float,
        @SerializedName("price_low")
        val priceLow: Double,
        @SerializedName("price_open")
        val priceOpen: Double,
        @SerializedName("price_close")
        val priceClose: Double
) {
    fun getDay() = DateTime(startTime).dayOfMonth
}