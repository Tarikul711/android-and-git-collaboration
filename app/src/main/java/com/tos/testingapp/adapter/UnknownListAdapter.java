package com.tos.testingapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.tos.testingapp.R;
import com.tos.testingapp.webapi.unknown.Datum;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by tarikul on 30/8/20
 */

public class UnknownListAdapter extends RecyclerView.Adapter<UnknownListAdapter.ViewHolder> {

    private Context context;
    private List<Datum> items;

    public UnknownListAdapter(Context context, List<Datum> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_unknown, parent, false);
        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Datum item = items.get(position);
        holder.tvName.setText(String.format("%s", item.getName()));
        holder.tvEmail.setText(String.format("%s | %d", item.getPantoneValue(), item.getYear()));

        holder.tvName.setTag(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        AppCompatTextView tvName, tvEmail;

        ViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvEmail = itemView.findViewById(R.id.tvEmail);


            /*itemView.setOnClickListener(view -> {
                Intent intent = new Intent(context, DepositDetailsActivity.class);
                intent.putExtra("title", items.get(getAdapterPosition()).getProductName());
                intent.putExtra("item_id", items.get(getAdapterPosition()).getId());
//                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NO_HISTORY);
                context.startActivity(intent);
                ((Activity) context).overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            });*/
        }

    }
}