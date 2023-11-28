package org.sopt.cds29cm.data.service

import org.sopt.cds29cm.data.dto.response.BaseResponse
import org.sopt.cds29cm.data.dto.response.HatDetailResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface HatDetailService {

    @GET("/api/v1/product")
    suspend fun getProductDetail(
        @Query("productId") page: Long
    ): BaseResponse<HatDetailResponseDto>
}