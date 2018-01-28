package fogelao.com.github.coinmarket.ui.main

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View.GONE
import android.view.View.VISIBLE
import fogelao.com.github.coinmarket.R
import fogelao.com.github.coinmarket.entity.view.TickerView
import fogelao.com.github.coinmarket.extensions.toast
import fogelao.com.github.coinmarket.presentation.main.MainPresenter
import fogelao.com.github.coinmarket.presentation.main.MainView
import fogelao.com.github.coinmarket.ui.graph.TickerInfoActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {
    private val presenter = MainPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        swipeRefreshLayout.setOnRefreshListener {
            presenter.refresh()
        }

        presenter.attachView(this)
    }


    override fun showTickers(tickerApis: List<TickerView>) {
        Log.d("Activity", "size=${tickerApis.size}")

        recyclerView.run {
            visibility = VISIBLE
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            val dividerItemDecoration = DividerItemDecoration(this@MainActivity, LinearLayoutManager.VERTICAL)
            addItemDecoration(dividerItemDecoration)
            adapter = TickersAdapter(tickerApis, this@MainActivity::showTickerInfo)
        }
    }

    override fun showProgress(show: Boolean) {
        if (show) {
            recyclerView.visibility = GONE
            progress.visibility = VISIBLE
        } else {
            progress.visibility = GONE
        }
    }

    override fun showMessage(message: String) {
        toast(message)
    }

    override fun showRefreshing(show: Boolean) {
        swipeRefreshLayout.isRefreshing = show
    }

    private fun showTickerInfo(ticker: TickerView) {
        //TODO: Show tickerApi info

        val intent = Intent(this, TickerInfoActivity::class.java).putExtra(TickerInfoActivity.TICKER_TAG, ticker)

        startActivity(intent)
    }

}
