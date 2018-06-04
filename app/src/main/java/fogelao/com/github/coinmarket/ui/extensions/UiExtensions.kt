package fogelao.com.github.coinmarket.ui.extensions

import android.content.Context
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.widget.Toast

/**
 * @author Fogel Artem on 14.05.2018.
 */

fun Fragment.showSnackBar(message: String) {
    if (view != null) {
        Snackbar.make(view!!, message, Snackbar.LENGTH_LONG).show()
    }
}

fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}