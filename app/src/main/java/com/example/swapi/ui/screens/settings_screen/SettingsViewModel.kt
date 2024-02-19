package com.example.swapi.ui.screens.settings_screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.swapi.data.datastore.DataStoreManager
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject
import com.example.swapi.R
import com.example.swapi.data.datastore.DsKeys
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val dataStoreManager: DataStoreManager
):ViewModel() {
    private val _user=MutableStateFlow(User())
    val user: StateFlow<User> =_user

    val darkMode=dataStoreManager.getBooleanValue(DsKeys.DARK_MODE)

    init {//косяк костыль
        viewModelScope.launch {
            dataStoreManager.getStringValue(DsKeys.NAME).collect(){ name->
                name?.let {name->
                    _user.value.name=name
                }
            }
            dataStoreManager.getStringValue(DsKeys.SURNAME).collect(){ surname->
                surname?.let {surname->
                    _user.value.surname=surname
                }
            }
            dataStoreManager.getStringValue(DsKeys.IMAGE_IDE).collect(){ id->
                id?.let {id->
                    _user.value.imageId=id.toInt()
                }
            }
        }
    }

    fun changeMode(change:Boolean){
        viewModelScope.launch {
            dataStoreManager.saveBooleanValue(DsKeys.DARK_MODE, change)
        }
    }
}

data class User(
    var name:String="unknown",
    var surname:String="unknown",
    var imageId:Int=R.drawable.unknown_person
)