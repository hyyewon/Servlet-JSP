<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<script>
//비밀번호 확인-DB에 갈 필요 없음
	$(document).ready(function(){
		//비번 일치 여부 확인
		$("#passwd2").on("keyup", function(){
			var passwd = $("#passwd").val(); //input태그니까 val로
			var passwd2 = $("#passwd2").val();
			var mesg = "비번 일치";
			if(passwd!=passwd2){
				mesg = "비번 불일치";
			}
			
				$("#pscheck").text(mesg); //body에 있는 내용은 html이나 text로
		});
		
		//아이디 중복 체크
		$("#idCheck").on("click", function(){
			//submit 비활성
			//button이 form태그 안에 있어서 submit됨 ->ajex로 동작 불가능->submut비활성화를 해줘야 ajex로 동작함
			event.preventDefault();
			//ajex연동
			$.ajax({
                type:"get", //get방식으로 요청
                url:"MemberIdCheckServlet", //button눌렀을 때 해당 주소로 감
                data:{
                	userid:$("#userid").val() //넘겨준 데이터가 해당 주소값으로 parameter로 넘어감
                },  // 요청코드
                dataType:'text',  //받아올 데이터 타입 - MemberIdCheckServlet에서 가져옴
                success:function(data, status, xhr){ //해당 문자열이 데이터에 저장됨
                  console.log(data);
                  $("#result").text(data);  //응답할 데이터
                },
                error:function(xhr, status, error){
                     console.log("error 발생");
                }// 응답코드

             });
			
		});
		
	});
</script>

<form action="MemberAddServlet" method="post"> <!-- 저장해야 하니까 post방식으로 보내줌 -->
*아이디<input type="text" name="userid" id="userid" >
<button id="idCheck">중복확인</button><span id="result"></span><br>
*비밀번호<input type="text" name="passwd" id="passwd" ><br>
*비밀번호확인<input type="text" name="passwd2" id="passwd2" ><span id="pscheck"></span><br>
*이름<input type="text" name="username"><br>

<!-- kakao addressAPI -->
<input type="text" name="post" id="sample4_postcode" placeholder="우편번호" > <!-- name이 없으면 DB로 가져갈 수 없음 -->
<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기" ><br>
<input type="text" name="addr1" id="sample4_roadAddress" placeholder="도로명주소" >
<input type="text" name="addr2" id="sample4_jibunAddress" placeholder="지번주소" >
<span id="guide" style="color:#999"></span>
<br>
<!-- kakao addressAPI -->

전화번호:
<select name="phone1">
<option value="010">010</option>
<option value="011">011</option>
</select>-
<input type="text" name="phone2" >-
<input type="text" name="phone3" ><br>
이메일:
<input type="text" name="email1" >@<input type="text" name="email2" placeholder="직접입력" >
<select name="email2">
<option value="daum">daum.net</option>
<option value="naver">naver.com</option>
<option value="google">google.com</option>
</select>
<br>
<input type="submit" value="회원가입">
<input type="reset" value="취소">

</form>


<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
    //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
    function sample4_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 도로명 조합형 주소 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }
                // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
                if(fullRoadAddr !== ''){
                    fullRoadAddr += extraRoadAddr;
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample4_postcode').value = data.zonecode; //5자리 새우편번호 사용
                document.getElementById('sample4_roadAddress').value = fullRoadAddr;
                document.getElementById('sample4_jibunAddress').value = data.jibunAddress;

                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                if(data.autoRoadAddress) {
                    //예상되는 도로명 주소에 조합형 주소를 추가한다.
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    document.getElementById('guide').innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';

                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    document.getElementById('guide').innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';

                } else {
                    document.getElementById('guide').innerHTML = '';
                }
            }
        }).open();
    }
</script>
