package org.sopt.cds29cm.module

import org.sopt.cds29cm.data.service.HatDetailService

object ServicePool {
    val hatDetailService = ApiFactory.create<HatDetailService>()
}