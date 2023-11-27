package org.sopt.cds29cm.presentation.hatCategory

import androidx.lifecycle.ViewModel
import org.sopt.cds29cm.data.CategoryVertical

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
}