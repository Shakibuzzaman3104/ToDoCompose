package com.diatomicsoft.todocompose.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.diatomicsoft.todocompose.ui.theme.FontStyle

@Composable
fun ItemToDoChecklist(
    modifier: Modifier,
    text: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {

    Row(modifier = modifier.padding(16.dp)) {

        Checkbox(
            checked = checked,
            onCheckedChange = { onCheckedChange(it) },
            modifier = Modifier.padding(end = 16.dp),
        )

        Text(text, style = FontStyle.titleMedium)

    }


}