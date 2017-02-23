package com.example.rohanrodrigues.build_a_resume;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by rohanrodrigues on 2/19/17.
 */

public class ViewFragment extends Fragment {
    GridView gridView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview =  inflater.inflate(R.layout.view_fragment, container, false);


        final ArrayList<Resume> resumes = ((MainUserActivity)getActivity()).getManageResumes().getResumesList();

        GridView gridView = (GridView)rootview.findViewById(R.id.gridview);

        ResumeAdapter booksAdapter = new ResumeAdapter(this.getContext(), resumes);
        gridView.setAdapter(booksAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Resume resume = resumes.get(position);
            }
        });

        return rootview;
}
