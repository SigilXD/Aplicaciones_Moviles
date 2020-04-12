package com.example.crudfirebasemusica.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.crudfirebasemusica.R;
import com.example.crudfirebasemusica.models.ContactoModel;

import java.util.ArrayList;

public class ContactoAdapter extends BaseAdapter {

    private final Context context;
    private ContactoModel model;
    private ArrayList<ContactoModel> list;
    private View view;

    public ContactoAdapter(Context context, ArrayList<ContactoModel> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemView = view;
        if(view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            itemView = inflater.inflate(R.layout.item_bandas, viewGroup, false);
        }
        TextView tv_item_bandas = itemView.findViewById(R.id.tv_item_banda);
        model = list.get(i);
        tv_item_bandas.setText(model.get_nombre());

        return itemView;
    }
}
