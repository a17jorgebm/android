package com.example.tasklist.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tasklist.R

@Composable
fun AddNoteScren(
    state: NoteState,
    navController: NavController,
    onEvent: (NotesEvent) -> Unit
){
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(

                onClick = {
                    onEvent(NotesEvent.SaveNote(
                        state.title.value,
                        state.description.value
                    ))

                    navController.popBackStack()
                }
            ) {
                Icon(
                    imageVector = Icons.Rounded.Check,
                    contentDescription = "Save Note"
                )
            }
        }
    ) {paddingValues ->

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                value = state.title.value,
                onValueChange = { novoText:String ->
                    state.title.value=novoText
                },
                textStyle = TextStyle(
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 17.sp
                ),
                placeholder = {
                    Text(text = stringResource(id = R.string.title))
                }
            )

            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                value = state.description.value,
                onValueChange = { novoText:String ->
                    state.description.value=novoText
                },
                placeholder = {
                    Text(text = stringResource(id = R.string.description))
                }
            )
        }

    }
}