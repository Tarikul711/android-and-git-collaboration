package com.tos.testingapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.tos.testingapp.R;
import com.tos.testingapp.webapi.user.Datum;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by tarikul on 30/8/20
 */

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.ViewHolder> {

    private Context context;
    private List<Datum> items;

    public UserListAdapter(Context context, List<Datum> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Datum item = items.get(position);
        holder.tvName.setText(String.format("%s %s", item.getFirstName(), item.getLastName()));
        holder.tvEmail.setText(item.getEmail());
        Glide.with(context)
                .load(item.getAvatar())
                .into(holder.ivProfileImage);
        holder.tvName.setTag(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        AppCompatImageView ivProfileImage;
        AppCompatTextView tvName, tvEmail;

        ViewHolder(View itemView) {
            super(itemView);
            ivProfileImage = itemView.findViewById(R.id.ivProfileImage);
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