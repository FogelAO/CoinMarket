package fogelao.com.github.coinmarket

import android.app.Application
import fogelao.com.github.coinmarket.di.DI


class App : Application() {

    override fun onCreate() {
        super.onCreate()

        DI.init(this)
    }
}