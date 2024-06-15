package ru.mixail_akulov.a42_database_room_2.model.boxes.room.entities

import androidx.room.ColumnInfo
import androidx.room.Embedded

/**
 * Кортеж, содержащий только саму настройку без идентификаторов.
 */
data class SettingsTuple(
    @ColumnInfo(name = "is_active") val isActive: Boolean
)

/**
 * Кортеж для объединения данных блока и данных настроек.
 */
data class BoxAndSettingsTuple(
    @Embedded val boxDbEntity: BoxDbEntity,
    @Embedded val settingDbEntity: AccountBoxSettingDbEntity?
)