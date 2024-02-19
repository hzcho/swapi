package com.example.swapi.ui.common_elements

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun <T> Grid(
    items: List<T>,
    rowSize: Int = 1,
    horizontalArrangement: Arrangement.Horizontal=Arrangement.SpaceEvenly,
    verticalArrangement:Arrangement.Vertical=Arrangement.SpaceEvenly,
    modifier: Modifier = Modifier,
    composeItem: @Composable (T)->Unit
) {
    val rows = items.chunked(rowSize)
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(bottom = 100.dp),
        verticalArrangement = verticalArrangement
    ) {
        items(rows){row->
            Row(
                horizontalArrangement = horizontalArrangement,
                modifier = Modifier.fillMaxWidth()
            ) {
                for (item in row){
                    composeItem(item)
                }
            }
        }
    }
}