package fogelao.com.github.coinmarket.model.interactor

import com.github.mikephil.charting.data.Entry
import fogelao.com.github.coinmarket.entity.api.HistoryItem
import fogelao.com.github.coinmarket.model.repository.TickerRepository
import javax.inject.Inject


class HistoryInteractor @Inject constructor(private val repository: TickerRepository) {

    fun getHistory(symbolId: String, periodId: String, timeStart: String) = repository.getHistory(symbolId, periodId, timeStart)


    private fun mapToEntries(items: List<HistoryItem>): List<Entry> {
        val entries = ArrayList<Entry>()

        for (i in 0..items.lastIndex) {
            val day = items[i].getDay().toFloat()
            val value = items[i].priceHigh.toFloat()
            entries.add(Entry(day, value))
        }

        return entries
    }


}