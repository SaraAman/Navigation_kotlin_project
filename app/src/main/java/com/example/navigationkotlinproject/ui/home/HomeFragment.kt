package com.example.navigationkotlinproject.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.example.navigationkotlinproject.*
import com.example.navigationkotlinproject.apicall.Industry
import com.example.navigationkotlinproject.apicall.IndustryDataModel
import com.example.navigationkotlinproject.apicall.IndustryInterface



import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() , ExampleBottomSheet.BottomSheetListener {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
//        homeViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })


        root.text_home.setOnClickListener {
//            NavHostFragment.findNavController(this@HomeFragment)
//                .navigate(R.id.action_nav_home_to_myDialog)
            getApiResponse()
        }


        root.modal_Bottom_Sheet.setOnClickListener(View.OnClickListener {
            val bottomSheet = ExampleBottomSheet()
            bottomSheet.show(childFragmentManager, "Example Bottom Sheet")
        })
        return root
    }
    fun getApiResponse() {

        val industryInterfaceAPI: IndustryInterface= Industry.createServices<IndustryInterface>(IndustryInterface::class.java, "admin",
                "XzUzTFQzUS5AUEkudkAyX5OG8eakYoY5XY39bxPGn")
       // var call = IndustryInterface.createServices()
        val call: Call<IndustryDataModel> =industryInterfaceAPI.getAllIndustry()
        if (call != null) {
            call.enqueue(object : Callback<IndustryDataModel> {
                override fun onResponse(call: Call<IndustryDataModel>, response: Response<IndustryDataModel?>) {
                    if (response.isSuccessful()) {

                        Log.d("ApiResponse", "Successful.......................!")

                    } else {

                    }
                }

                override fun onFailure(call: Call<IndustryDataModel>, t: Throwable) {
                    Log.d("ApiResponse", "Failure.......................!")
                }
            })
        }

    }
    
    
    override fun onButtonClick(text: String?) {


    }
}

private fun <T> Call<T>?.enqueue(callback: Callback<IndustryDataModel>) {

}






