package com.example.rohanrodrigues.build_a_resume;


import java.util.ArrayList;

/**
 * Created by rohanrodrigues on 2/19/17.
 */

public class ManageResumes {
    private ArrayList<Resume> resumes;

    public ManageResumes() {
        resumes = new ArrayList<>();
    }

    public ArrayList<Resume> getResumesList() {
        return resumes;
    }

    public void addResume(Resume r) {
        resumes.add(r);
    }

    public Resume getResume(String identifier) {
        for (int i = 0; i < resumes.size(); i++) {
            if (resumes.get(i).getIdentifier().equals(identifier)) {
                return resumes.get(i);
            }
        }
        return null;
    }

    public void removeResume(String identifier) {
        removeResume(getResume(identifier));
    }

    public void removeResume(Resume r) {
        for (int i = 0; i < resumes.size(); i++) {
            if (resumes.get(i).equals(r)) {
                resumes.remove(i);
            }
        }
    }
}
