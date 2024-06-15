package ru.mixail_akulov.a42_database_room_2

import android.content.Context
import androidx.room.Room
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import ru.mixail_akulov.a42_database_room_2.model.settings.SharedPreferencesAppSettings
import ru.mixail_akulov.a42_database_room_2.model.accounts.AccountsRepository
import ru.mixail_akulov.a42_database_room_2.model.accounts.room.RoomAccountsRepository
import ru.mixail_akulov.a42_database_room_2.model.boxes.BoxesRepository
import ru.mixail_akulov.a42_database_room_2.model.boxes.room.RoomBoxesRepository
import ru.mixail_akulov.a42_database_room_2.model.room.AppDatabase
import ru.mixail_akulov.a42_database_room_2.model.settings.AppSettings

object Repositories {

    private lateinit var applicationContext: Context

    // -- stuffs

    private val database: AppDatabase by lazy<AppDatabase> {
        Room.databaseBuilder(applicationContext, AppDatabase::class.java, "database.db")
            .createFromAsset("initial_database.db")
            .build()
    }

    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO

    private val appSettings: AppSettings by lazy {
        SharedPreferencesAppSettings(applicationContext)
    }

    // --- repositories

    val accountsRepository: AccountsRepository by lazy {
        RoomAccountsRepository(database.getAccountsDao(), appSettings, ioDispatcher)
    }

    val boxesRepository: BoxesRepository by lazy {
        RoomBoxesRepository(accountsRepository, database.getBoxesDao(), ioDispatcher)
    }

    /**
     * Call this method in all application components that may be created at app startup/restoring
     * (e.g. in onCreate of activities and services)
     */
    fun init(context: Context) {
        applicationContext = context
    }
}