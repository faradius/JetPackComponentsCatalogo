package com.alex.jetpackcomponentscatalogo

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alex.jetpackcomponentscatalogo.ui.theme.JetPackComponentsCatalogoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackComponentsCatalogoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    /*var myText by remember { mutableStateOf("Aris") }
                    MyTextField(myText,{myText = it})*/

                    /*Column() {
                        MyTextFieldOutlined()
                    }*/

                    MyProgress()

                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetPackComponentsCatalogoTheme {
        MyProgress()
    }
}

@Composable
fun MyProgress() {
    Column(
        Modifier
            .padding(24.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(color = Color.Red, strokeWidth = 10.dp)
        LinearProgressIndicator(modifier = Modifier.padding(top = 16.dp), color = Color.Red, backgroundColor = Color.Green)
    }
}

@Composable
fun MyIcon() {
    Icon(
        //https://fonts.google.com/icons
        imageVector = Icons.Rounded.Star,
        contentDescription = "Icon",
        tint = Color.Red
    )

}

@Composable
fun MyImageAdvance() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "ejemplo",
        modifier = Modifier
            .clip(CircleShape)
            .border(5.dp, Color.Red, CircleShape)
    )
}

@Composable
fun MyImage() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "ejemplo",
        alpha = 0.5f
    )
}

@Composable
fun MyButtonExample() {
    var enabled by rememberSaveable {
        mutableStateOf(true)
    }
    Column(
        Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        Button(
            onClick = { enabled = false },
            enabled = enabled,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Red,
                contentColor = Color.Blue
            ),
            border = BorderStroke(5.dp, Color.Green)
        ) {
            Text(text = "Hola")
        }

        OutlinedButton(
            onClick = { enabled = false },
            enabled = enabled,
            modifier = Modifier.padding(top = 8.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Red,
                contentColor = Color.Blue,
                disabledBackgroundColor = Color.Green,
                disabledContentColor = Color.Magenta
            )
        ) {
            Text(text = "Hola")
        }

        TextButton(onClick = { }) {
            Text(text = "Hola")
        }
    }
}

@Composable
fun MyTextFieldOutlined() {//EditText
    var myText by remember { mutableStateOf("") }
    OutlinedTextField(
        value = myText,
        onValueChange = { myText = it },
        modifier = Modifier.padding(24.dp),
        label = { Text(text = "Hola") },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Green,
            unfocusedLabelColor = Color.Red
        )
    )
}

@Composable
fun MyTextFieldAdvance() { //EditText
    var myText by remember { mutableStateOf("") }
    TextField(
        value = myText,
        onValueChange = {
            myText =
                if (it.contains("a")) {
                    it.replace("a", "")
                } else {
                    it
                }
        },
        label = { Text(text = "Introduce tu nombre") })
}

@Composable
fun MyTextField(name: String, onValueChange: (String) -> Unit) {//EditText
    //var myText by remember { mutableStateOf("Aris") }
    TextField(value = name, onValueChange = { onValueChange(it) })
}

@Composable
fun MyText() { //TextView
    Column(Modifier.fillMaxSize()) {
        Text(text = "Esto es un ejemplo")
        Text(text = "Esto es un ejemplo", color = Color.Blue)
        Text(text = "Esto es un ejemplo", fontWeight = FontWeight.ExtraBold)
        Text(text = "Esto es un ejemplo", fontWeight = FontWeight.ExtraLight)
        Text(text = "Esto es un ejemplo", style = TextStyle(fontFamily = FontFamily.Cursive))
        Text(text = "Esto es un ejemplo", textDecoration = TextDecoration.LineThrough)
        Text(text = "Esto es un ejemplo", textDecoration = TextDecoration.Underline)
        Text(
            text = "Esto es un ejemplo", textDecoration = TextDecoration.combine(
                listOf(TextDecoration.Underline, TextDecoration.LineThrough)
            )
        )
        Text(text = "Esto es un ejemplo", fontSize = 30.sp)
    }

}