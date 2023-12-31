package com.lelestacia.hayate.feature.anime.core.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.lelestacia.hayate.feature.anime.core.data.mapper.asAnime
import com.lelestacia.hayate.feature.anime.core.domain.model.Anime
import com.lelestacia.hayate.feature.anime.core.domain.repository.AnimeRepository
import com.lelestacia.hayate.feature.anime.core.source.remote.api.AnimeRemoteDataSourceApi
import com.lelestacia.hayate.feature.anime.core.source.remote.api.dto.anime.AnimeDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

internal class AnimeRepositoryImpl @Inject constructor(
    private val remoteDataSource: AnimeRemoteDataSourceApi
) : AnimeRepository {

    override fun getTopAnime(
        type: String?,
        filter: String?,
        rating: String?
    ): Flow<PagingData<Anime>> {
        return Pager(
            config = PagingConfig(
                pageSize = 24,
                prefetchDistance = 6,
                enablePlaceholders = false,
                initialLoadSize = 24
            ),
            pagingSourceFactory = {
                remoteDataSource.getTopAnime(type, filter, rating)
            }
        ).flow.map { pagingData: PagingData<AnimeDto> ->
            pagingData.map(AnimeDto::asAnime)
        }
    }

    override fun getCurrentSeasonAnime(
        filter: String?,
        sfw: Boolean
    ): Flow<PagingData<Anime>> {
        return Pager(
            config = PagingConfig(
                pageSize = 24,
                prefetchDistance = 6,
                enablePlaceholders = false,
                initialLoadSize = 24
            ),
            pagingSourceFactory = {
                remoteDataSource.getCurrentSeasonAnime(filter, sfw)
            }
        ).flow.map { pagingData: PagingData<AnimeDto> ->
            pagingData.map(AnimeDto::asAnime)
        }
    }

    override fun getUpcomingSeasonAnime(
        filter: String?,
        sfw: Boolean
    ): Flow<PagingData<Anime>> {
        return Pager(
            config = PagingConfig(
                pageSize = 24,
                prefetchDistance = 6,
                enablePlaceholders = false,
                initialLoadSize = 24
            ),
            pagingSourceFactory = {
                remoteDataSource.getUpcomingSeasonAnime(filter, sfw)
            }
        ).flow.map { pagingData: PagingData<AnimeDto> ->
            pagingData.map(AnimeDto::asAnime)
        }
    }

    override fun getScheduledAnime(
        filter: String?,
        sfw: Boolean
    ): Flow<PagingData<Anime>> {
        return Pager(
            config = PagingConfig(
                pageSize = 24,
                prefetchDistance = 6,
                enablePlaceholders = false,
                initialLoadSize = 24
            ),
            pagingSourceFactory = {
                remoteDataSource.getScheduledAnime(filter, sfw)
            }
        ).flow.map { pagingData: PagingData<AnimeDto> ->
            pagingData.map(AnimeDto::asAnime)
        }
    }
}