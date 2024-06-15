package ru.mixail_akulov.a42_database_room_2.model.accounts.entities

/**
 * Information about the user.
 */
data class Account(
    val id: Long,
    val username: String,
    val email: String,
    val createdAt: Long = UNKNOWN_CREATED_AT
) {

    /**
     * Предположим, что админ всего один и его ID = 1 xD
     */
    fun isAdmin() = id == ADMIN_ACCOUNT_ID

    companion object {
        const val UNKNOWN_CREATED_AT = 0L

        private const val ADMIN_ACCOUNT_ID = 1L
    }
}