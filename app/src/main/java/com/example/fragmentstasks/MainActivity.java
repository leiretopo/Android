package com.example.fragmentstasks;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Tarea> pendingTasks = new ArrayList<>();
    private ArrayList<Tarea> completedTasks = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pendingTasks.add(new Tarea("Tarea 1", "Descripción de la tarea 1"));
        pendingTasks.add(new Tarea("Tarea 2", "Descripción de la tarea 2"));

        loadFragment(new NavigationFragment(), R.id.navigationContainer);

        loadPendingTasksFragment();
    }

    public void loadFragment(Fragment fragment, int containerId) {
        getSupportFragmentManager().beginTransaction()
                .replace(containerId, fragment)
                .commit();
    }

    public void loadPendingTasksFragment() {
        Bundle bundle = new Bundle();
        bundle.putSerializable("pendingTasks", pendingTasks);
        bundle.putSerializable("completedTasks", completedTasks);

        PendingTasksFragment pendingFragment = new PendingTasksFragment();
        pendingFragment.setArguments(bundle);
        loadFragment(pendingFragment, R.id.fragmentContainer);
    }

    public void loadCompletedTasksFragment() {
        Bundle bundle = new Bundle();
        bundle.putSerializable("completedTasks", completedTasks);

        CompletedTasksFragment completedFragment = new CompletedTasksFragment();
        completedFragment.setArguments(bundle);
        loadFragment(completedFragment, R.id.fragmentContainer);
    }

    public ArrayList<Tarea> getPendingTasks() {
        return pendingTasks;
    }

    public ArrayList<Tarea> getCompletedTasks() {
        return completedTasks;
    }
}
