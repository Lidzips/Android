package com.example.zachet;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SideJobAdapter extends RecyclerView.Adapter<SideJobAdapter.ViewHolder>{

    interface OnJobClickListener{
        void onJobClick(SideJob job, int position);
    }

    private final OnJobClickListener onClickListener;
    private final LayoutInflater inflater;
    private final List<SideJob> jobs;

    SideJobAdapter(Context context, List<SideJob> jobs, OnJobClickListener onClickListener) {
        this.jobs = jobs;
        this.inflater = LayoutInflater.from(context);
        this.onClickListener = onClickListener;
    }

    @Override
    public SideJobAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SideJobAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        SideJob job = jobs.get(position);
        holder.paymentView.setText(job.getJobPayment().toString() + " руб");
        holder.descriptionView.setText(job.getDescription());

        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                onClickListener.onJobClick(job, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return jobs.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView paymentView, descriptionView;
        ViewHolder(View view){
            super(view);
            paymentView = view.findViewById(R.id.job_payment);
            descriptionView = view.findViewById(R.id.description);
        }
    }
}
