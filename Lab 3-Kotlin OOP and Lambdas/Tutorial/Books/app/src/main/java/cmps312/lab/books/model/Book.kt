package cmps312.lab.books.model

open class Book(var name: String, var author: String, var yearOfPublication: Int){
    override fun toString(): String {
        return """
            Name : $name
            Author : $author
            Year Of Publication : $yearOfPublication
        """
    }
}

//we call the super constuctor
//ctrl + alt + L
//cmnd + option + L

class PaperBook(
    name: String,
    author: String,
    yearOfPublication: Int,
    var publisher: String,
    var isbn: String
) : Book(name, author, yearOfPublication){

    override fun toString(): String {
        return """
            ${super.toString()}
            publisher : $publisher
            isbn : $isbn
        """.trimIndent()
    }

}


fun main() {
    val book = Book("The loard of the rings", "J.R.R", 1954);
    val paperBook = PaperBook("The loard of the rings", "J.R.R", 1954, "Oriely", "JJ-12-333-44-55");
//    println(book)
    println(paperBook)
}