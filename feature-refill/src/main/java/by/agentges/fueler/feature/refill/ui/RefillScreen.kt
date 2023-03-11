package by.agentges.fueler.ui.home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun RefillScreen(modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        item {
            Text(text = "One")
        }
    }
}