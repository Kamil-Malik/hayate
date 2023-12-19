package com.lelestacia.hayate.common.preferences

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore

internal val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "config")