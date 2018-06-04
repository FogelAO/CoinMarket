package fogelao.com.github.coinmarket.model.network.entity.social

import com.google.gson.annotations.SerializedName

/**
 * @author Fogel Artem on 18.05.2018.
 */
class CryptoCompare (
        @SerializedName("SimilarItems")
        val similarCoins:List<SimilarCoin>
)