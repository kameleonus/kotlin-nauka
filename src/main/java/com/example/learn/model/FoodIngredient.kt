package com.example.learn.model

import android.graphics.drawable.Drawable
import androidx.core.content.res.ResourcesCompat
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
   private val imgName:String)
{
    val intake
        get() = """${"\u2642"} $dailyMale ${unit.getLocalName()}
            |${"\u2640"} $dailyFem ${unit.getLocalName()}""".trimMargin()
    val drawable:Drawable?
        get(){
            val appContext = App.appContext
            val id= appContext.resources.getIdentifier(imgName,DRAWABLE_TYPE_DEF,appContext.packageName)
            return ResourcesCompat.getDrawable(appContext.resources,id,null)
        }
    companion object{
        const val DRAWABLE_TYPE_DEF= "drawable"
    }
}

enum class IntakeDoseUnit (){
    GRAM() {
        override fun getLocalName() = App.appContext.getString(R.string.gram)

    }, MGRAM() {
        override fun getLocalName() = App.appContext.getString(R.string.miligram)

    }, UGRAM() {
        override fun getLocalName() = App.appContext.getString(R.string.mikrogram)

    }, IU() {
        override fun getLocalName()= App.appContext.getString(R.string.unifiedunit)

    };

    abstract fun getLocalName():String?
}
