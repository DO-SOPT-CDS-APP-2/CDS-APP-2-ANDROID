package org.sopt.cds29cm.module

import org.sopt.cds29cm.data.service.HomeService

object ServicePool {
    val itemService = ApiFactory.create<ItemService>()
    // val authService = ApiFactory.create<AuthService>()
    val homeService = ApiFactory.create<HomeService>()
}