package de.tobbecit.memoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.tobbecit.memoapp.ui.theme.MemoMouseTheme

class MainActivity : ComponentActivity() {

    private val memos = mutableListOf<Memo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            MemoMouseTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    MemoTopAppBar()
                    MemoListScreen()
                }
            }
        }
    }
}

data class Memo(val title: String, val memo: String)


@Composable
fun MemoInput(
    title: String,
    onTitleChange: (String) -> Unit,
    memo: String,
    onMemoChange: (String) -> Unit
) {
    Column(modifier = Modifier.padding(16.dp)) {
        OutlinedTextField(
            value = title,
            onValueChange = onTitleChange,
            label = { Text("Title") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = memo,
            onValueChange = onMemoChange,
            label = { Text("Memo") },
            modifier = Modifier.fillMaxWidth(),
            maxLines = 4
        )
    }
}


@Composable
fun NewMemoScreen(
    onMemoSaved: (String, String) -> Unit
) {
    var title by remember { mutableStateOf("") }
    var memo by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        MemoInput(
            title = title,
            onTitleChange = { title = it },
            memo = memo,
            onMemoChange = { memo = it }
        )
        Button(
            onClick = { onMemoSaved(title, memo) },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Save Memo")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MemoMouseTheme {
        NewMemoScreen {title: String, memo: String -> /* Do nothing */ }
    }
}