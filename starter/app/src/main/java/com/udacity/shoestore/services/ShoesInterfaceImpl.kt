package com.udacity.shoestore.services

import com.udacity.shoestore.models.Shoe
import kotlin.random.Random

class ShoesInterfaceImpl : ShoesInterface {
    override fun getAllShoes(): ArrayList<Shoe> {
        val shoes = ArrayList<Shoe>()
        for (i in 1..7){
            var shoe = Shoe(
                "Shoe name $i",
                Random.nextDouble(37.0, 45.0),
                "Shoe company $i",
                "This is the description for shoe $i" )

            shoes.add(shoe)
        }
        return shoes
    }
}