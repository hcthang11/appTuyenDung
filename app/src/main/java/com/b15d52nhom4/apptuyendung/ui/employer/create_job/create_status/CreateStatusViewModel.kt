package com.b15d52nhom4.apptuyendung.ui.employer.create_job.create_status

import android.content.Context
import com.b15d52nhom4.apptuyendung.data.local.AppDatabase
import com.b15d52nhom4.apptuyendung.data.remote.InteractCommon
import com.b15d52nhom4.apptuyendung.data.sqlite.SQLiteHelper
import com.b15d52nhom4.apptuyendung.ui.base.viewmodel.BaseViewModel
import java.util.concurrent.Executor
import javax.inject.Inject

class CreateStatusViewModel @Inject constructor(
    appDatabase: AppDatabase,
    interactCommon: InteractCommon,
    scheduler: Executor
) : BaseViewModel<CreateStatusCallBack>(appDatabase,interactCommon,scheduler)  {

    lateinit var idJob : String

    companion object{
        const val CLICK_DONE = 1
        const val SET_STATUS_SUCCESS =2
    }

    fun onClickDone(){
        uiEventLiveData.value = CLICK_DONE
    }

    fun setStatus(context: Context, status : Int){
        val sqLiteHelper = SQLiteHelper(context, "Data.sqlite", null, 5)
        sqLiteHelper.QueryData("UPDATE Job4 SET status = '$status' WHERE JobCode ='$idJob'")
        uiEventLiveData.value = SET_STATUS_SUCCESS
    }

}