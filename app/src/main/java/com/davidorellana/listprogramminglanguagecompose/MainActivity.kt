package com.davidorellana.listprogramminglanguagecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.davidorellana.listprogramminglanguagecompose.ui.theme.ListProgrammingLanguageComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ListProgrammingLanguageComposeTheme {
                Surface(color = MaterialTheme.colors.background) {

                    val programmingLanguageList = ProgrammingLanguageListProvider.programmingLanguageList
                    ProgrammingLanguageListScreen(
                        programmingLanguageList = programmingLanguageList
                    )
                }
            }
        }
    }
}