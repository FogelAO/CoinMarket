package fogelao.com.github.coinmarket.presentation.main

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import fogelao.com.github.coinmarket.entity.view.TickerView


@StateStrategyType(AddToEndSingleStrategy::class)
interface MainView : MvpView {
    fun showTickers(tickerApis: List<TickerView>)

    fun showProgress(show: Boolean)

    fun showRefreshing(show: Boolean)

    @StateStrategyType(OneExecutionStateStrategy::class)

    fun showMessage(message: String)

}