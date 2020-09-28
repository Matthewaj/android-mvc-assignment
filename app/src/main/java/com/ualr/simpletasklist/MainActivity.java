package com.ualr.simpletasklist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.ualr.simpletasklist.databinding.ActivityMainBinding;
import com.ualr.simpletasklist.model.TaskList;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private TaskList taskList;
    private TextView taskListTV;
    private EditText descriptionInputET;
    private TextView taskIdTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        taskList = new TaskList();
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        descriptionInputET = findViewById(R.id.editTextTextPersonName);
        taskListTV = findViewById(R.id.taskList);
        taskIdTV = findViewById(R.id.editTextTaskId);

        binding.addBtn.setOnClickListener(this::onAddBtnClicked);
        binding.deleteBtn.setOnClickListener(this::onDeleteBtnClicked);
        binding.clearBtn.setOnClickListener(this::onDoneBtnClicked);

    }

    public void onAddBtnClicked(View view) {
        taskList.add(descriptionInputET.getText().toString());
        taskListTV.setText(taskList.toString());
    }

    public void onDeleteBtnClicked(View view) {
        taskList.delete(Integer.parseInt(taskIdTV.getText().toString()));
        taskListTV.setText(taskList.toString());
    }

    public void onDoneBtnClicked(View view) {
        taskList.markDone(Integer.parseInt(taskIdTV.getText().toString()));
        taskListTV.setText(taskList.toString());
    }

}