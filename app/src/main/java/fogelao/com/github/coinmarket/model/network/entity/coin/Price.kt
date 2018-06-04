package fogelao.com.github.coinmarket.model.network.entity.coin

import com.google.gson.annotations.SerializedName

/**
 * @author Fogel Artem on 17.05.2018.
 */
class Price(
        @SerializedName("Symbol")
        val symbol: String,
        @SerializedName("Price")
        val price: Double
)