package org.sopt.cds29cm.data.mock

import androidx.lifecycle.ViewModel
import org.sopt.cds29cm.R
import org.sopt.cds29cm.data.dataclass.HomeRecommend

class HomeRecommendViewModel : ViewModel() {

    val mockRecommend = listOf<HomeRecommend>(
    HomeRecommend(
        homeImage = R.drawable.img_home_46,
        homeName = "플레이스 스튜디오",
        homeDiscount = "20%",
        homePrice = "62,400",
        homeLike = R.drawable.ic_like_on_16
    ),
        HomeRecommend(
            homeImage = R.drawable.img_home_49,
            homeName = "제너럴 아이디어",
            homeDiscount = "53%",
            homePrice = "39,8000",
            homeLike = R.drawable.ic_like_off
        ),

        HomeRecommend(
            homeImage = R.drawable.img_home_47,
            homeName = "시엔느",
            homeDiscount = "10%",
            homePrice = "53,000",
            homeLike = R.drawable.ic_like_off
        ),
        HomeRecommend(
            homeImage = R.drawable.img_home_50,
            homeName = "레니비",
            homeDiscount = "24%",
            homePrice = "37,000",
            homeLike = R.drawable.ic_like_off
        ),
        HomeRecommend(
            homeImage = R.drawable.img_home_46,
            homeName = "플레이스 스튜디오",
            homeDiscount = "20%",
            homePrice = "62,400",
            homeLike = R.drawable.ic_like_on_16
        ),
        HomeRecommend(
            homeImage = R.drawable.img_home_46,
            homeName = "제너럴",
            homeDiscount = "10%",
            homePrice = "62,400",
            homeLike = R.drawable.ic_like_off
        ),
    )
}