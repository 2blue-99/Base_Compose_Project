package com.example.base_compose_project.util

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.os.VibratorManager
import android.provider.Settings
import androidx.compose.animation.core.tween
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.graphics.Color
import timber.log.Timber
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

object Utils {
    fun Int.toLottoColor(): Color{
        return when(this){
            in 1..10 -> Color(0xFFFFC81A)   // 노랑
            in 11..20 -> Color(0xFF0184E5)  // 파랑
            in 21..30 -> Color(0xFFFD5858)  // 빨강
            in 31..40 -> Color(0xFF999999)  // 회색
            in 41..45 -> Color(0xFF00A86B)  // 초록
            else -> Color.Black             // 예외 처리용
        }
    }

    fun Int.toAlphabet(): String{
        val alphabetList = listOf("A","B","C","D","E")
        return alphabetList.getOrNull(this) ?: "A"
    }



    /**
     * 로또 리스트 -> 홀짝 비율 값 (ex. 3:3)
     */
    fun List<Int>.toOddEventValue(): String {
        var odd = 0 // 홀수
        var event = 0 // 짝수
        this.forEach {
            if(it%3==0) odd++
            else event++
        }
        return "${odd}:${event}"
    }

    /**
     * 로또 리스트 -> 고, 저 비율 값 (ex. 3:3)
     * Low : 1~22
     * High : 23:45
     */
    fun List<Int>.toHighLowValue(): String {
        var high = 0 // 고
        var low = 0 // 저
        this.forEach {
            if(it in 1..22) low++
            else high++
        }
        return "${high}:${low}"
    }

    /**
     * 현재 시간 포멧
     *
     * @return yyyy-MM-dd HH:mm:ss
     */
    fun currentTimeFormat(): String {
        val currentTime = System.currentTimeMillis()
        return SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(Date(currentTime))
    }

    fun Long?.isAfterToday(): Boolean {
        return this?.let {
            val sdf = SimpleDateFormat("yyyyMMdd", Locale.getDefault())
            sdf.timeZone = TimeZone.getDefault()

            val targetDate = sdf.format(Date(this)).toInt()
            val todayDate = sdf.format(Date()).toInt()

            targetDate > todayDate
        } ?: false
    }

    /**
     * 타겟 년 월 일 포멧
     *
     * @return yyyy-MM-dd
     */
    fun Long.targetTimeFormat(): String {
        return SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date(this))
    }

    /**
     * 모두 True 처리
     */
    fun SnapshotStateList<Boolean>.setAllTrue() {
        this.indices.forEach {
            this[it] = true
        }
    }

    /**
     * 모두 False 처리
     */
    fun SnapshotStateList<Boolean>.setAllFalse() {
        this.indices.forEach {
            this[it] = false
        }
    }


    /**
     * 추첨 결과 공유하기
     */
    fun Context.shareLotto(inputText: String) {
        val sendIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, inputText)
            type = "text/plain"
        }
        val shareIntent = Intent.createChooser(sendIntent, "Share Lotto")
        this.startActivity(shareIntent)
    }
}

/**
 * Base 페이저 스크롤 애니메이션
 */
suspend fun PagerState.baseAnimateScrollToPage(index: Int){
    this.animateScrollToPage(
        page = index,
        animationSpec = tween(
            durationMillis = 500,
            easing = androidx.compose.animation.core.FastOutSlowInEasing
        )
    )
}

/**
 * 앱 설정 이동
 */
fun Context.openSetting() {
    val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).apply {
        data = Uri.fromParts("package", this@openSetting.packageName, null)
    }
    this.startActivity(intent)
}

/**
 * URL 웹 브라우저 이동
 */
fun Context.openBrowser(url: String){
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    this.startActivity(intent)
}

fun String.getPlayStoreUrl(): String = "https://play.google.com/store/apps/details?id=${this}"

/**
 * 플레이 스토어 이동
 */
fun Context.openStore(){
    this.packageName.getPlayStoreUrl()
    val playStoreUrl = this.packageName.getPlayStoreUrl()
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(playStoreUrl))
    this.startActivity(intent)
}

/**
 * 이메일 이동
 */
fun Context.openEmail(){
//    val intent = Intent(Intent.ACTION_SEND).apply {
//        type = "text/plain"
//        putExtra(Intent.EXTRA_EMAIL, arrayOf(BuildConfig.DEVELOPER_EMAIL))
//    }
//    this.startActivity(intent)
}

/**
 * 진동
 */
fun Context.startVibrate(){
    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.S){
        Timber.d("버전 S 이상")
        val manager = this.getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as VibratorManager
        manager.defaultVibrator.vibrate(VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE))
    }else{
        Timber.d("버전 S 미만")
        val manager = this.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        manager.vibrate(100)
    }
}