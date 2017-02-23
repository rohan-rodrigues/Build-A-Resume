package com.example.rohanrodrigues.build_a_resume;

import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.service.media.MediaBrowserService;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.common.api.Result;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;

import static android.app.Activity.RESULT_OK;


/**
 * Created by rohanrodrigues on 2/19/17.
 */

public class EditIndivResumeFrag extends Fragment {
    private Resume currentResume;
    private Button changeImage, saveResume;
    private EditText title, name, phoneNum, emailAddress, careerObj, profession, education, prevExperience, activities;
    private ArrayList<String> Experiences, Educations, Activities;
    private ImageView profilePic;
    private Uri imageCaptureUri;
    private static final int PICK_FROM_CAMERA = 1;
    private static final int PICK_FROM_FILE = 2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.edit_indiv_resume, container, false);

        currentResume = ((MainUserActivity)getActivity()).getCurrentResumeForViewFragment();
        Experiences = new ArrayList<>();
        Educations = new ArrayList<>();
        Activities = new ArrayList<>();

        final String[] items = new String[] {"From Cam", "From SD Card"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getContext(), android.R.layout.select_dialog_item, items);
        AlertDialog.Builder builder = new AlertDialog.Builder(this.getContext());
        builder.setTitle("Select Image");
        builder.setAdapter(adapter, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i == 0) {
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    File file = new File(Environment.getExternalStorageDirectory(), "tmp avatar" + String.valueOf(System.currentTimeMillis() + ".jpg"));
                    imageCaptureUri = Uri.fromFile(file);
                    try {
                        intent.putExtra(MediaStore.EXTRA_OUTPUT, imageCaptureUri);
                        intent.putExtra("return data", true);
                        startActivityForResult(intent, PICK_FROM_CAMERA);
                    } catch(Exception ex) {
                        ex.printStackTrace();
                    }
                    dialogInterface.cancel();
                }
                else {
                    Intent intent = new Intent();
                    intent.setType("image/*");
                    intent.setAction(Intent.ACTION_GET_CONTENT);
                    startActivityForResult(Intent.createChooser(intent, "Complete action using"), PICK_FROM_FILE);
                }
            }
        });
        final AlertDialog dialog = builder.create();


        profilePic = (ImageView)rootview.findViewById(R.id.profilePicUpdate);

        changeImage = (Button) rootview.findViewById(R.id.imageChangerUpdate);
        changeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
            }
        });

        title = (EditText) rootview.findViewById(R.id.resume_titleUpdate);
        title.setText(currentResume.getIdentifier());
        name = (EditText) rootview.findViewById(R.id.NameUpdate);
        name.setText(currentResume.getName());
        phoneNum = (EditText) rootview.findViewById(R.id.PhoneUpdate);
        phoneNum.setText(currentResume.getPhoneNum());
        emailAddress = (EditText) rootview.findViewById(R.id.EmailUpdate);
        emailAddress.setText(currentResume.getEmailAddress());
        careerObj = (EditText) rootview.findViewById(R.id.ObjectiveUpdate);
        careerObj.setText(currentResume.getCareerObj());
        profession = (EditText) rootview.findViewById(R.id.ProfessionUpdate);
        profession.setText(currentResume.getProfession());
        education = (EditText) rootview.findViewById(R.id.EducationUpdate);
        prevExperience = (EditText) rootview.findViewById(R.id.ExperienceUpdate);
        activities = (EditText) rootview.findViewById(R.id.ActivitiesUpdate);

        education.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int DRAWABLE_LEFT = 0;
                final int DRAWABLE_TOP = 1;
                final int DRAWABLE_RIGHT = 2;
                final int DRAWABLE_BOTTOM = 3;

                if(event.getAction() == MotionEvent.ACTION_UP) {
                    if(event.getRawX() >= (education.getRight() - education.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                        Educations.add(education.getText().toString());
                        education.setText("");
                        return true;
                    }
                }
                return false;
            }
        });

        prevExperience.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int DRAWABLE_LEFT = 0;
                final int DRAWABLE_TOP = 1;
                final int DRAWABLE_RIGHT = 2;
                final int DRAWABLE_BOTTOM = 3;

                if(event.getAction() == MotionEvent.ACTION_UP) {
                    if(event.getRawX() >= (prevExperience.getRight() - prevExperience.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                        Experiences.add(prevExperience.getText().toString());
                        prevExperience.setText("");
                        return true;
                    }
                }
                return false;
            }
        });

        activities.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int DRAWABLE_LEFT = 0;
                final int DRAWABLE_TOP = 1;
                final int DRAWABLE_RIGHT = 2;
                final int DRAWABLE_BOTTOM = 3;

                if(event.getAction() == MotionEvent.ACTION_UP) {
                    if(event.getRawX() >= (activities.getRight() - activities.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                        Activities.add(activities.getText().toString());
                        activities.setText("");
                        return true;
                    }
                }
                return false;
            }
        });

        saveResume = (Button)rootview.findViewById(R.id.save_resume);
        saveResume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Check to make sure that the edit texts are filled
                if (fieldsFilledIn()) {
                    // Save the resume and add it to manageResumes
                    String identifier = title.getText().toString();
                    String personName = name.getText().toString();
                    String personPhoneNum = phoneNum.getText().toString();
                    String personEmailAddress = emailAddress.getText().toString();
                    String personCareer = careerObj.getText().toString();
                    String personProfession = profession.getText().toString();

                    if (!education.getText().toString().equals("")) {
                        Educations.add(education.getText().toString());
                    }
                    if (!prevExperience.getText().toString().equals("")) {
                        Experiences.add(prevExperience.getText().toString());
                    }
                    if (!activities.getText().toString().equals("")) {
                        Activities.add(activities.getText().toString());
                    }

                    currentResume.setIdentifier(identifier);
                    currentResume.setName(personName);
                    currentResume.setPhoneNum(personPhoneNum);
                    currentResume.setEmailAddress(personEmailAddress);
                    currentResume.setCareerObj(personCareer);
                    currentResume.setProfession(personProfession);
                    currentResume.setProfilePic(profilePic);

                    for (String s : Educations) {
                        currentResume.addEducation(s);
                    }
                    for (String s : Activities) {
                        currentResume.addInterest(s);
                    }
                    for (String s : Experiences) {
                        currentResume.addExperience(s);
                    }

                    ViewFragment sp = new ViewFragment();
                    android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
                    fragmentManager.beginTransaction()
                            .replace(R.id.editIndivResume, sp)
                            .commit();
                }
                else {
                    Toast t = Toast.makeText(getContext().getApplicationContext(), "Fill out all the questions", Toast.LENGTH_SHORT);
                    t.show();
                }

            }
        });

        return rootview;
    }

    private boolean fieldsFilledIn() {
        EditText[] editTexts = new EditText[] {title,name,phoneNum,emailAddress,careerObj,profession};
        for (EditText editText : editTexts) {
            if (editText.getText().toString().equals("")) {
                return false;
            }
        }
        return true;
    }

    private void resetFields() {
        EditText[] editTexts = new EditText[] {title,name,phoneNum,emailAddress,careerObj,profession,education,prevExperience,activities};

        for (EditText editText : editTexts) {
            editText.setText("");
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode != RESULT_OK) {
            return;
        }
        Bitmap bitmap = null;
        String path = "";
        if (requestCode == PICK_FROM_FILE) {
            imageCaptureUri = data.getData();
            path = getRealPathFromURI(imageCaptureUri);
            if (path == null) {
                path = imageCaptureUri.getPath();
            }
            if (path != null) {
                bitmap = BitmapFactory.decodeFile(path);
            }
        } else {
            path = imageCaptureUri.getPath();
            bitmap = BitmapFactory.decodeFile(path);
        }
        profilePic.setImageBitmap(bitmap);

    }

    public String getRealPathFromURI(Uri contentURI) {
        String[] proj = {MediaStore.Images.Media.DATA};
        Cursor cursor = ((MainUserActivity) getActivity()).managedQuery(contentURI,proj, null, null, null);
        if (cursor == null) return null;
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        return cursor.getString(column_index);
    }

}
