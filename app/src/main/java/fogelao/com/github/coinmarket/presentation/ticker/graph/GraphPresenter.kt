package fogelao.com.github.coinmarket.presentation.ticker.graph

import android.util.Log
import fogelao.com.github.coinmarket.di.DI
import fogelao.com.github.coinmarket.model.interactor.HistoryInteractor
import fogelao.com.github.coinmarket.presentation.global.BasePresenter
import org.joda.time.DateTime
import javax.inject.Inject


class GraphPresenter : BasePresenter<GraphView>() {
    companion object {
        val TAG = GraphPresenter::class.java.simpleName
    }

    @Inject
    lateinit var repository: HistoryInteractor

    override fun onFirstViewAttach() {
        DI.componentManager().appComponent.inject(this)
    }


    fun getGraphData(name: String) {
        val start = DateTime.now().minusDays(7).millis
        val end = DateTime.now().millis

        Log.d(TAG, attachedViews.first().toString())

        repository
                .getGraphData(name, start, end)
                .doOnSubscribe { attachedViews.first().showProgress(true) }
                .doAfterTerminate { attachedViews.first().showProgress(false) }
                .subscribe(
                        { attachedViews.first().showGraph(it) },
                        { attachedViews.first().showError(it.message ?: "Error"); Log.w(TAG, it) }
                )
                .connect()
    }

}