package com.cmps312.todoapp.data.entity

import com.google.firebase.firestore.DocumentId

data class Project(

    //todo make it an document id
    @DocumentId
    var id: String = "",
    var name: String? = "",
)