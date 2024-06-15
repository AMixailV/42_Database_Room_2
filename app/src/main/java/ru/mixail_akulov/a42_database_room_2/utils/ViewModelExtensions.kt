package ru.mixail_akulov.a42_database_room_2.utils

import androidx.lifecycle.LiveData

fun <T> LiveData<T>.requireValue(): T {
    return this.value ?: throw IllegalStateException("Value is empty")
}