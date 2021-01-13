package com.example.Masjid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class DaftarMasjidAdapter extends ArrayAdapter<Masjid> {
    Context context;

    public DaftarMasjidAdapter(@NonNull Context context, @NonNull List<Masjid> objects) {
        super(context, R.layout.row_favorite, objects);
        this.context = context;
    }

    class ViewHolder {
        TextView txTgl;
        TextView txNama;
        TextView txDesa;
        TextView txKecamatan;
        TextView txKabupaten;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Masjid tr = getItem(position);
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.row_favorite,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.txTgl = convertView.findViewById(R.id.row_tx_tgl_favorite);
            viewHolder.txNama = convertView.findViewById(R.id.row_tx_nama_masjid);

            viewHolder.txKabupaten = convertView.findViewById(R.id.row_tx_kabupaten);
            viewHolder.txDesa = convertView.findViewById(R.id.row_tx_desa_masjid);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.txTgl.setText(GenericUtility.DATE_FORMAT.format(tr.getTanggal()));
        viewHolder.txNama.setText(tr.getNama());

        viewHolder.txKabupaten.setText(tr.getKabupaten());
        viewHolder.txDesa.setText(tr.getDesa());
        return convertView;
    }
}
