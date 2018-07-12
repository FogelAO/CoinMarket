package fogelao.com.github.coinmarket.di.module

import com.google.gson.Gson
import fogelao.com.github.coinmarket.di.provider.ChartApiProvider
import fogelao.com.github.coinmarket.di.provider.CoinMarketCapApiProvider
import fogelao.com.github.coinmarket.di.provider.CryptoCompareApiProvider
import fogelao.com.github.coinmarket.model.network.ChartApi
import fogelao.com.github.coinmarket.model.network.CoinApi
import fogelao.com.github.coinmarket.model.network.CoinmarketCapApi
import toothpick.config.Module

/**
 * @author Fogel Artem on 14.05.2018.
 */
class ServerModule : Module() {

  init {
    bind(Gson::class.java).toInstance(Gson())
    bind(CoinmarketCapApi::class.java).toProvider(CoinMarketCapApiProvider::class.java).providesSingletonInScope()
    bind(CoinApi::class.java).toProvider(CryptoCompareApiProvider::class.java).providesSingletonInScope()
    bind(ChartApi::class.java).toProvider(ChartApiProvider::class.java).providesSingletonInScope()
  }
}