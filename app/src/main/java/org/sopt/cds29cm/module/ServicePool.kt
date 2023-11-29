package org.sopt.cds29cm.module

object ServicePool {
    val itemService = ApiFactory.create<ItemService>()
    // val authService = ApiFactory.create<AuthService>()
}