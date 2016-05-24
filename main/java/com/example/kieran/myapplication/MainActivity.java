package com.example.kieran.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private int[] currentIds = new int[] { R.id.curr1, R.id.curr2, R.id.curr3, R.id.curr4, R.id.curr5, R.id.curr6, R.id.curr7, R.id.curr8, R.id.curr9 };
    private int[] totalIds = new int[]{ R.id.tot1, R.id.tot2, R.id.tot3, R.id.tot4, R.id.tot5, R.id.tot6, R.id.tot7, R.id.tot8, R.id.tot9 };
    private int[] subIds = new int[]{ R.id.subtract1, R.id.subtract2, R.id.subtract3, R.id.subtract4, R.id.subtract5, R.id.subtract6, R.id.subtract7, R.id.subtract8, R.id.subtract9 };
    private int[] addIds = new int[]{ R.id.addition1, R.id.addition2, R.id.addition3, R.id.addition4, R.id.addition5, R.id.addition6, R.id.addition7, R.id.addition8, R.id.addition9 };
    private TextView[] etCurr = new TextView[currentIds.length];
    private EditText[] etTot = new EditText[totalIds.length];
    private Button[] btnSub = new Button[subIds.length];
    private Button[] btnAdd = new Button[addIds.length];
    private Button longRest;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {


        for (int i = 0; i < currentIds.length; i++) {
            etCurr[i] = (TextView)findViewById(currentIds[i]);
            etTot[i] = (EditText)findViewById(totalIds[i]);
            btnSub[i] = (Button)findViewById(subIds[i]);
            btnAdd[i] = (Button)findViewById(addIds[i]);
            longRest = (Button)findViewById(R.id.btnLr);
            btnSub[i].setOnClickListener(this);
            btnAdd[i].setOnClickListener(this);
            longRest.setOnClickListener(this);

        }
    }
    @Override
    public void onClick(View view){
        int[] currents = new int[etCurr.length];
        int[] totals = new int[etTot.length];
        for (int i = 0; i <= 8; i++) {
             currents[i]=Integer.parseInt(etCurr[i].getText().toString());
             totals[i]=Integer.parseInt(etTot[i].getText().toString());
        }
        for (int i = 0; i < btnSub.length; i++) {
            if (view.getId() == subIds[i])
            {
                if (currents[i] > 0) {
                    currents[i] = currents[i] - 1;
                } else currents[i] = 0;
                etCurr[i].setText(String.valueOf(currents[i]));
            }
            else if (view.getId() == addIds[i])
            {
                if (currents[i] < totals[i]) {
                    currents[i] = currents[i] + 1;
                } else currents[i] = totals[i];
                etCurr[i].setText(String.valueOf(currents[i]));
            }
        }
        if (view.getId() == R.id.btnLr)
        {
            for(int i = 0; i < etCurr.length; i++) {
                currents[i] = totals[i];
                etCurr[i].setText(String.valueOf(currents[i]));
            }
        }
    }
}
