package org.sopt.cds29cm.data.service

import org.sopt.cds29cm.data.dto.response.BaseResponse
import org.sopt.cds29cm.data.dto.response.HomeResponseDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET

interface HomeService {
    @GET("/api/v1/category/home")
    suspend fun getHomeDataFromServer() : Response<BaseResponse<List<HomeResponseDto>>>
}