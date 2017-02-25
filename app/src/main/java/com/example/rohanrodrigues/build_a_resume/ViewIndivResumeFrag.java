package com.example.rohanrodrigues.build_a_resume;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

/**
 * Created by rohanrodrigues on 2/23/17.
 */

public class ViewIndivResumeFrag extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.view_indiv_resume, container, false);

        String state = Environment.getExternalStorageState();
        if (!Environment.MEDIA_MOUNTED.equals(state)) {
            Toast.makeText(getContext(), "Environment does not match State", Toast.LENGTH_LONG).show();
        }

        ResumeDisplay sp = new ResumeDisplay();
        View mRootView = sp.getRootview();

//Create a directory for your PDF
        File pdfDir = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_DOCUMENTS), "MyApp");
        if (!pdfDir.exists()){
            pdfDir.mkdir();
        }

//Then take the screen shot
        Bitmap screen; View v1 = mRootView.getRootView();
        v1.setDrawingCacheEnabled(true);
        screen = Bitmap.createBitmap(v1.getDrawingCache());
        v1.setDrawingCacheEnabled(false);

//Now create the name of your PDF file that you will generate
        File pdfFile = new File(pdfDir, "myPdfFile.pdf");

        try {
            Document document = new Document();

            PdfWriter.getInstance(document, new FileOutputStream(pdfFile));
            document.open();
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            screen.compress(Bitmap.CompressFormat.PNG, 100, stream);
            byte[] byteArray = stream.toByteArray();
            addImage(document,byteArray);
            document.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        Intent intent = new Intent(Intent.ACTION_VIEW);
        Uri uri = Uri.fromFile(new File(pdfDir,  "pdfFileName"));
        intent.setDataAndType(uri, "application/pdf");
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);

        return rootview;
    }

    private static void addImage(Document document,byte[] byteArray)
    {
        Image image = null;
        try
        {
            image = Image.getInstance(byteArray);
        }
        catch (BadElementException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (MalformedURLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // image.scaleAbsolute(150f, 150f);
        try
        {
            document.add(image);
        } catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
