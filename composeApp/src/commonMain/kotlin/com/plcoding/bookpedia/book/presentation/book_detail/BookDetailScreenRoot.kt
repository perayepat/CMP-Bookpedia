package com.plcoding.bookpedia.book.presentation.book_detail

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.plcoding.bookpedia.book.presentation.book_detail.componets.BlurredImageBackground

@Composable
fun BookDetailScreenRoot(
    viewModel: BookDetailViewModel,
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    BooKDetailScreen(
        state = state,
        onAction = { action ->
            when (action) {
                is BookDetailAction.OnBackClick -> onBackClick()
                else -> Unit
            }
            viewModel.onAction(action)
        }

    )
}

@Composable
private fun BooKDetailScreen(
    state: BookDetailState,
    onAction: (BookDetailAction) -> Unit,
) {
    BlurredImageBackground(
        imageUrl = state.book?.imageUrl,
        isFavorite = state.isFavourite,
        onFavoriteClick = {
            onAction(BookDetailAction.OnFavoriteClick)
        },
        onBackClick = {
            onAction(BookDetailAction.OnBackClick)
        },
        modifier = Modifier.fillMaxSize()
    ){

    }
}