package fogelao.com.github.coinmarket.entity.social

/**
 * @author Fogel Artem on 18.05.2018.
 */
data class TwitterView(
        val statuses: String,
        val followers: String,
        val favourites: String,
        val name: String,
        val lists: String,
        val link: String,
        val following: String,
        val points: String
)