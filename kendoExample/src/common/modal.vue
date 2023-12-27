<!-- modal.vue -->
<template>
    <div class="modal-overlay" v-if="isOpen" @click="closeModal">
      <div class="modal-container" :style="modalStyle">
        <div class="modal-content" @click.stop>
            <slot></slot>
        </div>
      </div>
    </div>
</template>

<script>
export default {
    props: {
      isOpen: {
        type: Boolean,
        required: true,
      },
    },
    computed: {
      modalStyle() {
        if (this.isOpen) {
          const topOffset = window.innerHeight * 0.2;
          return {
            marginTop: `${topOffset}px`,
            zIndex: 9999,
          };
        }
        return {};
      },
    },
    methods: {
      closeModal() {
        this.$emit('close');
      },
    },
};
</script>

<style scoped>
.modal-overlay {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: flex-start;
  overflow-y: auto;
  background: rgba(0, 0, 0, 0.5);
}

.modal-container {
  position: relative;
  background: white;
  padding: 20px;
  border-radius: 8px;
}

.modal-content {
  position: relative;
}

.close-button {
  position: absolute;
  top: 10px;
  right: 10px;
  cursor: pointer;
  background: none;
  border: none;
  font-size: 20px;
  color: #333;
}

.input-group {
  margin-top: 20px;
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
