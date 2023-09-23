package example.app.logisticsassistant

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import example.app.logisticsassistant.adapter.Chat
import example.app.logisticsassistant.adapter.ChatAdapter

class ChatActivity : AppCompatActivity() {

    private lateinit var recyclerViewChat: RecyclerView
    private lateinit var editTextMessage: EditText
    private lateinit var buttonSend: Button
    private val chatList = mutableListOf<Chat>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true) // Кнопка "Назад"

        val contactName = intent.getStringExtra("contactName")
        supportActionBar?.title = contactName

        recyclerViewChat = findViewById(R.id.recyclerViewChat)
        editTextMessage = findViewById(R.id.editTextMessage)
        buttonSend = findViewById(R.id.buttonSend)

        // Настройка RecyclerView для отображения чата
        recyclerViewChat.layoutManager = LinearLayoutManager(this)
        val chatAdapter = ChatAdapter(chatList) { chat ->
            // Обработчик клика, который открывает активити с перепиской
            val intent = Intent(this, ChatActivity::class.java)
            intent.putExtra("contactName", chat.contactName)
            startActivity(intent)
        }
        recyclerViewChat.adapter = chatAdapter

        // Обработчик нажатия кнопки "Отправить"
        buttonSend.setOnClickListener {
            val message = editTextMessage.text.toString()
            if (message.isNotEmpty()) {
                // Отправить сообщение и добавить его в адаптер чата
                chatAdapter.addMessage(
                    example.app.logisticsassistant.adapter.Message(
                        message,
                        isSentByUser = true
                    )
                )
                editTextMessage.text.clear()
                // Здесь можно добавить логику отправки сообщения на самом деле
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Обработка нажатия кнопки "Назад"
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}