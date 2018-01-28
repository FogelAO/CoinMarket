package fogelao.com.github.coinmarket.ui.graph

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View.GONE
import android.view.View.VISIBLE
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import fogelao.com.github.coinmarket.R
import fogelao.com.github.coinmarket.entity.api.HistoryItem
import fogelao.com.github.coinmarket.entity.view.TickerView
import fogelao.com.github.coinmarket.extensions.toast
import fogelao.com.github.coinmarket.presentation.ticker.TickerPresenter
import kotlinx.android.synthetic.main.activity_ticker_info.*
import org.joda.time.DateTime
import java.util.*

class TickerInfoActivity : AppCompatActivity(), fogelao.com.github.coinmarket.presentation.ticker.TickerView {
    companion object {

        const val TICKER_TAG = "ticker"
    }

    private val presenter = TickerPresenter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ticker_info)

        if (intent.getSerializableExtra(TICKER_TAG) == null) {
            toast("Unknown error occurred")
            return
        }

        val ticker = intent.getSerializableExtra(TICKER_TAG) as TickerView

        presenter.attachView(this)
        presenter.ticker = ticker

        val timeStart = DateTime.now().toDateTimeISO()
        Log.d(TICKER_TAG, "timeStart=$timeStart")

        presenter.getHistory("", "", "")

        swipeRefreshLayout.setOnRefreshListener { presenter.refresh() }
    }


    override fun showHistoryData(items: List<HistoryItem>) {
        lineChart.visibility = VISIBLE
        lineChart.clear()

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
        dataSet.lineWidth = 2f
        dataSet.color = Color.rgb(29, 247, 14)

        val lineData = LineData(dataSet)
        lineData.setValueTextSize(1.6f)
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
