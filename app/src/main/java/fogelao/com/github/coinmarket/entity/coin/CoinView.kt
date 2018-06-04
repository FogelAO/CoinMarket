package fogelao.com.github.coinmarket.entity.coin

import fogelao.com.github.coinmarket.entity.social.FacebookView
import fogelao.com.github.coinmarket.entity.social.RedditView
import fogelao.com.github.coinmarket.entity.social.TwitterView
import fogelao.com.github.coinmarket.model.network.entity.social.CryptoCompare
import fogelao.com.github.coinmarket.presentation.ListItem

/**
 * @author Fogel Artem on 15.05.2018.
 */
data class CoinView(
        val id: Int,
        val url: String,
        val imageUrl: String,
        val chartUrl: String,
        val symbol: String,
        val coinName: String,
        val sortOrder: String,
        val sponsored: Boolean,
        val price: String = "0.0",
        val cryptoCompare: CryptoCompare? = null,
        val twitterView: TwitterView? = null,
        val facebookView: FacebookView? = null,
        val redditView: RedditView? = null

) : ListItem {

    constructor(coinView: CoinView, price: String = "") : this(
            coinView.id,
            coinView.url,
            coinView.imageUrl,
            coinView.chartUrl,
            coinView.symbol,
            coinView.coinName,
            coinView.sortOrder,
            coinView.sponsored,
            price
    )

    constructor(coinView: CoinView,
                cryptoCompare: CryptoCompare?,
                twitterView: TwitterView?,
                facebookView: FacebookView?,
                redditView: RedditView?) : this(
            coinView.id,
            coinView.url,
            coinView.imageUrl,
            coinView.chartUrl,
            coinView.symbol,
            coinView.coinName,
            coinView.sortOrder,
            coinView.sponsored,
            cryptoCompare = cryptoCompare,
            twitterView = twitterView,
            facebookView = facebookView,
            redditView = redditView
    )
}