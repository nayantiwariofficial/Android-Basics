package com.example.nayantiwari.reportcard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ReportCard extends AppCompatActivity {

    private String stuName;
    private float marksPhy;
    private float marksChem;
    private float marksBio;
    private float marksMaths;
    private float marksEng;

    private String gradePhy;
    private String gradeChem;
    private String gradeBio;
    private String gradeMaths;
    private String gradeEng;
    private String finalGrade;

    private static final String TAG = "ReportCard";
    private String finalResult;

    public ReportCard() {

        stuName = "";
        marksPhy = 0;
        marksChem = 0;
        marksBio = 0;
        marksMaths = 0;
        marksEng = 0;

        gradePhy = "N/A";
        gradeChem = "N/A";
        gradeBio = "N/A";
        gradeMaths = "N/A";
        gradeEng = "N/A";

        finalGrade = "N/A";

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void setMarks(View view) {

        EditText studName = (EditText) findViewById(R.id.student_name);
        EditText marksPhysics = (EditText) findViewById(R.id.physics_marks);
        EditText marksChemistry = (EditText) findViewById(R.id.chemistry_marks);
        EditText marksBiology = (EditText) findViewById(R.id.biology_marks);
        EditText marksMathematics = (EditText) findViewById(R.id.mathematics_marks);
        EditText marksEnglish = (EditText) findViewById(R.id.english_marks);

        stuName = studName.getText().toString();
        marksPhy = Float.parseFloat(marksPhysics.getText().toString());
        marksChem = Float.parseFloat(marksChemistry.getText().toString());
        marksBio = Float.parseFloat(marksBiology.getText().toString());
        marksMaths = Float.parseFloat(marksMathematics.getText().toString());
        marksEng = Float.parseFloat(marksEnglish.getText().toString());

        ArrayList<Float> percentList = new ArrayList<>();
        percentList.add(marksPhy);
        percentList.add(marksChem);
        percentList.add(marksBio);
        percentList.add(marksMaths);
        percentList.add(marksEng);

        for (int i = 0; i < percentList.size(); i++) {
            Log.i(TAG, "Array elements: " + percentList.get(i));
        }

        gradePhy = getGrade(percentList.get(0));
        gradeChem = getGrade(percentList.get(1));
        gradeBio = getGrade(percentList.get(2));
        gradeMaths = getGrade(percentList.get(3));
        gradeEng = getGrade(percentList.get(4));

        String finalResult = getFinalResult();

        setContentView(R.layout.report_card_output);


        TextView nameTextView = (TextView) findViewById(R.id.student_name_result);
        nameTextView.setText(stuName);

        TextView phyTextView = (TextView) findViewById(R.id.physics_result);
        phyTextView.setText(gradePhy);

        TextView chemTextView = (TextView) findViewById(R.id.chemistry_result);
        chemTextView.setText(gradeChem);

        TextView bioTextView = (TextView) findViewById(R.id.biology_result);
        bioTextView.setText(gradeBio);

        TextView mathsTextView = (TextView) findViewById(R.id.mathematics_result);
        mathsTextView.setText(gradeMaths);

        TextView engTextView = (TextView) findViewById(R.id.english_result);
        engTextView.setText(gradeEng);

        TextView result = (TextView) findViewById(R.id.result);
        result.setText(finalResult + " " + finalGrade + " Grade");


    }

    private String getGrade(float marks) {
        if (marks > 90 && marks <= 100)
            return "A";
        else if (marks > 80 && marks <= 90)
            return "B";
        else if (marks > 70 && marks <= 80)
            return "C";
        else if (marks > 60 && marks <= 70)
            return "D";
        else if (marks >= 0 && marks <= 60)
            return "F";
        else
            return "Invalid percentage!";
    }

    public String getFinalResult() {
        float avgMarks = (marksBio + marksChem + marksPhy + marksMaths + marksEng) / 5;
        finalGrade = getGrade(avgMarks);
        if (!gradeBio.equals("F") && !gradeChem.equals("F") && !gradePhy.equals("F") && !gradeMaths.equals("F") && !gradeEng.equals("F"))
            return "PASS";
        else return "FAIL";
    }
}
