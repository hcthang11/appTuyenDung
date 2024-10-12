package com.b15d52nhom4.apptuyendung.ui.employer.company.create_company

import android.widget.Toast
import com.b15d52nhom4.apptuyendung.R
import com.b15d52nhom4.apptuyendung.databinding.FragmentCreateCompanyBinding
import com.b15d52nhom4.apptuyendung.ui.base.fragment.BaseMvvmFragment
import com.b15d52nhom4.apptuyendung.ui.base.viewmodel.BaseViewModel

class CreateCompanyFragment : BaseMvvmFragment<CreateCompanyCallBack,CreateCompanyViewModel>(),CreateCompanyCallBack{

    override fun initComponents() {
        getBindingData().createCompanyViewModel = mModel
        mModel.uiEventLiveData.observe(this){
            when(it){
                BaseViewModel.FINISH_ACTIVITY -> finishActivity()
                CreateCompanyViewModel.ON_CLICK_CREATE -> createCompany()
                CreateCompanyViewModel.CREATE_COMPANY_SUCCESS -> createCompanySuccess()
            }
        }
    }

    override fun getLayoutMain(): Int {
        return R.layout.fragment_create_company
    }

    override fun setEvents() {

    }

    override fun getBindingData() = mBinding as FragmentCreateCompanyBinding

    override fun getViewModel(): Class<CreateCompanyViewModel> {
        return CreateCompanyViewModel::class.java
    }

    override fun error(id: String, error: Throwable) {
        showMessage(error.message!!)
    }
    companion object{
        val TAG = CreateCompanyFragment::class.java.name
    }
    private fun createCompany(){
        val companyName = getBindingData().edCompanyName.text.toString().trim()
        val companyAvatar = getBindingData().edCompanyAvatar.text.toString().trim()
        val companyAddress = getBindingData().edCompanyAddress.text.toString().trim()
        if(companyName.isEmpty() || companyAvatar.isEmpty() || companyAddress.isEmpty()){
            Toast.makeText(context,"Thiếu thông tin",Toast.LENGTH_SHORT).show()
        }else{
            mModel.addCompanyToDB(companyName,companyAvatar,companyAddress,requireContext())
        }
    }
    private fun createCompanySuccess(){
        Toast.makeText(context,"Tạo thành công",Toast.LENGTH_SHORT).show()
        requireActivity().supportFragmentManager.popBackStack()
    }
}