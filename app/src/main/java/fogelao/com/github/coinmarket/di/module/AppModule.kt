package fogelao.com.github.coinmarket.di.module

import android.arch.persistence.room.Room
import android.content.Context
import dagger.Module
import dagger.Provides
import fogelao.com.github.coinmarket.model.data.storage.AppDatabase
import fogelao.com.github.coinmarket.model.data.storage.Prefs
import fogelao.com.github.coinmarket.model.system.AppSchedulers
import fogelao.com.github.coinmarket.model.system.SchedulersProvider
import javax.inject.Singleton

@Module
class AppModule(private val context: Context) {

    @Singleton
    @Provides
    fun provideContext() = context

    @Singleton
    @Provides
    fun provideSchedulersProvider(): SchedulersProvider = AppSchedulers()

    @Singleton
    @Provides
    fun provideAppDatabase(): AppDatabase = Room.databaseBuilder(context, AppDatabase::class.java, "coin_market-db").build()

    @Singleton
    @Provides
    fun provideTimePreferences(context: Context) = Prefs(context)


}