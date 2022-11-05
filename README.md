## 모바일 프로그래밍 개인과제
- 로그인/회원가입 앱 만들기
- 데이터 저장은 프레퍼런스 이용
- 2022년 11월에 만듦. (2학년 2학기)

 </br>
🚀 코드 위치  </br>

- xml 코드 (화면 UI) 는 **app > src > main > res > layout** 안에
- java 코드 (엑티비티) 는 **app > src > main > java/com/example/school_login** 안에 있습니다.


</br>

# 🔔 화면1 설명
로그인 화면
</br> </br> 
## 📌 activity_first.xml (화면 UI)
RelativeLayout을 사용함 </br>
- 아이디, 비밀번호 입력창은 EditText 로 만들고, inputType은 각각 textPersonName, textPassword로 함. </br>
- 로그인, 회원가입, 메인으로 이동 버튼은 Button 으로 만듦. 로그인, 회원가입 버튼을 나란히 배치하기 위해 layout_alignParentLeft를 사용</br>
- 아이디, 비밀번호 입력 오류로 출력될 에러메세지는 TextView로 만듦 (초기화면엔 빈 문자열을 넣고, 잘못된 입력값이 들어왔을 때, text값을 전달해 메세지가 보이도록 구현.) </br>
<image src="https://user-images.githubusercontent.com/84231143/200105720-01052a10-58d8-432c-b857-19727a228c78.JPG" width="15%">  <image src="https://user-images.githubusercontent.com/84231143/200105760-daa1ed29-bf2e-4539-a1c9-eaaf5f1d7345.JPG" width="15%"> 
 
</br> </br> 
## 📌 FirstActivity.java (엑티비티 코드)
activity_first.xml 과 연동하고, xml 파일에서 만들었던 뷰들의 id를 모두 가져옴. 

</br></br>
### ✅ 로그인 버튼 클릭 (입력된 ID, PW가 저장된 값과 동일한지 확인한 후, 화면3으로 이동.) </br>
> ### ID 또는 PW가 입력되지 않았다면 </br>
> - **만약 ID를 입력하지 않았다면**, activity_first.xml의 에러메세지 출력용으로 만들었던 textview에 "아이디를 입력하세요." text값 전달 후 return (종료)</br>
> - **만약 PW를 입력하지 않았다면**, ID와 동일한 방법으로 "비밀번호를 입력하세요." text값 전달 후 return (종료) </br>
<image src="https://user-images.githubusercontent.com/84231143/200105784-54fba9a9-3835-4646-ab4a-88d0b3d17995.JPG" width="15%"> <image src="https://user-images.githubusercontent.com/84231143/200105794-7ace29a9-dbe3-466a-b123-ead6e2919ce8.JPG" width="15%">
  
  </br> </br>
>  ### ID와 PW를 모두 입력했다면 </br>
> "personInfo" 프레퍼런스에 접근해 프레퍼런스 객체를 불러온다. 해당 파일에 입력된 ID값과 동일한 key값이 있는지 확인한다. </br></br>
> <image src="https://user-images.githubusercontent.com/84231143/200106872-3a60a794-21bc-4a53-ab64-4c43372403a5.JPG" width="50%"> </br>
> > #### ⭕ 입력된 ID와 동일한 key값이 있는 경우 </br>
> > 1. 해당 key값의 value로 저장된 hashset 을 불러온 후, 해당 hashset에 저장된 PW, 이름, 주소, 성별 값들을 변수에 담는다. </br>
> > 2. 입력된 PW와 프레퍼런스에 저장되어있던 PW값이 같은지 확인한다 </br>
> > <image src="https://user-images.githubusercontent.com/84231143/200105847-c499111e-ee89-4999-a07a-ac18b7d6cc2f.JPG" width="50%"> </br>
> >
> > > **입력된 PW와 저장된 PW가 같다면**, 로그인 성공이므로 화면3으로 [ID], [이름], [주소], [성별] 값을 전달한 후에, 화면3으로 이동한다. </br>
> > > <image src="https://user-images.githubusercontent.com/84231143/200105863-14795f99-6354-418e-86ce-abc249a26bc6.JPG" width="40%">
> > > </br></br>
> > > **입력된 PW와 저장된 PW가 다르면**, 로그인에 실패한 것이므로 activity_first.xml의 textview에 "비밀번호가 일치하지 않습니다." text값 전달 후 return (종료) </br>
> > > <image src="https://user-images.githubusercontent.com/84231143/200105872-0c9a4eb9-9bc3-4c77-b438-d76a12771779.JPG" width="40%">
> </br></br>
> 
> > #### ❌ 입력된 ID와 동일한 key값이 없는 경우 </br>
> > 해당 아이디로 가입하지 않았다는 것이므로 activity_first.xml의 textview에 "존재하지 않는 아이디입니다." text값 전달 후 return (종료)</br>
> > <image src="https://user-images.githubusercontent.com/84231143/200105893-b43990ad-a37e-4ee0-906d-31fa04c39fcd.JPG" width="40%"> </br>

</br></br>
### ✅ 회원가입 버튼 클릭 (화면 2로 이동) </br>
> <image src="https://user-images.githubusercontent.com/84231143/200105903-16227401-86ca-492a-be2f-071a93895808.JPG" width="40%"></br>


</br></br>
### ✅ 메인으로 이동 버튼 클릭 (화면3으로 이동) </br>
> <image src="https://user-images.githubusercontent.com/84231143/200105912-f4fce9b2-78e4-4ea2-b159-3028664aaf55.JPG" width="40%"> </br>

* * *
</br></br></br>
# 🔔 화면2 설명
회원가입 화면
</br> </br> 
## 📌 activity_second.xml (화면 UI)

LinearLayout을 사용함 </br>
- orientation="vertical" 로 설정해 한 행에 하나씩 뷰들이 채워지도록 함.
- [아이디], [비밀번호], [이름], [국적] 입력창은 EditText 로 만들고, [아이디], [이름], [국적] inputType은 textPersonName로, [비밀번호]의 inputType은 textPassword로 함.
- [성별]은 RadioGroup 안에 RadioButton 2개로 만들었음 (기본으로 여성이 선택되도록 함)
- [개인정보 사용 동의]는 RadioButtom으로 만들었음.
- [회원가입] 버튼은 Button으로 만듦
- 아이디, 비밀번호, 이름, 국적, 개인정보 동의 입력 오류로 출력될 [에러메세지]는 TextView로 만듦. (초기화면엔 빈 문자열을 넣고, 잘못된 입력값이 들어왔을 때, text값을 전달해 메세지가 보이도록 구현)

<image src="https://user-images.githubusercontent.com/84231143/200109509-42b0ff7c-b093-43a1-b13a-6186421dcf4e.png" width="30%">




</br> </br> 
## 📌 SecondActivity.java (엑티비티 코드)
activity_first.xml 과 연동하고 xml 파일에서 만들었던 뷰들의 id를 모두 가져옴. </br>

</br></br>
### ✅ 회원가입 버튼 클릭 (입력된 ID, PW, 이름, 국적값과, 성별 값을 가져온다.)
> ### [ID], [PW], [이름], [국적]에 입력된 값이 없거나, [개인정보 사용 동의] 버튼을 누르지 않았다면 </br> 
> activity_second.xml의 에러메세지 출력용으로 만들었던 각 textview에 오류 메세지를 담은 text값 전달 후 return (종료) </br>
> <image src="https://user-images.githubusercontent.com/84231143/200109814-793fe741-4e27-4bac-80cd-76e39058255d.JPG" width="18%"> <image src="https://user-images.githubusercontent.com/84231143/200109835-2bd29543-d8c7-462e-8c7b-be5c04d7b223.JPG" width="18%"> <image src="https://user-images.githubusercontent.com/84231143/200109826-2838790f-1199-4e84-a440-7be71420212e.JPG" width="18%"> <image src="https://user-images.githubusercontent.com/84231143/200109843-aed022c0-5117-43a4-b4c1-2f212a13f2fa.JPG" width="18%"> <image src="https://user-images.githubusercontent.com/84231143/200109844-4feee345-5a37-4d59-b6f5-c91309e5da13.JPG" width="18%">

</br> </br>
> ### 모든 값이 잘 입력됐다면 </br>
> "personInfo" 프레퍼런스에 접근해 프레퍼런스 객체를 불러온다. 해당 파일에 저장하려는 ID값과 동일한  key값이 있는지 확인한다.</br>
> </br></br>
> > #### ⭕ 입력된 ID와 동일한 key값이 있는 경우 </br> 
> > activity_second.xml의 에러메세지 출력용으로 만들었던 각 textview에 "이미 있는 아이디입니다." text값 전달 후 return (종료) </br></br> 
> <image src="https://user-images.githubusercontent.com/84231143/200110214-1d6d3a32-6e93-420e-94ec-dd352fe55e0f.png" width="70%"> </br> </br>
> > #### ❌ 입력된 ID와 동일한 key값이 없다면 </br>
> > hashset 컨테이너를 만들어, 그 안에 PW, 이름, 주소, 성별 정보를 담는다. (컨테이너가 hashset이므로 값들간에 순서가 없기 때문에 값들을 구분하기 위해 저장할 값 앞에 비밀번호는 "P"를, 이름은 "N"을, 주소는 "A"를, 성별은 "S"를 붙여서 hashset에 저장한다.) </br></br>
> > <image src="https://user-images.githubusercontent.com/84231143/200110458-a7c895f4-0c38-49ff-850e-1bcf025951bf.png" width="70%">  </br></br>
> > 저장 후 화면 1로 이동한다. </br>
> > <image src="https://user-images.githubusercontent.com/84231143/200110477-2e16be94-a26f-481d-800f-151b94d76b62.png" width="40%">

* * *
</br></br></br>
# 🔔 화면3 설명
메인 화면
</br> </br> 
## 📌 activity_third.xml (화면 UI)
GridLayout을 사용함 </br>
- orientation="horizontal"으로 설정해 열을 먼저채우고 다음행으로 넘어가도록 만듦. </br>
- columCount로 2열로 쪼갬.</br>
- 각 이미지의 이름은 TextView로 만들고, 이미지는 ImageView로 만들었음. (이름을 1열에, 이미지를 2열에 배치하고 싶어 layout_row 와 layout_col을 사용함.)
- 회원정보 확인 버튼은 Button으로 만들었음. (6행에 배치했고, layout_columnSpan="2" 으로 설정해, GridLayout의 두개 열을 모두 차지하도록 만듦.) </br>
<image src="https://user-images.githubusercontent.com/84231143/200111324-4bdf4d0c-873e-44c3-b2e7-25970dd7783f.png" width="20%">


</br> </br> 
## 📌 ThirdActivity.java (엑티비티 코드)
activity_tihrd.xml 과 연동하고, xml 파일에서 만들었던 뷰들의 id를 모두 가져옴. 


### ✅ 회원정보 확인 버튼 클릭시
화면3으로 이동하는 방법은 총 2가지가 있음. 화면1에서 [메인으로 이동] 버튼을 누르거나, 화면1에서 [로그인]에 성공한 경우임. </br></br>
<image src="https://user-images.githubusercontent.com/84231143/200111729-b96693a4-9f9a-417c-a391-9257135483ed.png" width="35%">
<image src="https://user-images.githubusercontent.com/84231143/200113349-4d992a25-5a15-4808-ac1d-5f29a8d058ce.png" width="40%"> </br>

-  화면1에서 인텐로 화면3으로 이동할 때, 전달한 user_id를 받는다. (전달받은 user_id가 없다면, 자동으로 null이 저장된다.)
-  팝업창은 AlertDialog으로 구현했다.
</br></br></br>

> ### [메인으로 이동] 버튼으로 온 경우 ("btn_3_userInfo" 변수에 null이 저장됨) </br>
> - "회원가입하시겠습니까?" 는 메세지와 positiveButton과 negativeButton을 담은 팝업창을 띄운다. </br>
> - postiveButton에는 "네" 를, negativeButton에는 "닫기" text를 넣어, "네"를 누르면 화면2로 이동하고, 닫기를 누르면 팝업창이 사라지도록 구현했다. </br>
> <image src="https://user-images.githubusercontent.com/84231143/200111985-29781ead-d7ab-4637-9705-4e0f4b7b8b7f.png" width="60%"> 

</br></br>
> ### [로그인] 버튼으로 온 경우 ("btn_3_userInfo" 변수에 user_id 키의 value값이 저장됨) </br>
> - 화면1로부터 ID값을 받았다면, 이름, 주소, 성별에 대한 값도 같이 전달 됐을 것이다. 각 값을 변수에 담고, 팝업창에 setMessage()로 회원정보를 text로 보여준다. </br>
> - 닫기버튼도 있는데 이는 비회원인 경우와 동일한 코드이다. </br>
> <image src="https://user-images.githubusercontent.com/84231143/200112028-cd2b2d80-ef07-4a18-b08d-57cd80036e07.png" width="40%">


