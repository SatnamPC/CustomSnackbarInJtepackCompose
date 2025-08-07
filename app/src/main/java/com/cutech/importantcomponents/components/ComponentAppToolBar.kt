package com.cutech.importantcomponents.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cutech.importantcomponents.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComponentAppToolBar(title: String, onBackClick: () -> Unit, isBackButton: Boolean) {
    CenterAlignedTopAppBar(
        modifier = Modifier.height(60.dp), title = {
            Box(
                modifier = Modifier.fillMaxHeight()
            ) {
                Text(
                    text = title,
                    modifier = Modifier.align(Alignment.Center),
                    color = Color.Blue,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Cursive
                )
            }
        }, colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color.Cyan, titleContentColor = Color.White
        ), navigationIcon = {
            if (isBackButton) {
                IconButton(
                    onClick = { onBackClick() }, modifier = Modifier.fillMaxHeight()
                ) {
                    Image(
                        painter = painterResource(R.drawable.ic_back_arrow_24),
                        contentDescription = "",
                        modifier = Modifier.size(height = 20.dp, width = 20.dp),
                        contentScale = ContentScale.FillBounds
                    )
                }
            }
        })
}