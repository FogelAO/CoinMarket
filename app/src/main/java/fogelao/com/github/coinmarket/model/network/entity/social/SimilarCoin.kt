package fogelao.com.github.coinmarket.model.network.entity.social

import com.google.gson.annotations.SerializedName

/**
 * @author Fogel Artem on 18.05.2018.
 */
class SimilarCoin(
        @SerializedName("Id")
        val id: Int,
        @SerializedName("Name")
        val name: String,
        @SerializedName("FullName")
        val fullName: String,
        @SerializedName("ImageUrl")
        val imageUrl: String
)