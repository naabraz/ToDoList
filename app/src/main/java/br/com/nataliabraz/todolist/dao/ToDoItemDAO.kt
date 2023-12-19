package br.com.nataliabraz.todolist.dao

import br.com.nataliabraz.todolist.model.ToDoItem

class ToDoItemDAO {
    fun add(item: ToDoItem) {
        todoList.add(item)
    }

    fun getAllItems() : List<ToDoItem> {
        return todoList.toList()
    }

    companion object {
        private val todoList = mutableListOf<ToDoItem>()
    }
}