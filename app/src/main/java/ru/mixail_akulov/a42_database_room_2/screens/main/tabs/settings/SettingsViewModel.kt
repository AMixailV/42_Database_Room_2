package ru.mixail_akulov.a42_database_room_2.screens.main.tabs.settings

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.mixail_akulov.a42_database_room_2.R
import ru.mixail_akulov.a42_database_room_2.model.StorageException
import ru.mixail_akulov.a42_database_room_2.model.boxes.BoxesRepository
import ru.mixail_akulov.a42_database_room_2.model.boxes.entities.Box
import ru.mixail_akulov.a42_database_room_2.model.boxes.entities.BoxAndSettings
import ru.mixail_akulov.a42_database_room_2.utils.MutableLiveEvent
import ru.mixail_akulov.a42_database_room_2.utils.publishEvent
import ru.mixail_akulov.a42_database_room_2.utils.share

class SettingsViewModel(
    private val boxesRepository: BoxesRepository
) : ViewModel(), SettingsAdapter.Listener {

    private val _boxSettings = MutableLiveData<List<BoxAndSettings>>()
    val boxSettings = _boxSettings.share()

    private val _showErrorMessageEvent = MutableLiveEvent<Int>()
    val showErrorMessageEvent =_showErrorMessageEvent.share()

    init {
        viewModelScope.launch {
            boxesRepository.getBoxesAndSettings().collect {
                _boxSettings.value = it
            }
        }
    }

    override fun enableBox(box: Box) {
        viewModelScope.launch {
            try {
                boxesRepository.activateBox(box)
            } catch (e: StorageException) {
                showStorageErrorMessage()
            }
        }
    }

    override fun disableBox(box: Box) {
        viewModelScope.launch {
            try {
                boxesRepository.deactivateBox(box)
            } catch (e: StorageException) {
                showStorageErrorMessage()
            }
        }
    }

    private fun showStorageErrorMessage() {
        _showErrorMessageEvent.publishEvent(R.string.storage_error)
    }
}