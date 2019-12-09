package com.poly.hungnqph07434_duan1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.poly.hungnqph07434_duan1.datasql.SqlOpenHelper;
import com.poly.hungnqph07434_duan1.model.NguoiChoi;

import java.util.List;

public class NguoiChoiAdapter extends RecyclerView.Adapter<NguoiChoiAdapter.RecyclerViewHodler> {

    private Context context;
    private SqlOpenHelper sqlOpenHelper;
    private List<NguoiChoi> nguoiChois;

    public NguoiChoiAdapter(Context context, List<NguoiChoi> nguoiChois) {
        this.context = context;
        this.nguoiChois = nguoiChois;
    }



    @NonNull
    @Override
    public NguoiChoiAdapter.RecyclerViewHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_nguoichoi , parent, false);
        return new RecyclerViewHodler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NguoiChoiAdapter.RecyclerViewHodler holder, int position) {
        holder.tvDiemNguoiChoi.setText(nguoiChois.get(position).getDiem());
        holder.tvTenNguoiChoi.setText(nguoiChois.get(position).getTen());
    }

    @Override
    public int getItemCount() {
        return nguoiChois.size();
    }

    public class RecyclerViewHodler extends RecyclerView.ViewHolder {
        private TextView tvTenNguoiChoi;
        private TextView tvDiemNguoiChoi;




        public RecyclerViewHodler(@NonNull View itemView) {


            super(itemView);

            tvTenNguoiChoi = (TextView) itemView.findViewById(R.id.tvTenNguoiChoi);
            tvDiemNguoiChoi = (TextView) itemView.findViewById(R.id.tvDiemNguoiChoi);
        }
    }
}
