    package com.leca.zandiakt.fragments

    import android.os.Bundle
    import android.view.*
    import androidx.appcompat.app.AlertDialog
    import androidx.appcompat.app.AppCompatActivity
    import androidx.fragment.app.Fragment
    import androidx.navigation.fragment.findNavController
    import com.google.firebase.auth.FirebaseAuth
    import com.leca.zandiakt.R
    import com.leca.zandiakt.databinding.FragmentHomeBinding

    class HomeFragment : Fragment() {

        private lateinit var auth: FirebaseAuth
        private var _binding: FragmentHomeBinding? = null
        private val binding get() = _binding!!

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            _binding = FragmentHomeBinding.inflate(inflater, container, false)
            return binding.root
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            // Inicializar FirebaseAuth
            auth = FirebaseAuth.getInstance()

            // Verificar si hay un usuario autenticado
            val currentUser = auth.currentUser
            if (currentUser != null) {
                // Mostrar mensaje de bienvenida para usuario autenticado
                val displayName = currentUser.displayName ?: currentUser.email
                binding.tvWelcomeMessage.text = "Bienvenido, $displayName"
            } else {
                // Manejar caso donde no hay usuario autenticado (opcional)
                binding.tvWelcomeMessage.text = "Bienvenido"
            }

            setHasOptionsMenu(true)
        }

        override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
            inflater.inflate(R.menu.menu_home, menu)
            super.onCreateOptionsMenu(menu, inflater)
        }

        override fun onOptionsItemSelected(item: MenuItem): Boolean {
            return when (item.itemId) {
                R.id.action_logout -> {
                    showLogoutConfirmationDialog()
                    true
                }
                else -> super.onOptionsItemSelected(item)
            }
        }

        private fun showLogoutConfirmationDialog() {
            AlertDialog.Builder(requireContext())
                .setTitle("Cerrar Sesión")
                .setMessage("¿Estás seguro de que deseas cerrar sesión?")
                .setPositiveButton("Sí") { _, _ ->
                    logout()
                }
                .setNegativeButton("No", null)
                .show()
        }

        private fun logout() {
            auth.signOut()
            findNavController().navigate(R.id.action_homeFragment_to_optionsFragment)
        }

        override fun onDestroyView() {
            super.onDestroyView()
            _binding = null
        }
    }
