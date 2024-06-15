package ru.mixail_akulov.a42_database_room_2.model.boxes.room.views

import androidx.room.ColumnInfo
import androidx.room.DatabaseView
import androidx.room.Embedded
import ru.mixail_akulov.a42_database_room_2.model.boxes.room.entities.SettingsTuple

/**
 * Это представление базы данных выглядит как таблица «accounts_boxes_settings»,
 * но возвращает значения по умолчанию («1») для строк, которых нет в «accounts_boxes_settings».
 */
@DatabaseView(
    viewName = "settings_view",
    value = "SELECT \n" +
            "  accounts.id as account_id, \n" +
            "  boxes.id as box_id,\n" +
            "  ifnull(accounts_boxes_settings.is_active, 1) as is_active\n" +
            "FROM accounts\n" +
            "JOIN boxes\n" +
            "LEFT JOIN accounts_boxes_settings\n" +
            "  ON accounts_boxes_settings.account_id = accounts.id \n" +
            "    AND accounts_boxes_settings.box_id = boxes.id"
)
data class SettingDbView(
    @ColumnInfo(name = "account_id") val accountId: Long,
    @ColumnInfo(name = "box_id") val boxId: Long,
    @Embedded val settings: SettingsTuple,
)
