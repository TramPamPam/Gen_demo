package com.example.Gen.activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ShapeDrawable;
import android.os.Bundle;
import android.view.*;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.example.Gen.DrawableBlock;
import com.example.Gen.Pair;
import com.example.Gen.R;

import java.util.ArrayList;

//import java.lang.reflect.Array;

public class StartActivity extends Activity {
    /**
     * Menus
     */
    public static final int IDM_PROCESS = 101;
    public static final int IDM_IF = 102;
    public static final int IDM_END_IF = 107;
    public static final int IDM_INPUT = 103;
    public static final int IDM_OUTPUT = 104;
    public static final int IDM_EXIT = 105;
    private static final int IDM_GEN = 106;

    public String forGen;
    public ArrayList<Pair<String, String>> consequence = new ArrayList<Pair<String, String>>();
    public Pair<String, String> currentElement;
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        getActionBar().setTitle("Виберіть, що намалювати ->");

        consequence = new ArrayList<Pair<String, String>>();
        consequence = (ArrayList<Pair<String, String>>) this.getIntent().getSerializableExtra("consequence");
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        //This method is overrided with:
        Button myButton;
        Pair <String, String> currentPair;
        int i;
        if (consequence!=null){
            i = 0;
            while (i <= consequence.size()-1){
                currentElement = consequence.get(i);

                myButton = new Button(this);
                switch (currentElement.getFirst()){
                    case "input":
                        myButton.setText(currentElement.getSecond());
                        final int finalI = i;
                        myButton.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View view) {
                                Intent intent = new Intent(StartActivity.this, InputActivity.class);
                                intent.putExtra("consequence", consequence);
                                intent.putExtra("index", finalI);
                                startActivity(intent);
//                                Toast toast2 = Toast.makeText(getApplicationContext(),
//                                        "Entered "+finalI, Toast.LENGTH_LONG);
//                                toast2.show();
                            }
                        });
                        myButton.setBackground(this.getResources().getDrawable(R.drawable.flowchart_io));

                        break;
                    case "output":
                        myButton.setText(currentElement.getSecond());
                        final int finalI1 = i;
                        myButton.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View view) {
                                Intent intent = new Intent(StartActivity.this, InputActivity.class);
                                intent.putExtra("consequence", consequence);
                                intent.putExtra("index", finalI1);
                                startActivity(intent);
                            }
                        });

                        myButton.setBackground(this.getResources().getDrawable(R.drawable.flowchart_io));
                        break;
                    case "process":
                        myButton.setText(currentElement.getSecond());
                        final int finalI2 = i;
                        myButton.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View view) {
                                Intent intent = new Intent(StartActivity.this, InputActivity.class);
                                intent.putExtra("consequence", consequence);
                                intent.putExtra("index", finalI2);
                                startActivity(intent);
                            }
                        });
                        myButton.setBackground(this.getResources().getDrawable(R.drawable.flowchart_process));
                        break;
                    case "selection":
                        myButton.setText(currentElement.getSecond());
                        final int finalI3 = i;
                        myButton.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View view) {
                                Intent intent = new Intent(StartActivity.this, InputActivity.class);
                                intent.putExtra("consequence", consequence);
                                intent.putExtra("index", finalI3);
                                startActivity(intent);
                            }
                        });
                        myButton.setBackground(this.getResources().getDrawable(R.drawable.flowchart_selection));
                        break;
                    case "end":
                        myButton.setText("end");
                        myButton.setBackground(this.getResources().getDrawable(R.drawable.flowchart_start_stop));
                        break;
                    default:
                        break;
                }
                LinearLayout ll = (LinearLayout)findViewById(R.id.main_layout);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);
                ll.addView(myButton, lp);
                i++;
            }
        }else
        {
            Toast toast2 = Toast.makeText(getApplicationContext(), "Empty ", Toast.LENGTH_LONG);
            toast2.show();
        }
    }

    /**
     * Create Menu:
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        menu.add(Menu.NONE, IDM_PROCESS, Menu.NONE, "Процесс")
                .setAlphabeticShortcut('o');

        menu.add(Menu.NONE, IDM_IF, Menu.NONE, "Умова...")
                .setAlphabeticShortcut('s');
        menu.add(Menu.NONE, IDM_END_IF, Menu.NONE, "ENDIF")
                .setAlphabeticShortcut('q');
        menu.add(Menu.NONE, IDM_INPUT, Menu.NONE, "Введення даних")
                .setAlphabeticShortcut('e');

        menu.add(Menu.NONE, IDM_OUTPUT, Menu.NONE, "Виведення даних")
                .setAlphabeticShortcut('h');

        menu.add(Menu.NONE, IDM_EXIT, Menu.NONE, "Закінчення")
                .setAlphabeticShortcut('x');

        menu.add(Menu.NONE, IDM_GEN, Menu.NONE, "Генерувати")
                .setAlphabeticShortcut('y');

        return(super.onCreateOptionsMenu(menu));
    }
    // Using Menu:
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        CharSequence message;
        ShapeDrawable d = null;
        Button myButton;
        if (consequence == null)
            consequence = new ArrayList<>();
        DrawableBlock drawableBlock;
        Pair<String, String> cur;
        switch (item.getItemId()) {
            case IDM_PROCESS:
                message = "Малюємо прямокутник...";
                myButton = new Button(this);
                myButton.setText("process...");
                myButton.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Toast toast2 = Toast.makeText(view.getContext(), "Enter process ", Toast.LENGTH_SHORT);
                        toast2.show();

                        Intent intent = new Intent(StartActivity.this, InputActivity.class);
                        intent.putExtra("consequence", consequence);
                        intent.putExtra("index", -2);
                        startActivity(intent);
                    }
                });
                myButton.setBackground(this.getResources().getDrawable(R.drawable.flowchart_process));
                cur =new Pair<String, String>("process","");
                consequence.add(cur);
                break;
            case IDM_IF:
                message = "Малюємо ромб...";
                myButton = new Button(this);
                myButton.setText("If...");
                myButton.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Toast toast2 = Toast.makeText(view.getContext(), "Enter rhombus ", Toast.LENGTH_SHORT);
                        toast2.show();

                        Intent intent = new Intent(StartActivity.this, InputActivity.class);
                        intent.putExtra("consequence", consequence);
                        intent.putExtra("index", -2);
                        startActivity(intent);

                    }
                });
                myButton.setBackground(this.getResources().getDrawable(R.drawable.flowchart_selection));
                cur =new Pair<String, String>("selection","");
                consequence.add(cur);
                break;
            case IDM_END_IF:
                message = "Малюємо ромб...";
                myButton = new Button(this);
                myButton.setText("END_IF");
                myButton.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Toast toast2 = Toast.makeText(view.getContext(), "Enter rhombus ", Toast.LENGTH_SHORT);
                        toast2.show();

                        Intent intent = new Intent(StartActivity.this, InputActivity.class);
                        intent.putExtra("consequence", consequence);
                        intent.putExtra("index", -2);
                        startActivity(intent);

                    }
                });
                myButton.setBackground(this.getResources().getDrawable(R.drawable.flowchart_selection));
                cur =new Pair<String, String>("selection_end","END_IF");
                consequence.add(cur);
                break;
            case IDM_INPUT:
                message = "Малюємо чотирикутник...";
                myButton = new Button(this);
                myButton.setText("input...");
                myButton.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Toast toast2 = Toast.makeText(view.getContext(), "Enter input ", Toast.LENGTH_SHORT);
                        toast2.show();

                        Intent intent = new Intent(StartActivity.this, InputActivity.class);
                        intent.putExtra("consequence", consequence);
                        intent.putExtra("index", -2);
                        startActivity(intent);

                    }
                });
                myButton.setBackground(this.getResources().getDrawable(R.drawable.flowchart_io));
                cur =new Pair<String, String>("input","");
                consequence.add(cur);

                break;
            case IDM_OUTPUT:
                message = "Малюємо чотирикутник...";
                myButton = new Button(this);
                myButton.setText("output...");
                myButton.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Toast toast2 = Toast.makeText(view.getContext(), "Enter output ", Toast.LENGTH_SHORT);
                        toast2.show();

                        Intent intent = new Intent(StartActivity.this, InputActivity.class);
                        intent.putExtra("consequence", consequence);
                        intent.putExtra("index", -2);
                        startActivity(intent);

                    }
                });
                myButton.setBackground(this.getResources().getDrawable(R.drawable.flowchart_io));
                cur =new Pair<String, String>("output","");
                consequence.add(cur);

                break;
            case IDM_EXIT:
                message = "Малюємо овал!";
                myButton = new Button(this);
                myButton.setText("end");
                myButton.setBackground(this.getResources().getDrawable(R.drawable.flowchart_start_stop));
                cur =new Pair<String, String>("end","");
                consequence.add(cur);

                break;
            case IDM_GEN:
                message = "Генеруємо...";
                Intent intent = new Intent(StartActivity.this, OutputActivity.class);
                intent.putExtra("consequence", consequence);
                startActivity(intent);
                myButton = null;
                break;
            default:
                return false;
        }
        if (myButton != null){
            LinearLayout ll = (LinearLayout)findViewById(R.id.main_layout);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            ll.addView(myButton, lp);
        }
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
        return true;
    }


}
