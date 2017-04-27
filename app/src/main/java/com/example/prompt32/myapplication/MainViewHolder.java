package com.example.prompt32.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by prompt32 on 2017-04-26.
 */

public class MainViewHolder extends RecyclerView.ViewHolder {
    public TextView textView;

    public MainViewHolder(View itemView) {
        super(itemView);
        textView = (TextView) itemView.findViewById(R.id.tvRow);
    }
}
