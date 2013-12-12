package com.example.Gen;

import android.*;
import android.R;
import android.widget.Button;

import java.io.Serializable;
import java.util.Map;

public class DrawableBlock implements Serializable {

//    int blockId;
//    BlockType blockType;
//    Map connections;//<id_in, id_out>
//    R.string text;
    public Button button;

    public DrawableBlock(Button button) {
        this.button = button;
    }

    public void setButtonText(String text) {
        this.button.setText(text);
    }
}
