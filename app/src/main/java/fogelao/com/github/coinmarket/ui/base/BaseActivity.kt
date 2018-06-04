package fogelao.com.github.coinmarket.ui.base

import com.arellomobile.mvp.MvpAppCompatActivity
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import javax.inject.Inject


abstract class BaseActivity : MvpAppCompatActivity() {
    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    protected abstract fun getNavigator(): Navigator

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(getNavigator())
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }
}