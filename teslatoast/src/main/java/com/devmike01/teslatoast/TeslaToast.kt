package com.devmike01.teslatoast

import android.os.Handler
import androidx.annotation.StringRes
import androidx.fragment.app.FragmentActivity

/**
 * @Author: Gbenga Oladipupo(devmike01)
 * @Date: 26/05/2022
 */
object TeslaToast {


    const val LENGTH_SHORT : Long = 1_000
    const val LENGTH_LONG : Long = 5_000

    fun show(activity: FragmentActivity, @StringRes content: Int, @StringRes buttonText: Int = 0, trailingIcon: Int, duration : Long?){

        val teslaToastArgs = TeslaToastArgs(text = content,  icon = trailingIcon, buttonText)
        val teslaToastView : TeslaToastView = TeslaToastViewImpl(teslaToastArgs)

        teslaToastView.show(activity)
        duration?.run {
            Handler(activity.mainLooper).postDelayed({
                teslaToastView.hide()
            }, this)
        }

    }


    fun show(activity: FragmentActivity, @StringRes content: Int, @StringRes buttonText: Int = 0, duration : Long?){
        show(activity, content, buttonText,  trailingIcon = 0, duration = duration)
    }

}