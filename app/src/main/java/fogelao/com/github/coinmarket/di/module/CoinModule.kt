package fogelao.com.github.coinmarket.di.module

import fogelao.com.github.coinmarket.model.interactor.coin.CoinInteractor
import fogelao.com.github.coinmarket.model.repository.coin.CoinRepository
import fogelao.com.github.coinmarket.presentation.coin.CoinDetailsPresenter
import toothpick.config.Module

/**
 * @author Fogel Artem on 16.05.2018.
 */
class CoinModule : Module() {
    init {
        bind(CoinDetailsPresenter::class.java).singletonInScope()
        bind(CoinInteractor::class.java)
        bind(CoinRepository::class.java)
    }
}