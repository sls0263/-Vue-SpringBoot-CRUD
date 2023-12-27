<template>
  <div style="max-width: 1440px; min-width: 1040px; margin: 0 auto;">
    <div class="container-fluid">
      <div class="d-flex border-bottom py-2">
        <div class="d-flex justify-content-between flex-grow-1">
          <div>
            <button @click="openDrawer">
              三
            </button>
          </div>
          <div class="project-name d-flex">
            <Drawer :is-open="isDrawerOpen" :speed="500" @close="closeDrawer">
              <div>
                <treelist :data-source="menus"
                          :filterable="true"
                          :sortable="true"
                          :selectable="'row'"
                          @change="handleRowChange">
                  <treelist-column :field="'Name'" :width="50" :title="'메뉴'"></treelist-column>
                </treelist>
              </div>
            </Drawer>
          </div>
          <div>
            <button v-if="!isLoggedIn" @click="openLoginModal">
              로그인
            </button>
            <button v-else @click="logout">
              로그아웃
            </button>
          </div>
        </div>
      </div>
    </div>
  </div>

  <Modal :is-open="isLoginModalOpen" @close="closeLoginModal" style="z-index: 9999;">
  <div class="modal-content">
    <!-- <button class="close-button" @click="closeLoginModal">×</button> -->

    <form @submit.prevent="handleLogin" class="input-group">
      <label for="username" class="label">Username:</label>
      <input type="text" id="username" v-model="username" class="input-field" required>

      <label for="password" class="label">Password:</label>
      <input type="password" id="password" v-model="password" class="input-field" required>

      <button type="submit">로그인</button>
    </form>
  </div>
</Modal>
</template>

<script>
import Drawer from "../common/drawer";
import axios from 'axios';
import { TreeList, TreeListColumn } from '@progress/kendo-treelist-vue-wrapper';
import Modal from "../common/modal.vue";

export default {
  components: {
    Drawer,
    'treelist': TreeList,
    'treelist-column': TreeListColumn,
    Modal,
  },
  data() {
    return {
      menus: [],
      isDrawerOpen: false,
      isLoginModalOpen: false,
      isLoggedIn: false,
      username: '',
      password: '',
    };
  },
  methods: {
    selMenu() {
      // 메뉴 조회
      axios.post(`/com/selMenu`)
        .then(response => {
          this.menus = this.convertData(response.data);
        })
        .catch(error => {
          console.error('Error 조회 실패', error);
        });
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
        if (clickedRowData && clickedRowData.Addr) {
          this.$router.push(clickedRowData.Addr);
        }
      }
    },
    handleLogin() {
      axios.post('/com/selLogin', {
        username: this.username,
        password: this.password,
      })
      .then(response => {
        this.isLoggedIn = true;
        this.closeLoginModal();

        this.selMenu();
      })
      .catch(error => {
        console.error('Login failed', error);
      });
    },
    logout() {
      // Clear the session
      axios.post('/com/logout')
        .then(() => {
          this.isLoggedIn = false;
          this.closeLoginModal();

          // 로그아웃 시 리로드
          location.reload();
        })
        .catch(error => {
          console.error('Logout failed', error);
        });
    },
    openDrawer() {
      this.isDrawerOpen = !this.isDrawerOpen;
    },
    closeDrawer() {
      this.isDrawerOpen = false;
    },
    openLoginModal() {
      this.isLoginModalOpen = !this.isLoginModalOpen;
    },
    closeLoginModal() {
      this.isLoginModalOpen = false;
    },
    mounted() {
      this.selMenu();
    },
  },
};
</script>

<style scoped>
.modal-content {
  position: relative;
}

.input-group {
  margin-top: 20px;
  text-align: right;
}

.label {
  display: block;
  margin-bottom: 5px;
}

.input-field {
  width: 100%;
  padding: 8px;
  box-sizing: border-box;
  margin-bottom: 10px;
}
</style>