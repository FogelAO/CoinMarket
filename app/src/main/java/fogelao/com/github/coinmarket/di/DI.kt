package fogelao.com.github.coinmarket.di

import android.content.Context


object DI {
    private lateinit var componentManager:ComponentManager

    fun init(applicationContext:Context){
        componentManager = ComponentManager(applicationContext)
    }

    fun componentManager() = componentManager
}