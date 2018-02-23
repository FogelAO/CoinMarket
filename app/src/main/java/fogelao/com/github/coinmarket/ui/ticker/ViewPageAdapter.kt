package fogelao.com.github.coinmarket.ui.ticker

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter


class ViewPageAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {
    companion object {
        const val PAGE_COUNT = 2
    }

    private val tabTitles = ArrayList<String>()
    private val fragments = ArrayList<Fragment>()

    override fun getItem(position: Int) = fragments[position]


    override fun getCount() = fragments.size

    override fun getPageTitle(position: Int) = tabTitles[position]

    fun addFragment(fragment: Fragment, title: String) {
        fragments.add(fragment)
        tabTitles.add(title)
    }
}