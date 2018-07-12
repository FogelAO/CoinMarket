package fogelao.com.github.coinmarket.presentation.base

import com.hannesdorfmann.adapterdelegates3.ListDelegationAdapter
import fogelao.com.github.coinmarket.presentation.ListItem

/**
 * @author Fogel Artem on 01-Jul-18.
 */
open class SimpleAdapter : ListDelegationAdapter<List<ListItem>>() {

  override fun setItems(items: List<ListItem>?) {
    super.setItems(items)
    notifyDataSetChanged()
  }
}