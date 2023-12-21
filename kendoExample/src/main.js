import { createApp } from 'vue'
import App from './App.vue'
import router from './router';

import '@progress/kendo-ui';
import '@progress/kendo-theme-default/dist/all.css';
import { TreeList, TreeListColumn } from '@progress/kendo-treelist-vue-wrapper';

const app = createApp(App);
app.component('treelist', TreeList);
app.component('treelist-column', TreeListColumn);
app.use(router);
app.mount('#app');