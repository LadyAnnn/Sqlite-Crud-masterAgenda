package com.example.kikerojas.sqlite_crud.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.kikerojas.sqlite_crud.R;
import com.example.kikerojas.sqlite_crud.entidades.Personas;

import java.util.List;

/**
 * Created by kikerojas on 19/04/2016.
 */
public class AdapterPerssonas extends ArrayAdapter<Personas> {
    Context CONTX;
    List<Personas> personases;

    public AdapterPerssonas(Context context, int resource, List<Personas> objects) {
        super(context, resource, objects);
        CONTX=context;
        personases = objects;
    }
    @Override
    public View getView (int position, View convertView, ViewGroup parent)
    {
        View row = convertView;

        if (row == null)
        {

            LayoutInflater vi = (LayoutInflater)CONTX.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = vi.inflate(R.layout.layout_lis_persona, null);
        }

        TextView tvNombre = (TextView) row.findViewById (R.id.textNombreIn);
        TextView tvNumero = (TextView) row.findViewById (R.id.textNumeroIn);
        tvNombre.setText(personases.get(position).get_nombre());
        tvNumero.setText(personases.get(position).get_numero()+"");

        return row;
    }
}
