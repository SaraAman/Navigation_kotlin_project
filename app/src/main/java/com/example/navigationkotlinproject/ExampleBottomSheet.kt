package com.example.navigationkotlinproject

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ExampleBottomSheet: BottomSheetDialogFragment() {
    private var bottomSheetListener: BottomSheetListener? = null
    var englishButton: Button? = null
    var urduButton:Button? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.bottom_sheet_layout, container, false)
        englishButton = view.findViewById(R.id.english)
        //        urduButton= view.findViewById(R.id.urdu);
//        englishButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                bottomSheetListener.onButtonClick("Button English Clicked");
//                dismiss();
//            }
//        });
//        urduButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                bottomSheetListener.onButtonClick("Button Urdu Clicked");
//                dismiss();
//            }
//        });
        return view
    }

    interface BottomSheetListener {
        fun onButtonClick(text: String?)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is BottomSheetListener) {
            bottomSheetListener = context
        } else {
        }
    }


}