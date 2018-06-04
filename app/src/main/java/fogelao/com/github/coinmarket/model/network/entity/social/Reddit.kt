package fogelao.com.github.coinmarket.model.network.entity.social

/**
 * @author Fogel Artem on 18.05.2018.
 */
class Reddit(
        link: String,
        name: String,
        points: Int,
        val subscribers: Int
) : BaseSocial(link, name, points)