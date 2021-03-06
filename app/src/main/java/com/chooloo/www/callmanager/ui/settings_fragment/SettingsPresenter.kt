package com.chooloo.www.callmanager.ui.settings_fragment

import androidx.preference.Preference
import com.chooloo.www.callmanager.ui.base.BasePresenter
import com.chooloo.www.callmanager.util.PermissionUtils.RC_DEFAULT
import com.chooloo.www.callmanager.util.PermissionUtils.checkPermissionsGranted

class SettingsPresenter<V : SettingsMvpView> : BasePresenter<V>(), SettingsMvpPresenter<V> {

    override fun onRequestPermissionResult(requestCode: Int, grantResults: IntArray) {
        if (requestCode == RC_DEFAULT && checkPermissionsGranted(grantResults)) {
            mvpView?.setupSimSelection()
        }
    }

    override fun onListPreferenceChange(preference: Preference, newValue: Any): Boolean {
        mvpView?.setListPreferenceSummary(preference, newValue)
        return true
    }

    override fun onSwitchPreferenceChange(preference: Preference, newValue: Any): Boolean {
        mvpView?.setSwitchPreferenceSummary(preference, newValue)
        return true
    }

    override fun onCheckBoxPreferenceChange(preference: Preference, newValue: Any): Boolean {
        mvpView?.setCheckBoxPreferenceSummary(preference, newValue)
        return true
    }

    override fun refresh() {
        mvpView?.goToMainActivity()
    }
}