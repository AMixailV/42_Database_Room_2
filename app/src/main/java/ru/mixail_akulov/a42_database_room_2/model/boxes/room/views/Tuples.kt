package ru.mixail_akulov.a42_database_room_2.model.boxes.room.views

import androidx.room.Embedded
import androidx.room.Relation
import ru.mixail_akulov.a42_database_room_2.model.accounts.room.entities.AccountDbEntity
import ru.mixail_akulov.a42_database_room_2.model.boxes.room.entities.BoxDbEntity

/**
 * Кортеж для запроса строк из «settings_view» со связанными сущностями:
 * [AccountDbEntity] по значению в столбце «account_id» и
 * [BoxDbEntity] по значению в столбце «box_id».
 */
data class SettingWithEntitiesTuple(
    @Embedded val settingDbEntity: SettingDbView,

    @Relation(
        parentColumn = "account_id",
        entityColumn = "id"
    )
    val accountDbEntity: AccountDbEntity,

    @Relation(
        parentColumn = "box_id",
        entityColumn = "id"
    )
    val boxDbEntity: BoxDbEntity
)