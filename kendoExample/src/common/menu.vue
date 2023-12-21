<template>
    <div>
        <treelist :data-source="menus"
                  :filterable="true"
                  :sortable="true"
                  :selectable="'row'"
                  @change="handleRowChange">
            <treelist-column :field="'Name'" :width="50" :title="'메뉴'"></treelist-column>
        </treelist>
    </div>
</template>

<script>
import axios from 'axios';
import { TreeList, TreeListColumn } from '@progress/kendo-treelist-vue-wrapper';

export default {
    name: 'App',
    components: {
        'treelist': TreeList,
        'treelist-column': TreeListColumn
    },
    data() {
        return {
            menus: [],
        };
    },
    methods: {
        selMenu() {
        // 메뉴 조회
        axios.get(`/com/selMenu`) 
            .then(response => {
            this.menus = this.convertData(response.data);

            // 메뉴 데이터 확인 필요시 주석 제거
            console.log("this.menus"+JSON.stringify(this.menus, null, 2));
            })
            .catch(error => {
            console.error('Error 조회 실패', error);
            })
        },
        convertData(input) {
            return input.map(item => ({
                id: item.MENU_ID,
                parentId: item.PARENT_MENU_ID || null,
                Name: item.MENU_NM,
                Addr: item.MENU_ADDR,
            }));
        },
        handleRowChange(e) {
            const selectedRows = e.sender.select();
            if (selectedRows.length > 0) {
                const clickedRowData = e.sender.dataItem(selectedRows[0]);

                // Log the clicked row data
                console.log("Clicked Row Data:", clickedRowData);

                // Now you can use the clickedRowData object as needed
                if (clickedRowData && clickedRowData.Addr) {
                    this.$router.push(clickedRowData.Addr);
                }
            }
        },
    },
    mounted() {
        this.selMenu();
    },
}
</script>
