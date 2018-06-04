package fogelao.com.github.coinmarket.model.network.entity

import com.google.gson.annotations.SerializedName

/**
 * @author Fogel Artem on 14.05.2018.
 */
class MapResponse<out P>(
        response: String,
        message: String,
        type: Int,
        @SerializedName("Data")
        val data: Map<String, P>
) : BaseResponse(response, message, type)