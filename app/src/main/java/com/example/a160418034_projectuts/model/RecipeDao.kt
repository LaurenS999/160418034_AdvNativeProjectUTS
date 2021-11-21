package com.example.a160418034_projectuts.model

import androidx.room.*

@Dao
interface RecipeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg recipe:Recipe)

    @Query("SELECT * FROM Recipe")
    suspend fun selectAllTodo(): List<Recipe>

    @Query("SELECT * FROM Recipe WHERE id= :id")
    suspend fun selectTodo(id:Int): Recipe

    @Delete
    suspend fun deleteTodo(recipe:Recipe)
}

