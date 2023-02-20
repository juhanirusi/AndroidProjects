package com.example.thirtytips

import androidx.annotation.DrawableRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.thirtytips.model.Tip


@Composable
fun TipsList(tips: List<Tip>, paddingValues: PaddingValues) {
    LazyColumn(Modifier.padding(paddingValues)) {
        itemsIndexed(tips) { index, tip ->
            TipItem(tip = tip, index = index + 1)
        }
    }
}

@Composable
fun TipItem(tip: Tip, index: Int, modifier: Modifier = Modifier) {

    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .border(
                width = 2.dp,
                color = MaterialTheme.colors.onSurface,
                shape = RoundedCornerShape(16.dp)
            )
    ) {
        Column(
            modifier = Modifier.padding(vertical = 16.dp, horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier
                    .padding(bottom = 10.dp)
                    .background(
                        MaterialTheme.colors.secondary,
                        shape = CircleShape
                    )
                    .padding(horizontal = 50.dp, vertical = 8.dp),
                text = stringResource(R.string.tip_count, index),
                style = MaterialTheme.typography.h2,
                textAlign = TextAlign.Center
            )
            Text(
                text = stringResource(id = tip.tipTitleRes),
                style = MaterialTheme.typography.h3,
                textAlign = TextAlign.Center
            )
            TipImage(tip.tipImageRes)
            TipDescription(tip.tipDescriptionRes, expanded)
            ShowMoreButton(expanded = expanded, onClick = { expanded = !expanded })
        }
    }
}

@Composable
fun TipImage(@DrawableRes tipImage: Int, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .padding(vertical = 16.dp)
            .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
    ) {
        AsyncImage(model = tipImage, contentDescription = null)
    }
}

@Composable
fun TipDescription(tipDescriptionRes: Int, showMore: Boolean, modifier: Modifier = Modifier) {

    Box(
        modifier = modifier
            .background(
                color = MaterialTheme.colors.onPrimary,
                RoundedCornerShape(bottomEnd = 16.dp, bottomStart = 16.dp)
            )
    ) {
        Column(
            modifier = Modifier.animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
        ) {
            if (showMore) {
                Text(
                    modifier = Modifier.padding(10.dp),
                    text = stringResource(id = tipDescriptionRes)
                )
            } else {
                Text(
                    modifier = Modifier.padding(10.dp),
                    text = stringResource(id = tipDescriptionRes),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Composable
fun ShowMoreButton(expanded: Boolean, onClick: () -> Unit, modifier: Modifier = Modifier) {

    val readMore = stringResource(id = R.string.read_more)
    val hideText = stringResource(id = R.string.collapse)

    Button(
        onClick = onClick,
        modifier = modifier.padding(top = 16.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.onSurface),
    ) {
        Text(
            text = if (expanded) hideText else readMore,
            color = MaterialTheme.colors.surface
        )
    }
}
