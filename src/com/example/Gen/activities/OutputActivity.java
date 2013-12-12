package com.example.Gen.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.Gen.Pair;
import com.example.Gen.R;

import java.util.ArrayList;

/**
 * Created with love.
 * User: Sasha
 * Package: com.example.Gen
 */
public class OutputActivity extends Activity {
    public Pair<String, String> current;
    public ArrayList<Pair<String, String>> conseq;

    public String result_c;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //This method is overrided with:
        setContentView(R.layout.activity_output);
        getActionBar().setTitle("Сгенерований код:");
        result_c = this.generateCode();
        TextView textView = (TextView)findViewById(R.id.textView);
        textView.setText(result_c);
        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OutputActivity.this,  StartActivity.class);
                intent.putExtra("consequence", conseq);
                startActivity(intent);
            }
        });

    }

    private String generateCode() {
        String result = "";
        conseq = (ArrayList<Pair<String, String>>)this.getIntent().getSerializableExtra("consequence");
        for (Pair<String, String> currPair : conseq) {
            switch (currPair.getFirst()){
                case "input":
                    result += "\nINPUT "+currPair.getSecond();
                    break;
                case "output":
                    result += "\nPRINT "+currPair.getSecond();
                    break;
                case "process":
                    result += "\n"+currPair.getSecond();
                    break;
                case "end":
                    result += "\nEND";
                    return result;
                case "selection":
                    result += "\nIF "+currPair.getSecond()+" THEN ";
                    break;
                case "selection_end":
                    result += "\nENDIF";
                    break;
                default:
                    break;
            }
        }
        return result;
    }
}
