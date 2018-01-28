package fogelao.com.github.coinmarket.model.data.storage


interface BaseDAO<E, in I> {

    fun get(i: I): E

    fun getAll(): List<E>

    fun save(e: E)

    fun saveAll(es: List<E>)

    fun delete(i: I)

    fun deleteAll()

}