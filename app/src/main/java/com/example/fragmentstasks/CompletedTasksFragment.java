package com.example.fragmentstasks;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class CompletedTasksFragment extends Fragment {

    private ArrayAdapter<Tarea> adapter;
    private ArrayList<Tarea> completedTasks;

    public CompletedTasksFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_completed_tasks, container, false);

        if (getArguments() != null) {
            completedTasks = (ArrayList<Tarea>) getArguments().getSerializable("completedTasks");
        }

        ListView listView = view.findViewById(R.id.listCompletedTasks);
        adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1, completedTasks);
        listView.setAdapter(adapter);

        return view;
    }
}
