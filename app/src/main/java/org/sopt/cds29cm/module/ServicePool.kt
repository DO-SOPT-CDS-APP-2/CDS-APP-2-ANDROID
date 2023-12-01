package org.sopt.cds29cm.module

import org.sopt.cds29cm.data.service.HomeService
import org.sopt.cds29cm.data.service.HatDetailService

object ServicePool {
    val hatDetailService = ApiFactory.create<HatDetailService>()
    val itemService = ApiFactory.create<ItemService>()
    val homeService = ApiFactory.create<HomeService>()
}