package com.example.school_login;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


public class ThirdActivity extends AppCompatActivity {

    private Button btn_3_userInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) { //엑티비티 시작시 처음으로 실행되는 생명주기!
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        Intent IntentFrom1 = getIntent();

        btn_3_userInfo = (Button)findViewById(R.id.btn_userInfo);

        btn_3_userInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userID = IntentFrom1.getStringExtra("user_id");    // 화면1의 로그인 된 ID를 가져오기
                AlertDialog.Builder ad = new AlertDialog.Builder(ThirdActivity.this); //btn_3_userInfo 버튼에 ad를 새로 만든다.

                //비회원인 경우 회원가입 팝업창을 띄운다.(화면2 -> 화면3)
                if(userID == null){

                    ad.setMessage("회원가입하시겠습니까?");

                    //팝업창에 [확인], [닫기] 버튼 구현
                    ad.setPositiveButton("네", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            //화면 2로 이동
                            Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                            startActivity(intent);
                            dialogInterface.dismiss(); //팝업창 닫기
                        }
                    });
                    ad.setNegativeButton("닫기", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();  //팝업창 닫기
                        }
                    });
                    ad.show();
                }
                //(화면1 -> 화면3)
                else{
                    String userName = IntentFrom1.getStringExtra("user_name");    // 화면1의 로그인 된 ID를 가져오기
                    String userAddress = IntentFrom1.getStringExtra("user_address");    // 화면1의 로그인 된 ID를 가져오기
                    String userSex = IntentFrom1.getStringExtra("user_sex");    // 화면1의 로그인 된 ID를 가져오기
                    ad.setMessage("아이디 : " + userID + "\n" + "이름 : " + userName + "\n" + "국적 : " + userAddress + "\n" + "성별 : " + userSex + "\n");

                    ad.setNegativeButton("닫기", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();  //팝업창 닫기
                        }
                    });
                    ad.show();
                }
            }
        });
    }
}






//public class ThirdActivity extends AppCompatActivity {
//    private Button btn_userInfo;
//    private TextView name, id, phone;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_third);
//
//        btn_userInfo = findViewById(R.id.btn_userInfo);
//        id = findViewById(R.id.user_id);
//        name = findViewById(R.id.user_name);
//        phone = findViewById(R.id.user_phone);
//
//
//        //버튼을 눌렀을 때, 만약 회원가입된 상태라면,
//        btn_userInfo.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Intent secondIntent = getIntent();
//                String user_id = secondIntent.getStringExtra("user_id");
//                String user_name = secondIntent.getStringExtra("user_name");
//                String user_phone = secondIntent.getStringExtra("user_phone");
//                boolean has_userInfo = secondIntent.getBooleanExtra("user_id", false);
//
//                //회원정보가 없다면 팝업창에 버튼 만들어서 회원가입 유도
//                if(!has_userInfo) {
//                    btn_userInfo = findViewById(R.id.btn_register);
//
//                    //회원가입하러 가기
//                    btn_userInfo.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View view) {
//                            AlertDialog.Builder ad = new AlertDialog.Builder(ThirdActivity.this);
//                            ad.setIcon(R.mipmap.ic_launcher);
//                            EditText et = new EditText(ThirdActivity.this);
//                            ad.setView(et);
//                            ad.setPositiveButton("네", new DialogInterface.OnClickListener() {
//                                @Override
//                                public void onClick(DialogInterface dialogInterface, int i) {
//                                    Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
//                                    startActivity(intent);
//                                    dialogInterface.dismiss();
//                                }
//                            });
//                            ad.setNegativeButton("아니요", new DialogInterface.OnClickListener() {
//                                @Override
//                                public void onClick(DialogInterface dialogInterface, int i) {
//                                    dialogInterface.dismiss();
//                                }
//                            });
//                            ad.show(); //팝업창 show
//                        }
//                    });
//                    //회원정보가 있다면 -> 회원정보를 팝업창에 보여줌
//
//                }
//            }
//        });
//    }}