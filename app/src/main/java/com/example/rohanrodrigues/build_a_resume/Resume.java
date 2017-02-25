package com.example.rohanrodrigues.build_a_resume;

import android.media.Image;
import android.provider.ContactsContract;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by rohanrodrigues on 2/19/17.
 */

public class Resume {
    private String identifier;
  //  private ArrayList<PositionExperience> experiences;
    private ArrayList<String> experiences;
  //  private ArrayList<VolunteerWork> volunteerWork;
  //  private ArrayList<Education> education;
    private ArrayList<String> education;
  //  private ArrayList<String> skills;
    private ArrayList<String> interests;
  //  private String summary;
  //  private ArrayList<TestScore> testScores;
    private String name;
  //  private int age;
    private int imageResource;
    private ImageView profilePic;

    private String imageUrl;
    private ImageView image;
    private String phoneNum, emailAddress, careerObj, profession;

    public Resume(String identifier, String name, String phoneNum, String emailAddress, String careerObj, String profession, int imageResource, String imageUrl) {
        this.identifier = identifier;
        experiences = new ArrayList<>();
    //    volunteerWork = new ArrayList<>();
        education = new ArrayList<>();
     //   skills = new ArrayList<>();
     //   summary = "";
    //    testScores = new ArrayList<>();
        interests = new ArrayList<>();
    //    age = 0;
        this.name = name;
        this.phoneNum = phoneNum;
        this.emailAddress = emailAddress;
        this.careerObj = careerObj;
        this.profession = profession;
        this.imageResource = imageResource;
        this.imageUrl = imageUrl;
        this.image = null;
        this.profilePic = null;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public ArrayList<String> getExperiences() {
        return experiences;
    }

    public void addExperience(String p) {
        this.experiences.add(p);
    }

    public void removeExperience(PositionExperience p) {
        for (int i = 0; i < experiences.size(); i++) {
            if (experiences.get(i).equals(p)) {
                experiences.remove(i);
            }
        }
    }

    public ImageView getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(ImageView profilePic) {
        this.profilePic = profilePic;
    }

  /*  public ArrayList<VolunteerWork> getVolunteerWork() {
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
    } */

    public ArrayList<String> getEducation() {
        return education;
    }

    public void addEducation(String e) {
        education.add(e);
    }

    public void removeEducation(Education e) {
        for (int i = 0; i < education.size(); i++) {
            if (education.get(i).equals(e)) {
                education.remove(i);
            }
        }
    }

   /* public ArrayList<String> getSkills() {
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
    } */

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

   /* public String getSummary() {
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
    } */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

  /*  public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    } */

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getCareerObj() {
        return careerObj;
    }

    public void setCareerObj(String careerObj) {
        this.careerObj = careerObj;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
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

    public void setImage(ImageView image) {
        this.image = image;
    }

    public ImageView getImage() {
        return this.image;
    }


}
