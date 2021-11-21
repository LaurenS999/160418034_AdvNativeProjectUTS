package com.example.a160418034_projectuts.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.a160418034_projectuts.R
import com.example.a160418034_projectuts.model.Recipe
import com.example.a160418034_projectuts.viewmodel.RecipeDetailModel
import kotlinx.android.synthetic.main.fragment_add_recipe.*

class AddRecipeFragment : Fragment() {
    private lateinit var viewModel:RecipeDetailModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_recipe, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(RecipeDetailModel::class.java)

        btnAdd.setOnClickListener{
            var recipe = Recipe(txtRecipeName.toString(), txtKategoriAdd.toString(), txtRecipeName.toString(), txtDeskripsiAdd.toString(), txtStepAdd.toString(), txtPhotoUrl.toString(), 0)

            val list = listOf(recipe)
            viewModel.addTodo(list)
            Toast.makeText(view.context, "Data added", Toast.LENGTH_LONG).show()
            Navigation.findNavController(it).popBackStack()

        }
    }
}