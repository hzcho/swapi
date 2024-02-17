package com.example.swapi.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private const val DATA_STORE_NAME = "hs"
private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(DATA_STORE_NAME)

class DataStoreManager(val context: Context) {
    suspend fun saveStringValue(key: String, value: String) {
        context.dataStore.edit { pref ->
            pref[stringPreferencesKey(key)] = value
        }
    }

    fun getStringValue(key: String): Flow<String?> {
        return context.dataStore.data.map { pref ->
            pref[stringPreferencesKey(key)]
        }
    }
}