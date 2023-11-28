package org.sopt.cds29cm.data.mock

import androidx.lifecycle.ViewModel
import org.sopt.cds29cm.R
import org.sopt.cds29cm.data.dataclass.HomeMarron

class HomeMarronViewModel : ViewModel() {

    val mockMarron = listOf<HomeMarron>(
        HomeMarron(
            imageUrl = R.drawable.img_home_44,
            brand = "노티아",
            name = "MERINO WOOL ROUND CARDIGAN - RED",
            discount = "10%",
            price = "106,200",
            like = R.drawable.ic_like_off,
            likeCount = "148",
        ),
        HomeMarron(
            imageUrl = R.drawable.img_home_45,
            brand = "노티아",
            name = "LUNA BALMACAN HANDMADE COAT - BEIGE",
            discount = "10%",
            price = "282,600",
            like = R.drawable.ic_like_off,
            likeCount = "148",
        ),

        )
}