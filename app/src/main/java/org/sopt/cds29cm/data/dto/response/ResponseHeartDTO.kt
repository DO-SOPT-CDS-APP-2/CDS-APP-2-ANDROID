package org.sopt.cds29cm.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseHeartDTO<HeartDTO>(
    @SerialName("status")
    val status:Int,
    @SerialName("message")
    val message:String,
    @SerialName("data")
    val data: HeartDTO,

)
@Serializable

data class HeartDTO(
    @SerialName("isMade")
    val isMade: Boolean,
)
