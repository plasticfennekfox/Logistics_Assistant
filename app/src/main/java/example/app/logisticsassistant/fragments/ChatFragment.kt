package example.app.logisticsassistant.fragments

import example.app.logisticsassistant.ChatActivity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import example.app.logisticsassistant.R
import example.app.logisticsassistant.adapter.Chat
import example.app.logisticsassistant.adapter.ChatAdapter

class ChatFragment : Fragment() {

    private lateinit var chatAdapter: ChatAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_chat, container, false)

        val chatList = mutableListOf(
            Chat("Контакт 1", "Привет, как дела?", System.currentTimeMillis()),
            Chat("Контакт 2", "Здравствуй, что нового?", System.currentTimeMillis())
            // Добавьте другие чаты
        )

        chatAdapter = ChatAdapter(chatList) { chat ->
            // Обработчик клика, который открывает активити с перепиской
            val intent = Intent(activity, ChatActivity::class.java)
            intent.putExtra("contactName", chat.contactName)
            startActivity(intent)
        }

        val recyclerViewChats: RecyclerView = view.findViewById(R.id.recyclerViewChats)
        recyclerViewChats.layoutManager = LinearLayoutManager(activity)
        recyclerViewChats.adapter = chatAdapter

        return view
    }
}