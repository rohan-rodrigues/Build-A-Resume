package com.example.rohanrodrigues.build_a_resume;

import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by rohanrodrigues on 2/19/17.
 */

public class ViewFragment extends Fragment {
    GridView gridView;
    Resume selectedResume;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.view_fragment, container, false);


        final ArrayList<Resume> resumes = ((MainUserActivity) getActivity()).getManageResumes().getResumesList();
        System.out.println(resumes.size());

        GridView gridView = (GridView) rootview.findViewById(R.id.gridview);

        final ResumeAdapter resumeAdapter = new ResumeAdapter(this.getContext(), resumes);
        gridView.setAdapter(resumeAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                selectedResume = resumes.get(position);
                ((MainUserActivity)getActivity()).setCurrentResumeForViewFragment(selectedResume);
                open(v);

             //   resumeAdapter.notifyDataSetChanged();
            }
        });

        return rootview;
    }

    public void open(View view){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this.getContext());
        alertDialogBuilder.setMessage("Do you want to view or edit this resume");
                alertDialogBuilder.setPositiveButton("View", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {
                                Toast.makeText(getContext(),"You clicked view button",Toast.LENGTH_LONG).show();

                                ViewIndivResumeFrag sp = new ViewIndivResumeFrag();
                                android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
                                fragmentManager.beginTransaction()
                                        .replace(R.id.viewFragment, sp)
                                        .commit();
                            }
                        });

        alertDialogBuilder.setNegativeButton("Edit",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getContext(),"You clicked edit button",Toast.LENGTH_LONG).show();

                EditIndivResumeFrag sp = new EditIndivResumeFrag();
                android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.viewFragment, sp)
                        .commit();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
