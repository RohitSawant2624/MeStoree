package com.android.mestore.Model

import androidx.room.Delete
import kotlinx.android.parcel.Parcelize
import java.util.Date


data class PolicyModel(
    val categories : ArrayList<categoriesdata>

) {
    data class categoriesdata (
        var categoryID : String,
        var category : String,
        var createdAt : String,
        var updatedAt : String ,
        var adminType : String,
        var modifiedBy : String,
        var srNo : Int,
        val policycategorys : ArrayList<Policycategorys>,
        var delete: Boolean,
    ) {
        data class Policycategorys (
            var policySubCategoryId :Int,
            var title: String,
            var description: String,
            var categoryID: String,
            var createdAt: Int,
            var updatedAt: Int,
            var employeeId : Int,
            var modifiedBy: String,
            var srNo: Int,
            var polices : ArrayList<Polices>
        ) {
            data class Polices (
                var _id : String,
                var scope : Int,
                var policyName: String,
                var description: String,
                var policy_pdf_link : String,
                var adminType: String,
                var uploadingAccess : String,
                var subcategory : String,
                var lastModifiedBy : String,
                var modificationDate: String,
                var companyId : String,
                var isAdmin : Boolean,
                var srNo: Int,
                var employeeId: Int,
                var modifiedBy: String,
                var encodedFile : Int,
                var objectives :String,
                var limits :String,
                var eligibility : String,
                var generalGuidelines: String,
                var sectorList : ArrayList<String> ,
                var buList : ArrayList<String> ,
                var sectorListDropDown : ArrayList<SectorListDropDown>,
                var buListDropDown :ArrayList<BuList>,
                var keys : ArrayList<String> ,
                var effectiveDate : String,
                var deleted : Boolean ,
                var notify : Boolean,





            ) {
               data  class SectorListDropDown (
                    var sectorId :String,
                    val SectorName :String,


                )

               data  class BuList (
                   var buId :String,
                   var buName : String,
                       )



            }
        }
    }


}








