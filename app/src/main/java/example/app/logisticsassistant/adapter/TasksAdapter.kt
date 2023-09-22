package example.app.logisticsassistant.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import example.app.logisticsassistant.R
import example.app.logisticsassistant.fragments.TaskDetailsFragment

class TasksAdapter(private val taskDataList: List<TaskData>) : RecyclerView.Adapter<TasksAdapter.TaskViewHolder>() {

    inner class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val furnitureTextView: TextView = itemView.findViewById(R.id.textViewFurniture)
        val currentTaskTextView: TextView = itemView.findViewById(R.id.textViewCurrentTask)
        val senderAddressTextView: TextView = itemView.findViewById(R.id.textViewSenderAddress)
        val deliveryAddressTextView: TextView = itemView.findViewById(R.id.textViewDeliveryAddress)
        val orderDetailsTextView: TextView = itemView.findViewById(R.id.textViewOrderDetails)
        val paymentDetailsTextView: TextView = itemView.findViewById(R.id.textViewPaymentDetails)
        val detailsButton: Button = itemView.findViewById(R.id.buttonViewDetails) // Добавляем кнопку
        val workDoneTextView: TextView  = itemView.findViewById(R.id.textViewWorkDone)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_task, parent, false)
        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = taskDataList[position]

        holder.furnitureTextView.text = task.furniture
        holder.senderAddressTextView.text = task.senderAddress
        holder.deliveryAddressTextView.text = task.deliveryAddress
        holder.orderDetailsTextView.text = task.orderDetails
        holder.paymentDetailsTextView.text = task.paymentDetails

        // Проверяем флаг isCurrentTask и устанавливаем видимость "Текущего задания"
        if (task.isCurrentTask) {
            holder.currentTaskTextView.visibility = View.VISIBLE
        } else {
            holder.currentTaskTextView.visibility = View.GONE
        }

        // Устанавливаем текст кнопки в зависимости от состояния задания
        if (task.isTaskCompleted) {
            //holder.detailsButton.text = "Работа выполнена"
            holder.workDoneTextView.visibility = View.VISIBLE // Показываем "Работа выполнена"
        } else {
            //holder.detailsButton.text = "Посмотреть детали"
            holder.workDoneTextView.visibility = View.GONE // Скрываем "Работа выполнена"
        }

        // Добавляем обработчик нажатия на кнопку
        holder.detailsButton.setOnClickListener {
            // Инвертируем значение isTaskCompleted и обновляем элемент списка
            task.isTaskCompleted = !task.isTaskCompleted
            notifyItemChanged(position)

            // Открываем фрагмент с деталями задания
            val fragment = TaskDetailsFragment.newInstance(task)
            val fragmentManager = (holder.itemView.context as AppCompatActivity).supportFragmentManager
            fragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .addToBackStack(null)
                .commit()
        }
    }

    override fun getItemCount(): Int {
        return taskDataList.size
    }
}