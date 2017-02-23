package com.example.rohanrodrigues.build_a_resume;

import android.provider.ContactsContract;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by rohanrodrigues on 2/19/17.
 */

public class Resume {
    private String identifier;
    private ArrayList<PositionExperience> experiences;
    private ArrayList<VolunteerWork> volunteerWork;
    private ArrayList<Education> education;
    private ArrayList<String> skills;
    private ArrayList<String> interests;
    private String summary;
    private ArrayList<TestScore> testScores;
    private String name;
    private int age;
    private ContactsContract.Contacts.Photo photo;
    private int imageResource;
    private final String imageUrl;

    public Resume(String identifier, int imageResource, String imageUrl) {
        this.identifier = identifier;
        experiences = new ArrayList<>();
        volunteerWork = new ArrayList<>();
        education = new ArrayList<>();
        skills = new ArrayList<>();
        summary = "";
        testScores = new ArrayList<>();
        interests = new ArrayList<>();
        age = 0;
        name = "";
        photo = null;
        this.imageResource = imageResource;
        this.imageUrl = imageUrl;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public ContactsContract.Contacts.Photo getPhoto() {
        return photo;
    }

    public void setPhoto(ContactsContract.Contacts.Photo photo) {
        this.photo = photo;
    }

    public ArrayList<PositionExperience> getExperiences() {
        return experiences;
    }

    public void addExperience(PositionExperience p) {
        this.experiences.add(p);
    }

    public void removeExperience(PositionExperience p) {
        for (int i = 0; i < experiences.size(); i++) {
            if (experiences.get(i).equals(p)) {
                experiences.remove(i);
            }
        }
    }

    public ArrayList<VolunteerWork> getVolunteerWork() {
        return volunteerWork;
    }

    public void addVolunteerWork(VolunteerWork v) {
        volunteerWork.add(v);
    }

    public void removeVolunteerWork(VolunteerWork v) {
        for (int i = 0; i < volunteerWork.size(); i++) {
            if (volunteerWork.get(i).equals(v)) {
                volunteerWork.remove(i);
            }
        }
    }

    public ArrayList<Education> getEducation() {
        return education;
    }

    public void addEducation(Education e) {
        education.add(e);
    }

    public void removeEducation(Education e) {
        for (int i = 0; i < education.size(); i++) {
            if (education.get(i).equals(e)) {
                education.remove(i);
            }
        }
    }

    public ArrayList<String> getSkills() {
        return skills;
    }

    public void addSkills(String skill) {
        skills.add(skill);
    }

    public void removeSkill(String s) {
        for (int i = 0; i < skills.size(); i++) {
            if (skills.get(i).equals(s)) {
                skills.remove(i);
            }
        }
    }

    public ArrayList<String> getInterests() {
        return interests;
    }

    public void removeInterest(String s) {
        for (int i = 0; i < interests.size(); i++) {
            if (interests.get(i).equals(s)) {
                interests.remove(i);
            }
        }
    }

    public void addInterest(String i) {
        interests.add(i);
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public ArrayList<TestScore> getTestScores() {
        return testScores;
    }

    public void addTestScore(TestScore t) {
        testScores.add(t);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getImageUrl() {
        return imageUrl;
    }

}
