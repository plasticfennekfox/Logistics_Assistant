package example.app.logisticsassistant

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

@Suppress("DEPRECATION")
class SplashActivity : AppCompatActivity() {
    private val SPLASH_DELAY: Long = 2000 // Время задержки в миллисекундах

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            val intent = Intent(this, PhoneNumberActivity::class.java)
            startActivity(intent)
            finish()
        }, SPLASH_DELAY)
    }
}