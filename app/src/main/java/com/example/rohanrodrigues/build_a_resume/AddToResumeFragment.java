package com.example.rohanrodrigues.build_a_resume;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

/**
 * Created by rohanrodrigues on 2/19/17.
 */

public class AddToResumeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.add_to_resume_fragment, container, false);

        return rootview;
    }
}
