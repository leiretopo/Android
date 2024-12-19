package com.example.fragmentstasks;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class PendingTasksFragment extends Fragment {

    private ArrayAdapter<Tarea> adapter;
    private ArrayList<Tarea> pendingTasks;
    private ArrayList<Tarea> completedTasks;

    public PendingTasksFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pending_tasks, container, false);

        if (getArguments() != null) {
            pendingTasks = (ArrayList<Tarea>) getArguments().getSerializable("pendingTasks");
            completedTasks = (ArrayList<Tarea>) getArguments().getSerializable("completedTasks");
        }

        ListView listView = view.findViewById(R.id.listPendingTasks);
        adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1, pendingTasks);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener((parent, view1, position, id) -> {
            Tarea completedTask = pendingTasks.get(position);

            pendingTasks.remove(position);
            completedTasks.add(completedTask);

            ((MainActivity) requireActivity()).loadPendingTasksFragment();
            ((MainActivity) requireActivity()).loadCompletedTasksFragment();
        });

        return view;
    }
}
