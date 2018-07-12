package fogelao.com.github.coinmarket.ui.main

import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import fogelao.com.github.coinmarket.R
import fogelao.com.github.coinmarket.di.Scopes
import fogelao.com.github.coinmarket.di.module.MainScreenModule
import fogelao.com.github.coinmarket.presentation.ListItem
import fogelao.com.github.coinmarket.presentation.base.SimpleAdapter
import fogelao.com.github.coinmarket.presentation.delegate.LoadingDelegate
import fogelao.com.github.coinmarket.presentation.delegate.PlaceholderDelegate
import fogelao.com.github.coinmarket.presentation.delegate.coin.CoinDelegate
import fogelao.com.github.coinmarket.presentation.main.MainPresenter
import fogelao.com.github.coinmarket.presentation.view.main.MainView
import fogelao.com.github.coinmarket.ui.base.BaseFragment
import fogelao.com.github.coinmarket.ui.extensions.showSnackBar
import kotlinx.android.synthetic.main.fragment_main.recyclerView
import toothpick.Toothpick


class MainFragment : BaseFragment(), MainView {
  companion object {
    fun newInstance() = MainFragment()
  }

  private val adapter = CoinAdapter()
  @InjectPresenter
  lateinit var presenter: MainPresenter

  override fun getLayoutRes() = R.layout.fragment_main

  @ProvidePresenter
  fun providePresenter(): MainPresenter {
    val scope = Toothpick.openScopes(Scopes.SERVER_SCOPE, Scopes.MAIN_SCREEN_SCOPE)
    scope.installModules(MainScreenModule())
    return scope.getInstance(MainPresenter::class.java)
  }

  override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)

    recyclerView.adapter = this.adapter
    recyclerView.run {
      layoutManager = LinearLayoutManager(this@MainFragment.activity, LinearLayoutManager.VERTICAL, false)
      val dividerItemDecoration = DividerItemDecoration(activity, LinearLayoutManager.VERTICAL)
      addItemDecoration(dividerItemDecoration)
    }
  }

  override fun showItems(items: List<ListItem>) {
    adapter.items = items
  }

  override fun showError(message: String) {
    showSnackBar(message)
  }

  private inner class CoinAdapter : SimpleAdapter() {
    init {
      delegatesManager.addDelegate(CoinDelegate { presenter.onCoinClicked(it) })
      delegatesManager.addDelegate(LoadingDelegate())
      delegatesManager.addDelegate(PlaceholderDelegate(R.drawable.ic_launcher_foreground, R.string.no_tickers))
    }
  }
}