package fogelao.com.github.coinmarket.presentation.ticker

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import fogelao.com.github.coinmarket.entity.api.HistoryItem


@StateStrategyType(AddToEndSingleStrategy::class)
interface TickerView : MvpView {

    fun showHistoryData(entries: List<HistoryItem>)

    fun showProgress(show: Boolean)

    fun showRefreshing(show: Boolean)

    fun showMessage(message: String)
}