package com.hcthang.apptuyendung.ui.payer

import android.content.Context
import com.android.volley.AuthFailureError
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.hcthang.apptuyendung.data.local.AppDatabase
import com.hcthang.apptuyendung.data.remote.InteractCommon
import com.hcthang.apptuyendung.data.sqlite.SQLiteHelper
import com.hcthang.apptuyendung.ui.base.viewmodel.BaseViewModel
import org.json.JSONException
import org.json.JSONObject
import java.util.concurrent.Executor
import javax.inject.Inject

class PayerActivityViewModel @Inject constructor(
    appDatabase: AppDatabase,
    interactCommon: InteractCommon,
    scheduler: Executor
) : BaseViewModel<PayerActivityCallBack>(appDatabase, interactCommon, scheduler) {

    private var SECRET_KEY : String = "sk_test_51LKdlnFE2VHDpf9G5XhkTsjlzRxgd7DDH5aPTtZy37xNbjPJOz8hJY6IvonqwtcnjnJZbep8pzogdnJ4PZyqbzEt00UXrDSDnN"
    private var PUBLISH_KEY : String = "pk_test_51LKdlnFE2VHDpf9GUFQtCwNsEdaPQidrn5x4A2WWAYgQu05Ys84SHNCFkOVp1iFLpAyj64PQv09gsVZYtOZXATHW00VSketTnk"
    private var customerID: String? = null
    private var EphericalKey: String? = null
    private var ClientSecret: String? = null
    private var active : Int? = null

    companion object{
        const val ON_CLICK_PAY = 1
        const val ON_CLICK_TRIAL = 2
        const val ON_PAYER_SUCCESS= 3
    }
    fun onClickPay(){
        uiEventLiveData.value = ON_CLICK_PAY
    }
    fun onClickTrial(){
        uiEventLiveData.value = ON_CLICK_TRIAL
    }
    fun payer(context: Context){
        val stringRequest: StringRequest = object : StringRequest(
            Method.POST, "https://api.stripe.com/v1/customers",
            Response.Listener { response ->
                try {
                    val `object` = JSONObject(response)
                    customerID = `object`.getString("id")
                    getEphericalKey(customerID!!,context)
                } catch (e: JSONException) {
                    e.printStackTrace()
                }
            }, Response.ErrorListener {
                println("error" + it.message)
            }) {
            @Throws(AuthFailureError::class)
            override fun getHeaders(): Map<String, String> {
                val header: MutableMap<String, String> = HashMap()
                header["Authorization"] = "Bearer $SECRET_KEY"
                return header
            }
        }

        val requestQueue = Volley.newRequestQueue(context)
        requestQueue.add(stringRequest)
    }

    private fun getEphericalKey(customerID: String,context: Context) {
        val stringRequest: StringRequest = object : StringRequest(
            Method.POST, "https://api.stripe.com/v1/ephemeral_keys",
            Response.Listener { response ->
                try {
                    val `object` = JSONObject(response)
                    EphericalKey = `object`.getString("id")
                    getClientSecret(customerID,context)
                } catch (e: JSONException) {
                    e.printStackTrace()
                }
            }, Response.ErrorListener { }) {
            @Throws(AuthFailureError::class)
            override fun getHeaders(): Map<String, String> {
                val header: MutableMap<String, String> = java.util.HashMap()
                header["Authorization"] = "Bearer $SECRET_KEY"
                header["Stripe-Version"] = "2020-08-27"
                return header
            }

            @Throws(AuthFailureError::class)
            override fun getParams(): Map<String, String>? {
                val params: MutableMap<String, String> = java.util.HashMap()
                params["customer"] = customerID
                return params
            }
        }
        val requestQueue = Volley.newRequestQueue(context)
        requestQueue.add(stringRequest)
    }

    private fun getClientSecret(customerID: String,context: Context) {
        val stringRequest: StringRequest = object : StringRequest(
            Method.POST, "https://api.stripe.com/v1/payment_intents",
            Response.Listener { response ->
                try {
                    val `object` = JSONObject(response)
                    ClientSecret = `object`.getString("client_secret")
                } catch (e: JSONException) {
                    e.printStackTrace()
                }
            }, Response.ErrorListener { }) {
            @Throws(AuthFailureError::class)
            override fun getHeaders(): Map<String, String> {
                val header: MutableMap<String, String> = java.util.HashMap()
                header["Authorization"] = "Bearer $SECRET_KEY"
                return header
            }

            @Throws(AuthFailureError::class)
            override fun getParams(): Map<String, String>? {
                val params: MutableMap<String, String> = java.util.HashMap()
                params["customer"] = customerID
                params["amount"] = "30" + "00"
                params["currency"] = "usd"
                params["automatic_payment_methods[enabled]"] = "true"
                return params
            }
        }
        val requestQueue = Volley.newRequestQueue(context)
        requestQueue.add(stringRequest)
    }
    fun getCustomerID() : String{
        return customerID!!
    }
    fun getEphericalKey() : String{
        return EphericalKey!!
    }
    fun getClientSecret() : String{
        return ClientSecret!!
    }
    fun setActive(context: Context,userId : String){
        val sqLiteHelper = SQLiteHelper(context, "Data.sqlite", null, 5)
        sqLiteHelper.QueryData("UPDATE UserActive SET active = '1' WHERE IdUser ='$userId'")
        uiEventLiveData.value = ON_PAYER_SUCCESS
    }
    fun checkActive(context: Context,userId : String) : Boolean{
        val sqLiteHelper = SQLiteHelper(context, "Data.sqlite", null, 5)
        val cursor = sqLiteHelper.GetData("SELECT * FROM UserActive WHERE IdUser = '$userId'")
        while (cursor.moveToNext()) {
            active = cursor.getInt(2)
        }
        if(active == 1){
            return true
        }else
            return false
    }
}