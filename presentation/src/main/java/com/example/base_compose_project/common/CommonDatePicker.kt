package com.example.base_compose_project.common

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.base_compose_project.ui.theme.CommonStyle
import com.example.base_compose_project.ui.theme.DarkGray
import com.example.base_compose_project.ui.theme.SubColor
import com.example.base_compose_project.util.Utils.targetTimeFormat
import com.example.domain.util.CommonMessage
import java.util.Calendar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommonDatePicker(
    onDismiss: () -> Unit,
    onConfirm: () -> Unit,
    onClickFuture: (CommonMessage) -> Unit,
    modifier: Modifier = Modifier
) {

    // TODO https://developer.android.com/develop/ui/compose/components/datepickers?hl=ko#range 여기 참고

    val today = System.currentTimeMillis()
    val currentYear = Calendar.getInstance().get(Calendar.YEAR)
    val datePickerState = rememberDatePickerState(
        initialSelectedDateMillis = today,
        yearRange = 2002..currentYear
    )

    // 미래 날짜 선택 제한
//    LaunchedEffect(datePickerState.selectedDateMillis) {
//        if(datePickerState.selectedDateMillis.isAfterToday()){
//            onClickFuture(CommonMessage.DATE_PICKER_FUTURE_DISABLE)
//            datePickerState.selectedDateMillis = today
//        }
//    }

    DatePickerDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            TextButton(onConfirm) {
                Text(
                    text = "확인",
                    style = CommonStyle.text16Bold,
                    color = SubColor
                )
            }
        },
        dismissButton = {
            TextButton(onConfirm) {
                Text(
                    text = "닫기",
                    style = CommonStyle.text16Bold,
                    color = DarkGray
                )
            }
        },
        modifier = modifier
    ) {
        val todayDate = today.targetTimeFormat()
        val targetDate = datePickerState.selectedDateMillis?.targetTimeFormat() ?: "2025.12.31"
        DatePicker(
            state = datePickerState,
            title = {
                Text(
                    text = "날짜를 선택해주세요.",
                    modifier = Modifier.padding(24.dp)
                )
            },
            headline = {
                Text(
                    text = "$targetDate ~ $todayDate",
                    style = CommonStyle.text20,
                    modifier = Modifier.padding(horizontal = 24.dp)
                )
            },
            colors = DatePickerDefaults.colors(
                containerColor = Color.White,
                selectedDayContainerColor = SubColor,
            )
        )
    }
}

@Preview
@Composable
private fun CommonDatePickerPreview() {
    CommonDatePicker({},{},{})
}