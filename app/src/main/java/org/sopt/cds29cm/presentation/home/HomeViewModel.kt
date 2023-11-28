package org.sopt.cds29cm.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.sopt.cds29cm.R
import org.sopt.cds29cm.data.dataclass.HomeIssue
import org.sopt.cds29cm.data.dataclass.HomeMarron
import org.sopt.cds29cm.data.dataclass.HomeNotia
import org.sopt.cds29cm.data.dataclass.HomePopular
import org.sopt.cds29cm.data.dataclass.HomeRecommend
import org.sopt.cds29cm.data.service.HomeService

class HomeViewModel(private val homeService : HomeService) : ViewModel() {

    private val _responseSuccess: MutableLiveData<Boolean> = MutableLiveData()
    val responseSuccess: LiveData<Boolean> get() = _responseSuccess

    fun getData(){
        viewModelScope.launch {
            runCatching {
                homeService.getHomeDataFromServer()
            }.onSuccess {
                _responseSuccess.value = true
            }.onFailure {
                _responseSuccess.value = false
            }
        }
    }

    val mockIssue = listOf<HomeIssue>(
        HomeIssue(
            homeFirstImage = R.drawable.img_home_52,
            homeFirstBrand = "피에톤",
            homeFirstTitle = "피에톤 겨울 컬렉션 공개\n" + "5% 단독할인",
            homeSecondImage = R.drawable.img_home_53,
            homeSecondBrand = "피에톤",
            homeSecondDiscount = "20%",
            homeSecondPrice = "62,400",
            homeThirdImage = R.drawable.img_home_54,
            homeThirdBrand = "피에톤",
            homeThirdDiscount = "10%",
            homeThirdPrice = "95,400",
        ),
        HomeIssue(
            homeFirstImage = R.drawable.img_home_55,
            homeFirstBrand = "호카",
            homeFirstTitle = "고어텍스 런닝화 모음전\n" + "겨울 러닝 추천",
            homeSecondImage = R.drawable.img_home_56,
            homeSecondBrand = "호카",
            homeSecondDiscount = "20%",
            homeSecondPrice = "279,000",
            homeThirdImage = R.drawable.img_home_57,
            homeThirdBrand = "호카",
            homeThirdDiscount = "10%",
            homeThirdPrice = "95,400",
        ),
    )

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

    val mockNotia = listOf<HomeNotia>(
        HomeNotia(
            imageUrl = R.drawable.img_home_44,
            brand = "노티아",
            name = "MERINO WOOL ROUND CARDIGAN - RED",
            discount = "10%",
            price = "106,200",
            like = R.drawable.ic_like_off,
            likeCount = "148",
        ),
        HomeNotia(
            imageUrl = R.drawable.img_home_45,
            brand = "노티아",
            name = "LUNA BALMACAN HANDMADE COAT - BEIGE",
            discount = "10%",
            price = "282,600",
            like = R.drawable.ic_like_off,
            likeCount = "148",
        ),

        )

    val mockPopular = listOf<HomePopular>(
        HomePopular(
            imageUrl = R.drawable.img_home_20
        ),
        HomePopular(
            imageUrl = R.drawable.img_home_21
        ),
        HomePopular(
            imageUrl = R.drawable.img_home_22
        ),
        HomePopular(
            imageUrl = R.drawable.img_home_23
        ),
        HomePopular(
            imageUrl = R.drawable.img_home_24
        ),
        HomePopular(
            imageUrl = R.drawable.img_home_25
        ),
        HomePopular(
            imageUrl = R.drawable.img_home_26
        ),
        HomePopular(
            imageUrl = R.drawable.img_home_27
        ),
        HomePopular(
            imageUrl = R.drawable.img_home_28
        ),
        HomePopular(
            imageUrl = R.drawable.img_home_29
        ),
        HomePopular(
            imageUrl = R.drawable.img_home_30
        ),
        HomePopular(
            imageUrl = R.drawable.img_home_31
        ),
    )

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