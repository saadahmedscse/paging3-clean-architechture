package com.saadahmedev.paging.domain.useCase

import com.saadahmedev.paging.domain.model.UnionResponse
import com.saadahmedev.paging.domain.repository.CmedRepository
import com.saadahmedev.paging.util.ResponseState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CmedUseCase @Inject constructor(private val cmedRepository: CmedRepository) {

    operator fun invoke(page: Int, size: Int): Flow<ResponseState<List<UnionResponse>>> = flow {
        emit(ResponseState.Loading())

        try {
            emit(
                ResponseState.Success(
                    cmedRepository.getUnions(page, size).unions?.map { it.toResponse() }
                )
            )
        }
        catch (e: Exception) {
            emit(ResponseState.Error(e.message))
        }
    }
}