package example.app.logisticsassistant.adapter

import android.os.Parcel
import android.os.Parcelable

data class TaskData(
    val furniture: String,
    val currentTask: String,
    val senderAddress: String,
    val deliveryAddress: String,
    val orderDetails: String,
    val paymentDetails: String,
    var isCurrentTask: Boolean,

    var isTaskCompleted: Boolean = false
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readByte() != 0.toByte(),
        parcel.readByte() != 0.toByte()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(furniture)
        parcel.writeString(currentTask)
        parcel.writeString(senderAddress)
        parcel.writeString(deliveryAddress)
        parcel.writeString(orderDetails)
        parcel.writeString(paymentDetails)
        parcel.writeByte(if (isCurrentTask) 1 else 0)
        parcel.writeByte(if (isTaskCompleted) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<TaskData> {
        override fun createFromParcel(parcel: Parcel): TaskData {
            return TaskData(parcel)
        }

        override fun newArray(size: Int): Array<TaskData?> {
            return arrayOfNulls(size)
        }
    }
}