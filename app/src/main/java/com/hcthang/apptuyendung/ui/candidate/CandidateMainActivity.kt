package com.hcthang.apptuyendung.ui.candidate


import androidx.fragment.app.Fragment
import com.hcthang.apptuyendung.R
import com.hcthang.apptuyendung.data.model.User
import com.hcthang.apptuyendung.databinding.ActivityCandidateBinding
import com.hcthang.apptuyendung.ui.base.activity.BaseMVVMActivity
import com.hcthang.apptuyendung.ui.candidate.list_job.ListJobSearchFragment
import com.hcthang.apptuyendung.ui.account.ProfileFragment

class CandidateMainActivity : BaseMVVMActivity<CandidateMainCallBack,CandidateMainModelView>(),CandidateMainCallBack {

    private var backPressTime: Long = 0
    private var user : User? = null

    override fun getLayoutMain(): Int {
        return R.layout.activity_candidate
    }

    override fun setEvents() {

    }

    override fun initComponents() {
        user = intent.getSerializableExtra("user") as User?
        getBindingData().candidateMainViewModel = mModel
        getFragmet(ListJobSearchFragment(user))
        onClickMenu()
    }

    override fun getBindingData() = mBinding as ActivityCandidateBinding

    override fun getViewModel(): Class<CandidateMainModelView> {
        return CandidateMainModelView::class.java
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
//            Toast.makeText(this, "Nhấn 2 lần liên tiếp để throat app", Toast.LENGTH_SHORT).show()
//        }
//        backPressTime = System.currentTimeMillis()
//    }
    private fun onClickMenu(){
        getBindingData().bottomNav.setOnNavigationItemSelectedListener { item ->
            when(item.itemId){
                R.id.myJobFragment2 -> {
                    getFragmet(ListJobSearchFragment(user))
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.profileFragment2 -> {
                    getFragmet(ProfileFragment(user))
                    return@setOnNavigationItemSelectedListener true
                }
            }
            false
        }
    }
    private fun getFragmet(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentMain2,fragment)
        fragmentTransaction.commit()
    }
}