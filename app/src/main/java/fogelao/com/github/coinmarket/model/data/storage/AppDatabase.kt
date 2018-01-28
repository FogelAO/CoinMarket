package fogelao.com.github.coinmarket.model.data.storage

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import fogelao.com.github.coinmarket.entity.api.TickerApi
import fogelao.com.github.coinmarket.model.data.storage.ticker.TickerDAO

@Database(entities = [(TickerApi::class)], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun tickerDAO(): TickerDAO

}