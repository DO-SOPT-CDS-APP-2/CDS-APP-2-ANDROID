package org.sopt.cds29cm.presentation.hatDetail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.sopt.cds29cm.data.dto.response.HatDetailResponseDto
import org.sopt.cds29cm.module.ServicePool.hatDetailService
import org.sopt.cds29cm.util.UiState

class HatDetailViewModel() : ViewModel() {

    private val _hatDetailState: MutableLiveData<UiState<HatDetailResponseDto?>> = MutableLiveData()
    val hatDetailState: LiveData<UiState<HatDetailResponseDto?>> = _hatDetailState

    fun getHatDetailFromServer(productId: Long) {
        viewModelScope.launch {
            runCatching {
                hatDetailService.getProductDetail(productId)
            }
                .onSuccess {
                    _hatDetailState.value = UiState.Success(it.body()?.data)
                }
                .onFailure {
                    _hatDetailState.value = UiState.Failure(it.message.toString())
                }
        }
    }
}