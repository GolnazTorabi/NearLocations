package com.cafebazaar.test.nearlocations.utils.Dialog

import android.app.Activity
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatDialog
import androidx.databinding.DataBindingUtil
import com.cafebazaar.test.nearlocations.R
import com.cafebazaar.test.nearlocations.databinding.CustomDialogBinding
import java.util.*

class CustomDialog(
    activity: Activity,
    onDialogCallBack: AlertDialogCallback,
    titleText: String,
    positiveText: String?,
    negativeText: String?
) :
    AppCompatDialog(activity) {
    init {
        Objects.requireNonNull(window)!!.setBackgroundDrawableResource(R.color.transparent)
        val dialogView: View =
            activity.layoutInflater.inflate(R.layout.custom_dialog, null)
        setContentView(dialogView)
        val title =
            dialogView.findViewById<TextView>(R.id.title)
        title.text = titleText
        val positive =
            dialogView.findViewById<TextView>(R.id.positiveBtn)
        val negative =
            dialogView.findViewById<TextView>(R.id.negativeBtn)
        positive.text = positiveText
        negative.text = negativeText
        positive.setOnClickListener { v: View? ->
            onDialogCallBack.onPositive()
            dismiss()
        }
        negative.setOnClickListener { v: View? ->
            onDialogCallBack.onNegative()
            dismiss()
        }
    }
}

interface AlertDialogCallback {
    fun onPositive()
    fun onNegative()
}