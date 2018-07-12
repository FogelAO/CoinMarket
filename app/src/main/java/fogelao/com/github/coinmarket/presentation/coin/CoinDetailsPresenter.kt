package fogelao.com.github.coinmarket.presentation.coin

import com.arellomobile.mvp.InjectViewState
import fogelao.com.github.coinmarket.model.interactor.coin.CoinInteractor
import fogelao.com.github.coinmarket.model.network.entity.market_cap.coin.MarketCapCoin
import fogelao.com.github.coinmarket.presentation.base.BasePresenter
import fogelao.com.github.coinmarket.presentation.view.coin.CoinDetailsView
import io.reactivex.rxkotlin.subscribeBy
import ru.terrakok.cicerone.Router
import timber.log.Timber
import javax.inject.Inject

/**
 * @author Fogel Artem on 16.05.2018.
 */
@InjectViewState
class CoinDetailsPresenter @Inject constructor(
    private val router: Router,
    private val coin: MarketCapCoin,
    private val interactor: CoinInteractor
) : BasePresenter<CoinDetailsView>() {

  override fun onFirstViewAttach() {
    interactor.getChart()
        .subscribeBy(
            onSuccess = { viewState.showChart(it) },
            onError = { Timber.w(it);viewState.showError(it.localizedMessage) }
        )
        .connect()

    viewState.showCoin(coin)
  }

  fun onNavigationClicked() {
    router.exit()
  }
}