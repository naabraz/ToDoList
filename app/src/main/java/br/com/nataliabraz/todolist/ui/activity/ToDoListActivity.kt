package br.com.nataliabraz.todolist.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.nataliabraz.todolist.databinding.ActivityTodoListBinding

class ToDoListActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityTodoListBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)
    }
}