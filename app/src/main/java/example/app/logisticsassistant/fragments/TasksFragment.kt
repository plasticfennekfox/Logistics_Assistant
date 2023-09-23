package example.app.logisticsassistant.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import example.app.logisticsassistant.R
import example.app.logisticsassistant.adapter.TaskData
import example.app.logisticsassistant.adapter.TasksAdapter


class TasksFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: TasksAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_tasks, container, false)

        recyclerView = view.findViewById(R.id.recyclerView)

        // создать список заданий и передать его в адаптер
        val taskDataList = createTaskDataList()
        val currentTaskPosition = 1
        // Установить текущее задание
        setCurrentTask(taskDataList, currentTaskPosition)

        adapter = TasksAdapter(taskDataList)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter



        return view
    }

    private fun createTaskDataList(): List<TaskData> {
        // Создайте и заполните список данных о заданиях
        // Каждый элемент списка представляет собой одно задание

        val taskList = mutableListOf<TaskData>()
        taskList.add(TaskData("Мебель 1", "Текущее задание", "Адрес отправки 1", "Адрес доставки 1", "Детали заказа 1", "Параметры по оплате 1",false))
        taskList.add(TaskData("Мебель 2", "Текущее задание", "Адрес отправки 2", "Адрес доставки 2", "Детали заказа 2", "Параметры по оплате 2",true))
        taskList.add(TaskData("Мебель 3", "Текущее задание", "Адрес отправки 3", "Адрес доставки 3", "Детали заказа 1", "Параметры по оплате 1",false))
        taskList.add(TaskData("Мебель 4", "Текущее задание", "Адрес отправки 4", "Адрес доставки 4", "Детали заказа 2", "Параметры по оплате 2",false))
        taskList.add(TaskData("Мебель 5", "Текущее задание", "Адрес отправки 5", "Адрес доставки 5", "Детали заказа 1", "Параметры по оплате 1",false))
        taskList.add(TaskData("Мебель 6", "Текущее задание", "Адрес отправки 6", "Адрес доставки 6", "Детали заказа 2", "Параметры по оплате 2",false))

        //
        // И тд

        return taskList
    }

    private fun setCurrentTask(taskList: List<TaskData>, currentTaskPosition: Int) {
        // Сначала сбрасываем флаг isCurrentTask для всех заданий
        for (task in taskList) {
            task.isCurrentTask = false
        }

        // Устанавливаем флаг isCurrentTask для текущего задания
        if (currentTaskPosition >= 0 && currentTaskPosition < taskList.size) {
            taskList[currentTaskPosition].isCurrentTask = true
        }
    }
}

