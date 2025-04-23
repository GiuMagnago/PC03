package com.example.todov1app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.todov1app.databinding.ActivityAddTaskBinding;

public class AddTaskActivity extends AppCompatActivity {

    ActivityAddTaskBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddTaskBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String[] prios = {"high", "medium", "low"};

        binding.addNewButton.setOnClickListener(view -> {
            String name = binding.taskNameEditText.getText().toString();
            String desc = binding.taskDescEditText.getText().toString();
            int checkedId = binding.radioGroup.getCheckedRadioButtonId();
            String prio = "low"; // default

            if (checkedId == R.id.highPrioButton) prio = "high";
            else if (checkedId == R.id.mediumPrioButton) prio = "medium";
            else if (checkedId == R.id.lowPrioButton) prio = "low";


            Task task = new Task(name, desc, prio);
            Intent i = new Intent();
            i.putExtra("taskAdded", task);
            setResult(RESULT_OK, i);
            AddTaskActivity.this.finish();
        });
    }
}