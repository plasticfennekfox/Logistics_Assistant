package example.app.logisticsassistant.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import example.app.logisticsassistant.R

class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Здесь разместите макет для фрагмента "Профиль"
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }
}