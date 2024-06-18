package com.fatherofapps.flib

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fatherofapps.flib.ui.theme.FLibTheme


class MainActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FLibTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeScreen()
                }
            }
        }
    }
}


@Composable
fun HomeScreen() {
    var message by remember {
        mutableStateOf("")
    }

    var encodeMessage by remember {
        mutableStateOf("")
    }

    var decodedMessage by remember {
        mutableStateOf("")
    }

    val action: (String) -> Unit = remember {
        { message ->

//            encodeMessage = FLib.encode(message)
//            decodedMessage = FLib.decode(encodeMessage)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Spacer(modifier = Modifier.height(48.dp))
        TextField(
            value = message,
            onValueChange = {
                message = it
            },
            placeholder = { Text(text = "Enter your message in here") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = { action(message) }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Just do it")
        }
        Spacer(modifier = Modifier.height(48.dp))
        Text(text = "Encoded message:")
        Spacer(modifier = Modifier.height(2.dp))
        Text(text = encodeMessage)
        Spacer(modifier = Modifier.height(12.dp))
        Text(text = "Decoded message:")
        Spacer(modifier = Modifier.height(2.dp))
        Text(text = decodedMessage)
    }

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FLibTheme {
        Greeting("Android")
    }
}