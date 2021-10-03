package com.example.a160418034_projectuts.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.a160418034_projectuts.R
import com.example.a160418034_projectuts.model.Recipe
import com.example.a160418034_projectuts.util.loadImage
import kotlinx.android.synthetic.main.recipe_list_item.view.*

class FavoriteAdapter(val recipeList: ArrayList<Recipe>): RecyclerView.Adapter<FavoriteAdapter.FavoriteViewHolder>() {
    class FavoriteViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    fun updateRecipeList(newRecipeList: List<Recipe>)
    {
        recipeList.clear()
        recipeList.addAll(newRecipeList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.recipe_list_item, parent, false)
        return FavoriteAdapter.FavoriteViewHolder(view)
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        if(recipeList[position].favorite == 1) {
            holder.view.txtNamaRecipe.text = recipeList[position].name
            holder.view.txtDescription.text = recipeList[position].description

            holder.view.imageView.loadImage(recipeList[position].photoUrl,
                    holder.view.progressBarPhoto)

            holder.view.btnDetail.setOnClickListener {
                val action = FavoriteFragmentDirections.actionRecipeDetilFragment(position)
                Navigation.findNavController(it).navigate(action)
            }
        }
        else
        {
            holder.itemView.setVisibility(View.GONE);
            holder.itemView.layoutParams = RecyclerView.LayoutParams(0, 0)
        }
    }

    override fun getItemCount(): Int {
        return recipeList.size
    }

}