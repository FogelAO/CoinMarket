package fogelao.com.github.coinmarket.ui

import com.arellomobile.mvp.MvpView


interface BaseView : MvpView {

    fun showError(message: String)

    fun showProgress(show: Boolean)
}