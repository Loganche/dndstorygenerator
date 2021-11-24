package lxndrloginov.projects.dndstorygenerator.data

import lxndrloginov.projects.dndstorygenerator.R

class Dice(val numSides: Int, val imageId: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}