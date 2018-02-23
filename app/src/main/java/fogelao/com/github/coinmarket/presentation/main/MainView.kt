package fogelao.com.github.coinmarket.presentation.main

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import fogelao.com.github.coinmarket.entity.view.TickerView
import fogelao.com.github.coinmarket.ui.BaseView


@StateStrategyType(AddToEndSingleStrategy::class)
interface MainView : BaseView {
    fun showTickers(tickerApis: List<TickerView>)

    fun showRefreshing(show: Boolean)

}