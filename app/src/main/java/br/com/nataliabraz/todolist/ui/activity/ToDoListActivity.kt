package br.com.nataliabraz.todolist.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.nataliabraz.todolist.dao.ToDoItemDAO
import br.com.nataliabraz.todolist.databinding.ActivityTodoListBinding
import br.com.nataliabraz.todolist.ui.recyclerview.adapter.ToDoListAdapter

class ToDoListActivity : AppCompatActivity() {
    private val dao = ToDoItemDAO()

    private val binding by lazy {
        ActivityTodoListBinding.inflate(layoutInflater)
    }

    private val adapter by lazy {
        ToDoListAdapter(context = this, items = dao.getAllItems())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setUpRecyclerView()
        setUpFab()

        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()

        adapter.update(dao.getAllItems())
    }

    private fun setUpFab() {
        val fab = binding.activityTodoListFab
        fab.setOnClickListener {
            goToForm()
        }
    }

    private fun goToForm() {
        val intent = Intent(this, FormToDoItemActivity::class.java)
        startActivity(intent)
    }

    private fun setUpRecyclerView() {
        val recyclerView = binding.activityTodoListRecyclerView
        recyclerView.adapter = adapter
    }
}