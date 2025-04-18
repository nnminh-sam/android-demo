package nnminh.playground.cocaro;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    int winer = -1;
    int startGame = 0;
    Button btnStart, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    TextView txtResult;
    int ActivePlayer=1; // 1 : first, 2 second
    ArrayList<Integer> Player1 = new ArrayList<Integer>();
    ArrayList<Integer> Player2 = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Mapping();
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (startGame == 1) {
                    PlayAgain();
                    startGame=0;
                    btnStart.setText("Start game");
                }
                else if (startGame == 0)
                {
                    btnStart.setText("Restart");
                    startGame=1;
                }
            }
        });
    }

    void PlayAgain() {
        Player1.clear();
        Player2.clear();
        winer = -1;
        btn1.setText("");
        btn1.setBackgroundColor(Color.rgb(188,185,185));
        btn2.setText("");
        btn2.setBackgroundColor(Color.rgb(188,185,185));
        btn3.setText("");
        btn3.setBackgroundColor(Color.rgb(188,185,185));
        btn4.setText("");
        btn4.setBackgroundColor(Color.rgb(188,185,185));
        btn5.setText("");
        btn5.setBackgroundColor(Color.rgb(188,185,185));
        btn6.setText("");
        btn6.setBackgroundColor(Color.rgb(188,185,185));
        btn7.setText("");
        btn7.setBackgroundColor(Color.rgb(188,185,185));
        btn8.setText("");
        btn8.setBackgroundColor(Color.rgb(188,185,185));
        btn9.setText("");
        btn9.setBackgroundColor(Color.rgb(188,185,185));
        txtResult.setVisibility(View.INVISIBLE);
    }

    void Mapping() {
        btnStart = (Button) findViewById(R.id.btnStart);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        txtResult = (TextView) findViewById(R.id.txtShowResilt);
    }

    public void btnClick(View view) {
        Button btSelected = (Button) view;
        int CellID = 0;

        int id = btSelected.getId();
        if (id == R.id.btn1) {
            CellID = 1;
        } else if (id == R.id.btn2) {
            CellID = 2;
        } else if (id == R.id.btn3) {
            CellID = 3;
        } else if (id == R.id.btn4) {
            CellID = 4;
        } else if (id == R.id.btn5) {
            CellID = 5;
        } else if (id == R.id.btn6) {
            CellID = 6;
        } else if (id == R.id.btn7) {
            CellID = 7;
        } else if (id == R.id.btn8) {
            CellID = 8;
        } else if (id == R.id.btn9) {
            CellID = 9;
        }

        if (winer == -1 && startGame == 1) {
            PlayGame(CellID, btSelected);
        }
    }

    void PlayGame(int CellID, Button btselected){
        if(ActivePlayer == 1)
        {
            btselected.setText("X");
            btselected.setBackgroundColor(Color.GREEN);
            btselected.setTextColor(Color.RED);
            Player1.add(CellID);
            ActivePlayer = 2;
        }
        else if (ActivePlayer ==2)
        {
            btselected.setText("O");
            btselected.setTextColor(Color.WHITE);
            btselected.setBackgroundColor(Color.BLUE);
            Player2.add(CellID);
            ActivePlayer = 1;
        }
        CheckWiner();
        if (winer == 1) {
            txtResult.setVisibility(View.VISIBLE);
            txtResult.setText("Player 1 win !");
//Toast.makeText(this,"Play 1 thắng !",Toast.LENGTH_LONG).show();
        }
        else if (winer == 2) {
            txtResult.setVisibility(View.VISIBLE);
            txtResult.setText("Player 2 win !");
//Toast.makeText(this,"Play 2 thắng !",Toast.LENGTH_LONG).show();
        }
        else if (winer == 0) {
            txtResult.setVisibility(View.VISIBLE);
            txtResult.setText("Draw !");
//Toast.makeText(this,"Hòa !",Toast.LENGTH_LONG).show();
        }
    }

    void CheckWiner(){
//Dòng 1
        if(Player1.contains(1) && Player1.contains(2) &&
                Player1.contains(3)){
            winer =1;
        }
        if(Player2.contains(1) && Player2.contains(2) &&
                Player2.contains(3)){
            winer =2;
        }
//Dòng 2
        if(Player1.contains(4) && Player1.contains(5) &&
                Player1.contains(6)){
            winer =1;
        }
        if(Player2.contains(4) && Player2.contains(5) &&
                Player2.contains(6)){
            winer =2;
        }
//Dòng 3
        if(Player1.contains(7) && Player1.contains(8) &&
                Player1.contains(9)){
            winer =1;
        }
        if(Player2.contains(7) && Player2.contains(8) &&
                Player2.contains(9)){
            winer =2;
        }
//Cột 1
        if(Player1.contains(1) && Player1.contains(4) &&
                Player1.contains(7)){
            winer =1;
        }
        if(Player2.contains(1) && Player2.contains(4) &&
                Player2.contains(7)){
            winer =2;
        }
//Cột 2
        if(Player1.contains(2) && Player1.contains(5) &&
                Player1.contains(8)){
            winer =1;
        }
        if(Player2.contains(2) && Player2.contains(5) &&
                Player2.contains(8)){
            winer =2;
        }
//Cột 3
        if(Player1.contains(2) && Player1.contains(5) &&
                Player1.contains(8)){
            winer =1;
        }
        if(Player2.contains(3) && Player2.contains(6) &&
                Player2.contains(9)){
            winer =2;
        }
//Chéo 1
        if(Player1.contains(1) && Player1.contains(5) &&
                Player1.contains(9)){
            winer =1;
        }
        if(Player2.contains(1) && Player2.contains(5) &&
                Player2.contains(9)){
            winer =2;
        }
//Chéo 2
        if(Player1.contains(3) && Player1.contains(5) &&
                Player1.contains(7)){
            winer =1;
        }
        if(Player2.contains(3) && Player2.contains(5) &&
                Player2.contains(7)){
            winer =2;
        }
        int sum = Player1.size() + Player2.size();
        if (sum == 9 && winer == -1)
        {
            winer = 0;
        }
    }
}