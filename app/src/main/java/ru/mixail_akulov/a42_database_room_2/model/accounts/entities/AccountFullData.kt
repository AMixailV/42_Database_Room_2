package ru.mixail_akulov.a42_database_room_2.model.accounts.entities

import ru.mixail_akulov.a42_database_room_2.model.boxes.entities.BoxAndSettings

/**
 * Информация об учетной записи со всеми ящиками и их настройками
 */
data class AccountFullData(
    val account: Account,
    val boxesAndSettings: List<BoxAndSettings>
)