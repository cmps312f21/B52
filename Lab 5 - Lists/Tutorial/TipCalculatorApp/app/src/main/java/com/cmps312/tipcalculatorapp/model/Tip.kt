package com.cmps312.tipcalculatorapp.model

//"Good" "Okay" "Amaizing"
class Tip(var amount: Double = 0.0, tipOption: String, roundUp : Boolean) {

    //CTRL + D -> repear a line
    private val tipPercentage = when(tipOption){
        "Okay (10%)" -> 0.1
        "Good (10%)" -> 0.15
        "Amazing (10%)" -> 0.2
    }

}