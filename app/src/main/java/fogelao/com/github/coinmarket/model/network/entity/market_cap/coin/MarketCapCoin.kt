package fogelao.com.github.coinmarket.model.network.entity.market_cap.coin

import com.google.gson.annotations.SerializedName
import fogelao.com.github.coinmarket.presentation.ListItem
import java.io.Serializable

/**
 * @author Fogel Artem on 02-Jul-18.
 */
data class MarketCapCoin(
    val id: String,
    val name: String,
    val symbol: String,
    val rank: String,
    @SerializedName("price_usd")
    val priceUsd: String,
    @SerializedName("price_btc")
    val priceBtc: String,
    @SerializedName("last_updated")
    val lastUpdated: String,
    @SerializedName("total_supply")
    val totalSupply: String,
    @SerializedName("percent_change_1h")
    val hourChange: String,
    @SerializedName("percent_change_24h")
    val dayChange: String,
    @SerializedName("percent_change_7d")
    val weekChange: String
) : ListItem, Serializable