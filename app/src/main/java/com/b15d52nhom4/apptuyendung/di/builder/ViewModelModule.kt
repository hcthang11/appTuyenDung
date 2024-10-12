package com.b15d52nhom4.apptuyendung.di.builder

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.b15d52nhom4.apptuyendung.di.model.ViewModelFactory
import com.b15d52nhom4.apptuyendung.di.model.ViewModelKey
import com.b15d52nhom4.apptuyendung.ui.candidate.CandidateMainModelView
import com.b15d52nhom4.apptuyendung.ui.candidate.answer.AnswerViewModel
import com.b15d52nhom4.apptuyendung.ui.candidate.list_job.ListJobSearchViewModel
import com.b15d52nhom4.apptuyendung.ui.employer.job.job_information.JobInformationViewModel
import com.b15d52nhom4.apptuyendung.ui.employer.EmployerMainViewModel
import com.b15d52nhom4.apptuyendung.ui.employer.company.create_company.CreateCompanyViewModel
import com.b15d52nhom4.apptuyendung.ui.employer.create_job.create_description.AddJobViewModel
import com.b15d52nhom4.apptuyendung.ui.employer.create_job.create_question.CreateQuestionViewModel
import com.b15d52nhom4.apptuyendung.ui.employer.create_job.create_request.CreateRequestViewModel
import com.b15d52nhom4.apptuyendung.ui.employer.create_job.create_right.CreateRightViewModel
import com.b15d52nhom4.apptuyendung.ui.employer.create_job.create_status.CreateStatusViewModel
import com.b15d52nhom4.apptuyendung.ui.employer.job.my_job.MyJobViewModel
import com.b15d52nhom4.apptuyendung.ui.employer.company.update_company.UpdateCompanyViewModel
import com.b15d52nhom4.apptuyendung.ui.login.FirstViewModel
import com.b15d52nhom4.apptuyendung.ui.login.signin.LoginViewModel
import com.b15d52nhom4.apptuyendung.ui.login.signup.RegisterViewModel
import com.b15d52nhom4.apptuyendung.ui.xample.MainViewModel
import com.b15d52nhom4.apptuyendung.ui.noticification.NotificationViewModel
import com.b15d52nhom4.apptuyendung.ui.account.ProfileViewModel
import com.b15d52nhom4.apptuyendung.ui.account.information.InformationViewModel
import com.b15d52nhom4.apptuyendung.ui.account.update_skill.UpdateSkillViewModel
import com.b15d52nhom4.apptuyendung.ui.payer.PayerActivityViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
//******************************
//******************************
//***** Create by cuongpq  *****
//******************************
//******************************

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindsMainViewModel(mainViewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(EmployerMainViewModel::class)
    abstract fun bindsEmployerMainViewModel(employerMainViewModel: EmployerMainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CandidateMainModelView::class)
    abstract fun bindsCandidateMainViewModel(candidateMainModelView: CandidateMainModelView): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(FirstViewModel::class)
    abstract fun bindsFirstViewModel(firstViewModel: FirstViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun bindsLoginViewModel(logInViewModel: LoginViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(RegisterViewModel::class)
    abstract fun bindsRegisterViewModel(registerViewModel: RegisterViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel::class)
    abstract fun bindsProfileViewModel(profileViewModel: ProfileViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MyJobViewModel::class)
    abstract fun bindsMyJobViewModel(myJobViewModel: MyJobViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(NotificationViewModel::class)
    abstract fun bindsNotificationViewModel(notificationViewModel: NotificationViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AddJobViewModel::class)
    abstract fun bindsAddJobViewModel(addJobViewModel: AddJobViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(UpdateSkillViewModel::class)
    abstract fun bindsUpdateSkillViewModel(updateSkillViewModel: UpdateSkillViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(JobInformationViewModel::class)
    abstract fun bindsJobInformationViewModel(jobInformationViewModel: JobInformationViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(UpdateCompanyViewModel::class)
    abstract fun bindsUpdateCompanyViewModel(updateCompanyViewModel: UpdateCompanyViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CreateRequestViewModel::class)
    abstract fun bindsCreateRequestViewModel(createRequestViewModel: CreateRequestViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CreateQuestionViewModel::class)
    abstract fun bindsCreateQuestionViewModel(createQuestionViewModel: CreateQuestionViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CreateRightViewModel::class)
    abstract fun bindsCreateRightViewModel(createRightViewModel: CreateRightViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CreateStatusViewModel::class)
    abstract fun bindsCreateStatusViewModel(createStatusViewModel: CreateStatusViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ListJobSearchViewModel::class)
    abstract fun bindsListJobSearchViewModel(listJobSearchViewModel: ListJobSearchViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AnswerViewModel::class)
    abstract fun bindsAnswerViewModel(answerViewModel: AnswerViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CreateCompanyViewModel::class)
    abstract fun bindsCreateCompanyViewModel(createCompanyViewModel: CreateCompanyViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(InformationViewModel::class)
    abstract fun bindsInformationViewModel(informationViewModel: InformationViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(PayerActivityViewModel::class)
    abstract fun bindsPayerActivityViewModel(payerActivityViewModel: PayerActivityViewModel): ViewModel

    @Binds
    abstract fun bindsViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}