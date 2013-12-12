package com.example.Gen.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.Gen.DrawableBlock;
import com.example.Gen.Pair;
import com.example.Gen.R;

import java.util.ArrayList;

/**
 * Created with love.
 * User: Sasha
 * Package: com.example.Gen
 */


public class InputActivity extends Activity {
    public EditText editText;
    public String typeOfExtra;
    public Pair<String, String> current;
    public ArrayList<Pair<String, String>> conseq;
    public int index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //This method is overrided with:
        setContentView(R.layout.activity_input);
        getActionBar().setTitle("Введіть дані для блоку");
        editText = (EditText) findViewById(R.id.editText);
        conseq = (ArrayList<Pair<String, String>>)this.getIntent().getSerializableExtra("consequence");
        index = this.getIntent().getIntExtra("index",-1);

        Button button_ok = (Button)findViewById(R.id.button_ok);
        button_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (index >= 0)
                {
                    current = conseq.get(index);
                    current.setSecond(editText.getText().toString());
                    conseq.set(index, current);
                }else{
                    current = conseq.get(conseq.size()-1);
                    conseq.remove(conseq.size()-1);
                    current.setSecond(editText.getText().toString());
                    conseq.add(current);
                }
                Intent intent = new Intent(InputActivity.this, StartActivity.class);
                intent.putExtra("consequence",conseq);
                startActivity(intent);
//                Toast toast2 = Toast.makeText(getApplicationContext(),
//                        "Entered "+editText.getText().toString()
//                                +"\n" + conseq.get(conseq.size()-1).getFirst()
//                                +"\n" + conseq.get(conseq.size()-1).getSecond()
//                                +"\n" + current.getSecond()
//                                +"\n" + index, Toast.LENGTH_LONG);
//                toast2.show();

            }
        });


    }

}
