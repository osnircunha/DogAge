package com.wipro.bootcamp.dogage;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import org.apache.commons.lang3.math.NumberUtils;


public class MainActivity extends ActionBarActivity implements View.OnClickListener{

    private Spinner breedSpinner;
    private EditText ageYearText;
    private EditText ageMonthText;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        breedSpinner = (Spinner) findViewById(R.id.breedSpinner);
        ageYearText = (EditText) findViewById(R.id.ageYearText);
        ageMonthText = (EditText) findViewById(R.id.ageMonthText);
        button = (Button) findViewById(R.id.submitButton);

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.submitButton && validateFields()){
            double year = NumberUtils.toDouble(this.ageYearText.getText().toString());
            double month = NumberUtils.toDouble(this.ageMonthText.getText().toString());
            double result = DogAgeUtil.calculate(this.breedSpinner.getSelectedItemPosition(), year, month);

            Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
            intent.putExtra("result", result);
            intent.putExtra("index", this.breedSpinner.getSelectedItemPosition());

            startActivity(intent);

        } else {
            AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            dialog.setTitle("Empty fields");
            dialog.setMessage("At least one of Year or Month should be provided.");
            dialog.create();

            dialog.show();
        }
        clearFields();
    }

    private boolean validateFields(){
        if (NumberUtils.isNumber(this.ageYearText.getText().toString()) || NumberUtils.isNumber(this.ageMonthText.getText().toString())){
            return true;
        }
        return false;
    }

    private void clearFields(){
        this.ageYearText.setText("");
        this.ageMonthText.setText("");
    }
}
