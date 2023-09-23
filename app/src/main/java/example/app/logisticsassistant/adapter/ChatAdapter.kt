package example.app.logisticsassistant.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import example.app.logisticsassistant.R

class ChatAdapter(private val chatList: List<Chat>, private val onItemClick: (Chat) -> Unit) :
    RecyclerView.Adapter<ChatAdapter.ChatViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_chat, parent, false)
        return ChatViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        val chat = chatList[position]
        holder.bind(chat)
        holder.itemView.setOnClickListener { onItemClick(chat) }
    }

    override fun getItemCount(): Int = chatList.size
    fun addMessage(message: Message) {

    }

    inner class ChatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val contactNameTextView: TextView = itemView.findViewById(R.id.contactNameTextView)
        private val lastMessageTextView: TextView = itemView.findViewById(R.id.lastMessageTextView)

        fun bind(chat: Chat) {
            contactNameTextView.text = chat.contactName
            lastMessageTextView.text = chat.lastMessage
        }
    }
}