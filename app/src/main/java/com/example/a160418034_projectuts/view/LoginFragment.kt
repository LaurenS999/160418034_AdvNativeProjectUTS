package com.example.a160418034_projectuts.view

import android.os.Bundle
import android.os.Debug
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.a160418034_projectuts.R
import com.example.a160418034_projectuts.model.User
import com.example.a160418034_projectuts.viewmodel.UserModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {
    private lateinit var ViewModel: UserModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        ViewModel = ViewModelProvider(this).get(UserModel::class.java)
        ViewModel.fetch()

        btnLogin.setOnClickListener {
            if (txtUsername.text.toString() == ViewModel.UserLD.value?.Username.toString() &&
                txtPassword.text.toString() == ViewModel.UserLD.value?.password.toString())
                {
                    val action = LoginFragmentDirections.actionLoginFragmentToRecipeListFragment(ViewModel.UserLD.value?.Username.toString())
                    Navigation.findNavController(it).navigate(action)

                }
            else
            {

            }
        }
    }
}