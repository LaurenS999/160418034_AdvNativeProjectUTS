package com.example.a160418034_projectuts.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.a160418034_projectuts.R
import com.example.a160418034_projectuts.util.loadImage
import com.example.a160418034_projectuts.viewmodel.RecipeDetailModel
import com.example.a160418034_projectuts.viewmodel.UserModel
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlinx.android.synthetic.main.fragment_profile.view.*
import kotlinx.android.synthetic.main.fragment_recipe_detail.*

class ProfileFragment : Fragment() {
    private lateinit var ViewModel: UserModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnLogout.setOnClickListener{
            val action = ProfileFragmentDirections.actionLoginFragment()
            Navigation.findNavController(it).navigate(action)
        }

        ViewModel = ViewModelProvider(this).get(UserModel::class.java)
        ViewModel.fetch()

        txtUsername.setText(ViewModel.UserLD.value?.Username)
        txtPassword.setText(ViewModel.UserLD.value?.password)
        txtAddress.setText(ViewModel.UserLD.value?.address)
        txtPhone.setText(ViewModel.UserLD.value?.phone)

        imageViewProfile.loadImage(ViewModel.UserLD.value?.photoUrl,
                view.progressBarPhotoUser)

        observeViewModel()
    }

    fun observeViewModel(){
        ViewModel.UserLD.observe(viewLifecycleOwner, Observer {
            txtUsername.setText(it.Username)
            txtPassword.setText(it.password)
            txtAddress.setText(it.address)
            txtPhone.setText(it.phone)

        })

    }

}