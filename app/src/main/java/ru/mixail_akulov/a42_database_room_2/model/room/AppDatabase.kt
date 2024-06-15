package ru.mixail_akulov.a42_database_room_2.model.room

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.mixail_akulov.a42_database_room_2.model.accounts.room.AccountsDao
import ru.mixail_akulov.a42_database_room_2.model.accounts.room.entities.AccountDbEntity
import ru.mixail_akulov.a42_database_room_2.model.boxes.room.BoxesDao
import ru.mixail_akulov.a42_database_room_2.model.boxes.room.entities.AccountBoxSettingDbEntity
import ru.mixail_akulov.a42_database_room_2.model.boxes.room.entities.BoxDbEntity
import ru.mixail_akulov.a42_database_room_2.model.boxes.room.views.SettingDbView

@Database(
    version = 1,
    entities = [
        AccountDbEntity::class,
        BoxDbEntity::class,
        AccountBoxSettingDbEntity::class
    ],
    views = [
        SettingDbView::class
    ]
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getAccountsDao(): AccountsDao

    abstract fun getBoxesDao(): BoxesDao

}