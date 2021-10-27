package cmps312.lab3.lab10.data.local.entity

//One to Many [One projecet can have many stodos]
//this will enforce to not have inconsitent ID for a project.

data class Todo(
    var title: String? = null,

    var priority: String? = null,

    var pid: Int,
    val id: Int = 0,
)
