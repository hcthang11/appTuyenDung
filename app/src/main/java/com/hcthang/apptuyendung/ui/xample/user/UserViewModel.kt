package com.hcthang.apptuyendung.ui.xample.user

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.MutableLiveData
import com.hcthang.apptuyendung.common.Constants
import com.hcthang.apptuyendung.data.local.AppDatabase
import com.hcthang.apptuyendung.data.model.UserExample
import com.hcthang.apptuyendung.data.remote.ApiHelp
import com.hcthang.apptuyendung.data.remote.ApiUser
import com.hcthang.apptuyendung.data.remote.InteractCommon
import com.hcthang.apptuyendung.ui.base.viewmodel.BaseViewModel
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.Executor
import javax.inject.Inject

class UserViewModel @Inject constructor(
    appDatabase: AppDatabase,
    interactCommon: InteractCommon,
    scheduler: Executor) : BaseViewModel<UserCallBack>(appDatabase, interactCommon, scheduler) {
    val mIsRefreshing = ObservableBoolean(false)
    private val api: ApiUser
    val obUsers = MutableLiveData<MutableList<UserExample>>()
        get

    init {
        api = ApiHelp.createRetrofit(endpoint = Constants.BASE_URL, formatDate = Constants.LIST_FORMAT_TIME).create(ApiUser::class.java)
        getUsers()
    }

    fun getUsers() : Disposable?{
        setIsLoading(true)
        return subscribeHasResultDispose(api.getUsers().subscribeOn(Schedulers.from(schedulers))
                .observeOn(Schedulers.computation()), {
                setIsLoading(false)
                mIsRefreshing.set(false)
                makeFunOnOtherThread {
                    appDatabase.userDao().insertListUser(it.data!!)
                }
                obUsers.postValue(it.data)
            },{
                mIsRefreshing.set(false)
                setIsLoading(false)
                callBack?.get()?.error(UserExample::class.java.name, it)
            }
        )
    }

    fun getAllUserOffline(){
        obUsers.postValue(appDatabase.userDao().findAll())
    }

    fun onRefresh(){
        mIsRefreshing.set(true)
        getUsers()
    }
}