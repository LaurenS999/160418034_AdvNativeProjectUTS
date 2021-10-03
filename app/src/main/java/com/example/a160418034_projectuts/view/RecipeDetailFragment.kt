package com.example.a160418034_projectuts.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.a160418034_projectuts.R
import com.example.a160418034_projectuts.util.loadImage
import com.example.a160418034_projectuts.viewmodel.RecipeDetailModel
import com.example.a160418034_projectuts.viewmodel.RecipeListModel
import kotlinx.android.synthetic.main.fragment_recipe_detail.*
import kotlinx.android.synthetic.main.fragment_recipe_detail.view.*

class RecipeDetailFragment : Fragment() {
    private lateinit var ViewModel: RecipeDetailModel
    private lateinit var ViewModel2: RecipeListModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recipe_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var index = 0;
        if(arguments != null) {
            index = RecipeDetailFragmentArgs.fromBundle(requireArguments()).Index
        }

        ViewModel2 = ViewModelProvider(this).get(RecipeListModel::class.java)
        ViewModel2.refresh()

        ViewModel = ViewModelProvider(this).get(RecipeDetailModel::class.java)
        ViewModel.fetch(index, ViewModel2.RecipeLD)

        txtNamaRecipe.setText(ViewModel.RecipeDetialLD.value?.name)
        txtDescription.setText(ViewModel.RecipeDetialLD.value?.description)
        txtStep.setText(ViewModel.RecipeDetialLD.value?.step)
        txtRecipe.setText(ViewModel.RecipeDetialLD.value?.step)
        txtDeskripsiAdd.setText(ViewModel.RecipeDetialLD.value?.Kategori)

        imageView2.loadImage(ViewModel.RecipeDetialLD.value?.photoUrl,
                view.progressBarRecipeDetail)

        observeViewModel()
    }

    fun observeViewModel(){
        ViewModel.RecipeDetialLD.observe(viewLifecycleOwner, Observer {
            txtNamaRecipe.setText(it.name)
            txtDescription.setText(it.description)
            txtStep.setText(it.step)
        })

    }
}