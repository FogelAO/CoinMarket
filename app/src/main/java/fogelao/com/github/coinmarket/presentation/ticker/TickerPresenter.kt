package fogelao.com.github.coinmarket.presentation.ticker

import android.util.Log
import com.arellomobile.mvp.InjectViewState
import fogelao.com.github.coinmarket.di.DI
import fogelao.com.github.coinmarket.model.interactor.HistoryInteractor
import fogelao.com.github.coinmarket.presentation.global.BasePresenter
import javax.inject.Inject


@InjectViewState
class TickerPresenter : BasePresenter<TickerView>() {
    companion object {
        val TAG = TickerPresenter::class.java.simpleName
    }

    @Inject
    lateinit var historyInteractor: HistoryInteractor

    lateinit var ticker: fogelao.com.github.coinmarket.entity.view.TickerView

    override fun onFirstViewAttach() {
        DI.componentManager().appComponent.inject(this)
    }

    fun getHistory(symbolId: String, periodId: String, timeStart: String) {
        historyInteractor
                .getHistory(symbolId, periodId, timeStart)
                .doOnSubscribe { viewState.showProgress(true) }
                .doAfterTerminate { viewState.showProgress(false) }
                .subscribe(
                        { viewState.showHistoryData(it) },
                        { viewState.showMessage(it.message ?: "Error"); Log.w(TAG, it) }
                )
                .connect()
    }

    fun refresh() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}