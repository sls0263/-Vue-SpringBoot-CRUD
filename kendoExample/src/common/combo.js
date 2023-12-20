import axios from 'axios';

// 01 - 근무형태, 02 - 삭제여부 etc..
// num이 1이면 전체, 2면 선택
// 사용예시
// selCombo('01', 1).then((data) => {
//     this.변수명 = data.map(item => ({ value: item.COMM_CD, name: item.COMM_NM }));
// });
export async function selCombo(groupCd, num) {
    try {
        const response = await axios.post('/com/selCombo', { groupCd });
        let data = response.data;

        if (num === 1) {
            data = [
                { COMM_NM: '전체', COMM_CD: '' },
                ...data,
            ];
        } else if (num === 2) {
            data = [
                { COMM_NM: '선택', COMM_CD: '' },
                ...data,
            ];
        }

        //console.log('공통코드 조회:', data);
        return data;
    } catch (error) {
        console.error('공통코드 조회 실패', error);
        throw error;
    }
}