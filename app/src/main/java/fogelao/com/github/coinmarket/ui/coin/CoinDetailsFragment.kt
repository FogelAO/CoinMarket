package fogelao.com.github.coinmarket.ui.coin

import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import fogelao.com.github.coinmarket.R
import fogelao.com.github.coinmarket.di.Scopes
import fogelao.com.github.coinmarket.model.network.entity.chart.Chart
import fogelao.com.github.coinmarket.model.network.entity.market_cap.coin.MarketCapCoin
import fogelao.com.github.coinmarket.presentation.coin.CoinDetailsPresenter
import fogelao.com.github.coinmarket.presentation.view.coin.CoinDetailsView
import fogelao.com.github.coinmarket.ui.base.BaseFragment
import fogelao.com.github.coinmarket.ui.extensions.showSnackBar
import kotlinx.android.synthetic.main.fragment_coin_details.lineChartView
import kotlinx.android.synthetic.main.fragment_coin_details.nameTextView
import kotlinx.android.synthetic.main.fragment_coin_details.priceTextView
import kotlinx.android.synthetic.main.fragment_coin_details.toolbar
import toothpick.Toothpick
import toothpick.config.Module
import java.util.Date

/**
 * @author Fogel Artem on 16.05.2018.
 */
class CoinDetailsFragment : BaseFragment(), CoinDetailsView {
  companion object {
    fun newInstance(coin: MarketCapCoin?): CoinDetailsFragment {
      Toothpick.openScope(Scopes.COIN_SCOPE)
          .installModules(object : Module() {
            init {
              bind(MarketCapCoin::class.java).toInstance(coin)
            }
          })
      return CoinDetailsFragment()
    }
  }

  override fun getLayoutRes() = R.layout.fragment_coin_details

  @InjectPresenter
  lateinit var presenter: CoinDetailsPresenter

  @ProvidePresenter
  fun providePresenter(): CoinDetailsPresenter {
    val scope = Toothpick.openScope(Scopes.COIN_SCOPE)
    return scope.getInstance(CoinDetailsPresenter::class.java)
  }

  override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)
    toolbar.setNavigationOnClickListener { presenter.onNavigationClicked() }
  }

  override fun showCoin(coinView: MarketCapCoin) = with(coinView) {
    toolbar.title = symbol
    nameTextView.text = name
    priceTextView.text = priceUsd
  }

  override fun showChart(chart: List<Chart>) {
    lineChartView.apply {
      setTouchEnabled(false)
      setNoDataText(getString(R.string.no_chart_data))
      isDragEnabled = false
      setScaleEnabled(false)

      val entries = ArrayList<Entry>()
      chart.forEach {
        val hour = Date(it.time).hours
        entries.add(
            Entry(
                hour.toFloat(),
                it.value
            )
        )
      }
      val set = LineDataSet(entries, "Price")
      val lineData = LineData(set)
      data = lineData
      invalidate()
    }
  }

  override fun showError(message: String) {
    showSnackBar(message)
  }
}