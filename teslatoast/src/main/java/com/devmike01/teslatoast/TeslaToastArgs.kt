package com.devmike01.teslatoast

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

/**
 * @Author: Gbenga Oladipupo(devmike01)
 * @Date: 26/05/2022
 */

data class TeslaToastArgs(val text: Int =0, @DrawableRes val icon: Int=0, @StringRes val buttonText: Int =0)