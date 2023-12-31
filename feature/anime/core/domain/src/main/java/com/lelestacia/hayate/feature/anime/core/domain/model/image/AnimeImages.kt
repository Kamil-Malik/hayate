package com.lelestacia.hayate.feature.anime.core.domain.model.image

import android.os.Parcelable
import androidx.compose.runtime.Immutable
import kotlinx.parcelize.Parcelize

@Immutable
@Parcelize
data class AnimeImages(
    val jpg: AnimeJpg,
    val webp: AnimeWebp
) : Parcelable
