package com.example.school_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class FirstActivity extends AppCompatActivity {
    private EditText mEditID, mEditPW;
    private Button btn_login, btn_register, btn_moveToMain;
    private TextView error_id, error_pw;

    @Override
    protected void onCreate(Bundle savedInstanceState) { //엑티비티 시작시 처음으로 실행되는 생명주기!
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        mEditID = (EditText) findViewById(R.id.et_id);
        mEditPW = (EditText) findViewById(R.id.et_password);
        btn_login = findViewById(R.id.btn_login);
        btn_register = findViewById(R.id.btn_register);
        btn_moveToMain = findViewById(R.id.btn_moveToMain);
        error_id = findViewById(R.id.error_id);
        error_pw = findViewById(R.id.error_pw);

        //로그인 버튼 클릭시 -> ID, PW값이 프레퍼런스에 있던 값인지 확인 후 메인으로 이동
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputID = mEditID.getText().toString();
                String inputPW = mEditPW.getText().toString();

                error_id.setText(""); error_pw.setText(""); //에러메세지 초기화
                boolean rightInput = true;

                //만약 ID input창 값이 공백이라면 -> 에러창
                if(inputID.replace(" ", "").equals("")){
                    error_id.setText("아이디를 입력하세요.");
                    rightInput = false;
                }
                //만약 PW input창 값이 공백이라면 -> 에러창
                if(inputPW.replace(" ", "").equals("")){
                    error_pw.setText("비밀번호를 입력하세요.");
                    rightInput = false;
                }

                //ID, PW에 값이 잘 입력된 상태에서, 해당 ID 파일명인 프레퍼런스가 있는지 화인
                if(rightInput){
                    SharedPreferences prefs = getSharedPreferences("personInfo", 0);

                    //만약 프레퍼런스 파일에 해당 key값(즉,ID)가 있다면,
                    if (prefs.contains(inputID)){
                        //프레퍼런스에 해당 key값의 value (set으로 저장됨) 를 infoSet에 저장함.
                        Set<String> infoSet = prefs.getStringSet(inputID, new HashSet<>());
                        //iterator로 set에서 첫번째 값 (pw가 저장되어있음)을 userPW에 담음.

                        Iterator iter = infoSet.iterator();
                        String userPW="", userName="", userAddress="", userSex="";
                        while(iter.hasNext()){
                           String data = iter.next().toString();
                           if(data.charAt(0) == 'P') userPW = data.substring(1);
                           else if(data.charAt(0) == 'N') userName = data.substring(1);
                           else if(data.charAt(0) == 'A') userAddress = data.substring(1);
                           else userSex = data.substring(1);
                        }

                        //만약 기존에 저장된 pw(userPW)와 input으로 들어온 pw가 동일하다면 -> 로그인 성공.
                        if(userPW.equals(inputPW)){
                            Intent intent = new Intent(getApplicationContext(), ThirdActivity.class);
                            intent.putExtra("user_id", inputID);
                            intent.putExtra("user_name", userName);
                            intent.putExtra("user_address", userAddress);
                            intent.putExtra("user_sex", userSex);
                            startActivity(intent);
                        }
                        //동일하지 않다면 -> pw를 확인하라는 에러창
                        else{
                            error_id.setText("");
                            error_pw.setText("비밀번호가 일치하지 않습니다.");
                        }
                    }

                    //프레퍼런스에 그런 ID값이 없다면, (즉 ID가 틀림) -> ID가 틀렸다는 에러창
                    else{
                        error_id.setText("존재하지 않는 아이디입니다.");
                    }
                }
            }
        });
        //회원가입 버튼 클릭시 -> 화면2로 이동.
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //화면2로 이동.
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                startActivity(intent);
            }
        });
        //메인 버튼 클릭시 -> 화면3으로 이동
        btn_moveToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //화면3으로 이동.
                Intent intent = new Intent(getApplicationContext(), ThirdActivity.class);
                startActivity(intent);
            }
        });

        //프레퍼런스에서 데이터를 읽어온다. (프레퍼런스에 이미 있는 데이터인 경우만)
        //앱이 처음시작된 것이 아니라면,
        if(savedInstanceState == null){
            //ID를 파일명으로 해서 프레퍼런스에 ID, PW를 저장했었음.
            SharedPreferences prefs = getSharedPreferences("personInfo", 0);
//            String ID = prefs.getString("ID", ""); //전에 만든 prefs에서 "ID" key값의 value를 ID변수에 불러온다.
//            String PW = prefs.getString("PW", "");

            //회원가입한 아이디 기록..?
//            mEditID.setText(ID);
//            mEditPW.setText(PW);
        }
    }
    //엑티비티가 종료될 때, 마지막 시점에 editor에 값을 저장하는 함수.
    @Override
    protected void onDestroy(){
        super.onDestroy();
        //프레퍼런스에 데이터를 저장한다.
        SharedPreferences prefs = getSharedPreferences("personInfo", 0);
        SharedPreferences.Editor editor = prefs.edit(); //SharedPreferences의 edit 객체에 값을 저장하기로.

        String ID = mEditID.getText().toString();
        String PW = mEditPW.getText().toString();

//        editor.putString("ID", ID); //editor의 "ID"라는 키 값에 ID value를 저장한다.
//        editor.putString("ID", PW);
        editor.apply(); //이 모든 것을 프레퍼런스에 완전 저장.
    }

}