package fogelao.com.github.coinmarket.model.data.storage.ticker

import android.arch.persistence.room.*
import fogelao.com.github.coinmarket.entity.api.TickerApi
import io.reactivex.Single

@Dao
interface TickerDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAll(tickerApis: List<TickerApi>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(tickerApi: TickerApi)

    @Query("SELECT * FROM ticker")
    fun getAll(): List<TickerApi>

    @Query("SELECT * FROM ticker WHERE uid = :arg0 LIMIT 1")
    fun get(id: String): TickerApi

    @Query("SELECT * FROM ticker")
    fun getAllObservable(): Single<List<TickerApi>>

    @Query("SELECT * FROM ticker WHERE uid = :arg0 LIMIT 1")
    fun getObservable(id: String): Single<TickerApi>

    @Query("DELETE FROM ticker WHERE uid = :arg0")
    fun delete(id: String)

    @Delete
    fun delete(tickerApi: TickerApi)

    @Query("DELETE  FROM ticker")
    fun deleteAll()


}