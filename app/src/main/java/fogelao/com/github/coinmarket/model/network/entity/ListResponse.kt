package fogelao.com.github.coinmarket.model.network.entity

import com.google.gson.annotations.SerializedName

/**
 * @author Fogel Artem on 17.05.2018.
 */
class ListResponse<P>(
        response: String,
        message: String,
        type: Int,
        @SerializedName("Data")
        val data: List<P>) : BaseResponse(response, message, type)