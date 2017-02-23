package com.example.rohanrodrigues.build_a_resume;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by rohanrodrigues on 2/23/17.
 */

public class ViewIndivResumeFrag extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.view_indiv_resume, container, false);
    }
}
