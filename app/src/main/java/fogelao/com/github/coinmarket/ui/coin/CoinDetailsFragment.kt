package fogelao.com.github.coinmarket.ui.coin

import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import fogelao.com.github.coinmarket.R
import fogelao.com.github.coinmarket.di.Scopes
import fogelao.com.github.coinmarket.di.module.CoinModule
import fogelao.com.github.coinmarket.entity.coin.CoinView
import fogelao.com.github.coinmarket.presentation.coin.CoinDetailsPresenter
import fogelao.com.github.coinmarket.presentation.view.coin.CoinDetailsView
import fogelao.com.github.coinmarket.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_coin_details.*
import toothpick.Toothpick

/**
 * @author Fogel Artem on 16.05.2018.
 */
class CoinDetailsFragment : BaseFragment(), CoinDetailsView {
    companion object {
        fun newInstance() = CoinDetailsFragment()
    }

    @InjectPresenter
    lateinit var presenter: CoinDetailsPresenter

    @ProvidePresenter
    fun providePresenter(): CoinDetailsPresenter {
        val scope = Toothpick.openScope(Scopes.COIN_SCOPE)
        scope.installModules(CoinModule())
        return scope.getInstance(CoinDetailsPresenter::class.java)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //initView
        toolbar.setNavigationOnClickListener { presenter.onNavigationClicked() }
    }

    override fun showCoin(coinView: CoinView) = with(coinView) {
        toolbar.title = coinName
//        symbolView.text = symbol
//        priceView.text = price
    }

    override fun getLayoutRes() = R.layout.fragment_coin_details
}