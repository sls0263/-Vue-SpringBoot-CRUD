<template>
    <kendo-menu :items="items" @select="onSelect" />
</template>
<script>
import { Menu } from "@progress/kendo-vue-layout";

export default {
    components: {
       'kendo-menu': Menu
    },
    data() {
      return {
        items: [
          {
            text: "Home",
            data: {
              path: "/"
            }
          }
          ,{
            text: "EmployInfo",
            data: {
              path: "/EmployInfo"
            }
          }
        ]
      };
    },
    methods: {
      onSelect(e) {
        this.$router.push(e.item.data);
      }
    }
}
</script>
