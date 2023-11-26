package org.sopt.cds29cm.data.mock

import androidx.lifecycle.ViewModel
import org.sopt.cds29cm.R
import org.sopt.cds29cm.data.dataclass.HomePopular

class HomePopularViewModel : ViewModel() {
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
}