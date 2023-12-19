package com.lelestacia.hayate.feature.anime.core.source.local.api.api

import com.lelestacia.hayate.feature.anime.core.source.local.api.entity.AnimeEntity
import com.lelestacia.hayate.feature.anime.core.source.local.api.entity.demographic.AnimeDemographicEntity
import com.lelestacia.hayate.feature.anime.core.source.local.api.entity.genre.AnimeExplicitGenreEntity
import com.lelestacia.hayate.feature.anime.core.source.local.api.entity.genre.AnimeGenreEntity
import com.lelestacia.hayate.feature.anime.core.source.local.api.entity.theme.AnimeThemeEntity

interface AnimeLocalDataSourceApi {
    suspend fun insertAnime(animeEntity: AnimeEntity)

    suspend fun insertGenres(genres: List<AnimeGenreEntity>)

    suspend fun insertExplicitGenres(explicitGenres: List<AnimeExplicitGenreEntity>)

    suspend fun insertThemes(themes: List<AnimeThemeEntity>)

    suspend fun insertDemographics(demographics: List<AnimeDemographicEntity>)
}