package com.dagger.newdagger.ui

import androidx.fragment.app.Fragment
import com.dagger.main.MainFlowFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

interface RootScreens {
    object MainFlow : SupportAppScreen() {
        override fun getFragment(): Fragment = MainFlowFragment()
    }
}