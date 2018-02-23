package fogelao.com.github.coinmarket.ui.ticker.info

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import fogelao.com.github.coinmarket.R
import fogelao.com.github.coinmarket.entity.view.TickerView
import kotlinx.android.synthetic.main.fragment_ticker_info.*


class TickerInfoFragment : Fragment() {
    companion object {
        fun newInstance(): TickerInfoFragment = TickerInfoFragment()

        fun newInstance(bundle: Bundle): TickerInfoFragment = TickerInfoFragment().apply { arguments = bundle }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
            inflater.inflate(R.layout.fragment_ticker_info, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val ticker = arguments.getSerializable(TickerView.TAG) as TickerView?
        if (ticker == null) {
            //TODO: Show error
            return
        }

        rankView.text = "#${ticker.rank}"
        tickerName.text = ticker.name
        priceView.text = "${ticker.priceUsd} $"
    }
}