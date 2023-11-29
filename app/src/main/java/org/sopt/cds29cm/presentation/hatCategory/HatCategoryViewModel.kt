package org.sopt.cds29cm.presentation.hatCategory

import androidx.lifecycle.ViewModel
import org.sopt.cds29cm.R
import org.sopt.cds29cm.data.dataclass.HatBestItem
import org.sopt.cds29cm.data.dataclass.HatCategoryFilter
import org.sopt.cds29cm.data.dataclass.CategoryVertical
import org.sopt.cds29cm.data.dataclass.HatCategoryItemComment

class HatCategoryViewModel : ViewModel() {

    val subCategoryHatDataList = listOf<CategoryVertical>(
        CategoryVertical(categoryName = "전체"),
        CategoryVertical(categoryName = "비니"),
        CategoryVertical(categoryName = "볼캡"),
        CategoryVertical(categoryName = "버킷햇"),
        CategoryVertical(categoryName = "바라클라바"),
        CategoryVertical(categoryName = "베레모"),
        CategoryVertical(categoryName = "트루퍼"),
        CategoryVertical(categoryName = "페도라"),
    )

    val bestItemDataList = listOf<HatBestItem>(
        HatBestItem(
            itemName = "타입서비스",
            itemDiscount = "5%",
            itemPrice = "37,050",
            itemRanking = 1,
            itemImage = R.drawable.img_hat_category_30,

            ),
        HatBestItem(
            itemName = "슬리피슬립",
            itemDiscount = "10%",
            itemPrice = "52,200",
            itemRanking = 2,
            itemImage = R.drawable.img_hat_category_31,

            ),
        HatBestItem(
            itemName = "론론",
            itemDiscount = "15%",
            itemPrice = "140,250",
            itemRanking = 3,
            itemImage = R.drawable.img_hat_category_32,

            ),
        HatBestItem(
            itemName = "시엔느",
            itemDiscount = "5%",
            itemPrice = "37,050",
            itemRanking = 4,
            itemImage = R.drawable.img_hat_category_33,

            ),
    )

    val filterDataList = listOf<HatCategoryFilter>(
        HatCategoryFilter(filterName = "추천순"),
        HatCategoryFilter(filterName = "색상"),
        HatCategoryFilter(filterName = "가격대"),
        HatCategoryFilter(filterName = "상품정보"),
        HatCategoryFilter(filterName = "브랜드"),
    )

    val hatItemCommentDataList = listOf<HatCategoryItemComment>(
        HatCategoryItemComment(
            heart = "93,594",
            mark = "5.0",
            markPeople = "(13286)"
        ),
        HatCategoryItemComment(
            heart = "93,594",
            mark = "5.0",
            markPeople = "(13286)"
        ),
        HatCategoryItemComment(
            heart = "31,300",
            mark = "5.0",
            markPeople = "(4091)"
        ),
        HatCategoryItemComment(
            heart = "31,300",
            mark = "5.0",
            markPeople = "(4091)"
        ),
    )
}