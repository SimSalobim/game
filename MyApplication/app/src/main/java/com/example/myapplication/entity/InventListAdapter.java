package com.example.myapplication.entity;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.myapplication.InventoryAC;
import com.example.myapplication.R;

public class InventListAdapter extends ArrayAdapter<InventList> {
    public InventListAdapter(Context context, InventList[] dialogs) {
        super(context, R.layout.ress, dialogs);
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup){
        final InventList InventList = getItem(position);
        if(view == null){
            view = LayoutInflater.from(getContext()).inflate(R.layout.ress, null);
        }
        ((TextView)view.findViewById(R.id.textViewName)).setText(InventList.name);
        ((TextView)view.findViewById(R.id.textViewNumb)).setText(InventList.numb);
        return view;
    }
}