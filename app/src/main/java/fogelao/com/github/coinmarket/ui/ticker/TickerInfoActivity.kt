package fogelao.com.github.coinmarket.ui.ticker

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.WindowManager
import fogelao.com.github.coinmarket.R
import fogelao.com.github.coinmarket.entity.api.HistoryItem
import fogelao.com.github.coinmarket.entity.view.TickerView
import fogelao.com.github.coinmarket.extensions.toast
import fogelao.com.github.coinmarket.presentation.ticker.TickerPresenter
import fogelao.com.github.coinmarket.ui.ticker.graph.GraphFragment
import fogelao.com.github.coinmarket.ui.ticker.info.TickerInfoFragment
import kotlinx.android.synthetic.main.activity_ticker_info.*
import kotlinx.android.synthetic.main.default_toolbar.*


class TickerInfoActivity : AppCompatActivity(), fogelao.com.github.coinmarket.presentation.ticker.TickerView {
    companion object {

        const val TICKER_TAG = "ticker"
    }

    private val presenter = TickerPresenter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE)
        setContentView(R.layout.activity_ticker_info)
        setSupportActionBar(toolbar)

        swipeRefreshLayout.setOnRefreshListener { }

        if (intent.getSerializableExtra(TICKER_TAG) == null) {
            toast("Unknown error occurred")
            return
        }

        val ticker = intent.getSerializableExtra(TICKER_TAG) as TickerView
        toolbar.title = ticker.name

        presenter.attachView(this)

        val adapter = ViewPageAdapter(supportFragmentManager)

        val bundle = Bundle()
        bundle.putSerializable(TickerView.TAG, ticker)

        adapter.addFragment(TickerInfoFragment.newInstance(bundle), "Info")
        adapter.addFragment(GraphFragment.newInstance(bundle), "Graph")

        viewpager.adapter = adapter

        tabs.setupWithViewPager(viewpager)
    }


    override fun showHistoryData(entries: List<HistoryItem>) {

//        lineChart.visibility = VISIBLE
//        lineChart.clear()
//
//        if (items.isEmpty()) {
//            toast("Server error occurred")
//            onBackPressed()
//        }
//
//        val entries = ArrayList<Entry>()
//
////        for (i in 0..20){
////            entries.add(Entry(i.toFloat(), Random().nextFloat()))
////        }
//
//
//        for (i in 0..items.lastIndex) {
//            val x = items[i].getDay().toFloat()
//            val y = items[i].priceHigh
//            entries.add(Entry(x, y))
//        }
//
//
//        val dataSet = LineDataSet(entries, "Price USD")
//        dataSet.lineWidth = 3f
//        dataSet.color = Color.rgb(29, 247, 14)
//
//        val lineData = LineData(dataSet)
//        lineChart.data = lineData
//        lineChart.invalidate()
    }

    override fun showProgress(show: Boolean) {
        if (show) {
            progress.visibility = VISIBLE
//            lineChart.visibility = GONE
        } else {
            progress.visibility = GONE
        }
    }

    override fun showRefreshing(show: Boolean) {
        swipeRefreshLayout.visibility = if (show) VISIBLE else GONE
    }

    override fun showError(message: String) {
        toast(message)
    }


}
