package com.example.snack_bar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.snack_bar.ui.theme.Snack_barTheme
import kotlinx.coroutines.launch
import java.time.Duration

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            
//            Snackbar {
//                Text(text = "Hello Jetpack Compose")
//            }
            val scaffoldState = rememberScaffoldState()
            var textField by remember {
                mutableStateOf("")
            }
            val scope = rememberCoroutineScope()

            Scaffold(
                modifier = Modifier.fillMaxSize(),
                scaffoldState = scaffoldState
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 30.dp)
                ) {
                    TextField(
                        value = textField,
                        onValueChange = {
                            textField = it
                        },
                        label = {
                            Text(text = "Enter your name")
                        },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(),
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(onClick = {
                        scope.launch {
                            scaffoldState.snackbarHostState.showSnackbar(
                                "Hello $textField"
                                )
                        }

                    }) {
                        Text(text = "Pls greet me")
                    }
                }
            }
        }
    }
}
