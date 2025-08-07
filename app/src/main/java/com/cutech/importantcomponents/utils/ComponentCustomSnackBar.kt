package com.cutech.importantcomponents.utils

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * This component is used to show custom toast
 * @param icon to display the icon on toast with message
 * @param message to display the message on toast
 */
@Composable
fun ComponentCustomSnackBar(@DrawableRes icon: Int, message: String) {
    Snackbar(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 20.dp),
        shape = RoundedCornerShape(5.dp),
        containerColor = Color.Red,
        contentColor = Color.White
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = null,
                modifier = Modifier
                    .height(20.dp)
                    .width(20.dp)
            )
            Spacer(modifier = Modifier.padding(end = 15.dp))
            Text(
                text = message,
                color = Color.White,
                fontWeight = FontWeight.Normal,
                fontSize = 15.sp.value.sp,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }
    }
}