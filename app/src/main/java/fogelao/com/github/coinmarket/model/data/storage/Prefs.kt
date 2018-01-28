package fogelao.com.github.coinmarket.model.data.storage

import android.content.Context


class Prefs(private val context: Context) {
    private val DEFAULT_STORAGE = "default_storage"
    private val LAST_UPDATE = "last_update"

    private fun getSharedPreferences(prefsName: String) = context.getSharedPreferences(prefsName, Context.MODE_PRIVATE)

    var lastUpdate: Long
        get() = getSharedPreferences(DEFAULT_STORAGE).getLong(LAST_UPDATE, 0)
        set(value) {
            getSharedPreferences(DEFAULT_STORAGE).edit().putLong(LAST_UPDATE, value).apply()
        }

}