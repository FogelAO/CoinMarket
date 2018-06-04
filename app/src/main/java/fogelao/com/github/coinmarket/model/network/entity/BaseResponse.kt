package fogelao.com.github.coinmarket.model.network.entity

import com.google.gson.annotations.SerializedName

/**
 * @author Fogel Artem on 18.05.2018.
 */
abstract class BaseResponse(
        @SerializedName("Response")
        val response: String,
        @SerializedName("Message")
        val message: String,
        @SerializedName("Type")
        val type: Int
)