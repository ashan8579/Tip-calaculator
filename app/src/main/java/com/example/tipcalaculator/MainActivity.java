package com.example.tipcalaculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
        EditText Base;
        TextView tip;
        SeekBar sb;
        TextView Percent;
        TextView total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Base=findViewById(R.id.Base);
         tip=findViewById(R.id.tip);
         Percent=findViewById(R.id.Percent);
         sb =findViewById(R.id.sb);
         total=findViewById(R.id.total);
       sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
           @Override
           public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int percent= i;
               Percent.setText(String.valueOf(Percent)+"%") ;
calculate();
           }

           @Override
           public void onStartTrackingTouch(SeekBar seekBar) {

           }

           @Override
           public void onStopTrackingTouch(SeekBar seekBar) {



           }
       });
        Base.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
calculate();
            }
        });

    }
    private void calculate(){
        if(Base.length()==0){
            Base.requestFocus();
            Base.setError("enter amount");
        }
        else{
            double Amount=Double.parseDouble(Base.getText().toString());
            int percent =sb.getProgress();
            double Tip=(Amount*percent)/100;
            double Total=Amount+Tip;
            tip.setText(String.valueOf(Tip));
            total.setText(String.valueOf(Total));


        }
    }
}