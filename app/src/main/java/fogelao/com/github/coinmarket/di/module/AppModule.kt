package fogelao.com.github.coinmarket.di.module

import android.content.Context
import fogelao.com.github.coinmarket.di.qualifier.AppCtx
import fogelao.com.github.coinmarket.model.system.ResourceManager
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import toothpick.config.Module

/**
 * @author Fogel Artem on 14.05.2018.
 */
class AppModule(context: Context) : Module() {

    init {
        bind(Context::class.java).withName(AppCtx::class.java).toInstance(context)
        bind(ResourceManager::class.java).singletonInScope()
        //Navigation
        val cicerone = Cicerone.create(Router())
        bind(Router::class.java).toInstance(cicerone.router)
        bind(NavigatorHolder::class.java).toInstance(cicerone.navigatorHolder)
    }
}