package fogelao.com.github.coinmarket.model.network.entity

/**
 * @author Fogel Artem on 18.05.2018.
 */
class EntityResponse<E>(
        response: String,
        message: String,
        type: Int,
        val entity: E
) : BaseResponse(response, message, type)