package com.example.school_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SecondActivity extends AppCompatActivity {
    private EditText editID, editPW, editName, editAddress;
    private Button btn_register;
    private RadioButton radio_agree, radio_woman, radio_man;
    private TextView error_agree, error_ID, error_PW, error_name, error_address;
    private final int PWMinLength = 6; //비번 최소길이


    @Override
    //가로 -> 세로화면으로 변경될 때, 이전값을 초기화하지 안도록하려면 savedInstanceState를 써야함.
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second); //xml파일과 연결하기.

        //xml파일의 inputbox와 java파일의 변수를 연결하기.
        editID = (EditText) findViewById(R.id.et_id);
        editPW = (EditText) findViewById(R.id.et_password);
        editName = (EditText) findViewById(R.id.et_name);
        editAddress = (EditText) findViewById(R.id.et_address);
        radio_woman = findViewById(R.id.radio_woman);
        radio_man = findViewById(R.id.radio_man);
        btn_register = findViewById(R.id.btn_register);
        radio_agree = findViewById(R.id.radio_agree);
        error_agree = findViewById(R.id.error_agree);
        error_ID = findViewById(R.id.error_id);
        error_PW = findViewById(R.id.error_pw);
        error_name = findViewById(R.id.error_name);
        error_address = findViewById(R.id.error_address);



        //회원가입 버튼 클릭시 input box의 ID, PW, name, age값을 읽어와서 그 값을 프레퍼런스에 저장.
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                error_ID.setText(""); error_PW.setText(""); error_name.setText(""); error_address.setText(""); error_agree.setText(""); //에러메세지 초기화


                //input box의 값 읽어오기
                String userID = editID.getText().toString();
                String userPW = editPW.getText().toString();
                String userName = editName.getText().toString();
                String userAddress = editAddress.getText().toString();
                String userSex = "";
                if(radio_woman.isChecked()) userSex = "woman";


                //아이디에 아무것도 입력 안 했으면 -> 오류 메세지
                if(userID.replace(" ", "").equals("")){
                    error_ID.setText("아이디를 입력해주세요.");
                    return;
                }
                //비밀번호 입력시 6자 미만 -> 오류 메세지
                if(userPW.length() < PWMinLength){
                    error_PW.setText("비밀번호는 6자 이상으로 해주세요.");
                    return;
                }
                //이름에 아무것도 입력 안 했으면 -> 오류 메세지
                if(userName.replace(" ", "").equals("")){
                    error_name.setText("이름을 입력해주세요.");
                    return;
                }
                //국적에 아무것도 입력 안 했으면 -> 오류 메세지
                if(userAddress.replace(" ", "").equals("")){
                    error_address.setText("국적을 입력해주세요.");
                    return;
                }

                //라디오 버튼을 누르지 않았다면 -> 에러창.
                if(!radio_agree.isChecked()){
                    error_agree.setText("개인정보 사용에 동의해주세요.");
                    return;
                }


                //personInfo 프레퍼런스에 ID를 key값으로 하고 나머지 정보는 hashset에 저장.
                SharedPreferences prefs = getSharedPreferences("personInfo", 0);

                //이미 있는 아이디라면
                if(prefs.contains(userID)){
                    error_ID.setText("이미 있는 아이디입니다.");
                }else{
                    // 진짜 저장.
                    SharedPreferences.Editor editor = prefs.edit(); //SharedPreferences의 edit 객체에 값을 저장하기로.
                    Set<String> set = new HashSet<>();
                    set.add("P"+userPW); set.add("N"+userName); set.add("A"+userAddress); set.add("S"+userSex);
                    editor.putStringSet(userID, set);
                    editor.commit();

                    //화면1로 다시 이동.
                    Intent intent = new Intent(getApplicationContext(), FirstActivity.class);
                    startActivity(intent);
                }
            }
        });


    }
}