package org.sopt.cds29cm.module

import org.sopt.cds29cm.data.dataclass.HatCategoryItem
import org.sopt.cds29cm.data.dto.request.HeartRequestDto
import org.sopt.cds29cm.data.dto.response.BaseResponse
import org.sopt.cds29cm.data.dto.response.HeartDTO
import org.sopt.cds29cm.data.dto.response.ResponseCategoryItemDTO
import org.sopt.cds29cm.data.dto.response.ResponseHeartDTO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface ItemService {


    @GET("api/v1/category/1")
    fun getCategoryItem(): Call<HatCategoryItem>

    @PUT("api/v1/heart/2/{productId}")
    fun putHeartItem(
        @Path("productId") productId: Int
    ): Call<ResponseHeartDTO<HeartDTO>>

}