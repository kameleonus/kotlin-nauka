package com.example.learn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.learn.model.FoodIngredient
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MainActivity : AppCompatActivity() {

    val ingredientArray by lazy{
        val jsonStream = assets.open("base.json")
        val size=jsonStream.available()
        val buffer = ByteArray(size)
        jsonStream.read(buffer)
        jsonStream.close()
        val jsonString = String(buffer,Charsets.UTF_8)

        Gson().fromJson<List<FoodIngredient>>(jsonString, FOOD_ING_TYPE)
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
    companion object{
        val FOOD_ING_TYPE = object: TypeToken<List<FoodIngredient>>(){}.type
    }
}