package com.example.childprotect;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;


public class ChildAdapter extends RecyclerView.Adapter<ChildViewHolder> {

    ArrayList<Child> childArrayList;

    public ChildAdapter(ArrayList<Child> childArrayList) {
        this.childArrayList = childArrayList;
    }

    @NonNull
    @Override
    public ChildViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_child, parent, false);
        ChildViewHolder userViewHolder = new ChildViewHolder(v);
        return userViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ChildViewHolder holder, int position) {
        Child c = childArrayList.get(position);
        holder.bind(c);
    }

    @Override
    public int getItemCount() {
        return childArrayList.size();
    }
}

class ChildViewHolder extends RecyclerView.ViewHolder {

    TextView name;
    TextView id;


    public ChildViewHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.custom_tv_child_name);
        id = itemView.findViewById(R.id.custom_tv_id);
    }

    public void bind(Child child) {
        name.setText("Name: " + child.getName());
        id.setText("Id: " + child.getId());
    }

}