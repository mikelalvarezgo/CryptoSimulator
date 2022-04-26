package com.mikelalvarezgo.crypto_wolf.shared.domain

import com.mikelalvarezgo.crypto_wolf.shared.domain.error.Validation

interface UseCase<R : Request<T>, T> {
    fun execute(request: R): Validation<T>
}