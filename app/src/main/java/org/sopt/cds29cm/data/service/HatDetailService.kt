package org.sopt.cds29cm.data.service

import org.sopt.cds29cm.data.dto.response.BaseResponse
import org.sopt.cds29cm.data.dto.response.HatDetailResponseDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface HatDetailService {

    @GET("/api/v1/product/{productId}")
    suspend fun getProductDetail(
        @Path("productId") productId: Long
    ): Response<BaseResponse<HatDetailResponseDto>>
}