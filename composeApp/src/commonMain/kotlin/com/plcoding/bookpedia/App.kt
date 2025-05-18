package com.plcoding.bookpedia

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.plcoding.bookpedia.app.Route
import com.plcoding.bookpedia.book.presentation.book_list.BookListScreenRoot
import com.plcoding.bookpedia.book.presentation.book_list.BookListViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Composable
@Preview
fun App() {
    MaterialTheme {
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = Route.BookGraph
        ) {
            composable<Route.BookGraph> {
                val viewModel = koinViewModel<BookListViewModel>()
                BookListScreenRoot(
                    viewModel = viewModel,
                    onBookClick = { book ->
                        println("ON:$book")
                        navController.navigate(
                            Route.BookDetail(book.id)
                        )
                    }
                )
            }

            composable<Route.BookDetail> { entry ->
                val args = entry.toRoute<Route.BookDetail>()
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "Book Detail ${args.id}")
                }
            }

        }
    }
}