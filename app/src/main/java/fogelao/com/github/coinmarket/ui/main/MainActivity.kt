package fogelao.com.github.coinmarket.ui.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import fogelao.com.github.coinmarket.R
import fogelao.com.github.coinmarket.di.Scopes
import fogelao.com.github.coinmarket.ui.Screens
import fogelao.com.github.coinmarket.ui.base.BaseActivity
import fogelao.com.github.coinmarket.ui.coin.CoinActivity
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.SupportAppNavigator
import toothpick.Toothpick
import javax.inject.Inject


class MainActivity : BaseActivity() {
    companion object {
        fun createIntent(context: Context) = Intent(context, MainActivity::class.java)
    }

    @Inject
    lateinit var router: Router
    private val navigator = object : SupportAppNavigator(this, R.id.container) {
        override fun createActivityIntent(context: Context, screenKey: String, data: Any?) = when (screenKey) {
            Screens.COIN_FLOW -> CoinActivity.createIntent(context, (data as Bundle?))
            else -> null
        }

        override fun createFragment(screenKey: String, data: Any?) = when (screenKey) {
            Screens.MAIN_SCREEN -> MainFragment.newInstance()
            else -> throw RuntimeException("Screen $screenKey not found")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Toothpick.inject(this, Toothpick.openScope(Scopes.APP_SCOPE))
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            router.replaceScreen(Screens.MAIN_SCREEN)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (isFinishing) {
            Toothpick.closeScope(Scopes.MAIN_SCREEN_SCOPE)
        }
    }

    override fun getNavigator() = navigator

}