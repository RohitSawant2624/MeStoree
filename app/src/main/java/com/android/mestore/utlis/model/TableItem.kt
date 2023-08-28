import android.annotation.SuppressLint
import android.os.Parcel
import android.os.Parcelable
import android.os.Parcelable.Creator
import android.provider.ContactsContract.Contacts.Data
import androidx.versionedparcelable.VersionedParcelize
import kotlinx.android.parcel.Parcelize


@Parcelize
class TableItem  (
    val tableName : String,
    val tableBrandName : String,
    val tableImage: Int,
    val tablePrice: Double ,) :Parcelable





//     constructor(parcel: Parcel) {
//        tableName = parcel.readString()
//        tableBrandName = parcel.readString()
//        tableImage = parcel.readInt()
//        tablePrice = parcel.readDouble()
//    }
//
//    override fun describeContents(): Int {
//        return 0
//    }
//
//    override fun writeToParcel(parcel: Parcel, i: Int) {
//        parcel.writeString(tableName)
//        parcel.writeString(tableBrandName)
//        parcel.writeInt(tableImage)
//        parcel.writeDouble(tablePrice)
//    }

//    fun getTableName(): String {
//        return getTableName()
//
//    }
//
//    fun getTableBrandName(): String {
//        return getTableBrandName()
//
//    }
//
//    fun getTablePrice(): Double {
//        return getTablePrice()
//
//    }
//
//    fun getTableImage(): Int {
//        return getTableImage()
//
//    }

//    companion object {
//        val Creator: Creator<TableItem> = object : Creator<TableItem> {
//            override fun createFromParcel(parcel: Parcel): TableItem {
//                return TableItem(parcel)
//            }
//
//            override fun newArray(size: Int): Array<TableItem?> {
//                return arrayOfNulls(size)
//            }
//        }
//    }

//    companion object CREATOR : Creator<TableItem> {
//        override fun createFromParcel(parcel: Parcel): TableItem {
//            return TableItem(parcel)
//        }
//
//        override fun newArray(size: Int): Array<TableItem?> {
//            return arrayOfNulls(size)
//        }
//    }
