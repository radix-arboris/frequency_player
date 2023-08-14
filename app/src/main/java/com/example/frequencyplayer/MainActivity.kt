package com.example.frequencyplayer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.frequencyplayer.ui.theme.FrequencyPlayerTheme
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FrequencyPlayerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GridOfButtons()
                }
            }
        }
    }
}

@Composable
fun GridOfButtons() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        repeat(4) { rowIndex ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                repeat(3) { columnIndex ->
                    val frequency = (rowIndex * 3 + columnIndex + 1) * 100.0 // Adjust this calculation as needed
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .padding(4.dp)
                            .fillMaxSize()
                    ) {
                        Text(
                            text = "${frequency.toInt()} Hz",
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                }
            }
        }
    }
}

fun playFrequency(frequency: Double) {
    // Implement your audio generation and playback logic here
}

@Preview(showBackground = true)
@Composable
fun GridOfButtonsPreview() {
    FrequencyPlayerTheme {
        GridOfButtons()
    }
}
