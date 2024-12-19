package com.example.fragmentstasks;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateTaskFragment extends Fragment {

    public CreateTaskFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_create_task, container, false);

        EditText taskName = view.findViewById(R.id.taskName);
        Button btnAddTask = view.findViewById(R.id.btnAddTask);

        btnAddTask.setOnClickListener(v -> {
            String task = taskName.getText().toString();
            if (!task.isEmpty()) {
                Toast.makeText(requireContext(), "Tarea agregada: " + task, Toast.LENGTH_SHORT).show();
                taskName.setText("");
            }
        });

        return view;
    }
}