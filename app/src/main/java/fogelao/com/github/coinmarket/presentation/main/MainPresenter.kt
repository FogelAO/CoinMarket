package fogelao.com.github.coinmarket.presentation.main

import android.os.Bundle
import com.arellomobile.mvp.InjectViewState
import fogelao.com.github.coinmarket.di.Scopes
import fogelao.com.github.coinmarket.entity.coin.CoinView
import fogelao.com.github.coinmarket.model.interactor.coin.CoinInteractor
import fogelao.com.github.coinmarket.model.system.ResourceManager
import fogelao.com.github.coinmarket.presentation.LoadingListItem
import fogelao.com.github.coinmarket.presentation.PlaceholderListItem
import fogelao.com.github.coinmarket.presentation.base.BasePresenter
import fogelao.com.github.coinmarket.presentation.view.main.MainView
import fogelao.com.github.coinmarket.ui.Screens
import ru.terrakok.cicerone.Router
import timber.log.Timber
import toothpick.Toothpick
import toothpick.config.Module
import javax.inject.Inject

/**
 * @author Fogel Artem on 14.05.2018.
 */
@InjectViewState
class MainPresenter @Inject constructor(
        private val router: Router,
        val resourceManager: ResourceManager,
        private val interactor: CoinInteractor) : BasePresenter<MainView>() {

    override fun onFirstViewAttach() {
        interactor.getAll()
                .doOnSubscribe { showLoading() }
                .subscribe(
                        { viewState.showItems(it) },
                        {
                            Timber.e(it)
                            showError()
                        }
                )
                .connect()

    }

    fun onCoinClicked(coinView: CoinView, bundle: Bundle?) {
        viewState.showError("${coinView.coinName} clicked!")
        Toothpick.openScopes(Scopes.SERVER_SCOPE, Scopes.COIN_SCOPE)
                .installModules(
                        object : Module() {
                            init {
                                bind(CoinView::class.java).toInstance(coinView)
                            }
                        }
                )

        router.navigateTo(Screens.COIN_FLOW)
    }

    private fun showLoading() {
        viewState.showItems(listOf(LoadingListItem()))
    }

    private fun showError() {
        viewState.showItems(listOf(PlaceholderListItem()))
        viewState.showError("Error")
    }
}