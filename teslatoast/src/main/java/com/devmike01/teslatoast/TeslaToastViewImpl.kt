package com.devmike01.teslatoast

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.saybits.teslatoast.R


/**
 * @Author: Gbenga Oladipupo(devmike01)
 * @Date: 26/05/2022
 */
    class TeslaToastViewImpl(private val teslaToastArgs: TeslaToastArgs) : BottomSheetDialogFragment(), TeslaToastView {

    override fun getTheme() = R.style.TeslaToastTheme

    private var mainTextView : TextView? = null

    private var actionButton: Button? = null

    private var imageIcon: ImageView? = null

    private var mContext: Context? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.TeslaToastTheme)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.window?.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        return dialog
    }

    override fun onAttach(context: Context) {
        this.mContext = context
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val teslaView = inflater.inflate(R.layout.tesla_toast_layout, container, false)
        mainTextView = teslaView.findViewById<TextView>(R.id.content_text)
        actionButton = teslaView.findViewById(R.id.button_text)
        imageIcon = teslaView.findViewById(R.id.trailing_iv)
        return teslaView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mainTextView?.setText(teslaToastArgs.text)
        imageIcon?.setImageResource(teslaToastArgs.icon)
    }

    override fun show(activity: FragmentActivity?) {
        activity?.run {
            show(supportFragmentManager, "TeslaToast")
        }
    }

    override fun hide() {
        dismiss()
    }
}