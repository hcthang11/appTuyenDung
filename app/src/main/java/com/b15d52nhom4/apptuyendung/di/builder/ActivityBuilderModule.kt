package com.b15d52nhom4.apptuyendung.di.builder

import com.b15d52nhom4.apptuyendung.ui.candidate.CandidateMainActivity
import com.b15d52nhom4.apptuyendung.ui.employer.EmployerMainActivity
import com.b15d52nhom4.apptuyendung.ui.login.FirstActivity
import com.b15d52nhom4.apptuyendung.ui.payer.PayerActivity
import com.b15d52nhom4.apptuyendung.ui.xample.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector
//******************************
//******************************
//***** Create by cuongpq  *****
//******************************
//******************************

@Module
abstract class ActivityBuilderModule {
    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun contributeFirstActivity(): FirstActivity

    @ContributesAndroidInjector
    abstract fun contributeEmployerMaintActivity(): EmployerMainActivity

    @ContributesAndroidInjector
    abstract fun contributeCandidateMainActivity(): CandidateMainActivity

    @ContributesAndroidInjector
    abstract fun contributePayerActivity(): PayerActivity
}