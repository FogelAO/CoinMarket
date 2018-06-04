package fogelao.com.github.coinmarket.di.module

import com.google.gson.Gson
import fogelao.com.github.coinmarket.BuildConfig
import fogelao.com.github.coinmarket.di.provider.CoinApiProvider
import fogelao.com.github.coinmarket.di.qualifier.ApiEndpoint
import fogelao.com.github.coinmarket.model.network.CoinApi
import toothpick.config.Module

/**
 * @author Fogel Artem on 14.05.2018.
 */
class ServerModule : Module() {

    init {
        bind(String::class.java).withName(ApiEndpoint::class.java).toInstance(BuildConfig.API_ENDPOINT)

        bind(Gson::class.java).toInstance(Gson())
        bind(CoinApi::class.java).toProvider(CoinApiProvider::class.java).providesSingletonInScope()
    }
}