package fogelao.com.github.coinmarket.extensions

import android.content.Context
import android.widget.Toast
import org.joda.time.DateTime
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

class MyLazy : ReadWriteProperty<DateTime, DateTime> {
    var isInitialised = false
    lateinit var time: DateTime

    override fun getValue(thisRef: DateTime, property: KProperty<*>): DateTime {
        if (!isInitialised) {
            time = DateTime.now()
        }

        return time
    }

    override fun setValue(thisRef: DateTime, property: KProperty<*>, value: DateTime) {
        time = value
    }


}
