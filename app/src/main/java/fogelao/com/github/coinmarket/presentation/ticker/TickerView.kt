package fogelao.com.github.coinmarket.presentation.ticker

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import fogelao.com.github.coinmarket.entity.api.HistoryItem
import fogelao.com.github.coinmarket.ui.BaseView


@StateStrategyType(AddToEndSingleStrategy::class)
interface TickerView : BaseView {

    fun showHistoryData(entries: List<HistoryItem>)

    fun showRefreshing(show: Boolean)

}