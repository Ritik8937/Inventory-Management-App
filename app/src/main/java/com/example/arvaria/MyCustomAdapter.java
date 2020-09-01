package com.example.arvaria;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

/**
 * Created by DEEP on 09-11-2019.
 */

public class MyCustomAdapter extends RecyclerView.Adapter<MyCustomAdapter.MyView> {
    Context context;
    List<User> userList;
    RequestOptions options;

    public MyListener listener;

    public interface MyListener {
        void deepItemClick(View view, int position);
    }

    public MyCustomAdapter(Context context, List<User> userList) {
        this.context = context;
        this.userList = userList;
    }

    @NonNull
    @Override
    public MyView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        options = RequestOptions.placeholderOf(R.drawable.inventory1).error(R.drawable.ic_launcher_background).centerCrop();
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);

        return new MyView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyView holder, int position) {
        User user = userList.get(position);
        holder.tv.setText(user.getName());
        //holder.im.setImageResource(images[position]);
        Glide.with(context).load(user.getImage()).apply(options).into(holder.im);

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    class MyView extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tv;
        ImageView im;

        public MyView(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.mytext);
            im = itemView.findViewById(R.id.myimage);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.deepItemClick(view, getAdapterPosition());
        }
    }

    public void setDeepListener(MyListener myListener) {
        listener = myListener;
    }

}

