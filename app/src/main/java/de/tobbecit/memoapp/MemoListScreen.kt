package de.tobbecit.memoapp

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MemoListScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        MemoTopAppBar()

        val stringItems = listOf("StringItem 1", "StringItem 2", "StringItem 3")

        LazyColumn {
            items(stringItems.size) { index ->
                Text(text = stringItems[index], modifier = Modifier.padding(16.dp))
            }
        }

        LazyColumn {
            item {
                Text(text = "One Item")
            }
        }

        val testItemList = listOf(
            TestItem(1, "Item 1"),
            TestItem(2, "Item 2"),
            TestItem(3, "Item 3")
        )

        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(
                items = testItemList,
                key = { list -> list.key }
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(IntrinsicSize.Min)
                        .background(MaterialTheme.colorScheme.surface)
                        .padding(5.dp)
                        .border(
                            BorderStroke(
                                1.dp,
                                MaterialTheme.colorScheme.surface
                            ),
                            shape = RoundedCornerShape(5.dp)
                        )
                ) {
                    Row(modifier = Modifier.padding(5.dp).fillMaxWidth()) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(text = it.key.toString())
                            Text(text = it.value)
                        }
                    }
                }
            }
        }
    }
}

data class TestItem(val key: Int, val value: String)