package com.mikelalvarezgo.crypto_wolf.shared.domain

sealed interface Request<T>

interface Command:Request<Unit>

interface Query<R>:Request<R>