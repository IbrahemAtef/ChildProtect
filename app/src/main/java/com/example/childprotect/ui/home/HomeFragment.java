package com.example.childprotect.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.childprotect.Child;
import com.example.childprotect.ChildAdapter;
import com.example.childprotect.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_children, container, false);

        ArrayList<Child> children = homeViewModel.getArray();
        RecyclerView view = root.findViewById(R.id.rv_recycler);
        ChildAdapter adapter = new ChildAdapter(children);
        GridLayoutManager manager = new GridLayoutManager(getContext(),1);
        view.setAdapter(adapter);
        view.setLayoutManager(manager);
        view.setHasFixedSize(true);
        return root;
    }
}