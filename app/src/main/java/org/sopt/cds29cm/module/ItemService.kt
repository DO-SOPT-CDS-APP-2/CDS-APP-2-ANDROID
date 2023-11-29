package org.sopt.cds29cm.module

import org.sopt.cds29cm.data.dataclass.HatCategoryItem
import org.sopt.cds29cm.data.dto.response.ResponseHeartDTO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Query

interface ItemService {


    @GET("api/v1/category/1")
    fun getCategoryItem(): Call<HatCategoryItem>

    @PUT("api/v1/heart/{memberId}/{productId}")
    fun putHeartItem(
        @Query("memberId") memberId: Int,
        @Query("productId") productId: Int
    ): Call<ResponseHeartDTO>

}