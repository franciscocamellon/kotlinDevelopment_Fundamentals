package camell.oncase.investorprofileanalyzer.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InvestorProfileViewModel : ViewModel() {

    private val _punctuation = MutableLiveData<Int>(0)
    val punctuation: LiveData<Int> = _punctuation

    init {
        resetPunctuation()
    }

    fun setPunctuation(point: Int) {
        _punctuation.value = point
    }

    private fun resetPunctuation() {
        _punctuation.value = 0
    }

    private fun updatePunctuation(point: Int) {
        _punctuation.value!!.plus(point)
    }

}