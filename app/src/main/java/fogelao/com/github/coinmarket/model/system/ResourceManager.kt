package fogelao.com.github.coinmarket.model.system

import android.content.Context
import android.support.annotation.StringRes
import fogelao.com.github.coinmarket.di.qualifier.AppCtx
import javax.inject.Inject

/**
 * @author Fogel Artem on 14.05.2018.
 */
class ResourceManager @Inject constructor(@AppCtx private val context: Context) {

    fun getString(@StringRes id: Int) = context.getString(id)
}