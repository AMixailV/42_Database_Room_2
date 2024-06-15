package ru.mixail_akulov.a42_database_room_2.screens.main.tabs.dashboard

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.mixail_akulov.a42_database_room_2.model.boxes.BoxesRepository
import ru.mixail_akulov.a42_database_room_2.model.boxes.entities.Box
import ru.mixail_akulov.a42_database_room_2.utils.share

class DashboardViewModel(
    private val boxesRepository: BoxesRepository
) : ViewModel() {

    private val _boxes = MutableLiveData<List<Box>>()
    val boxes = _boxes.share()

    init {
        viewModelScope.launch {
            boxesRepository.getBoxesAndSettings(onlyActive = true).collect { list ->
                _boxes.value = list.map { it.box }
            }
        }
    }

}