package com.offers.couponempire;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * Created by Romit Pc on 22-08-2015.
 */
public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.MyViewHolder> {
    private  LayoutInflater inflater;
   List<Information> data=Collections.emptyList();
    Context context;

    public ViewAdapter(Context context,List<Information>data){
       this.context=context;
        inflater=LayoutInflater.from(context);
        this.data=data;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view=  inflater.inflate(R.layout.custom_row,parent,false);
        MyViewHolder holder=new MyViewHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

       Information current=data.get(position);
        holder.tittes.setText(current.tittle);
        holder.icon.setImageResource(current.iconid);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }




    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tittes;
        ImageView icon;
        public MyViewHolder(View itemView) {
           super(itemView);
            tittes= (TextView) itemView.findViewById(R.id.listtext);
            icon=(ImageView) itemView.findViewById(R.id.list_item);

        }
    }
}
