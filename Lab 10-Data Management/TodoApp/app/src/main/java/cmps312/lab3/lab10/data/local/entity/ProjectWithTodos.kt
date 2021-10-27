package cmps312.lab.todoapplication.data.local.entity

import cmps312.lab3.lab10.data.local.entity.Project
import cmps312.lab3.lab10.data.local.entity.Todo

data class ProjectWithTodos(
    val project: Project,
    val todos: List<Todo>,
)