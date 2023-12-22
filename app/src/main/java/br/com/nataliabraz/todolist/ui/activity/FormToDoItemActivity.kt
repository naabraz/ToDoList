package br.com.nataliabraz.todolist.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.nataliabraz.todolist.dao.ToDoItemDAO
import br.com.nataliabraz.todolist.databinding.ActivityFormTodoItemBinding
import br.com.nataliabraz.todolist.model.ToDoItem

class FormToDoItemActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityFormTodoItemBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setUpSaveButton()
        setContentView(binding.root)
    }

    private fun createItem(): ToDoItem {
        val inputTitle = binding.activityFormTodoItemTitle
        val title = inputTitle.text.toString()

        return ToDoItem(title = title)
    }

    private fun setUpSaveButton() {
        val saveButton = binding.activityFormTodoSave
        val dao = ToDoItemDAO()

        saveButton.setOnClickListener {
            val newItem = createItem()
            dao.add(newItem)
            finish()
        }
    }
}