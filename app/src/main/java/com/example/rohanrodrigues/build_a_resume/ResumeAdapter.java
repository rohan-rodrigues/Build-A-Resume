package com.example.rohanrodrigues.build_a_resume;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ResumeAdapter extends BaseAdapter {

    private final Context mContext;
  //  private final Book[] books;
    private final ArrayList<Resume> resumes;

    // 1
    public ResumeAdapter(Context context, ArrayList<Resume> resumes) {
        this.mContext = context;
        this.resumes = resumes;
    }

    // 2
    @Override
    public int getCount() {
        return resumes.size();
    }

    // 3
    @Override
    public long getItemId(int position) {
        return 0;
    }

    // 4
    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // 1
        final Resume resume = resumes.get(position);

        // 2
        if (convertView == null) {
            final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(R.layout.layout_resume, null);
        }

        // 3
        final ImageView imageView = (ImageView) convertView.findViewById(R.id.imageview_cover_art);
        final TextView nameTextView = (TextView) convertView.findViewById(R.id.textview_book_name);
        final TextView authorTextView = (TextView) convertView.findViewById(R.id.textview_book_author);
        final ImageView imageViewFavorite = (ImageView) convertView.findViewById(R.id.imageview_favorite);

        // 4
   //     imageView.setImageResource(resume.getImageResource());
        nameTextView.setText(resume.getIdentifier());
         authorTextView.setText(resume.getName());

       /* imageViewFavorite.setImageResource(
                resume.getIsFavorite() ? R.drawable.star_enabled : R.drawable.star_disabled); */

        return convertView;
    }



}

