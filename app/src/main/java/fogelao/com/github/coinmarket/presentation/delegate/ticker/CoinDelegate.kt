package fogelao.com.github.coinmarket.presentation.delegate.ticker

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.hannesdorfmann.adapterdelegates3.AbsListItemAdapterDelegate
import fogelao.com.github.coinmarket.R
import fogelao.com.github.coinmarket.entity.coin.CoinView
import fogelao.com.github.coinmarket.presentation.ListItem
import kotlinx.android.synthetic.main.item_coin.view.*

/**
 * @author Fogel Artem on 14.05.2018.
 */
class CoinDelegate(
        private val itemClickListener: (CoinView, View, View, View) -> Unit
) : AbsListItemAdapterDelegate<CoinView, ListItem, CoinDelegate.CoinViewHolder>() {

    override fun isForViewType(item: ListItem, items: MutableList<ListItem>, position: Int) = item is CoinView


    override fun onCreateViewHolder(parent: ViewGroup): CoinViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_coin, parent, false)
        return CoinViewHolder(view, itemClickListener)
    }

    override fun onBindViewHolder(item: CoinView, viewHolder: CoinViewHolder, payloads: MutableList<Any>) {
        viewHolder.bind(item)
    }

    inner class CoinViewHolder(
            itemView: View,
            private val itemClickListener: (CoinView, View, View, View) -> Unit)
        : RecyclerView.ViewHolder(itemView) {
        private val symbolView = itemView.symbolView
        private val rankView = itemView.rankView
        private val imageView = itemView.imageView
        private val chartView = itemView.chartView
        private val nameView = itemView.nameView

        fun bind(coin: CoinView) = with(coin) {
            symbolView.text = symbol
            rankView.text = sortOrder
            Glide.with(itemView)
                    .load(imageUrl)
                    .into(imageView)

            Glide.with(itemView)
                    .load(chartUrl)
                    .into(chartView)

            itemView.setOnClickListener {
                itemClickListener(coin, symbolView, nameView, imageView)
            }
        }
    }
}