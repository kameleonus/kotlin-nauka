package com.example.learn.model

import com.example.learn.App
import com.example.learn.R

/**
 * Model danych dla składnika pokarnomwego
 */
data class FoodIngredient(
    val id:Int,
    val name:String,
    val desc: String,
    val danger: String,
    val foodExample: String,
   private val dailyMale: String,
   private val dailyFem: String,
   private val unit:IntakeDoseUnit,
   private val imageName:String)
{
    val intake
        get() = """${"\u2642"} $dailyMale ${unit.getName()}
            |${"\u2640"} $dailyFem ${unit.getName()}""".trimMargin()

}

enum class IntakeDoseUnit (){
    GRAM() {
        override fun getName() {
            App.appContext.getString(R.string.gram)
        }
    }, MGRAM() {
        override fun getName() {
            App.appContext.getString(R.string.miligram)
        }
    }, UGRAM() {
        override fun getName() {
            App.appContext.getString(R.string.mikrogram)
        }
    }, IU() {
        override fun getName() {
            App.appContext.getString(R.string.unifiedunit)
        }
    };

    abstract fun getName()
}
