package com.plcoding.bookpedia
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import com.plcoding.bookpedia.book.presentation.book_list.components.BookSearchBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.plcoding.bookpedia.book.domain.Book
import com.plcoding.bookpedia.book.presentation.book_list.BookListScreen
import com.plcoding.bookpedia.book.presentation.book_list.BookListState

@Preview
@Composable
fun BookSearchBarPreview() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {
        BookSearchBar(
            searchQuery = "Kotlin",
            onSearchQueryChange = {},
            onImeSearch = {},
        )
    }
}

private val books = (1..100).map {
     Book(
         id = it.toString(),
         title = "Book $it",
         imageUrl = "https://picsum.photos/200/300?random=$it",
         authors = listOf("Author $it"),
         description = "Description $it",
         languages = listOf("English"),
         firstPublishYear = it.toString(),
         averageRating = it.toDouble(),
         ratingCount = it,
         numPages = it,
         numEditions = it
     )
}

@Preview
@Composable
private fun BookListScreenPreview() {
    BookListScreen(
        state = BookListState(
            searchResults = books,
        ),
        onAction = {},
    )
}