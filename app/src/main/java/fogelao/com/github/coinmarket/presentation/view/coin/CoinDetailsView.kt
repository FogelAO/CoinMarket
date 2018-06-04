package fogelao.com.github.coinmarket.presentation.view.coin

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import fogelao.com.github.coinmarket.entity.coin.CoinView

/**
 * @author Fogel Artem on 16.05.2018.
 */
@StateStrategyType(AddToEndSingleStrategy::class)
interface CoinDetailsView : MvpView {
    fun showCoin(coinView: CoinView)
}