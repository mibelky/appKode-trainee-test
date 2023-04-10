package com.example.appkodetraineetest

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.appkodetraineetest.remote.Api
import com.example.appkodetraineetest.remote.ApiService
import com.example.appkodetraineetest.remote.Employee
import kotlinx.coroutines.launch
import org.json.JSONObject

enum class ApiStatus { LOADING, DONE, ERROR }

class EmployeesViewModel(app: Application) : AndroidViewModel(app) {

    //The internal MutableLiveData that stores the most recent employees list loaded from remote API
    private val _sourceList = MutableLiveData<List<Employee>>()

    val sourceList: LiveData<List<Employee>>
        get() = _sourceList

    //The internal MutableLiveData that stores the status of the most recent request
    private val _status = MutableLiveData<ApiStatus>()

    //The external immutable LiveData for the request status
    val status : LiveData<ApiStatus>
        get() = _status

    init {
        updateSourceList()
    }

    private fun updateSourceList() {
        viewModelScope.launch {
            _status.value = ApiStatus.LOADING
            try {
                _sourceList.value = Api.retrofitService.getEmployees().list
                Log.d("Employees", "JSONObject: ${_sourceList.value}")
                _status.value = ApiStatus.DONE
            } catch (e: Exception) {
                Log.d("API", "Exception: " + e.localizedMessage)
                e.printStackTrace()
                _status.value = ApiStatus.ERROR
            }
        }
    }

}