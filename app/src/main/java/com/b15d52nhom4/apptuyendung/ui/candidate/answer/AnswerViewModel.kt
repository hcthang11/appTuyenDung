package com.b15d52nhom4.apptuyendung.ui.candidate.answer

import android.content.Context
import com.b15d52nhom4.apptuyendung.data.local.AppDatabase
import com.b15d52nhom4.apptuyendung.data.model.User
import com.b15d52nhom4.apptuyendung.data.model.job.Job
import com.b15d52nhom4.apptuyendung.data.remote.InteractCommon
import com.b15d52nhom4.apptuyendung.data.sqlite.SQLiteHelper
import com.b15d52nhom4.apptuyendung.ui.base.viewmodel.BaseViewModel
import java.util.concurrent.Executor
import javax.inject.Inject

class AnswerViewModel @Inject constructor(
    appDatabase: AppDatabase,
    interactCommon: InteractCommon,
    scheduler: Executor
) : BaseViewModel<AnswerCallBack>(appDatabase, interactCommon, scheduler) {
    private var active : Int? = null
    companion object{
        const val CLICK_COMFIRM = 1
        const val APPLY_ERROR = 2
        const val APPLY_SUCCESS = 3
    }

    fun onClickComfirm(){
        uiEventLiveData.value = CLICK_COMFIRM
    }
    fun setApply(candidate: User, job: Job, context: Context) {
        val sqLiteHelper = SQLiteHelper(context, "Data.sqlite", null, 5)
        val cursor = sqLiteHelper.GetData("SELECT * FROM Apply WHERE IdCandidate = '${candidate.idAccount}' AND IdJob ='${job.idJob}'")
        if (cursor.count <= 0) {
            sqLiteHelper.QueryData("INSERT INTO Apply VALUES(null,'${candidate.idAccount}','${job.idJob}','${job.employer!!.idAccount}')")
            uiEventLiveData.value = APPLY_SUCCESS
        } else {
            uiEventLiveData.value = APPLY_ERROR
        }
    }
}