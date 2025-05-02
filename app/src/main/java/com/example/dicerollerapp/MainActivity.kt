package com.example.dicerollerapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.dicerollerapp.ui.theme.DiceRollerAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DiceRollerAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    DiceRoller(
                        name = "Daniel",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun DiceRoller(name: String, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Column (
        modifier = modifier.fillMaxSize()
    ) {
        Text(text = "Roll it $name!")

        Button (onClick = {
            Toast.makeText(context, "Dice Rolled!", Toast.LENGTH_SHORT).show()
        }) {
            Text("Roll Dice...")
        }
    }
}
