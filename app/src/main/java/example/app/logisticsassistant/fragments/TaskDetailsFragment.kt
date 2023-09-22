package example.app.logisticsassistant.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import example.app.logisticsassistant.R
import example.app.logisticsassistant.adapter.TaskData

@Suppress("DEPRECATION")
class TaskDetailsFragment : Fragment() {

    companion object {
        fun newInstance(task: TaskData): TaskDetailsFragment {
            val fragment = TaskDetailsFragment()
            val args = Bundle()
            // Здесь добавьте данные задания в аргументы
            args.putParcelable("task", task)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_task_details, container, false)

        // Получаем данные задания из аргументов
        val task = arguments?.getParcelable<TaskData>("task")

        // Заполняем элементы интерфейса данными задания
        if (task != null) {
            val cargoTypeTextView: TextView = view.findViewById(R.id.textViewCargoType)
            val cityTextView: TextView = view.findViewById(R.id.textViewExecutionCity) // Замените на нужный ID
            val dateTextView: TextView = view.findViewById(R.id.textViewOrderDate) // Замените на нужный ID
            val arrivalTimeTextView: TextView = view.findViewById(R.id.textViewArrivalTime) // Замените на нужный ID
            val startLocationTextView: TextView = view.findViewById(R.id.textViewStartLocation) // Замените на нужный ID
            val endLocationTextView: TextView = view.findViewById(R.id.textViewEndLocation) // Замените на нужный ID
            val bodyTypeTextView: TextView = view.findViewById(R.id.textViewTruckType) // Замените на нужный ID
            val orderDetailsTextView: TextView = view.findViewById(R.id.textViewOrderDetails) // Замените на нужный ID
            val paymentDetailsTextView: TextView = view.findViewById(R.id.textViewPaymentDetails) // Замените на нужный ID
            val contactsTextView: TextView = view.findViewById(R.id.textViewContacts) // Замените на нужный ID

            cargoTypeTextView.text = "Тип груза: ${task.furniture}"
            cityTextView.text = "Город исполнения: ${task.deliveryAddress}"
            dateTextView.text = "Дата заказа: ${task.orderDetails}" // Используйте нужное поле
            arrivalTimeTextView.text = "Время прибытия: ${task.paymentDetails}" // Используйте нужное поле
            startLocationTextView.text = "Начальная точка маршрута: ${task.senderAddress}"
            endLocationTextView.text = "Конечная точка маршрута: ${task.deliveryAddress}"
            bodyTypeTextView.text = "Тип кузова: ..." // Замените на нужное поле
            orderDetailsTextView.text = "Детали заказа: ${task.orderDetails}"
            paymentDetailsTextView.text = "Параметры по оплате: ${task.paymentDetails}"
            contactsTextView.text = "Контакты: ..." // Замените на нужное поле
        }

        // Обработчик кнопки "Скачать"
        val downloadButton = view.findViewById<Button>(R.id.buttonDownloadRules)
        downloadButton.setOnClickListener {
            // Добавьте код для скачивания правил клиента
        }

        // Обработчик кнопки "Принять"
        val acceptButton = view.findViewById<Button>(R.id.buttonAccept)
        acceptButton.setOnClickListener {
            // Добавьте код для обработки действия "Принять"
        }

        // Обработчик кнопки "Отказаться"
        val declineButton = view.findViewById<Button>(R.id.buttonDecline)
        declineButton.setOnClickListener {
            // Добавьте код для обработки действия "Отказаться"
        }

        // Получаем ссылку на активность
        val activity = requireActivity() as AppCompatActivity

        // Устанавливаем новый заголовок в Toolbar активности
        activity.supportActionBar?.title = "Детали задания"

        return view
    }
}