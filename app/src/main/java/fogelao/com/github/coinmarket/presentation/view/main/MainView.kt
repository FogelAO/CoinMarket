package fogelao.com.github.coinmarket.presentation.view.main

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import fogelao.com.github.coinmarket.presentation.ListItem

/**
 * @author Fogel Artem on 14.05.2018.
 */
@StateStrategyType(AddToEndSingleStrategy::class)
interface MainView : MvpView {
    fun showItems(items: List<ListItem>)

    fun showError(message: String)
}