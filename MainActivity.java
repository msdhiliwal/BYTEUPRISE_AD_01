package com.example.todolist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements TaskAdapter.OnTaskClickListener {

    private RecyclerView recyclerView;
    private TaskAdapter adapter;
    private List<Task> taskList;
    private Button addTaskButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        addTaskButton = findViewById(R.id.addTaskButton);

        taskList = new ArrayList<>();
        adapter = new TaskAdapter(taskList, this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        addTaskButton.setOnClickListener(v -> showAddEditTaskDialog(null, -1));
    }

    private void showAddEditTaskDialog(Task task, int position) {
        boolean isEdit = task != null;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_add_edit_task, null);
        builder.setView(dialogView);

        EditText taskTitleEditText = dialogView.findViewById(R.id.taskTitleEditText);
        Button saveTaskButton = dialogView.findViewById(R.id.saveTaskButton);

        if (isEdit) {
            taskTitleEditText.setText(task.getTitle());
        }

        AlertDialog dialog = builder.create();
        saveTaskButton.setOnClickListener(v -> {
            String taskTitle = taskTitleEditText.getText().toString().trim();
            if (!taskTitle.isEmpty()) {
                if (isEdit) {
                    task.setTitle(taskTitle);
                    taskList.set(position, task);
                } else {
                    taskList.add(new Task(taskTitle));
                }
                adapter.notifyDataSetChanged();
                dialog.dismiss();

                Toast.makeText(MainActivity.this,taskTitle,Toast.LENGTH_LONG).show();
            }
        });

        dialog.show();
    }

    @Override
    public void onEditTaskClick(Task task, int position) {
        showAddEditTaskDialog(task, position);
    }

    @Override
    public void onDeleteTaskClick(Task task, int position) {
        taskList.remove(position);
        adapter.notifyItemRemoved(position);
    }
}
