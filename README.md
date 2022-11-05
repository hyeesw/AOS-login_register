모바일 프로그래밍 개인과제

# 🔔 화면1 설명
로그인 화면
</br> </br> 
## 📌 activity_first.xml (화면 UI)
RelativeLayout을 사용함 </br>
- 아이디, 비밀번호 입력창은 EditText 로 만들고, inputType은 각각 textPersonName, textPassword로 함. </br>
- 로그인, 회원가입, 메인으로 이동 버튼은 Button 으로 만듦. 로그인, 회원가입 버튼을 나란히 배치하기 위해 layout_alignParentLeft를 사용</br>
- 아이디, 비밀번호 입력 오류로 출력될 에러메세지는 TextView로 만듦 (초기화면엔 빈 문자열을 넣고, 잘못된 입력값이 들어왔을 때, text값을 전달해 메세지가 보이도록 구현.) </br>
<image src="https://user-images.githubusercontent.com/84231143/200105720-01052a10-58d8-432c-b857-19727a228c78.JPG" width="20%">  <image src="https://user-images.githubusercontent.com/84231143/200105760-daa1ed29-bf2e-4539-a1c9-eaaf5f1d7345.JPG" width="20%"> 
 
</br> </br> 
## 📌 FirstActivity.java (엑티비티 코드)
activity_first.xml 과 연동하고, xml 파일에서 만들었던 뷰들의 id를 모두 가져옴. 

</br></br>
### ✅ 로그인 버튼 클릭 (입력된 ID, PW가 저장된 값과 동일한지 확인한 후, 화면3으로 이동.) </br>
> ## ID 또는 PW가 입력되지 않았다면 </br>
> - **만약 ID를 입력하지 않았다면**, activity_first.xml의 에러메세지 출력용으로 만들었던 textview에 "아이디를 입력하세요." text값 전달 후 return (종료)</br>
> - **만약 PW를 입력하지 않았다면**, ID와 동일한 방법으로 "비밀번호를 입력하세요." text값 전달 후 return (종료) </br>
<image src="https://user-images.githubusercontent.com/84231143/200105784-54fba9a9-3835-4646-ab4a-88d0b3d17995.JPG" width="20%"> <image src="https://user-images.githubusercontent.com/84231143/200105794-7ace29a9-dbe3-466a-b123-ead6e2919ce8.JPG" width="20%">
![personInfo]()

  
  </br> </br>
>  ## ID와 PW를 모두 입력했다면 </br>
> "personInfo" 프레퍼런스에 접근해 프레퍼런스 객체를 불러온다. 해당 파일에 입력된 ID값과 동일한 key값이 있는지 확인한다. </br></br>
> <image src="https://user-images.githubusercontent.com/84231143/200106872-3a60a794-21bc-4a53-ab64-4c43372403a5.JPG" width="70%"> </br>
> > ### ⭕ input ID와 동일한 key값이 있는 경우 </br>
> > 1. 해당 key값의 value로 저장된 hashset 을 불러온 후, 해당 hashset에 저장된 PW, 이름, 주소, 성별 값들을 변수에 담는다. </br>
> > 2. 입력된 PW와 프레퍼런스에 저장되어있던 PW값이 같은지 확인한다 </br>
> > <image src="https://user-images.githubusercontent.com/84231143/200105847-c499111e-ee89-4999-a07a-ac18b7d6cc2f.JPG" width="30%"> </br>
> >
> > > **input PW와 저장된 PW가 같다면**, 로그인 성공이므로 화면3으로 [ID], [이름], [주소], [성별] 값을 전달한 후에, 화면3으로 이동한다. </br>
> > > <image src="https://user-images.githubusercontent.com/84231143/200105863-14795f99-6354-418e-86ce-abc249a26bc6.JPG" width="40%">
> > > </br></br>
> > > **input PW와 저장된 PW가 다르면**, 로그인에 실패한 것이므로 activity_first.xml의 textview에 "비밀번호가 일치하지 않습니다." text값 전달 후 return (종료) </br>
> > > <image src="https://user-images.githubusercontent.com/84231143/200105872-0c9a4eb9-9bc3-4c77-b438-d76a12771779.JPG" width="40%">
> </br></br>
> 
> > ### ❌ input ID와 동일한 key값이 없는 경우 </br>
> > 해당 아이디로 가입하지 않았다는 것이므로 activity_first.xml의 textview에 "존재하지 않는 아이디입니다." text값 전달 후 return (종료)</br>
> > <image src="https://user-images.githubusercontent.com/84231143/200105893-b43990ad-a37e-4ee0-906d-31fa04c39fcd.JPG" width="60%"> </br>

</br></br>
### ✅ 회원가입 버튼 클릭 (화면 2로 이동) </br>
> <image src="https://user-images.githubusercontent.com/84231143/200105903-16227401-86ca-492a-be2f-071a93895808.JPG" width="30%"></br>


</br></br>
### ✅ 메인으로 이동 버튼 클릭 (화면3으로 이동) </br>
> <image src="https://user-images.githubusercontent.com/84231143/200105912-f4fce9b2-78e4-4ea2-b159-3028664aaf55.JPG" width="30%"> </br>
