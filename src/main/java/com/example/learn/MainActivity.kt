package com.example.learn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.learn.model.FoodIngredient
import com.github.florent37.materialviewpager.header.HeaderDesign
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_main.*

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
        initPager()
    }
    private fun initPager(){
        material_pager.viewPager.adapter = object : FragmentStatePagerAdapter(supportFragmentManager,
            BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT)
        {
            override fun getCount() = ingredientArray.size
            override fun getItem(position: Int) = Fragment()
            override fun getPageTitle(position: Int) = ingredientArray[position].name
        }

        material_pager.viewPager.offscreenPageLimit= (material_pager.viewPager.adapter as FragmentStatePagerAdapter).count
        material_pager.pagerTitleStrip.setViewPager(material_pager.viewPager)
        material_pager.setMaterialViewPagerListener{ page: Int -> HeaderDesign.fromColorResAndDrawable(R.color.black,ingredientArray[page].drawable) }
    }
    companion object{
        val FOOD_ING_TYPE = object: TypeToken<List<FoodIngredient>>(){}.type
    }
}