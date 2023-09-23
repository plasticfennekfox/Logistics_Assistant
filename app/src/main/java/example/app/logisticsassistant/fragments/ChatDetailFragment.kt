package example.app.logisticsassistant.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import example.app.logisticsassistant.R

class ChatDetailFragment : Fragment() {

    companion object {
        private const val ARG_CONTACT_NAME = "contact_name"

        fun newInstance(contactName: String): ChatDetailFragment {
            val fragment = ChatDetailFragment()
            val args = Bundle()
            args.putString(ARG_CONTACT_NAME, contactName)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Получите информацию о чате из аргументов
        val contactName = arguments?.getString(ARG_CONTACT_NAME)

        // Используйте информацию для отображения соответствующей переписки

        // Верните макет для фрагмента
        return inflater.inflate(R.layout.fragment_chat_detail, container, false)
    }
}