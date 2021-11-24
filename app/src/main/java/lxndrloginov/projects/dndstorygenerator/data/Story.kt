package lxndrloginov.projects.dndstorygenerator.data

class Story(val inputString: String) {

    fun generateText(): String {
        // dummy function
        // later will generate text on backend
        return "$inputString Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras rhoncus eu massa a convallis. Nullam ac mattis tortor. Phasellus fermentum augue erat, a accumsan eros lobortis in. Ut bibendum, enim vel mollis eleifend, libero nisi mattis neque, ut lobortis nulla sem non massa. Morbi maximus rutrum purus, ut malesuada massa."
    }
}