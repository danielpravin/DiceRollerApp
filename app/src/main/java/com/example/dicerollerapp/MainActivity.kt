package com.example.dicerollerapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.ui.draw.shadow
import com.example.dicerollerapp.ui.theme.DiceRollerAppTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DiceRollerAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    DiceRoller(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}


fun handleDiceRoll(): Int{

    val diceNumber = Random.nextInt(1, 7)
    //Toast.makeText(context, "Dice Rolled: $diceNumber", Toast.LENGTH_SHORT).show()
    return diceNumber
}

@Composable
fun DiceRoller( modifier: Modifier = Modifier) {
    var diceNumber by remember { mutableIntStateOf(0) }
    Column (
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Text(text = "Click To Roll the Dice")

        Button (
            modifier = Modifier
                .padding(10.dp)
                .shadow(
                    elevation = 10.dp,           // Shadow depth
                    shape = RoundedCornerShape(8.dp), // Match button shape
                    ambientColor = Color.Gray,   // Optional: control ambient color
                    spotColor = Color.DarkGray   // Optional: more realism
                ),
            shape = RoundedCornerShape(8.dp),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 8.dp,
                pressedElevation = 2.dp
            ),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFE0E0E0),
                contentColor = Color.Blue
            ),
            border = BorderStroke(1.dp, Color.DarkGray),
            onClick = { diceNumber = handleDiceRoll() }
        ) {
            Text("..Roll Dice..")
        }

        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "$diceNumber",
            color = Color.Red,
            fontSize = 20.sp
        )
    }
}

