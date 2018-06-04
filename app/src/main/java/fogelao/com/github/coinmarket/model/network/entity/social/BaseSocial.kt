package fogelao.com.github.coinmarket.model.network.entity.social

import com.google.gson.annotations.SerializedName

/**
 * @author Fogel Artem on 18.05.2018.
 */
open class BaseSocial(
        val link: String,
        val name: String,
        @SerializedName("Points")
        val points:Int
        )