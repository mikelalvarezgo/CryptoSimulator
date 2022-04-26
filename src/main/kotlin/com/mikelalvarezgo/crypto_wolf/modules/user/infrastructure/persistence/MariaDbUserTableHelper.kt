package com.mikelalvarezgo.crypto_wolf.modules.user.infrastructure.persistence

import com.mikelalvarezgo.crypto_wolf.modules.user.domain.User
import com.mikelalvarezgo.crypto_wolf.shared.infrastructure.persistence.mariadb.MariaDbTable
import com.mikelalvarezgo.crypto_wolf.shared.infrastructure.persistence.mariadb.MariaDdTableHelper

class MariaDbUserTableHelper : MariaDdTableHelper<User> {
    override val table: MariaDbTable<User> = MariaDbUserTable
}