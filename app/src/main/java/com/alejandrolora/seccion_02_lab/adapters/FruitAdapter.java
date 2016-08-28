package com.alejandrolora.seccion_02_lab.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.alejandrolora.seccion_02_lab.R;
import com.alejandrolora.seccion_02_lab.models.Fruit;

import java.util.List;

/**
 * Created by Alejandro on 28/8/16.
 */
public class FruitAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Fruit> list;

    public FruitAdapter(Context context, int layout, List<Fruit> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Fruit getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        ViewHolder holder;

        if (convertView == null) {
            // Sólo si está nulo, es decir, primera vez en ser renderizado, inflamos
            // y adjuntamos las referencias del layout en una nueva instancia de nuestro
            // ViewHolder, y lo insertamos dentro del convertView, para reciclar su uso
            convertView = LayoutInflater.from(context).inflate(layout, null);
            holder = new ViewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.textViewName);
            holder.origin = (TextView) convertView.findViewById(R.id.textViewOrigin);
            holder.icon = (ImageView) convertView.findViewById(R.id.imageViewIcon);
            convertView.setTag(holder);
        } else {
            // Obtenemos la referencia que posteriormente pusimos dentro del convertView
            // Y así, reciclamos su uso sin necesidad de buscar de nuevo, referencias con FindViewById
            holder = (ViewHolder) convertView.getTag();
        }

        final Fruit currentFruit = getItem(position);
        holder.name.setText(currentFruit.getName());
        holder.origin.setText(currentFruit.getOrigin());
        holder.icon.setImageResource(currentFruit.getIcon());

        return convertView;
    }

    static class ViewHolder {
        private TextView name;
        private TextView origin;
        private ImageView icon;
    }
}
