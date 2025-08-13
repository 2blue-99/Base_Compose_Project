package com.example.base_compose_project.common

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.base_compose_project.ui.theme.CommonStyle
import com.example.base_compose_project.ui.theme.DarkGray
import com.example.base_compose_project.ui.theme.SubColor
import com.lucky_lotto.mvi_test.designsystem.common.AutoSizeText

@Composable
fun CommonButton(
    text: String,
    color: Color = DarkGray,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = color),
        shape = RoundedCornerShape(16.dp),
        modifier = modifier
    ) {
        AutoSizeText(
            text = text,
            style = CommonStyle.text16Bold,
            minSize = 10,
            color = Color.White
        )
    }
}

@Preview
@Composable
private fun CommonButtonPreview() {
    CommonButton("Text", SubColor, {})
}