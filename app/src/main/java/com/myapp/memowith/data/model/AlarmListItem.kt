package com.myapp.memowith.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "AlarmList")
class AlarmListItem {
    @PrimaryKey(autoGenerate = true)
    var no: Long = 0L
    var createTimestamp: Long = 0L
    var handledTimestamp: Long = 0L
    var triggerUserId: Int? = null
    var userName: String? = null
    var alarmPriority: Int = 0
    var alarmTitle: String? = null
    var alarmMsg: String? = null
    var isHandled: Boolean = false

}