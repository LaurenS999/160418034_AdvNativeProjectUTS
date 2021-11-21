package com.example.a160418034_projectuts.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.a160418034_projectuts.model.Kategori
import com.example.a160418034_projectuts.model.Recipe

class KategoriModel: ViewModel() {
    val KategoriLD = MutableLiveData<List<Kategori>>()
    val KategoriLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

    fun refresh() {
        val kategori1 = Kategori("Ayam")
        val kategori2 = Kategori( "Nasi")

        val KategoriList:ArrayList<Kategori> = arrayListOf<Kategori>(kategori1,kategori2)

        KategoriLD.value = KategoriList
        KategoriLoadErrorLD.value = false
        loadingLD.value = false
    }
}