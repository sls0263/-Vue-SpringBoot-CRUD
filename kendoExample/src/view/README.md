<h2>[Vue + SpringBoot] 직원정보 페이지 CRUD</h2>
<img src="https://github.com/sls0263/Vue-SpringBoot-CRUD/assets/107562213/613ba115-ce11-498e-a7c2-2da86c20a490">
<p>vue 공통코드 위치 : kendoExample/src/common</p>
<p>백앤드 파일 위치: backend/src/main/java/com/backend/vue/</p>
<p>mapper 파일 위치: backend/src/main/resources/mapper/</p>
<br/>
<h3>화면 설명</h3>
<p>- 화면오픈시 바로 조회</p>
<p>- 조회조건에 따라 직원목록이 다르게 조회됨</p>
<p>- 직원목록 row 클릭 시 그 직원번호에 맞게 직원 정보 setting</p>
<p>- 선택 컬럼의 체크박스가 체크된 것만 삭제(여러개 선택 시 여러개 삭제)</p>
<p>- 신규 누르면 직원이름, 휴대폰번호, 이메일, 퇴사일자, 근무형태, 삭제여부는 초기화되고, 입사일자는 오늘날짜로 설정됨</p>
<p>- 신규 저장 시 직원번호는 백앤드에서 처리(E+이번년도+4자리/ex. E20230001) / 마지막 4자리숫자는 디비에 저장된 마지막 숫자 + 1</p>
<p>- 저장 눌렀을 때 직원번호가 있으면 update 없으면 insert됨</p>
