package fogelao.com.github.coinmarket.presentation.ticker.graph

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import fogelao.com.github.coinmarket.entity.api.graph.GraphItem
import fogelao.com.github.coinmarket.ui.BaseView


@StateStrategyType(AddToEndSingleStrategy::class)
interface GraphView : BaseView {
    fun showGraph(items: List<GraphItem>)
}