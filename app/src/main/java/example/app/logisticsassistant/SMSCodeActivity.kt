package example.app.logisticsassistant

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class SMSCodeActivity : AppCompatActivity() {

    private lateinit var smsCodeEditText: EditText
    private lateinit var resendCodeTextView: TextView

    private val countdownTimer: CountDownTimer by lazy {
        object : CountDownTimer(60000, 1000) { // 60 секунд, обновление каждую секунду
            override fun onTick(millisUntilFinished: Long) {
                val secondsLeft = millisUntilFinished / 1000
                val timerText = "Повторно выслать код через $secondsLeft сек."
                resendCodeTextView.text = timerText
            }

            override fun onFinish() {
                // Таймер завершился, делаем строку "выслать повторный код" кликабельной и меняем цвет на красный
                resendCodeTextView.text = "Выслать повторный код"
                resendCodeTextView.setTextColor(getColor(R.color.red_text_color))
                resendCodeTextView.isClickable = true
                resendCodeTextView.setOnClickListener {
                    // Здесь можно реализовать логику отправки повторного кода
                    startCountdown() // Запустить таймер снова
                    resendCodeTextView.setTextColor(getColor(R.color.gray_text_color))
                    resendCodeTextView.isClickable = false // После нажатия делаем строку некликабельной
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sms_code)

        smsCodeEditText = findViewById(R.id.editTextSMSCode)
        resendCodeTextView = findViewById(R.id.textViewResendCode)
        //smsCodeEditText = findViewById(R.id.editTextSMSCode)

        startCountdown() // Запустить таймер при создании активности
    }

    fun onVerifyCodeClick(view: android.view.View) {
        val enteredCode = smsCodeEditText.text.toString()
        val correctCode = "123456" // Здесь установите правильный код

        if (enteredCode == correctCode) {
            showToast("Код верный")
            // Здесь вы можете добавить логику для авторизации пользователя
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            showToast("Код неверный")
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    // Функция для запуска и рестарта таймера
    private fun startCountdown() {
        countdownTimer.start()
    }

    override fun onResume() {
        super.onResume()
        resendCodeTextView.setTextColor(getColor(R.color.gray_text_color)) // Установка серого цвета при восстановлении активности
    }

    fun onBackButtonClick(view: View) {
        val intent = Intent(this, PhoneNumberActivity::class.java)
        startActivity(intent)
        finish()
    }
}

