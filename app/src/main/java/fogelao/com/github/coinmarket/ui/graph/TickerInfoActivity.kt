package fogelao.com.github.coinmarket.ui.graph

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.WindowManager
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import fogelao.com.github.coinmarket.R
import fogelao.com.github.coinmarket.entity.api.HistoryItem
import fogelao.com.github.coinmarket.entity.view.TickerView
import fogelao.com.github.coinmarket.extensions.toast
import fogelao.com.github.coinmarket.presentation.ticker.TickerPresenter
import kotlinx.android.synthetic.main.activity_ticker_info.*
import kotlinx.android.synthetic.main.default_toolbar.*
import org.joda.time.DateTime
import java.util.*


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
        presenter.ticker = ticker

        val timeStart = DateTime.now().minusDays(7)

        presenter.getHistory(periodId = "1DAY", timeStart = timeStart)

        swipeRefreshLayout.setOnRefreshListener { presenter.refresh() }
    }


    override fun showHistoryData(items: List<HistoryItem>) {
        lineChart.visibility = VISIBLE
        lineChart.clear()

        if (items.isEmpty()) {
            toast("Server error occurred")
            onBackPressed()
        }

        val entries = ArrayList<Entry>()

//        for (i in 0..20){
//            entries.add(Entry(i.toFloat(), Random().nextFloat()))
//        }


        for (i in 0..items.lastIndex) {
            val x = items[i].getDay().toFloat()
            val y = items[i].priceHigh
            entries.add(Entry(x, y))
        }


        val dataSet = LineDataSet(entries, "Price USD")
        dataSet.lineWidth = 3f
        dataSet.color = Color.rgb(29, 247, 14)

        val lineData = LineData(dataSet)
        lineChart.data = lineData
        lineChart.invalidate()
    }

    override fun showProgress(show: Boolean) {
        if (show) {
            progress.visibility = VISIBLE
            lineChart.visibility = GONE
        } else {
            progress.visibility = GONE
        }
    }

    override fun showRefreshing(show: Boolean) {
        swipeRefreshLayout.visibility = if (show) VISIBLE else GONE
    }

    override fun showMessage(message: String) {
        toast(message)
    }
}
