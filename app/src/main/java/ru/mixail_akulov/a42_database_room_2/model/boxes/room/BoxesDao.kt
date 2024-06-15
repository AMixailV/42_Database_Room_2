package ru.mixail_akulov.a42_database_room_2.model.boxes.room

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import ru.mixail_akulov.a42_database_room_2.model.boxes.room.entities.AccountBoxSettingDbEntity
import ru.mixail_akulov.a42_database_room_2.model.boxes.room.views.SettingWithEntitiesTuple

@Dao
interface BoxesDao {

    @Transaction
    @Query("SELECT * FROM settings_view WHERE account_id = :accountId")
    fun getBoxesAndSettings(accountId: Long): Flow<List<SettingWithEntitiesTuple>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun setActiveFlagForBox(accountBoxSetting: AccountBoxSettingDbEntity)

}
