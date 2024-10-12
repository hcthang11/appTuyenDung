 package com.hcthang.apptuyendung.ui.noticification

import androidx.recyclerview.widget.LinearLayoutManager
import com.hcthang.apptuyendung.R
import com.hcthang.apptuyendung.data.model.NotificationItem
import com.hcthang.apptuyendung.data.model.User
import com.hcthang.apptuyendung.databinding.FragmentNoticificationBinding
import com.hcthang.apptuyendung.ui.account.information.InformationFragment
import com.hcthang.apptuyendung.ui.base.fragment.BaseMvvmFragment
import com.hcthang.apptuyendung.ui.base.viewmodel.BaseViewModel

 class NoticificationFragment(private val user: User?) : BaseMvvmFragment<NotificationCallBack,NotificationViewModel>(),NotificationCallBack,NoticificationAdapter.INotification{

     override fun initComponents() {
        getBindingData().noticifiViewModel = mModel
        mModel.uiEventLiveData.observe(this){
            when(it){
                BaseViewModel.FINISH_ACTIVITY -> finishActivity()

            }
        }
        mModel.getDataNotification(user!!,requireContext())
         initRecyclerViewNotification()
     }
     private fun initRecyclerViewNotification(){
         val noticificationAdapter = NoticificationAdapter(this)
         getBindingData().rcvNotification.layoutManager = LinearLayoutManager(context)
         getBindingData().rcvNotification.adapter = noticificationAdapter
     }

     override fun getBindingData() = mBinding as FragmentNoticificationBinding

     override fun setEvents() {

     }

     override fun getViewModel(): Class<NotificationViewModel> {
         return NotificationViewModel::class.java
     }
     override fun error(id: String, error: Throwable) {
         showMessage(error.message!!)
     }

     override fun getLayoutMain(): Int {
         return R.layout.fragment_noticification
     }

     override fun count(): Int {
         return mModel.getListNotification().size
     }

     override fun getNotification(position: Int): NotificationItem {
         return mModel.getListNotification().get(position)
     }

     override fun onClickViewProfile(position: Int) {
         val notificationItem = mModel.getListNotification().get(position)
         val fragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
         fragmentTransaction.replace(R.id.fragmentMain, InformationFragment(notificationItem.candidate!!))
         fragmentTransaction.addToBackStack(InformationFragment.TAG)
         fragmentTransaction.commit()
     }

 }