/** 
* FILE NAME   : combo.js
* DESCRIPTION : 콤보박스 공통 조회
* DATASET     : groupCd 01 - 근무형태, 02 - 삭제여부 etc..
                num 1 - 전체, 2 - 선택
* EXAMPLE     : selCombo('01', 1).then((data) => {
                    this.변수명 = data.map(item => ({ value: item.COMM_CD, name: item.COMM_NM }));
                }); 
*/
import axios from 'axios';

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

        return data;
    } catch (error) {
        console.error('콤보박스 조회 실패', error);
        throw error;
    }
}
