package com.sonixa.innertube.models.body

import com.sonixa.innertube.models.Context
import com.sonixa.innertube.models.Continuation
import kotlinx.serialization.Serializable

@Serializable
data class BrowseBody(
    val context: Context,
    val browseId: String?,
    val params: String?,
    val continuation: String?
)