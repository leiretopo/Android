package com.example.fragmentstasks;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class NavigationFragment extends Fragment {

    public NavigationFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_navigation, container, false);

        view.findViewById(R.id.btnPendingTasks).setOnClickListener(v ->
                ((MainActivity) getActivity()).loadFragment(new PendingTasksFragment(), R.id.fragmentContainer));

        view.findViewById(R.id.btnCompletedTasks).setOnClickListener(v ->
                ((MainActivity) getActivity()).loadFragment(new CompletedTasksFragment(), R.id.fragmentContainer));

        view.findViewById(R.id.btnCreateTask).setOnClickListener(v ->
                ((MainActivity) getActivity()).loadFragment(new CreateTaskFragment(), R.id.fragmentContainer));

        return view;
    }
}