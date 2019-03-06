package com.example.firebaseapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import java.util.List;

public class CourseRecyclerAdapter extends RecyclerView.Adapter<CourseRecyclerAdapter.ViewHolder> {

    private List<Course> course_list;
    private OnItemClickListener listener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public CourseRecyclerAdapter(List<Course> course_list)
    {
        this.course_list = course_list;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private View mView;

        private TextView course_name_view;

        public ViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);

            mView = itemView;

            mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(listener != null)
                    {
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }

                }
            });
        }

        public void setName(String text)
        {
            course_name_view = mView.findViewById(R.id.course_text_view);
            course_name_view.setText(text);
        }

    }

    @NonNull
    @Override
    public CourseRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.courses_list_item, viewGroup, false);

        return new ViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseRecyclerAdapter.ViewHolder viewHolder, int i) {

        String course_name = course_list.get(i).getCourseName();
        viewHolder.setName(course_name);
    }

    @Override
    public int getItemCount() {
        return course_list.size();
    }
}
