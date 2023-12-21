<script setup>
import Datepicker from 'vue3-datepicker'
</script>

<template>
  <div style="max-width: 1440px; min-width: 1040px; margin: 0 auto;">
  <div class="buttons-container">
    <!-- 조회, 신규, 삭제, 저장 버튼 -->
    <button @click="selEmployee(this.selUser)">조회</button>
    <button @click="addNewEmployee">신규</button>
    <button @click="deleteEmployee">삭제</button>
    <button @click="saveEmployee(this.userDetail)">저장</button>
  </div>
  <!-- 조회조건 -->
  <div style="width: 100%;">
    <table class="table" id="employeeInfo">
      <thead>
          <th>직원번호</th>
          <td><input type="text" v-model="selUser.DEPLOY_NO"/></td>
          <th>직원이름</th>
          <td><input type="text" v-model="selUser.DEPLOY_NM"/></td>
          <th>휴대폰번호</th>
          <td><input type="text" v-model="selUser.HP_NO"/></td>
          <th>입사일자</th>
          <td><input type="text" v-model="selUser.ENTR_DT"/></td>
      </thead>
      <tbody>
        <th>근무형태</th>
        <td><select v-model="selUser.WRK_TYP_CD">
                <option 
                  v-for="item in selWrkTyp"
                  :key="item.value"
                  :value="item.value"
                >{{ item.name }}</option>
            </select></td>
        <th>삭제여부</th>
        <td><select v-model="selUser.DEL_YN">
                <option 
                  v-for="item in selDelYn"
                  :key="item.value"
                  :value="item.value"
                >{{ item.name }}</option>
            </select></td>
      </tbody>
    </table>
  </div>
  <br/>
  <div>

  <!-- 직원목록 테이블 -->
  <div id="app" style="width: 33%; float: left;">
    <p style="font-weight: bold;">직원목록</p>
    <table class="table">
      <thead>
        <tr>
          <th>No</th>
          <th>직원번호</th>
          <th>이름</th>
          <th>입사일자</th>
          <th>삭제</th>
        </tr>
      </thead>
      <tbody style="text-align: center;">
        <!-- computed 속성값 데이터 사용해서 데이터 표시 -->
        <tr v-for="(user,idx) in displayedItems" :key="user.DEPLOY_NO" @click="selectRow(user.DEPLOY_NO)">
          <td>{{ idx+1 }}</td>
          <td>{{ user.DEPLOY_NO }}</td>
          <td>{{ user.DEPLOY_NM }}</td>
          <td>{{ user.ENTR_DT }}</td>
          <td style="text-align: center;"><input type="checkbox" v-model="user.selected" /></td>
        </tr>
      </tbody>
    </table>
  </div>

  <!-- 직원정보 테이블 -->
  <div id="app" style="width: 62%; float: right;">
    <p style="font-weight: bold;">직원정보</p>
    <table class="table" id="employeeInfo">
      <thead>
        <tr v-for="(user,idx) in userDetail" :key="user.DEPLOY_NO">
          <th>직원번호</th>
          <td>{{user.DEPLOY_NO}}</td>
          <th>직원이름</th>
          <td><input type="text" v-model="user.DEPLOY_NM" placeholder="이름을 입력하세요."/></td>
        </tr>
      </thead>
      <tbody>
        <tr v-for="user in userDetail" :key="user.DEPLOY_NO">
          <th>휴대폰번호</th>
          <td><input type="text" v-model="user.HP_NO" placeholder="ex)01012345678"/></td>
          <th>이메일</th>
          <td><input type="text" v-model="user.EMAIL" placeholder="ex)abc123@gmail.com"/></td>
        </tr>
        <tr v-for="user in userDetail" :key="user.DEPLOY_NO">
          <th>입사일자</th> <!--user.ENTR_DT-->
          <td><Datepicker 
                v-model="picked" 
                :locale="ko"
                :inputFormat="'yyyy-MM-dd'"
              /></td>
          <th>퇴사일자</th> <!--user.RETR_DT-->
          <td><Datepicker 
                v-model="picked_RETR"
                :locale="ko"
                :inputFormat="'yyyy-MM-dd'"
                :clearable="true"
              /></td>
        </tr>
        <tr v-for="user in userDetail" :key="user.DEPLOY_NO">
          <th>근무형태</th>
          <td>
            <select v-model="user.WRK_TYP_CD">
              <option 
                v-for="item in selWrkTypD"
                :key="item.value"
                :value="item.value"
              >{{ item.name }}</option>
            </select>
          </td>
          <th>삭제여부</th>
          <td>
            <select v-model="user.DEL_YN">
              <option 
                v-for="item in selDelYnD"
                :key="item.value"
                :value="item.value"
              >{{ item.name }}</option>
            </select>
          </td>
        </tr>
        <tr v-for="user in userDetail" :key="user.DEPLOY_NO">
          <th>등록자</th>
          <td>{{ user.IP_IPUT_PRSN }}</td>
          <th>등록일시</th>
          <td>{{ user.DNT_IPUT }}</td>
        </tr>
        <tr v-for="user in userDetail" :key="user.DEPLOY_NO">
          <th>수정자</th>
          <td>{{ user.ID_CHG_PRSN }}</td>
          <th>수정일시</th>
          <td>{{ user.IP_CHG_PRSN }}</td>
        </tr>
      </tbody>
    </table>
  </div>
  </div>
</div>
</template>
  
<script>
import axios from 'axios';
import Datepicker from 'vue3-datepicker';
import { ref, toRef } from 'vue';
import { ko } from 'date-fns/locale';
import { format } from 'date-fns';
import { selCombo } from '../common/combo.js';
import dayjs from "dayjs";

// 오늘날짜 설정
let picked = ref(format(new Date(), 'yyyyMMdd'));
let picked_RETR = ref(null);

export default {
  data() {
    return {
      users: [],          // 직원목록
      userDetail: [],     // 직원정보
      selUser: {          // 조회조건
        DEPLOY_NO: '',
        DEPLOY_NM: '',
        HP_NO: '',
        ENTR_DT: '',
        WRK_TYP_CD: '',
        DEL_YN: ''
      },
      selDelYn: [],       // 삭제여부
      selWrkTyp: [],      // 근무형태
      selDelYnD: [],      // 직원정보의 삭제여부
      selWrkTypD: [],     // 직원정보의 근무형태
    };
  },
  components: {
    Datepicker,
  },
  //데이터를 기반으로 변경할 속성	
  computed: {
    displayedItems() {
      return this.users; 
    } ,
  },
  methods: {
    fetchData() {
      // 직원목록 테이블 데이터 조회
      this.selEmployee(this.selUser);
    },
    selEmployee(selUser) {
      // 화면 오픈시/조회 버튼 클릭 시 조회
      axios.post(`/grid/selEcoGridList`, selUser) 
        .then(response => {
          this.users = response.data;

          // 조회조건 데이터 확인 필요시 주석 제거
          //console.log("this.selUser"+JSON.stringify(selUser, null, 2));
        })
        .catch(error => {
          console.error('Error 조회 실패', error);
        })
    },
    selectRow(rowId) {
      // 직원정보 테이블 데이터 조회
      axios.post(`/grid/selEcoGridDetail`, {rowId})
        .then((response) => {
          this.userDetail = response.data;

          // 직원 정보 테이블 데이터 확인 필요 시 주석 제거
          //console.log("this.userDetail = "+JSON.stringify(this.userDetail,null,2));

          // 근무형태, 삭제여부 데이터 없을 시 ''처리
          if (response.data.length > 0) {
            if (!response.data[0].WRK_TYP_CD) {
              response.data[0].WRK_TYP_CD = '';
            }

            if (!response.data[0].DEL_YN) {
              response.data[0].DEL_YN = '';
            }
          }

          //입사일
          if (response.data.length > 0 && response.data[0].ENTR_DT) {
            // 조회된 날짜로 셋팅
            picked.value = new Date(response.data[0].ENTR_DT);
          } else {
            // 오늘 날짜로 셋팅
            picked = ref(new Date());
          }
          
          //퇴사일
          if (response.data.length > 0 && response.data[0].RETR_DT) {
            // 조회된 날짜로 셋팅
            picked_RETR.value = new Date(response.data[0].RETR_DT);
          } else {
            // 공백으로 셋팅
            picked_RETR.value = null;
          }

          // groupCd 01 = 근무형태 / 2 = 선택
          selCombo('01', 2).then((data) => {
            this.selWrkTypD = data.map(item => ({ value: item.COMM_CD, name: item.COMM_NM }));
          });

          // groupCd 02 = 삭제여부 / 2 = 선택
          selCombo('02', 2).then((data) => {
            this.selDelYnD = data.map(item => ({ value: item.COMM_CD, name: item.COMM_NM }));
          });
        })
        .catch ((error) => {
          console.error('Error 직원정보 테이블 데이터', error);
        })
    },
    addNewEmployee() {
      // 신규 버튼 클릭 시 오른쪽 테이블 초기화

      // 직원번호 백앤드 처리로 변경
      // const lastEmployee = this.users[this.users.length - 1];
      // const newDeployNo = lastEmployee ? Number(lastEmployee.DEPLOY_NO)+1 : 1;

      picked = ref(new Date());
      picked_RETR = ref(null);

      this.userDetail = [{
        DEPLOY_NO: '', //newDeployNo,
        DEPLOY_NM: '',
        HP_NO: '',
        EMAIL: '',
        ENTR_DT: picked,
        RETR_DT: picked_RETR,
        WRK_TYP_CD: '',
        DEL_YN: '',
        IP_IPUT_PRSN: '',
        DNT_IPUT: '',
        ID_CHG_PRSN: '',
        IP_CHG_PRSN: '',
      }];
    },
    saveEmployee(userDetail) {
      // 저장 버튼 클릭 시 저장
      // 필수 값 체크
      if (!userDetail[0].DEPLOY_NM) {
        alert("직원이름을 입력해주세요.");
        return;
      }
      if (!userDetail[0].ENTR_DT) {
        alert("입사일자를 입력해주세요.");
        return;
      }

      // 날짜 데이터 set
      userDetail[0].ENTR_DT = dayjs(picked.value).format('YYYY-MM-DD');
      userDetail[0].RETR_DT = dayjs(picked_RETR ? picked_RETR.value : '').format('YYYY-MM-DD');

      // 데이터 확인 필요시 주석 제거 후 시도
      //console.log("userDetail = "+JSON.stringify(userDetail, null, 2));

      axios.post(`/grid/saveEcoGrid`, userDetail)
        .then(response => {
          console.log('변경된 정보 저장 성공:', response.data);
          alert("저장되었습니다.");
          // 저장 후 직원목록 조회
          this.selEmployee(this.selUser);
        })
        .catch(error => {
          console.error('변경된 정보 저장 실패', error);
        });
    },
    deleteEmployee() {
      // 삭제 버튼 클릭 시 삭제
      // 체크박스 선택 된 row
      const selectedUsers = this.users.filter(user => user.selected);

      if (selectedUsers.length === 0) {
        alert("선택된 직원이 없습니다.");
        return;
      }

      // 체크박스 체크된 직원번호
      const deployNo = selectedUsers.map(user => user.DEPLOY_NO);
      console.log("deployNo = "+deployNo);

      // 사용자에게 삭제 여부 확인
      const confirmMessage = `선택된 직원(${deployNo.join(', ')})을 삭제하시겠습니까?`;

      if (confirm(confirmMessage)) {
        // 사용자가 확인을 눌렀을 때 선택된 직원 삭제 로직 실행
        axios.post('/grid/delEcoGridDetail', deployNo)
          .then(response => {
            alert(`선택된 직원(${deployNo.join(', ')})이 삭제되었습니다.`);

            // 직원목록 조회
            this.selEmployee(this.selUser);
          })
          .catch(error => {
            console.error('Error 삭제 실패', error);
          });
      }
    },
  },
  mounted() { 
    //DOM 최초 로드 후 서버에서 데이터 조회
    this.fetchData();

    // groupCd 01 = 근무형태 / 1 = 전체
    selCombo('01', 1).then((data) => {
      this.selWrkTyp = data.map(item => ({ value: item.COMM_CD, name: item.COMM_NM }));
    });

    // groupCd 02 = 삭제여부 / 1 = 전체
    selCombo('02', 1).then((data) => {
      this.selDelYn = data.map(item => ({ value: item.COMM_CD, name: item.COMM_NM }));
    });
  },
};
</script>

<style>
  th {background-color: lightsteelblue; border: 1px solid rgb(214, 214, 214); text-align: center; padding: 7px;}
  table {margin-left: auto; margin-right: auto; width: 100%; border: 1px solid rgb(192, 192, 192);}
  tr {border: 1px solid rgb(192, 192, 192); padding: 7px;}
  td {border: 1px solid rgb(192, 192, 192); padding: 7px;}
/* 추가적인 스타일은 필요에 따라 적용합니다. */

  .buttons-container {
    margin-bottom: 10px; /* 버튼과 테이블 사이에 간격 추가 */
    display: flex; 
    justify-content: flex-end;
  }

  .buttons-container button {
    margin-left: 10px; /* 버튼 간격 조절 */
    border: 1px solid rgb(80, 80, 80);
    border-radius: 5px;
  }

  html {background-color: rgb(233, 233, 233);}
</style>
