package fogelao.com.github.coinmarket.presentation.delegate

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hannesdorfmann.adapterdelegates3.AbsListItemAdapterDelegate
import fogelao.com.github.coinmarket.R
import fogelao.com.github.coinmarket.presentation.ListItem
import fogelao.com.github.coinmarket.presentation.LoadingListItem

/**
 * @author Fogel Artem on 14.05.2018.
 */
class LoadingDelegate : AbsListItemAdapterDelegate<LoadingListItem, ListItem, LoadingDelegate.LoadingViewHolder>() {

    override fun isForViewType(item: ListItem, items: MutableList<ListItem>, position: Int) = item is LoadingListItem

    override fun onCreateViewHolder(parent: ViewGroup): LoadingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_loading, parent, false)
        return LoadingViewHolder(view)
    }

    override fun onBindViewHolder(item: LoadingListItem, viewHolder: LoadingViewHolder, payloads: MutableList<Any>) {

    }


    inner class LoadingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}