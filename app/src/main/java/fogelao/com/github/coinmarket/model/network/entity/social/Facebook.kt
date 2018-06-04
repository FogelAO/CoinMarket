package fogelao.com.github.coinmarket.model.network.entity.social

/**
 * @author Fogel Artem on 18.05.2018.
 */
class Facebook(
        link: String,
        name: String,
        points: Int,
        val likes: Int
) : BaseSocial(link, name, points)