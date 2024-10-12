package com.hcthang.apptuyendung.ui.employer

import androidx.fragment.app.Fragment
import com.hcthang.apptuyendung.R
import com.hcthang.apptuyendung.data.model.User
import com.hcthang.apptuyendung.databinding.ActivityEmployerMainBinding
import com.hcthang.apptuyendung.ui.base.activity.BaseMVVMActivity
import com.hcthang.apptuyendung.ui.employer.job.my_job.MyJobFragment
import com.hcthang.apptuyendung.ui.noticification.NoticificationFragment
import com.hcthang.apptuyendung.ui.account.ProfileFragment

class EmployerMainActivity : BaseMVVMActivity<EmployerMainCallBack,EmployerMainViewModel>(),EmployerMainCallBack {

    private var backPressTime: Long = 0
    private var user : User? = null

    override fun getLayoutMain(): Int {
       return R.layout.activity_employer_main;
    }

    override fun setEvents() {

    }

    override fun initComponents() {
        user = intent.getSerializableExtra("user") as User?
        getBindingData().employerMainViewModel = mModel
        getFragmet(MyJobFragment(user))
        onClickMenu()
    }

    override fun getBindingData() = mBinding as ActivityEmployerMainBinding

    override fun getViewModel(): Class<EmployerMainViewModel> {
        return EmployerMainViewModel::class.java
    }
    override fun error(id: String, error: Throwable) {
        showMessage(error.message!!)
    }

//    override fun onBackPressed() {
//        if (backPressTime + 2000 > System.currentTimeMillis()) {
//            finishAffinity()
//            System.exit(0)
//            return
//        } else {
//            Toast.makeText(this, "Nhấn 2 lần liên tiếp để thoát app", Toast.LENGTH_SHORT).show()
//        }
//        backPressTime = System.currentTimeMillis()
//    }

    private fun getFragmet(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentMain,fragment)
        fragmentTransaction.commit()
    }
    private fun onClickMenu(){
        getBindingData().bottomNav.setOnNavigationItemSelectedListener { item ->
            when(item.itemId){
                R.id.myJobFragment -> {
                    getFragmet(MyJobFragment(user))
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.profileFragment -> {
                    getFragmet(ProfileFragment(user))
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.notificationFragment -> {
                    getFragmet(NoticificationFragment(user))
                    return@setOnNavigationItemSelectedListener true
                }
            }
            false
        }
    }
}