package fogelao.com.github.coinmarket.model.network.entity.social

import com.google.gson.annotations.SerializedName

/**
 * @author Fogel Artem on 18.05.2018.
 */
class SocialResponse(
        @SerializedName("CryptoCompareView")
        val cryptoCompare: CryptoCompare,
        @SerializedName("TwitterView")
        val twitter: Twitter,
        @SerializedName("RedditView")
        val reddit: Reddit,
        @SerializedName("FacebookView")
        val facebook: Facebook
)