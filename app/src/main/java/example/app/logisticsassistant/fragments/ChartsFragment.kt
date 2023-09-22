package example.app.logisticsassistant.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CalendarView
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.ScrollView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import example.app.logisticsassistant.R

class ChartsFragment : Fragment() {

    private lateinit var buttonWork: Button
    private lateinit var buttonDayOff: Button
    private lateinit var calendarView: CalendarView
    private lateinit var textViewSelectedDay: TextView
    private lateinit var scrollView: ScrollView
    private lateinit var containeR: LinearLayout
    private lateinit var radioGroup: RadioGroup
    private lateinit var radioButtonWorkDay: RadioButton
    private lateinit var radioButtonDayOff: RadioButton
    private lateinit var buttonSave: Button
    private lateinit var buttonCancel: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_charts, container, false)

        // Найдите и инициализируйте ваши элементы интерфейса здесь
        buttonWork = view.findViewById(R.id.buttonWork)
        buttonDayOff = view.findViewById(R.id.buttonDayOff)
        calendarView = view.findViewById(R.id.calendarView)
        textViewSelectedDay = view.findViewById(R.id.textViewSelectedDay)
        scrollView = view.findViewById(R.id.scrollView)
        containeR = view.findViewById(R.id.container)
        radioGroup = view.findViewById(R.id.radioGroup)
        radioButtonWorkDay = view.findViewById(R.id.radioButtonWorkDay)
        radioButtonDayOff = view.findViewById(R.id.radioButtonDayOff)
        buttonSave = view.findViewById(R.id.buttonSave)
        buttonCancel = view.findViewById(R.id.buttonCancel)

        // Установите слушатели событий для кнопок и календаря
        buttonWork.setOnClickListener {
            // Обработка нажатия на кнопку "Рабочий"
            // Здесь вы можете выполнить необходимые действия
        }

        buttonDayOff.setOnClickListener {
            // Обработка нажатия на кнопку "Выходной"
            // Здесь вы можете выполнить необходимые действия
        }

        calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
            // Обработка выбора даты в календаре
            val selectedDate = "$dayOfMonth/${month + 1}/$year"
            textViewSelectedDay.text = "$selectedDate"

            // Сделать контейнер видимым
            textViewSelectedDay.visibility = View.VISIBLE
            containeR.visibility = View.VISIBLE
        }

        // Установите слушатель события для кнопки "Сохранить"
        buttonSave.setOnClickListener {
            // Получите выбранную дату
            val selectedDate = textViewSelectedDay.text.toString()
            // Получите выбранный параметр
            val selectedParameter = if (radioButtonWorkDay.isChecked) "Рабочий день" else "Выходной день"
            // Выполните необходимые действия с выбранными данными
            // Например, вы можете отправить данные на сервер или сохранить их локально
            Toast.makeText(requireContext(), "Сохранено: $selectedDate, $selectedParameter", Toast.LENGTH_SHORT).show()
            // Скройте контейнер после сохранения
            containeR.visibility = View.GONE
        }

        // Установите слушатель события для кнопки "Отменить"
        buttonCancel.setOnClickListener {
            // Скройте контейнер без сохранения
            containeR.visibility = View.GONE
        }

        return view
    }


}