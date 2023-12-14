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
            text: "Grid",
            data: {
              path: "/Grid"
            }
          }
          ,{
            text: "Form",
            data: {
              path: "/Form"
            }
          }
          ,{
            text: "Chart",
            data: {
              path: "/Chart"
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
