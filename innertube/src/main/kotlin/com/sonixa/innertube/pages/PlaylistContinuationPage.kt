package com.sonixa.innertube.pages

import com.sonixa.innertube.models.SongItem

data class PlaylistContinuationPage(
    val songs: List<SongItem>,
    val continuation: String?,
)
