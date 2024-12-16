package com.hcthang.apptuyendung.ui.utils

import androidx.fragment.app.FragmentManager
import com.hcthang.apptuyendung.R
import com.hcthang.apptuyendung.ui.base.AnimationScreen
import com.hcthang.apptuyendung.ui.base.fragment.BaseFragment
import com.hcthang.apptuyendung.ui.login.signup.RegisterFragment
import com.hcthang.apptuyendung.ui.xample.user.UserFragment

object OpenFragmentUtils {
    @JvmStatic
    fun getAnimationScreenFullOpen(): AnimationScreen {
        return AnimationScreen(
            R.anim.enter_to_left,
            R.anim.exit_to_left,
            R.anim.enter_to_right,
            R.anim.exit_to_right
        )
    }

    @JvmStatic
    fun openUserFragment(manager: FragmentManager) {
        val transaction = manager.beginTransaction()
        BaseFragment.openFragment(
            manager,
            transaction,
            UserFragment::class.java,
            null,
            false,
            true,
            null,
            R.id.content
        )
    }
    @JvmStatic
    fun openRegisterFragment(manager: FragmentManager) {
        val transaction = manager.beginTransaction()
        BaseFragment.openFragment(
            manager,
            transaction,
            RegisterFragment::class.java,
            null,
            false,
            true,
            null,
            R.id.fragmentLogin1
        )
    }
}