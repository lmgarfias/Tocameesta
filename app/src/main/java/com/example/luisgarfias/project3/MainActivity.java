package com.example.luisgarfias.project3;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int rightAnswersCountTotal = 0;
    boolean rightAnswerCount1 = false;
    boolean rightAnswerCount2 = false;
    boolean rightAnswerCount3 = false;





    //Onpause:I will be helping out with basic Lifecycle, Saved Instance State and the basics of AsyncTaskLoader.


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitAnswers(View view) {

        if (rightAnswerCount1) {
            rightAnswersCountTotal += 1;
        }
        if (rightAnswerCount2) {
            rightAnswersCountTotal += 1;
        }
        if (rightAnswerCount3) {
            rightAnswersCountTotal += 1;
        }




        CheckBox emailCheckBox = (CheckBox) findViewById(R.id.email_results);
        boolean checkEmailResults = emailCheckBox.isChecked();

        if (checkEmailResults) {
            toastMessage(rightAnswersCountTotal);
            sendEmailWithResults();
            rightAnswersCountTotal = 0;


        } else {
            toastMessage(rightAnswersCountTotal);
            rightAnswersCountTotal = 0;

        }
    }

    public void sendEmailWithResults() {

        Intent intent = new Intent(Intent.ACTION_SENDTO);

        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Practice Test results ");
        intent.putExtra(Intent.EXTRA_TEXT, "Practice Test results ");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }


    public void onRadioButtonClicked1(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.position_1_1:
                if (checked)
                    rightAnswerCount1 = false;
                break;
            case R.id.position_1_2:
                if (checked)
                    rightAnswerCount1 = false;
                break;
            case R.id.position_1_3:
                if (checked)
                    rightAnswerCount1 = true;
                break;


        }
    }

    public void onRadioButtonClicked2(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.position_2_1:
                if (checked)
                    rightAnswerCount2 = true;
                break;
            case R.id.position_2_2:
                if (checked)
                    rightAnswerCount2 = false;
                break;
            case R.id.position_2_3:
                if (checked)
                    rightAnswerCount2 = false;
                break;


        }
    }

    public void onRadioButtonClicked3(View view) {
        // Is the button now checked?

        boolean checked = ((RadioButton) view).isChecked();


        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.position_3_1:
                if (checked)
                    rightAnswerCount3 = false;
                break;
            case R.id.position_3_2:
                if (checked)
                    rightAnswerCount3 = true;
                break;
            case R.id.position_3_3:
                if (checked)
                    rightAnswerCount3 = false;
                break;


        }
    }

    public void onCheckboxClicked(View view) {
        CheckBox option1 = (CheckBox) findViewById(R.id.option_1);
        CheckBox option2 = (CheckBox) findViewById(R.id.option_2);
        CheckBox option3 = (CheckBox) findViewById(R.id.option_3);
        if(option1.isChecked() && option2.isChecked()) {

            rightAnswersCountTotal += 1;
        }
        }

    private void toastMessage(int score) {

        Context context = getApplicationContext();
        CharSequence text = "Score:  " + score + "/4";
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();


    }

    public void resetAnswers(View view) {
        RadioGroup radioGroup1 = (RadioGroup) findViewById(R.id.ans_group_1);
        radioGroup1.clearCheck();
        RadioGroup radioGroup2 = (RadioGroup) findViewById(R.id.ans_group_2);
        radioGroup2.clearCheck();
        RadioGroup radioGroup3 = (RadioGroup) findViewById(R.id.ans_group_3);
        radioGroup3.clearCheck();
        CheckBox option1 = (CheckBox) findViewById(R.id.option_1);
        option1.setChecked(false);
        CheckBox option2 = (CheckBox) findViewById(R.id.option_2);
        option2.setChecked(false);
        CheckBox option3 = (CheckBox) findViewById(R.id.option_3);
        option3.setChecked(false);
        CheckBox emailCheckBox = (CheckBox) findViewById(R.id.email_results);
        emailCheckBox.setChecked(false);


        rightAnswerCount1 = false;
        rightAnswerCount2 = false;
        rightAnswerCount3 = false;
        rightAnswersCountTotal = 0;
    }

}