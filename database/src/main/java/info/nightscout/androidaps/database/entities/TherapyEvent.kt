package info.nightscout.androidaps.database.entities

import androidx.room.*
import info.nightscout.androidaps.database.TABLE_THERAPY_EVENTS
import info.nightscout.androidaps.database.embedments.InterfaceIDs
import info.nightscout.androidaps.database.interfaces.DBEntry
import info.nightscout.androidaps.database.interfaces.DBEntryWithTimeAndDuration

@Entity(tableName = TABLE_THERAPY_EVENTS,
        foreignKeys = [ForeignKey(
                entity = TherapyEvent::class,
                parentColumns = ["id"],
                childColumns = ["referenceID"])],
        indices = [Index("referenceID"), Index("timestamp")])
data class TherapyEvent(
        @PrimaryKey(autoGenerate = true)
        override var id: Long = 0,
        override var version: Int = 0,
        override var lastModified: Long = -1,
        override var valid: Boolean = true,
        override var referenceID: Long = 0,
        @Embedded
        override var interfaceIDs: InterfaceIDs = InterfaceIDs(),
        override var timestamp: Long,
        override var utcOffset: Long,
        override var duration: Long,
        var type: Type,
        var note: String?,
        var amount: Double?
) : DBEntry, DBEntryWithTimeAndDuration {
    enum class Type {
        CANNULA_CHANGED,
        TUBE_CHANGED,
        RESERVOIR_CHANGED,
        BATTERY_CHANGED,
        LEAKING_INFUSION_SET,
        SENSOR_INSERTED,
        SENSOR_STARTED,
        SENSOR_STOPPED,
        FINGER_STICK_BG_VALUE,
        ACTIVITY,
        FALLING_ASLEEP,
        WAKING_UP,
        SICKNESS,
        STRESS,
        PRE_PERIOD,
        ALCOHOL,
        CORTISON,
        FEELING_LOW,
        FEELING_HIGH,
        ANNOUNCEMENT,
        QUESTION,
        NOTE,
        APS_OFFLINE,
        PUMP_BATTERY_EMPTY,
        RESERVOIR_EMPTY,
        OCCLUSION
    }
}