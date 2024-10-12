package com.b15d52nhom4.apptuyendung.di.builder

import com.b15d52nhom4.apptuyendung.ui.candidate.answer.AnswerFragment
import com.b15d52nhom4.apptuyendung.ui.candidate.list_job.ListJobSearchFragment
import com.b15d52nhom4.apptuyendung.ui.employer.company.create_company.CreateCompanyFragment
import com.b15d52nhom4.apptuyendung.ui.employer.job.job_information.JobInformationFragment
import com.b15d52nhom4.apptuyendung.ui.employer.create_job.create_description.AddJobFragment
import com.b15d52nhom4.apptuyendung.ui.employer.create_job.create_question.CreateQuestionFragment
import com.b15d52nhom4.apptuyendung.ui.employer.create_job.create_request.CreateRequestFragment
import com.b15d52nhom4.apptuyendung.ui.employer.create_job.create_right.CreateRightFragment
import com.b15d52nhom4.apptuyendung.ui.employer.create_job.create_status.CreateStatusFragment
import com.b15d52nhom4.apptuyendung.ui.employer.job.my_job.MyJobFragment
import com.b15d52nhom4.apptuyendung.ui.employer.company.update_company.UpdateCompanyFragment
import com.b15d52nhom4.apptuyendung.ui.login.signin.LoginFragment
import com.b15d52nhom4.apptuyendung.ui.login.signup.RegisterFragment
import com.b15d52nhom4.apptuyendung.ui.xample.user.UserFragment
import com.b15d52nhom4.apptuyendung.ui.noticification.NoticificationFragment
import com.b15d52nhom4.apptuyendung.ui.account.ProfileFragment
import com.b15d52nhom4.apptuyendung.ui.account.information.InformationFragment
import com.b15d52nhom4.apptuyendung.ui.account.update_skill.UpdateSkillFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector
//******************************
//******************************
//***** Create by cuongpq  *****
//******************************
//******************************

@Module
abstract class FragmentBuilderModule {
    @ContributesAndroidInjector
    abstract fun contributeUserFragment(): UserFragment

    @ContributesAndroidInjector
    abstract fun contributeLoginFragment(): LoginFragment

    @ContributesAndroidInjector
    abstract fun contributeRegisterFragment(): RegisterFragment

    @ContributesAndroidInjector
    abstract fun contributeProfileFragment() : ProfileFragment

    @ContributesAndroidInjector
    abstract fun contributeMyJobFragment() : MyJobFragment

    @ContributesAndroidInjector
    abstract fun contributeNoticificationFragment() : NoticificationFragment

    @ContributesAndroidInjector
    abstract fun contributeAddJobFragment() : AddJobFragment

    @ContributesAndroidInjector
    abstract fun contributeUpdateSkillFragment() : UpdateSkillFragment

    @ContributesAndroidInjector
    abstract fun contributeJobInformationFragment() : JobInformationFragment

    @ContributesAndroidInjector
    abstract fun contributeUpdateCompanyFragment() : UpdateCompanyFragment

    @ContributesAndroidInjector
    abstract fun contributeCreateRequestFragment() : CreateRequestFragment

    @ContributesAndroidInjector
    abstract fun contributeCreateQuestionFragment() : CreateQuestionFragment

    @ContributesAndroidInjector
    abstract fun contributeCreateRightFragment() : CreateRightFragment

    @ContributesAndroidInjector
    abstract fun contributeCreateStatusFragment() : CreateStatusFragment

    @ContributesAndroidInjector
    abstract fun contributeListJobSearchFragment() : ListJobSearchFragment

    @ContributesAndroidInjector
    abstract fun contributeAnswerFragment() : AnswerFragment

    @ContributesAndroidInjector
    abstract fun contributeCreateCompanyFragment() : CreateCompanyFragment

    @ContributesAndroidInjector
    abstract fun contributeInformationFragment() : InformationFragment
}