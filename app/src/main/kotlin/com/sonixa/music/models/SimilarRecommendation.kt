package com.sonixa.music.models

import com.sonixa.innertube.models.YTItem
import com.sonixa.music.db.entities.LocalItem

data class SimilarRecommendation(
    val title: LocalItem,
    val items: List<YTItem>,
)
