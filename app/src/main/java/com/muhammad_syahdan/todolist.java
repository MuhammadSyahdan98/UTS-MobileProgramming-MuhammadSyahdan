package com.muhammad_syahdan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;


public class todolist extends AppCompatActivity {
    private ArrayList<Task> tasks;
    private TaskAdapter taskAdapter;
    private EditText editTextTask;
    private ListView listViewTasks;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todolist);

        editTextTask = findViewById(R.id.editTextTask);
        Button buttonAdd = findViewById(R.id.buttonAdd);
        listViewTasks = findViewById(R.id.listViewTasks);

        tasks = new ArrayList<>();
        taskAdapter = new TaskAdapter(this, tasks);
        listViewTasks.setAdapter(taskAdapter);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String taskName = editTextTask.getText().toString().trim();
                if (!taskName.isEmpty()) {
                    Task task = new Task(taskName);
                    tasks.add(task);
                    taskAdapter.notifyDataSetChanged();
                    editTextTask.setText("");
                }
            }
        });
    }
}