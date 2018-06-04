package fogelao.com.github.coinmarket.di.module

import fogelao.com.github.coinmarket.model.interactor.coin.CoinInteractor
import fogelao.com.github.coinmarket.model.repository.coin.CoinRepository
import fogelao.com.github.coinmarket.presentation.main.MainPresenter
import toothpick.config.Module

/**
 * @author Fogel Artem on 14.05.2018.
 */
class MainScreenModule : Module() {

    init {
        bind(MainPresenter::class.java)
        bind(CoinInteractor::class.java)
        bind(CoinRepository::class.java)
    }
}