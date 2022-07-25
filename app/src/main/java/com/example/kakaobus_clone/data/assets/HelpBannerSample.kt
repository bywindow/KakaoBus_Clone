package com.example.kakaobus_clone.data.assets

import com.example.kakaobus_clone.R
import com.example.kakaobus_clone.data.models.HelpBanner

fun HelpBannerSample(): List<HelpBanner> {
    return listOf(
        HelpBanner(
            image = R.drawable.ic_first_banner,
            title = "주변 정류장",
            comment = "위치 사용을 동의하세요."
        ),
        HelpBanner(
            image = R.drawable.ic_first_banner,
            title = "주변 정류장",
            comment = "위치 사용을 동의하세요."
        ),
        HelpBanner(
            image = R.drawable.ic_first_banner,
            title = "주변 정류장",
            comment = "위치 사용을 동의하세요."
        )
    )
}