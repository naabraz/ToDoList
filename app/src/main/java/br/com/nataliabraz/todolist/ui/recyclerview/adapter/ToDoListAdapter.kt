package br.com.nataliabraz.todolist.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.nataliabraz.todolist.databinding.TodoItemBinding
import br.com.nataliabraz.todolist.model.ToDoItem

class ToDoListAdapter(
    private val context: Context,
    items: List<ToDoItem>): RecyclerView.Adapter<ToDoListAdapter.ViewHolder>() {
    private val items = items.toMutableList()

    class ViewHolder(binding: TodoItemBinding) : RecyclerView.ViewHolder(binding.root) {
        private val title = binding.todoItemTitle

        fun bind(item: ToDoItem) {
            title.text = item.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = TodoItemBinding.inflate(LayoutInflater.from(context), parent, false)

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    fun update(items: List<ToDoItem>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }
}