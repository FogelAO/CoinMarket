package fogelao.com.github.coinmarket.ui.coin

import android.content.Context
import android.content.Intent
import android.os.Bundle
import fogelao.com.github.coinmarket.R
import fogelao.com.github.coinmarket.di.Scopes
import fogelao.com.github.coinmarket.ui.Screens
import fogelao.com.github.coinmarket.ui.base.BaseActivity
import fogelao.com.github.coinmarket.ui.main.MainActivity
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.SupportAppNavigator
import toothpick.Toothpick
import javax.inject.Inject

/**
 * @author Fogel Artem on 16.05.2018.
 */
class CoinActivity : BaseActivity() {
    companion object {
        const val TRANSACTION_EXTRA_TAG = "transaction_extra"

        fun createIntent(context: Context, bundle: Bundle?): Intent {
            val intent = Intent(context, CoinActivity::class.java)
            intent.putExtra(TRANSACTION_EXTRA_TAG, bundle)
            return intent
        }
    }

    @Inject
    lateinit var router: Router
    private val navigator = object : SupportAppNavigator(this, R.id.container) {
        override fun createActivityIntent(context: Context, screenKey: String, data: Any?) = when (screenKey) {
            Screens.MAIN_FLOW -> MainActivity.createIntent(context)
            else -> null
        }

        override fun createFragment(screenKey: String, data: Any?) = when (screenKey) {
            Screens.COIN_DETAILS_SCREEN -> CoinDetailsFragment.newInstance()
            else -> throw RuntimeException("Screen: $screenKey not found")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Toothpick.inject(this, Toothpick.openScopes(Scopes.SERVER_SCOPE, Scopes.COIN_SCOPE))
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coin)

        if (savedInstanceState == null) {
            router.replaceScreen(Screens.COIN_DETAILS_SCREEN)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (isFinishing) {
            Toothpick.closeScope(Scopes.COIN_SCOPE)
        }
    }

    override fun getNavigator(): Navigator = navigator
}