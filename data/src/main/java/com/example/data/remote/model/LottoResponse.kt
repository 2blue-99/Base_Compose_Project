package com.example.data.remote.model

import com.google.gson.annotations.SerializedName

data class LottoResponse(
    @SerializedName("returnValue")
    val responseState: String, // 응답 상태
) {

}
