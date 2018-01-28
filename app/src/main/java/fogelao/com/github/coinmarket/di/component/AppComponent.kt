package fogelao.com.github.coinmarket.di.component

import dagger.Component
import fogelao.com.github.coinmarket.di.module.AppModule
import fogelao.com.github.coinmarket.di.module.HistoryModule
import fogelao.com.github.coinmarket.di.module.TickerModule
import fogelao.com.github.coinmarket.presentation.main.MainPresenter
import fogelao.com.github.coinmarket.presentation.ticker.TickerPresenter
import javax.inject.Singleton


@Singleton
@Component(modules = [(AppModule::class), (TickerModule::class), (HistoryModule::class)])
interface AppComponent {
    fun inject(mainPresenter: MainPresenter)

    fun inject(tickerPresenter: TickerPresenter)
}