package fogelao.com.github.coinmarket

import android.app.Application
import com.squareup.leakcanary.LeakCanary
import fogelao.com.github.coinmarket.di.Scopes
import fogelao.com.github.coinmarket.di.module.AppModule
import fogelao.com.github.coinmarket.di.module.ServerModule
import timber.log.Timber
import toothpick.Toothpick
import toothpick.configuration.Configuration


class App : Application() {

    override fun onCreate() {
        super.onCreate()

        initTimber()
        initToothpick()
        initAppScope()
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return
        }
        LeakCanary.install(this)
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    private fun initToothpick() {
        if (BuildConfig.DEBUG) {
            Toothpick.setConfiguration(Configuration.forDevelopment().preventMultipleRootScopes())
        } else {
            Toothpick.setConfiguration(Configuration.forProduction().disableReflection())
        }
    }

    private fun initAppScope() {
        Toothpick.openScope(Scopes.APP_SCOPE)
                .installModules(AppModule(this))
        Toothpick.openScopes(Scopes.APP_SCOPE, Scopes.SERVER_SCOPE)
                .installModules(ServerModule())
    }
}