package com.example.android.xsandos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;


public class BoardActivity extends AppCompatActivity {

    private ImageView[] myBlocks = new ImageView[9];
    private TextView myDisplay;
    private ImageView myExit, myReplay;
    private enum TURN {CIRCLE, CROSS}
    private TURN myTurn;
    private int myExitCounter = 0;
    private int myStatusCounter = 0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);
        initialize();

        GridLayout board = (GridLayout) findViewById(R.id.the_board);

    }

    private void initialize() {

        for (int position = 0; position < 9; position++) {
            int resId = getResources().getIdentifier("block_" + (position + 1), "id", getPackageName());
            myBlocks[position] = (ImageView) findViewById(resId);
            final int finalPosition = position;
            myBlocks[position].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switchTurn(finalPosition);
                }
            });
        }

        myDisplay = (TextView) findViewById(R.id.display_board);
        myReplay = (ImageView) findViewById(R.id.replay);
        myReplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newGame();
            }
        });
    }

    private void switchTurn(int position) {
        if (myTurn == TURN.CIRCLE) {
            myBlocks[position].setImageResource(R.drawable.ohs1);
            myBlocks[position].setId(GameLogic.CIRCLE);
            myTurn = TURN.CROSS;
//            myDisplay.setText("CROSS's turn");
        } else {
            myBlocks[position].setImageResource(R.drawable.exs);
            myBlocks[position].setId(GameLogic.CROSS);
            myTurn = TURN.CIRCLE;
//            myDisplay.setText("CIRCLE's turn");
        }
        myBlocks[position].setEnabled(false);
        myStatusCounter++;
        if (GameLogic.isCompleted(position + 1, myBlocks)) {
//            myDisplay.setText(GameLogic.sWinner + " won");
           displayStick(GameLogic.xSet);
            disableAll();
            newGame();
        }else if (myStatusCounter==9){
//            myDisplay.setText("DRAW. Try again");
            newGame();
        }
    }

    private void displayStick(int stick) {
        View view;
        switch (stick) {
            case 1:
                view = findViewById(R.id.top_horizontal);
                break;
            case 2:
                view = findViewById(R.id.center_horizontal);
                break;
            case 3:
                view = findViewById(R.id.bottom_horizontal);
                break;
            case 4:
                view = findViewById(R.id.left_vertical);
                break;
            case 5:
                view = findViewById(R.id.center_vertical);
                break;
            case 6:
                view = findViewById(R.id.right_vertical);
                break;
            case 7:
                view = findViewById(R.id.left_right_diagonal);
                break;
            case 8:
                view = findViewById(R.id.right_left_diagonal);
                break;
            default://which will never happen
                view = findViewById(R.id.top_horizontal);
        }
        view.setVisibility(View.VISIBLE);
    }

    private void disableAll() {
        for (int i = 0; i < 9; i++)
            myBlocks[i].setEnabled(false);
    }



    public void newGame(){

        Intent starter = getIntent();
        finish();
        starter.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(starter);
    }

    }
