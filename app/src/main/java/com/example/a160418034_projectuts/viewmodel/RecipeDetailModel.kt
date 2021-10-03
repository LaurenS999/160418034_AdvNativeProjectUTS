package com.example.a160418034_projectuts.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.a160418034_projectuts.model.Recipe
import com.example.a160418034_projectuts.view.RecipeListAdapter

class RecipeDetailModel:ViewModel() {
    val RecipeDetialLD = MutableLiveData<Recipe>()

    fun fetch(index: Int, List: MutableLiveData<List<Recipe>>)
    {
        val recipeDetil = List.value?.get(index)
        RecipeDetialLD.value = recipeDetil
    }
}