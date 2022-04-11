package com.example.book;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.MyViewHolder> {
//    String data1[],data2[],data3[],data4[],data5[],data6[],data7[];
    Context context;
    List<String> data1 = new ArrayList<>();
    List<String> data2 = new ArrayList<>();
    List<String> data3 = new ArrayList<>();
    List<String> data4 = new ArrayList<>();
    List<String> data5 = new ArrayList<>();
    List<String> data6 = new ArrayList<>();
    List<String> data7 = new ArrayList<>();

    public HistoryAdapter(Context ct,List<String> s1,List<String> s2,List<String> s3,List<String> s4,List<String> s5,List<String> s6,List<String> s7){
        context = ct;
        data1.addAll(s1);
        data2.addAll(s2);
        data3.addAll(s3);
        data4.addAll(s4);
        data5.addAll(s5);
        data6.addAll(s6);
        data7.addAll(s7);
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.history_low,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.myText1.setText(data1.get(position));
        holder.myText2.setText(data2.get(position));
        holder.myText3.setText(data3.get(position));
        holder.myText4.setText(data4.get(position));
        holder.myText5.setText(data5.get(position));
        holder.myText6.setText(data6.get(position));
        holder.myText7.setText(data7.get(position));

    }

    @Override
    public int getItemCount() {
        return data1.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView myText1,myText2,myText3,myText4,myText5,myText6,myText7;
        ConstraintLayout mainLayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            myText1 = itemView.findViewById(R.id.hisName);
            myText2 = itemView.findViewById(R.id.hisBook);
            myText3 = itemView.findViewById(R.id.hisEmail);
            myText4 = itemView.findViewById(R.id.hisAddress2);
            myText5 = itemView.findViewById(R.id.hisPhone);
            myText6 = itemView.findViewById(R.id.hisPrice);
            myText7 = itemView.findViewById(R.id.hisDate);
            mainLayout = itemView.findViewById(R.id.mainLayoutHistory);
        }
    }
}