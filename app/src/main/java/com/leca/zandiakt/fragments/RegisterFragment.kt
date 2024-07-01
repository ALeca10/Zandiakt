package com.leca.zandiakt.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.leca.zandiakt.R
import com.leca.zandiakt.services.ApiClient
import com.leca.zandiakt.databinding.FragmentRegisterBinding
import com.leca.zandiakt.models.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonRegisterRegister.setOnClickListener {
            val name = binding.etNameRegister.text.toString()
            val last_name = binding.etLastNameRegister.text.toString()
            val email = binding.etEmailRegister.text.toString()
            val password = binding.etPasswordRegister.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                val user = User(0, name, last_name,email, password)
                registerUser(user)
            } else {
                Toast.makeText(requireContext(), "Por favor ingresar los datos requeridos", Toast.LENGTH_SHORT).show()
            }
        }

        binding.tvCrearCuenta.setOnClickListener {
            findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
        }
    }

    private fun registerUser(user: User) {
        ApiClient.instance.registerUser(user).enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.isSuccessful) {
                    findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
                    Toast.makeText(requireContext(), "Registro exitoso", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(requireContext(), "Registro fallido", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                Toast.makeText(requireContext(), "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
