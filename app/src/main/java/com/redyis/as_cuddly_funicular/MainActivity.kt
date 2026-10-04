package com.redyis.as_cuddly_funicular
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.tooling.preview.Preview
import com.redyis.as_cuddly_funicular.ui.theme.AScuddlyfunicularTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            AScuddlyfunicularTheme {
                Scaffold( modifier = Modifier.fillMaxSize() ) { innerPadding ->
                    MainScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    var inputText by remember { mutableStateOf("") }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = inputText,
            onValueChange = {inputText = it},
            label = { Text("Введите текст / номер") }
        )

        Button(
            onClick = {
                if (inputText.isNotBlank()) {
                    val intent = Intent(context, SecondActivity::class.java).apply{
                        putExtra("EXTRA_TEXT", inputText)
                    }
                    context.startActivity(intent)
                }
                else {
                    Toast.makeText(context, "Пожалуйста, введите текст", Toast.LENGTH_SHORT).show()
                }

            }
        ) {
            Text("Открыть вторую Activity")
        }

        Button(
            onClick = {
                if (inputText.isNotBlank() && android.util.Patterns.PHONE.matcher(inputText).matches()) {
                    val intent = Intent(Intent.ACTION_DIAL).apply{
                        data = Uri.parse("tel:$inputText")
                    }
                    context.startActivity(intent)
                }
                else {
                    Toast.makeText(context, "Пожалуйста, введите номер", Toast.LENGTH_SHORT).show()
                }

            }
        ) {
            Text("Позвонить другу")
        }

        Button(
            onClick = {
                if (inputText.isNotBlank()) {
                    val sendIntent = Intent(Intent.ACTION_SEND).apply{
                        type = "text/plain"
                        putExtra(Intent.EXTRA_TEXT, inputText)
                    }
                    val shareIntent = Intent.createChooser(sendIntent, "Поделиться через…")
                    context.startActivity(shareIntent)
                }
                else {
                    Toast.makeText(context, "Пожалуйста, введите текст", Toast.LENGTH_SHORT).show()
                }

            }
        ) {
            Text("Поделиться текстом")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AScuddlyfunicularTheme {
        Greeting("Android")
    }
}

@Composable
fun Greeting(x0: String) {
    TODO("Not yet implemented")
}