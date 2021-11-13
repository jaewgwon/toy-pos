package io.github.jaewgwon.pos.ui.custom

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import io.github.jaewgwon.pos.databinding.FragmentLoadingDialogBinding
import io.github.jaewgwon.pos.ui.base.BaseDialog

class LoadingDialogFragment: BaseDialog<FragmentLoadingDialogBinding>(FragmentLoadingDialogBinding::inflate) {
    override fun onResume() {
        super.onResume()
        dialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }
}