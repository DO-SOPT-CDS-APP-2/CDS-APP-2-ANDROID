package org.sopt.cds29cm.presentation.category

import androidx.lifecycle.ViewModel
import org.sopt.cds29cm.R
import org.sopt.cds29cm.data.CategoryHorizontal

class CategoryViewModel :ViewModel() {

    //상단 가로스크롤 카테고리
    val categoryHorizontalDataList = listOf<CategoryHorizontal>(
        CategoryHorizontal(
            categoryName = "모아보기",
            categoryImage = R.drawable.ic_category_horizontal_all
        ),
        CategoryHorizontal(
            categoryName = "쇼케이스",
            categoryImage = R.drawable.ic_category_horizontal_showcase
        ),
        CategoryHorizontal(
            categoryName = "PT",
            categoryImage = R.drawable.ic_category_horizontal_pt
        ),CategoryHorizontal(
            categoryName = "선물하기",
            categoryImage = R.drawable.ic_category_horizontal_present
        ),
        CategoryHorizontal(
            categoryName = "해외브랜드",
            categoryImage = R.drawable.ic_category_horizontal_oversea
        ),
        CategoryHorizontal(
            categoryName = "프리미엄홈",
            categoryImage = R.drawable.ic_category_horizontal_primium
        ),
        CategoryHorizontal(
            categoryName = "전시공간",
            categoryImage = R.drawable.ic_category_horizontal_exhibit,
        ),
        CategoryHorizontal(
            categoryName = "던스트",
            categoryImage = R.drawable.ic_category_horizontal_dunst,
        ),
        CategoryHorizontal(
            categoryName = "테이블웨어",
            categoryImage = R.drawable.ic_category_horizontal_table,
        ),
        CategoryHorizontal(
            categoryName = "이벤트",
            categoryImage = R.drawable.ic_category_horizontal_event,
        ),
        CategoryHorizontal(
            categoryName = "리빙스타일",
            categoryImage = R.drawable.ic_category_horizontal_living,
        ),
        CategoryHorizontal(
            categoryName = "WELOVE",
            categoryImage = R.drawable.ic_category_horizontal_welove,
        ),
        CategoryHorizontal(
            categoryName = "룩북",
            categoryImage = R.drawable.ic_category_horizontal_lookbook,
        ),
        CategoryHorizontal(
            categoryName = "스페셜오더",
            categoryImage = R.drawable.ic_category_horizontal_special,
        ),

    )
}