package com.app.docshaper.data.settings

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.app.docshaper.core.SettingsConstants.SETTINGS_DATASTORE
import kotlinx.coroutines.flow.first


private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = SETTINGS_DATASTORE)

class SettingsDataStoreImpl(
    private val context: Context
) : SettingsDataStore {
    override suspend fun putBoolean(key: String, value: Boolean) {
        val preferenceKey = booleanPreferencesKey(key)
        context.dataStore.edit {
            it[preferenceKey] = value
        }
    }

    override suspend fun putString(key: String, value: String) {
        val preferenceKey = stringPreferencesKey(key)
        context.dataStore.edit {
            it[preferenceKey] = value
        }
    }

    override suspend fun putInt(key: String, value: Int) {
        val preferenceKey = stringPreferencesKey(key)
        context.dataStore.edit {
            it[preferenceKey] = value.toString()
        }
    }

    override suspend fun getBoolean(key: String): Boolean? {
        val head = context.dataStore.data.first()
        val preferenceKey = booleanPreferencesKey(key)
        return head[preferenceKey]

    }

    override suspend fun getString(key: String): String? {
        return try {
            val head = context.dataStore.data.first()
            val preferenceKey = stringPreferencesKey(key)
            head[preferenceKey]
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    override suspend fun getInt(key: String): Int? {
        return try {
            val head = context.dataStore.data.first()
            val preferenceKey = stringPreferencesKey(key)
            head[preferenceKey]?.toInt()
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    override suspend fun deleteBoolean(key: String) {
        val preferenceKey = booleanPreferencesKey(key)
        context.dataStore.edit {
            if (it.contains(preferenceKey)) {
                it.remove(preferenceKey)
            }
        }
    }

    override suspend fun deleteString(key: String) {
        val preferenceKey = stringPreferencesKey(key)
        context.dataStore.edit {
            if (it.contains(preferenceKey)) {
                it.remove(preferenceKey)
            }
        }
    }

    override suspend fun deleteInt(key: String) {
        val preferenceKey = stringPreferencesKey(key)
        context.dataStore.edit {
            if (it.contains(preferenceKey)) {
                it.remove(preferenceKey)
            }
        }
    }

    override suspend fun clearPreferences() {
        context.dataStore.edit {
            it.clear()
        }
    }


}