package fogelao.com.github.coinmarket.di

import android.content.Context
import fogelao.com.github.coinmarket.di.component.AppComponent
import fogelao.com.github.coinmarket.di.component.DaggerAppComponent
import fogelao.com.github.coinmarket.di.module.AppModule


class ComponentManager(private val context: Context) {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
                .appModule(AppModule(context))
                .build()
    }
}