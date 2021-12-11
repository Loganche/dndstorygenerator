package lxndrloginov.projects.dndstorygenerator.data

class Story(private val inputStringStory: String) {
    val inputs = inputStringStory
    var outputs = ""

    fun getOutput(): String{
        return "$inputs $outputs."
    }
}