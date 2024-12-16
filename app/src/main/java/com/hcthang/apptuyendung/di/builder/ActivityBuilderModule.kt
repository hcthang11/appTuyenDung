package com.hcthang.apptuyendung.di.builder

import com.hcthang.apptuyendung.ui.candidate.CandidateMainActivity
import com.hcthang.apptuyendung.ui.employer.EmployerMainActivity
import com.hcthang.apptuyendung.ui.login.FirstActivity
import com.hcthang.apptuyendung.ui.payer.PayerActivity
import com.hcthang.apptuyendung.ui.xample.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

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