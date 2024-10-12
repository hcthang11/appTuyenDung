package com.hcthang.apptuyendung.ui.employer.job.job_information

import com.hcthang.apptuyendung.data.local.AppDatabase
import com.hcthang.apptuyendung.data.remote.InteractCommon
import com.hcthang.apptuyendung.ui.base.viewmodel.BaseViewModel
import java.util.concurrent.Executor
import javax.inject.Inject

class JobInformationViewModel @Inject constructor(
    appDatabase: AppDatabase,
    interactCommon: InteractCommon,
    scheduler: Executor
) : BaseViewModel<JobInformationCallBack>(appDatabase, interactCommon, scheduler) {

    companion object{
        const val ON_CLICK_APPLY = 1
        const val ON_CLICK_UPDATE = 2
    }

    fun onClickApply(){
        uiEventLiveData.value = ON_CLICK_APPLY
    }
    fun onClickUpdate(){
        uiEventLiveData.value = ON_CLICK_UPDATE
    }
}