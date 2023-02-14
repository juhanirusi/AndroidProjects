package com.example.thirtytips

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.thirtytips.model.TipsRepository
import com.example.thirtytips.ui.theme.ThirtyTipsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ThirtyTipsTheme {
                TipsApp()
            }
        }
    }
}

@Composable
fun TipsApp() {
    Scaffold(topBar = { TipsTopAppBar() }) { paddingValues ->
        val tips = TipsRepository.tips // Not recommended to access data directly from the UI!
        TipsList(tips = tips, paddingValues)
    }
}

@Composable
fun TipsTopAppBar(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxWidth().size(70.dp), Alignment.Center) {
        Text(
            text = stringResource(R.string.app_name),
            style = MaterialTheme.typography.h1,
            color = MaterialTheme.colors.onSurface
        )
    }
}

//@Preview(showBackground = true)
@Preview("Light Theme")
@Composable
fun TipsPreviewLight() {
    ThirtyTipsTheme(darkTheme = false) {
        TipsApp()
    }
}

//@Preview(showBackground = true)
@Preview("Dark Theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun TipsPreviewDark() {
    ThirtyTipsTheme(darkTheme = true) {
        TipsApp()
    }
}
