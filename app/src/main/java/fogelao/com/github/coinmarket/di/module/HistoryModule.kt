package fogelao.com.github.coinmarket.di.module

import dagger.Module
import dagger.Provides
import fogelao.com.github.coinmarket.model.data.api.hisapi.HistoryApi
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class HistoryModule {

    @Singleton
    @Provides
    fun provideCoinMarketApi(): HistoryApi {
        return Retrofit.Builder()
                .baseUrl(HistoryApi.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(HistoryApi::class.java)
    }


}