package com.devmike01.teslatoast

import androidx.fragment.app.FragmentActivity

/**
 * @Author: Gbenga Oladipupo(devmike01)
 * @Date: 26/05/2022
 */
interface TeslaToastView  {
    fun show(activity: FragmentActivity?)
    fun hide()
}