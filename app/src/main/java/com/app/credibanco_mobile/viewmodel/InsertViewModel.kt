package com.app.credibanco_mobile.viewmodel

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.credibanco_mobile.domain.AuthorizeTransactionUseCase
import com.app.credibanco_mobile.model.dto.AuthorizationRequest
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InsertViewModel @Inject constructor(
    private val authorizeTransactionUseCase: AuthorizeTransactionUseCase
): ViewModel(){


    @RequiresApi(Build.VERSION_CODES.O)
    fun onCreate(request: AuthorizationRequest){
        viewModelScope.launch {
            authorizeTransactionUseCase(request)
        }
    }
}