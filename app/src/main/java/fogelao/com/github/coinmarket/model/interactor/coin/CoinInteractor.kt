package fogelao.com.github.coinmarket.model.interactor.coin

import fogelao.com.github.coinmarket.model.network.entity.chart.Chart
import fogelao.com.github.coinmarket.model.repository.coin.CoinRepository
import io.reactivex.Single
import javax.inject.Inject

/**
 * @author Fogel Artem on 15.05.2018.
 */
class CoinInteractor @Inject constructor(private val repository: CoinRepository) {
  companion object {
    const val BASE_IMAGE_URL = "https://www.cryptocompare.com/"
    const val BASE_CHART_URL = "https://images.cryptocompare.com/sparkchart/"
  }

//  fun getAll(currency: String = "USD"): Single<List<CoinView>> = repository.getAll()
//      .map {
//        it.data
//            .values
//            .toList()
//            .sortedBy { it.sortOrder.toInt() }
//            .map { coin -> mapToView(coin) }
//      }

  fun getAll(currency: String = "USD") = repository.getAll(currency)

  fun getChart(currency: String = "ripple", timeStart: Long = 1530365070467, timeEnd: Long = 1530452130467): Single<List<Chart>> = repository.getChart(currency, timeStart, timeEnd)
      .map { t ->
        t.usdPrice.map {
          val time = it[0].toLong()
          val value = it[1].toFloat()
          Chart(time, value)
        }
      }

//  fun getPrice(coinView: CoinView, quote: String = "USD"): Single<CoinView> = repository.getPrice(coinView.symbol, quote)
//      .map { it.data.first() }
//      .map { t -> mapToView(coinView, t, quote) }
//
//  fun getSocial(coinView: CoinView): Single<CoinView> = repository.getSocial(coinView.id)
//      .map { t -> mapToView(coinView, t.entity) }
//
//  private fun mapToView(coin: Coin, quote: String = "USD"): CoinView {
//    return CoinView(
//        coin.id.toInt(),
//        coin.url,
//        BASE_IMAGE_URL + coin.imageUrl,
//        "$BASE_CHART_URL${coin.symbol}/$quote/latest.png?ts=1526449200",
//        coin.symbol,
//        coin.coinName,
//        coin.sortOrder,
//        coin.sponsored
//    )
//  }
//
//  private fun mapToView(coinView: CoinView, price: Price, quote: String) = CoinView(coinView, "${price.price}($quote)")
//
//  private fun mapToView(coinView: CoinView, socialResponse: SocialResponse): CoinView {
//    val cryptoCompare = socialResponse.cryptoCompare
//    val twitter = socialResponse.twitter
//    val twitterView = TwitterView(
//        twitter.statuses.toString(),
//        twitter.followers.toString(),
//        twitter.favourites,
//        twitter.name,
//        twitter.lists.toString(),
//        twitter.link,
//        twitter.following,
//        twitter.points.toString())
//
//    val facebook = socialResponse.facebook
//    val facebookView = FacebookView(
//        facebook.link,
//        facebook.name,
//        facebook.points.toString(),
//        facebook.likes.toString())
//
//    val reddit = socialResponse.reddit
//    val redditView = RedditView(
//        reddit.link,
//        reddit.name,
//        reddit.points.toString(),
//        reddit.subscribers.toString())
//
//    return CoinView(coinView, cryptoCompare, twitterView, facebookView, redditView)
//  }

}