package com.instances.resturent_finder.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.instances.resturent_finder.databinding.FragmentProfileBinding
import com.instances.resturent_finder.networking.ApiListener
import com.instances.resturent_finder.networking.NetworkingModel
import com.instances.resturent_finder.networking.request.UpdateProfileRequest
import com.instances.resturent_finder.networking.response.UpdateProfileResponse


class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding
    private lateinit var networkingModel: NetworkingModel
    private lateinit var userId: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(layoutInflater)

        initViews()
        setClickListeners()
        return binding.root
    }

    private fun setClickListeners() {
        binding.apply {
            btnSaveProfile.setOnClickListener {
                validateData()
            }
        }
    }

    private fun FragmentProfileBinding.validateData() {
        val name = etUsername.text.toString().trim()
        val idNumber = etCnic.text.toString().trim()
        val email = etEmail.text.toString().trim()
        val phone = etPhone.text.toString().trim()

        if (name.isEmpty() && idNumber.isEmpty() && email.isEmpty() && phone.isEmpty()){
            Toast.makeText(requireContext(),"error",Toast.LENGTH_SHORT).show()
        }else{
            val request =
                UpdateProfileRequest(name = name, role = idNumber, email = email, phone = phone)
            excUpdateProfileApi(request)
        }
    }

    private fun excUpdateProfileApi(request: UpdateProfileRequest) {
        networkingModel.updateProfile(userId,request,
        object :ApiListener<UpdateProfileResponse>{
            override fun onSuccess(body: UpdateProfileResponse?) {
                if (body!!.status == "success"){
                    Toast.makeText(requireContext(),"Profile Update successfully",Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(error: Throwable) {
                Toast.makeText(requireContext(),error.message.toString(),Toast.LENGTH_SHORT).show()

            }

        })
    }


    private fun initViews() {
       networkingModel = NetworkingModel()
        //this user id will be get when you hit the get user api
        userId = "1"
    }

}