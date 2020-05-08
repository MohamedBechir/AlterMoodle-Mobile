package com.example.cs425;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private static final String TAG = "RecyclerViewAdapter";
    private ArrayList<String> coursesIds;
    private ArrayList<String> coursesNames;
    private Context context;
    private OnCourseListener mOnCourseListener;

    public RecyclerViewAdapter(ArrayList<String> coursesNames, ArrayList<String> coursesIds, Context context
            , OnCourseListener mOnCourseListener) {
        this.coursesIds = coursesIds;
        this.coursesNames = coursesNames;
        this.context = context;
        this.mOnCourseListener = mOnCourseListener;
     }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_items,parent,false);
        ViewHolder viewHolder = new ViewHolder(view, mOnCourseListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       holder.courseid.setText(coursesIds.get(position));
       holder.coursename.setText(coursesIds.get(position));
    }

    @Override
    public int getItemCount() {

        return coursesIds.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView courseid;
        TextView coursename;
        OnCourseListener onCourseListener;


        public ViewHolder(@NonNull View itemView, OnCourseListener onCourseListener) {
            super(itemView);
             courseid = (TextView) itemView.findViewById(R.id.helloworld);
             coursename = (TextView) itemView.findViewById(R.id.course_name);
             Button button = itemView.findViewById(R.id.button);
             this.onCourseListener = onCourseListener;

             itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onCourseListener.onCourseClick(getAdapterPosition());
        }
    }
    public interface OnCourseListener{
        void onCourseClick(int position);
    }
}
