package fogelao.com.github.coinmarket.presentation.main

import android.util.Log
import com.arellomobile.mvp.InjectViewState
import fogelao.com.github.coinmarket.di.DI
import fogelao.com.github.coinmarket.model.interactor.TickerInteractor
import fogelao.com.github.coinmarket.presentation.global.BasePresenter
import javax.inject.Inject


@InjectViewState
class MainPresenter : BasePresenter<MainView>() {
    companion object {
        val TAG = MainPresenter::class.java.simpleName
    }


    @Inject
    lateinit var tickerInteractor: TickerInteractor

    override fun onFirstViewAttach() {
        DI.componentManager().appComponent.inject(this)

        getAllTickers()
    }

    fun refresh() {
        tickerInteractor
                .refreshAllTickers()
                .doOnSubscribe { viewState.showRefreshing(true) }
                .doAfterTerminate { viewState.showRefreshing(false) }
                .subscribe(
                        { viewState.showTickers(it) },
                        { viewState.showMessage(it.message ?: "Error") }
                )
                .connect()
    }


    private fun getAllTickers() {
        tickerInteractor
                .getAllTickers()
                .doOnSubscribe { viewState.showProgress(true) }
                .doAfterTerminate { viewState.showProgress(false) }
                .subscribe(
                        { viewState.showTickers(it) },
                        { viewState.showMessage(it.message ?: "Error"); Log.w(TAG, it) }
                )
                .connect()
    }
}