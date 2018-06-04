package fogelao.com.github.coinmarket.model.network.entity.social

/**
 * @author Fogel Artem on 18.05.2018.
 */
class Twitter(
        val statuses: Int,
        val followers: Int,
        val favourites: String,
        name: String,
        val lists: Int,
        link: String,
        val following: String,
        points: Int) : BaseSocial(link, name, points)