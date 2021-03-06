package com.example.recyclerviewmodule.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.recyclerviewmodule.R;

import org.itzheng.and.recyclerview.adapter.BaseRecyclerAdapter;
import org.itzheng.and.recyclerview.adapter.BaseRecyclerLoadHintAdapter;

/**
 * Title:<br>
 * Description: <br>
 *
 * @email ItZheng@ZoHo.com
 * Created by itzheng on 2018-6-27.
 */
public class MyAdapter extends BaseRecyclerLoadHintAdapter<MyAdapter.ViewHolder> {
    public MyAdapter() {
//        setHintEnable(false);
    }

    @Override
    public View onCreateRealView(ViewGroup parent, int viewType) {
        return LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_item_test, parent, false);
    }

    @Override
    public void onBindRealViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public ViewHolder onCreateRealViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(onCreateView(parent, viewType));
    }


    @Override
    public int getItemCount() {
        return 5;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
