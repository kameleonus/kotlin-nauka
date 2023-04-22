package com.example.learn.recycler

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.learn.R
import com.example.learn.model.FoodIngredient
import com.github.florent37.materialviewpager.header.MaterialViewPagerHeaderDecorator
import kotlinx.android.synthetic.main.recycler_fragment_layout.*


/**
 * Fragment listy odzyskiwalnej składnika diety
 */
class RecyclerViewFragment : Fragment() {

    private val foodIngredient by lazy{ arguments?.get(FOOD_TAG) as FoodIngredient}

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?)=
            inflater.inflate(R.layout.recycler_fragment_layout,container,false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
    }

    private fun initRecycler() {
        fragment_recycler.layoutManager = LinearLayoutManager(activity)
        fragment_recycler.setHasFixedSize(true)
        fragment_recycler.addItemDecoration(MaterialViewPagerHeaderDecorator())
        fragment_recycler.adapter = RecyclerViewAdapter(initRecyclerList())
    }

    private fun initRecyclerList(): ArrayList<Pair<String, String>> {
        val List= ArrayList<Pair<String,String>>()
        List.add(Pair(foodIngredient.name,foodIngredient.desc))
        List.add(Pair("Zapotrzebowanie",foodIngredient.intake))
        List.add(Pair("Zagrożenia",foodIngredient.danger))
        List.add(Pair("Zalecane",foodIngredient.foodExample))
        return List
    }

    companion object{
        fun newInstance(foodIngredient: FoodIngredient) : RecyclerViewFragment {
            val recyclerViewFragment =  RecyclerViewFragment()
            val bundle = Bundle()
            bundle.putSerializable(FOOD_TAG,foodIngredient)
            recyclerViewFragment.arguments = bundle
            return recyclerViewFragment
        }
        const val FOOD_TAG = "FOOD_TAG"
    }

}