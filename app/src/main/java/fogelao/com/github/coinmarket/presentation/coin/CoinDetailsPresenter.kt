package fogelao.com.github.coinmarket.presentation.coin

import com.arellomobile.mvp.InjectViewState
import fogelao.com.github.coinmarket.entity.coin.CoinView
import fogelao.com.github.coinmarket.model.interactor.coin.CoinInteractor
import fogelao.com.github.coinmarket.presentation.base.BasePresenter
import fogelao.com.github.coinmarket.presentation.view.coin.CoinDetailsView
import ru.terrakok.cicerone.Router
import timber.log.Timber
import javax.inject.Inject

/**
 * @author Fogel Artem on 16.05.2018.
 */
@InjectViewState
class CoinDetailsPresenter @Inject constructor(
        private val interactor: CoinInteractor,
        private val router: Router,
        private val coin: CoinView
) : BasePresenter<CoinDetailsView>() {

    override fun onFirstViewAttach() {
        interactor.getPrice(coin)
                .subscribe(
                        {
                            viewState.showCoin(it)
                        },
                        { Timber.e(it) }
                )
                .connect()

//        viewState.showCoin(coin)
    }

    fun onNavigationClicked() {
        router.exit()
    }
}