package by.agentges.fueler.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.agentges.fueler.core.data.RefillRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject
import by.agentges.fueler.ui.home.HomeUiState.Error
import by.agentges.fueler.ui.home.HomeUiState.Loading
import by.agentges.fueler.ui.home.HomeUiState.Success
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.stateIn

@HiltViewModel
class RefillScreenViewModel @Inject constructor(
    private val refillRepository: RefillRepository
) : ViewModel() {

    val uiState: StateFlow<HomeUiState> = refillRepository
        .refills.map { Success(data = it) }
        .catch { Error(it) }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), Loading)

    fun addRefill(name: String) {
        viewModelScope.launch {
            refillRepository.add(name)
        }
    }
}

sealed interface HomeUiState {
    object Loading : HomeUiState
    data class Error(val throwable: Throwable) : HomeUiState
    data class Success(val data: List<String>) : HomeUiState
}
