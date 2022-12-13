package pl.edu.uwr.lista3

data class Lista(val name: String, val index: Int) {
    var id: Int = 0

    constructor(id: Int, name: String, index: Int) : this(name, index) {
        this.id = id
    }
}