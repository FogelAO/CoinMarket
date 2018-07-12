package fogelao.com.github.coinmarket.presentation.delegate.coin

import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hannesdorfmann.adapterdelegates3.AbsListItemAdapterDelegate
import fogelao.com.github.coinmarket.R
import fogelao.com.github.coinmarket.model.network.entity.market_cap.coin.MarketCapCoin
import fogelao.com.github.coinmarket.presentation.ListItem
import kotlinx.android.synthetic.main.item_coin.view.*

/**
 * @author Fogel Artem on 14.05.2018.
 */
class CoinDelegate(
    private val itemClickListener: (MarketCapCoin) -> Unit
) : AbsListItemAdapterDelegate<MarketCapCoin, ListItem, CoinDelegate.CoinViewHolder>() {

  override fun isForViewType(item: ListItem, items: MutableList<ListItem>, position: Int) = item is MarketCapCoin


  override fun onCreateViewHolder(parent: ViewGroup): CoinViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.item_coin, parent, false)
    return CoinViewHolder(view, itemClickListener)
  }

  override fun onBindViewHolder(item: MarketCapCoin, viewHolder: CoinViewHolder, payloads: MutableList<Any>) {
    viewHolder.bind(item)
  }

  inner class CoinViewHolder(
      itemView: View,
      private val itemClickListener: (MarketCapCoin) -> Unit)
    : RecyclerView.ViewHolder(itemView) {
    private lateinit var item: MarketCapCoin

    init {
      itemView.setOnClickListener { itemClickListener.invoke(item) }
    }

    fun bind(coin: MarketCapCoin) {
      item = coin
      with(coin) {
        itemView.apply {
          priceView.text = priceUsd
          symbolView.text = symbol
          nameView.text = name
          hourChangeView.text = "$hourChange%"
          dayChangeView.text = "$dayChange%"
          weekChangeView.text = "$weekChange%"

          hourChangeView.setTextColor(getColor(hourChange))
          dayChangeView.setTextColor(getColor(dayChange))
          weekChangeView.setTextColor(getColor(weekChange))
        }
      }
    }

    private fun getColor(change: String): Int {
      val value = change.toDouble()
      return ContextCompat.getColor(itemView.context, if (value > 0) R.color.green else R.color.red)
    }
  }
}