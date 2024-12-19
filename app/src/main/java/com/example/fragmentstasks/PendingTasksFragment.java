package com.example.fragmentstasks;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class PendingTasksFragment extends Fragment {

    private ArrayList<String> pendingTasks = new ArrayList<>(Arrays.asList("Tarea 1", "Tarea 2"));
    private ArrayAdapter<String> adapter;

    public PendingTasksFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pending_tasks, container, false);

        ListView listView = view.findViewById(R.id.listPendingTasks);
        adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1, pendingTasks);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view1, position, id) -> {
            String task = pendingTasks.remove(position);
            adapter.notifyDataSetChanged();

            CompletedTasksFragment completedFragment = new CompletedTasksFragment();
            ((MainActivity) requireActivity()).loadFragment(completedFragment, R.id.fragmentContainer);
        });

        return view;
    }
}