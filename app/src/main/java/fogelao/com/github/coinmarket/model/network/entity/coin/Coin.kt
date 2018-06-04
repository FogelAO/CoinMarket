package fogelao.com.github.coinmarket.model.network.entity.coin

import com.google.gson.annotations.SerializedName

/**
 * @author Fogel Artem on 15.05.2018.
 */
data class Coin(
        @SerializedName("Id")
        val id: String,
        @SerializedName("Url")
        val url: String,
        @SerializedName("ImageUrl")
        val imageUrl: String,
        @SerializedName("Symbol")
        val symbol: String,
        @SerializedName("CoinName")
        val coinName: String,
        @SerializedName("Algorithm")
        val algorithm: String,
        @SerializedName("SortOrder")
        val sortOrder: String,
        @SerializedName("Sponsored")
        val sponsored: Boolean
)