package com.android.mestore

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager.TAG
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.android.mestore.databinding.FragmentLoginBinding
import com.android.mestore.databinding.FragmentRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class RegisterFragment : Fragment() {
    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!
    private lateinit var register: Button
    lateinit var RedirectLogin: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        register = binding.regBtn
        RedirectLogin = binding.regTxt5

        register.setOnClickListener {
            val intent = Intent ( requireContext(), HomeActivity::class.java)
            startActivity(intent)

        }
        RedirectLogin.setOnClickListener {
            Navigation.findNavController(view).navigate(com.android.mestore.R.id.action_registerFragment_to_loginFragment);
        }
    }

}












