package example.app.logisticsassistant

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PhoneNumberActivity : AppCompatActivity() {

    private lateinit var editTextPhoneNumber: EditText
    private lateinit var sendCodeButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_number)

        editTextPhoneNumber = findViewById(R.id.editTextPhoneNumber)
        sendCodeButton = findViewById(R.id.buttonSendCode)

        sendCodeButton.setOnClickListener {
            val phoneNumber = editTextPhoneNumber.text.toString()

            // Проверка, что номер введен правильно (например, проверка формата)
            if (isValidPhoneNumber(phoneNumber)) {
                // Здесь вы можете добавить логику отправки SMS-кода


                // После отправки кода переход к активности ввода кода
                val intent = Intent(this, SMSCodeActivity::class.java)
                intent.putExtra("phoneNumber", phoneNumber)
                startActivity(intent)
            } else {
                // Вывод сообщения об ошибке пользователю через Toast
                Toast.makeText(this, "Введите правильный номер телефона", Toast.LENGTH_SHORT).show()
            }
        }
    }


    private fun isValidPhoneNumber(phoneNumber: String): Boolean {
        //val phoneNumberRegex = "\\d{10}" // Формат: 10 цифр подряд
        //return phoneNumber.matches(phoneNumberRegex.toRegex())
        return true
    }
}