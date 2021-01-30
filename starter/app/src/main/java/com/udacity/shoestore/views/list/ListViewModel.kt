package com.udacity.shoestore.views.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.services.ShoesInterfaceImpl

class ListViewModel : ViewModel() {

    val shoesList = MutableLiveData<ArrayList<Shoe>>()

    private var shoesRepository: ShoesInterfaceImpl = ShoesInterfaceImpl()

    init {
        shoesList.value = shoesRepository
            .getAllShoes()
    }

    fun addShoe(shoe: Shoe) {
        shoesList
            .value
            ?.add(shoe)
    }
}