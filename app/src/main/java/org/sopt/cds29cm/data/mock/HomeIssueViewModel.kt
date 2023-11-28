package org.sopt.cds29cm.data.mock

import androidx.lifecycle.ViewModel
import org.sopt.cds29cm.R
import org.sopt.cds29cm.data.dataclass.HomeIssue

class HomeIssueViewModel : ViewModel() {
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
}
