package fogelao.com.github.coinmarket.di.module

import dagger.Module
import dagger.Provides
import fogelao.com.github.coinmarket.model.data.api.coinmarket.CoinMarketApi
import fogelao.com.github.coinmarket.model.data.storage.AppDatabase
import fogelao.com.github.coinmarket.model.data.storage.ticker.TickerDAO
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class TickerModule {

    @Singleton
    @Provides
    fun provideCoinMarketApi(): CoinMarketApi {
        return Retrofit.Builder()
                .baseUrl(CoinMarketApi.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(CoinMarketApi::class.java)
    }

    @Singleton
    @Provides
    fun provideTickerDAO(appDatabase: AppDatabase): TickerDAO = appDatabase.tickerDAO()
}