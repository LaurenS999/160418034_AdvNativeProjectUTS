package com.example.a160418034_projectuts.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a160418034_projectuts.R
import com.example.a160418034_projectuts.viewmodel.RecipeListModel
import kotlinx.android.synthetic.main.fragment_recipe_list.*

class RecipeListFragment : Fragment() {
    private lateinit var ViewModel:RecipeListModel
    private val recipeListAdapter = RecipeListAdapter(arrayListOf())
    public var Username:String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recipe_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        floatingActionButtonAdd.setOnClickListener {
            val action = RecipeListFragmentDirections.actionRecipeListFragmentToAddRecipeFragment2()
            Navigation.findNavController(it).navigate(action)
        }

        ViewModel = ViewModelProvider(this).get(RecipeListModel::class.java)
        ViewModel.refresh()

        recViewRecipeList.layoutManager = LinearLayoutManager(context)
        recViewRecipeList.adapter = recipeListAdapter

        refreshlayout.setOnRefreshListener {
            recViewRecipeList.visibility = View.GONE
            txtError.visibility = View.GONE
            progressLoadRecipeList.visibility = View.VISIBLE
            ViewModel.refresh()
            refreshlayout.isRefreshing = false
        }

        observeViewModel()
    }

    fun observeViewModel(){
        ViewModel.RecipeLD.observe(viewLifecycleOwner, Observer {
            recipeListAdapter.updateRecipeList(it)
        })

        ViewModel.RecipeLoadErrorLD.observe(viewLifecycleOwner, Observer {
            if(it) {
                txtError.visibility = View.VISIBLE
            } else {
                txtError.visibility = View.GONE
            }
        })

        ViewModel.loadingLD.observe(viewLifecycleOwner, Observer {
            if(it) {
                progressLoadRecipeList.visibility = View.VISIBLE
                recViewRecipeList.visibility = View.GONE
            } else {
                progressLoadRecipeList.visibility = View.GONE
                recViewRecipeList.visibility = View.VISIBLE
            }
        })
    }
}