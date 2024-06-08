package com.example.todolist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    private final List<Task> taskList;
    private final OnTaskClickListener listener;

    public TaskAdapter(List<Task> taskList, OnTaskClickListener listener) {
        this.taskList = taskList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_item, parent, false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        Task task = taskList.get(position);
        holder.taskTitle.setText(task.getTitle());

        holder.editTaskButton.setOnClickListener(v -> listener.onEditTaskClick(task, position));
        holder.deleteTaskButton.setOnClickListener(v -> listener.onDeleteTaskClick(task, position));
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    public static class TaskViewHolder extends RecyclerView.ViewHolder {
        TextView taskTitle;
        ImageButton editTaskButton;
        ImageButton deleteTaskButton;

        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            taskTitle = itemView.findViewById(R.id.taskTitle);
            editTaskButton = itemView.findViewById(R.id.editTaskButton);
            deleteTaskButton = itemView.findViewById(R.id.deleteTaskButton);
        }
    }

    public interface OnTaskClickListener {
        void onEditTaskClick(Task task, int position);
        void onDeleteTaskClick(Task task, int position);
    }
}
