package fogelao.com.github.coinmarket.presentation.delegate

import android.support.annotation.DrawableRes
import android.support.annotation.StringRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hannesdorfmann.adapterdelegates3.AbsListItemAdapterDelegate
import fogelao.com.github.coinmarket.R
import fogelao.com.github.coinmarket.presentation.ListItem
import fogelao.com.github.coinmarket.presentation.PlaceholderListItem
import kotlinx.android.synthetic.main.item_placeholder.view.*

/**
 * @author Fogel Artem on 14.05.2018.
 */
class PlaceholderDelegate(@DrawableRes private val imageId: Int, @StringRes private val messageId: Int) : AbsListItemAdapterDelegate<PlaceholderListItem, ListItem, PlaceholderDelegate.PlaceholderViewHolder>() {

    override fun isForViewType(item: ListItem, items: MutableList<ListItem>, position: Int) = item is PlaceholderListItem

    override fun onCreateViewHolder(parent: ViewGroup): PlaceholderViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_placeholder, parent, false)
        return PlaceholderViewHolder(view, imageId, messageId)
    }

    override fun onBindViewHolder(item: PlaceholderListItem, viewHolder: PlaceholderViewHolder, payloads: MutableList<Any>) {

    }


    inner class PlaceholderViewHolder(
            itemView: View,
            @DrawableRes imageId: Int,
            @StringRes messageId: Int) : RecyclerView.ViewHolder(itemView) {

        init {
            val message = itemView.context.getString(messageId)
            itemView.imageView.setImageResource(imageId)
            itemView.messageTextView.text = message
        }
    }
}