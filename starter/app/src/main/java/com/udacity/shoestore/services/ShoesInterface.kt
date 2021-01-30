package com.udacity.shoestore.services

import com.udacity.shoestore.models.Shoe

interface ShoesInterface {
    fun getAllShoes() : List<Shoe>
}