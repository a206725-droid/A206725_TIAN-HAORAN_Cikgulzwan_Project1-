package com.example.educationsdg4app

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class EducationViewModel : ViewModel() {

    private val _records = MutableStateFlow<List<EducationRecord>>(emptyList())
    val records: StateFlow<List<EducationRecord>> = _records.asStateFlow()

    // ✅ 这个函数必须存在！！
    fun addRecord(record: EducationRecord) {
        _records.value = _records.value + record
    }
}