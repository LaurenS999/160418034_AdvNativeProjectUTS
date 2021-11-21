package com.example.a160418034_projectuts.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.a160418034_projectuts.model.Recipe
import com.example.a160418034_projectuts.model.RecipeDatabase
import com.example.a160418034_projectuts.view.RecipeListAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class RecipeDetailModel(application: Application):AndroidViewModel(application),CoroutineScope {
    val RecipeDetialLD = MutableLiveData<Recipe>()

    fun fetch(index: Int, List: MutableLiveData<List<Recipe>>)
    {
        val recipeDetil = List.value?.get(index)
        RecipeDetialLD.value = recipeDetil
    }

    private val job = Job()

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    fun addTodo(list:List<Recipe>) {
        launch {
            val db = Room.databaseBuilder(
                getApplication(), RecipeDatabase::class.java,
                "newrecipedb").build()
            db.recipeDao().insertAll(*list.toTypedArray())
        }
    }

}