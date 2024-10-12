package com.b15d52nhom4.apptuyendung.ui.employer.company.create_company

import android.content.Context
import com.b15d52nhom4.apptuyendung.data.local.AppDatabase
import com.b15d52nhom4.apptuyendung.data.remote.InteractCommon
import com.b15d52nhom4.apptuyendung.data.sqlite.SQLiteHelper
import com.b15d52nhom4.apptuyendung.ui.base.viewmodel.BaseViewModel
import java.util.concurrent.Executor
import javax.inject.Inject

class CreateCompanyViewModel @Inject constructor(
    appDatabase: AppDatabase,
    interactCommon: InteractCommon,
    scheduler: Executor
) : BaseViewModel<CreateCompanyCallBack>(appDatabase,interactCommon,scheduler)  {

   companion object{
       const val ON_CLICK_CREATE = 1
       const val CREATE_COMPANY_SUCCESS = 2
   }
   fun onClickCreateCompany(){
       uiEventLiveData.value = ON_CLICK_CREATE
   }
   fun addCompanyToDB(companyName : String, companyAvatar : String, companyAddress : String,context: Context){
       val sqLiteHelper = SQLiteHelper(context, "Data.sqlite", null, 5)
       sqLiteHelper.QueryData("INSERT INTO Company VALUES(null,'$companyName','$companyAvatar','$companyAddress')")
       uiEventLiveData.value = CREATE_COMPANY_SUCCESS
   }
}