package com.example.quizapplicationproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import java.util.HashMap;
import android.view.View;
import android.util.Log;
// 종료 체크
import android.app.AlertDialog;
import android.content.DialogInterface;
// 1초 후 문제 보여주기
import android.os.Handler;

public class MainActivity extends AppCompatActivity {
    TextView questionTextView;
    Button example1Button;
    Button example2Button;
    Button example3Button;
    Button example4Button;

    HashMap[] problems = {
            new HashMap() {{
                put("question", "길 위에 떠도는 소문");
                put("answer", "가담항설");
                put("example1", "낙화유수");
                put("example2", "각주구검");
                put("example3", "오매불망");
                put("example4", "가담항설");
            }},
            new HashMap() {{
                put("question", "거짓된 것을 참된 것처럼 보이게 하는 것으로 장난삼아 한 일이 진짜가 됨");
                put("answer", "가롱성진");
                put("example1", "가인박명");
                put("example2", "가렴주구");
                put("example3", "가장집물");
                put("example4", "가롱성진");
            }},
            new HashMap() {{
                put("question", "입은 은혜에 대한 고마운 마음이 뼈에 사무쳐 잊혀지지 않음");
                put("answer", "각골난망");
                put("example1", "각자무치");
                put("example2", "각골난망");
                put("example3", "강구연월");
                put("example4", "간두지세");
            }},
            new HashMap() {{
                put("question", "한 번 궂은 일을 당하고 나면 늘 의심하고 두려워하게 됨");
                put("answer", "경궁지조");
                put("example1", "경천동지");
                put("example2", "계구우후");
                put("example3", "경궁지조");
                put("example4", "경국지색");
            }},
            new HashMap() {{
                put("question", "배를 두드리며 땅을 침. 태평성대를 즐김");
                put("answer", "고복격양");
                put("example1", "고식지계");
                put("example2", "고복격양");
                put("example3", "계명구도");
                put("example4", "곡학아세");
            }},
            new HashMap() {{
                put("question", "물건을 보면 갖고 싶은 욕심이 생김");
                put("answer", "견물생심");
                put("example1", "견위수명");
                put("example2", "견물생심");
                put("example3", "견토지쟁");
                put("example4", "결자해지");
            }},
            new HashMap() {{
                put("question", "기름지고 맛있는 음식");
                put("answer", "고량진미");
                put("example1", "고량진미");
                put("example2", "고식지계");
                put("example3", "고장난명");
                put("example4", "고군분투");
            }},
            new HashMap() {{
                put("question", "의심 받을 행동은 처음부터 해서는 안됨");
                put("answer", "과전이하");
                put("example1", "과대망상");
                put("example2", "과유불급");
                put("example3", "과전이하");
                put("example4", "괄목상대");
            }},
            new HashMap() {{
                put("question", "남을 가르치거나 남에게 배우거나 모두 나의 학업을 증진시킨다");
                put("answer", "교학상장");
                put("example1", "구곡간장");
                put("example2", "구미속초");
                put("example3", "교학상장");
                put("example4", "구사일생");
            }},
            new HashMap() {{
                put("question", "나라 안에 견줄 만 한 자가 없는 인재로 국내에서 가장 뛰어난 인물을 이르는 말");
                put("answer", "국사무쌍");
                put("example1", "군계일학");
                put("example2", "국사무쌍");
                put("example3", "군웅할거");
                put("example4", "궁여지책");
            }}
    };

    int problemNumber = 1;
    String question = "";
    String answer = "";
    String example1 = "";
    String example2 = "";
    String example3 = "";
    String example4 = "";

    int totalCorrect = 0;
    TextView totalCorrectTextView;
    TextView correctIncorrectTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionTextView = findViewById(R.id.questionTextView);
        example1Button = findViewById(R.id.example1Button);
        example2Button = findViewById(R.id.example2Button);
        example3Button = findViewById(R.id.example3Button);
        example4Button = findViewById(R.id.example4Button);

        totalCorrectTextView = findViewById(R.id.totalCorrectTextView);
        correctIncorrectTextView = findViewById(R.id.correctIncorrectTextView);

        showProblem();

        totalCorrectTextView.setText("Total Correct: 0");
        correctIncorrectTextView.setText("정답/오답");
    }

    void showProblem() {
        question = (String)problems[problemNumber - 1].get("question");
        answer = (String)problems[problemNumber - 1].get("answer");
        example1 = (String)problems[problemNumber - 1].get("example1");
        example2 = (String)problems[problemNumber - 1].get("example2");
        example3 = (String)problems[problemNumber - 1].get("example3");
        example4 = (String)problems[problemNumber - 1].get("example4");

        questionTextView.setText(question);
        example1Button.setText(example1);
        example2Button.setText(example2);
        example3Button.setText(example3);
        example4Button.setText(example4);
    }
    // 버튼 클릭 이벤트
    public void example1ButtonClicked(View v) {
        Log.d("MainActivity", "example1ButtonClicked");
        selectExample(example1);
    }

    void selectExample(String example) {
        Log.d("MainActivity", example);
        if (answer.equals(example)) {
            totalCorrect += 1;
            totalCorrectTextView.setText(Integer.toString(totalCorrect));
            correctIncorrectTextView.setText("Correct");
        }
        else {
            correctIncorrectTextView.setText("Incorrect");
        }

        example1Button.setEnabled(false);
        example2Button.setEnabled(false);
        example3Button.setEnabled(false);
        example4Button.setEnabled(false);
        Handler h = new Handler() ;
        h.postDelayed(new Runnable() {
            public void run() {
                example1Button.setEnabled(true);
                example2Button.setEnabled(true);
                example3Button.setEnabled(true);
                example4Button.setEnabled(true);

                if (problemNumber < problems.length) {
                    problemNumber += 1;
                    showProblem();
                }
                else {
                    Log.d("MainActivity", "showGameOverBox");
                    showGameOverBox();
                }
            }}, 1000);
    }



    void showGameOverBox() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("게임 종료");
        builder.setMessage("게임을 다시 하시겠습니까?");
        builder.setNegativeButton("앱 종료", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                exitApp();
            }
        });
        builder.setPositiveButton("다시 하기", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                replay();
            }
        });
        builder.setCancelable(false); //true by default
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    void exitApp() {
        finishAffinity();
    }

    void replay() {
        problemNumber = 1;
        totalCorrect = 0;
        showProblem();
        totalCorrectTextView.setText("Total Correct: 0");
        correctIncorrectTextView.setText("Correct/Incorrect");
    }

    public void example2ButtonClicked(View v) {
        Log.d("MainActivity", "example2ButtonClicked");
        selectExample(example2);
    }

    public void example3ButtonClicked(View v) {
        Log.d("MainActivity", "example3ButtonClicked");
        selectExample(example3);
    }

    public void example4ButtonClicked(View v) {
        Log.d("MainActivity", "example4ButtonClicked");
        selectExample(example4);
    }
}