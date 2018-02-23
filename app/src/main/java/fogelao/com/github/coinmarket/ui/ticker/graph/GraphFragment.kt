package fogelao.com.github.coinmarket.ui.ticker.graph

import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.VISIBLE
import android.view.ViewGroup
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import fogelao.com.github.coinmarket.R
import fogelao.com.github.coinmarket.entity.api.HistoryItem
import fogelao.com.github.coinmarket.entity.api.graph.GraphItem
import fogelao.com.github.coinmarket.entity.view.TickerView
import fogelao.com.github.coinmarket.extensions.toast
import fogelao.com.github.coinmarket.presentation.ticker.graph.GraphPresenter
import fogelao.com.github.coinmarket.presentation.ticker.graph.GraphView
import kotlinx.android.synthetic.main.fragment_ticker_graph.*


class GraphFragment : Fragment(), GraphView {
    companion object {
        val TAG = GraphFragment::class.java.simpleName
        fun newInstance(): GraphFragment = GraphFragment()
        fun newInstance(bundle: Bundle): GraphFragment = GraphFragment().apply { arguments = bundle }
    }

    private val presenter = GraphPresenter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_ticker_graph, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val ticker = arguments.getSerializable(TickerView.TAG) as TickerView?
        if (ticker == null) {
            //TODO: Error
            return
        }

        presenter.attachView(this)
        presenter.getGraphData(ticker.id)

    }

    override fun showGraph(items: List<GraphItem>) {
        items.forEach { Log.d(TAG, "$it") }
    }

    override fun showError(message: String) {
        context.toast(message)
    }

    override fun showProgress(show: Boolean) {
        //TODO:show progress
    }


    private fun showHistoryData(items: List<HistoryItem>) {

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
        dataSet.lineWidth = 3f
        dataSet.color = Color.rgb(29, 247, 14)

        val lineData = LineData(dataSet)


        lineChart.data = lineData
        lineChart.invalidate()
    }

}