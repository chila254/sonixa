package com.sonixa.innertube.pages

import com.sonixa.innertube.models.YTItem

data class LibraryContinuationPage(
    val items: List<YTItem>,
    val continuation: String?,
)
