package ru.mixail_akulov.a42_database_room_2.screens.main.tabs.admin

import androidx.recyclerview.widget.DiffUtil

class AdminTreeItemDiffCallback(
    private val oldList: List<AdminTreeItem>,
    private val newList: List<AdminTreeItem>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }
    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}