package fogelao.com.github.coinmarket.presentation.view.coin

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import fogelao.com.github.coinmarket.model.network.entity.chart.Chart
import fogelao.com.github.coinmarket.model.network.entity.market_cap.coin.MarketCapCoin

/**
 * @author Fogel Artem on 16.05.2018.
 */
@StateStrategyType(AddToEndSingleStrategy::class)
interface CoinDetailsView : MvpView {

  fun showCoin(coinView: MarketCapCoin)

  fun showChart(chart: List<Chart>)

  fun showError(message: String)
}