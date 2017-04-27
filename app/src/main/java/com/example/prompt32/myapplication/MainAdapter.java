package com.example.prompt32.myapplication;

import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prompt32 on 2017-04-26.
 */

public class MainAdapter extends RecyclerView.Adapter<MainViewHolder> {

    private List<Integer> mItemList;

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, parent, false);
        return new MainViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, int position) {
        Log.d("TAG", "onBindViewHolder: " + position);
        holder.textView.setText("" + position + " : " + mItemList.get(position));
    }

    @Override
    public int getItemCount() {
        return mItemList != null ? mItemList.size() : 0;
    }

    public void updateListItems(List<Integer> items) {
        final MainDiffCallback diffCallback = new MainDiffCallback(this.mItemList, items);
        final DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(diffCallback);

        if(mItemList == null) {
            mItemList = new ArrayList<>();
        }
        //this.mItemList.clear();

        int oldPosition = mItemList.size();

        this.mItemList.addAll(items);
        //notifyItemInserted(oldPosition);
        //notifyDataSetChanged();
        diffResult.dispatchUpdatesTo(this);

    }


}
