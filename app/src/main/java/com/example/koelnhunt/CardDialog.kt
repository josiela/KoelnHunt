package com.example.koelnhunt

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.fragment.app.DialogFragment

class CardDialog : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            // Get the layout inflater
            val inflater = requireActivity().layoutInflater

            // Inflate and set the layout for the dialog
            // Pass null as the parent view because its going in the dialog layout
            val linearLayout = inflater.inflate(R.layout.card_hinweis, null)
            val closeCard = linearLayout.findViewById<ImageButton>(R.id.CloseButtonHint)
            closeCard.setOnClickListener {
                this
            }
            builder.setView(inflater.inflate(R.layout.card_hinweis, null))
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}