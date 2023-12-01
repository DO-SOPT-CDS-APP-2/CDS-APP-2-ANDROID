package org.sopt.cds29cm.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.sopt.cds29cm.data.service.HomeService

class HomeViewModelFactory(private val homeService: HomeService) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(homeService) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
