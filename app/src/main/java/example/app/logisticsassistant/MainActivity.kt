package example.app.logisticsassistant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import example.app.logisticsassistant.fragments.ChartsFragment
import example.app.logisticsassistant.fragments.ChatFragment
import example.app.logisticsassistant.fragments.ProfileFragment
import example.app.logisticsassistant.fragments.TasksFragment
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat


@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {


    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var toolbar: Toolbar

    // переменная для сохранения состояния фрагмента
    private var selectedFragmentId: Int = R.id.menu_tasks

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        bottomNavigationView = findViewById(R.id.bottomNavigationView)
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Установка начального заголовка
        supportActionBar?.title = "Задания"

        // Установка слушателя для обработки выбора элементов навигации
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            selectedFragmentId = item.itemId
            when (item.itemId) {
                R.id.menu_tasks -> {
                    loadFragment(TasksFragment())
                    setToolbarTitle("Задания")
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.menu_charts -> {
                    loadFragment(ChartsFragment())
                    setToolbarTitle("График смен")
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.menu_chat -> {
                    loadFragment(ChatFragment())
                    setToolbarTitle("Чат")
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.menu_profile -> {
                    loadFragment(ProfileFragment())
                    setToolbarTitle("Профиль")
                    return@setOnNavigationItemSelectedListener true
                }
                else -> return@setOnNavigationItemSelectedListener false
            }
        }

        // Проверяем, было ли сохранено состояние
        if (savedInstanceState != null) {
            selectedFragmentId = savedInstanceState.getInt("selectedFragmentId")
        }

        // Восстанавливаем выбранный фрагмент
        bottomNavigationView.selectedItemId = selectedFragmentId
    }

    override fun onSaveInstanceState(outState: Bundle) {
        // Сохраняем состояние
        outState.putInt("selectedFragmentId", selectedFragmentId)
        super.onSaveInstanceState(outState)
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }

    private fun setToolbarTitle(title: String) {
        supportActionBar?.title = title
    }

    override fun onBackPressed() {
        finishAffinity()
    }


}