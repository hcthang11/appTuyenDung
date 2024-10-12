package com.b15d52nhom4.apptuyendung.ui.candidate

import com.b15d52nhom4.apptuyendung.data.local.AppDatabase
import com.b15d52nhom4.apptuyendung.data.remote.InteractCommon
import com.b15d52nhom4.apptuyendung.ui.base.viewmodel.BaseViewModel
import java.util.concurrent.Executor
import javax.inject.Inject

class CandidateMainModelView @Inject constructor(
    appDatabase: AppDatabase,
    interactCommon: InteractCommon,
    scheduler: Executor
) : BaseViewModel<CandidateMainCallBack>(appDatabase, interactCommon, scheduler) {
}