package fogelao.com.github.coinmarket.ui.main

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import fogelao.com.github.coinmarket.R
import fogelao.com.github.coinmarket.entity.view.TickerView
import kotlinx.android.synthetic.main.item_ticker.view.*


class TickersAdapter(
        private val tickerApis: List<TickerView>,
        private val itemClick: (TickerView) -> Unit
) : RecyclerView.Adapter<TickersAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_ticker, parent, false)

        return ViewHolder(view, itemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ticker = tickerApis[position]
        holder.bind(ticker)
    }

    override fun getItemCount() = tickerApis.size


    inner class ViewHolder(itemView: View, private val itemClick: (TickerView) -> Unit) : RecyclerView.ViewHolder(itemView) {
        private val nameView = itemView.nameView
        private val rankView = itemView.rankView
        private val priceView = itemView.priceView
        private val changeView = itemView.changeView

        fun bind(tickerApi: TickerView) = with(tickerApi) {
            nameView.text = name
            rankView.text = "#$rank"
            priceView.text = "$priceUsd$"

            val color = if (get24hVec()) Color.GREEN else Color.RED

            changeView.setTextColor(color)
            changeView.text = "$percentChange_24h%"

            itemView.setOnClickListener { itemClick(tickerApi) }
        }
    }
}