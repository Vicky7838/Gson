package com.gson.languages.gson;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;



import java.util.List;

/**
 * Created by vicky on 10/24/2016.
 */

public class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {
    private Context context;
    private LayoutInflater inflater;
    List<Language> data;
    private final String LOG_TAG = "infovision_log";

    Language current;
    int currentPos=0;
    private static ClickListener clickListener;

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        TextView name;

        public MyViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);

        }

        @Override
        public void onClick(View v) {
            clickListener.onItemClick(getAdapterPosition(), v);
        }

        @Override
        public boolean onLongClick(View v) {
            clickListener.onItemLongClick(getAdapterPosition(), v);
            return false;
        }
    }

    public void setOnItemClickListener(ClickListener clickListener) {
        Adapter.clickListener = clickListener;
    }

    public interface ClickListener {
        void onItemClick(int position, View v);
        void onItemLongClick(int position, View v);
    }
    // create constructor to innitilize context and data sent from MainActivity
    public Adapter(Context context, List<Language> data){
        Log.d(LOG_TAG, "Adapter - constructor : ");
        this.context=context;
        inflater= LayoutInflater.from(context);
        this.data=data;
    }

    // Inflate the layout when viewholder created
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.details, parent,false);
        MyHolder holder=new MyHolder(view);
        Log.d(LOG_TAG, "Adapter - onCreateViewHolder : ");
        return holder;
    }

    // Bind data
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder,  int position) {

        Log.d(LOG_TAG, "Adapter - onBindViewHolder : ");

        // Get current position of item in recyclerview to bind data and assign values from list
        MyHolder myHolder= (MyHolder) holder;
        current=data.get(position);
        myHolder.name.setText(current.getName());
        Log.d(LOG_TAG, "Adapter - name : " + current.getName());

        myHolder.id.setText(current.getId());
        myHolder.status.setText(current.getStatus());
      /*
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ShowData.class);
                //Create Parcelable object
                ParcelableDetails parcelableLaptop = new ParcelableDetails(data.get(position));

                //Store Parcelable object in Intent
                intent.putExtra("details", parcelableLaptop);

                //Start next activity
                view.getContext().startActivity(intent);            }
        });*/
    }

    // return total item from List
    @Override
    public int getItemCount() {
        Log.d(CONSTANTS.TAG, "size : " + data.size());
        return data.size();
    }


    public static class MyHolder extends RecyclerView.ViewHolder {

        TextView id;
        TextView name;
        TextView status;


        // create constructor to get widget reference
        public MyHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            id = (TextView) itemView.findViewById(R.id.id);
            status = (TextView) itemView.findViewById(R.id.status);

        }
    }

}
