<template>
  <a-layout style="min-height: 100vh">
    <a-layout-sider v-model:collapsed="collapsed" collapsible>
      <div class="logo" />
      <a-menu v-model:selectedKeys="selectedKeys" theme="dark" mode="inline">
        <a href="/">
          <a-menu-item key="1">
            <pie-chart-outlined />
            <span>Introduction</span>
          </a-menu-item>
        </a>
        <a href="/table">
          <a-menu-item key="2">
            <pie-chart-outlined />
            <span>Table</span>
          </a-menu-item>
        </a>
      </a-menu>
    </a-layout-sider>
    <a-layout>
      <a-layout-content style="margin: 0 16px">
        <RouterView />
      </a-layout-content>
      <a-layout-footer style="text-align: center">
        Ant Design Vue Demo Created by LireEruel
      </a-layout-footer>
    </a-layout>
  </a-layout>
</template>
<script lang="ts">
import {PieChartOutlined} from '@ant-design/icons-vue';
import {defineComponent, ref} from 'vue';
export default defineComponent({
  components: {
    PieChartOutlined,
  },
  data() {
    return {
      collapsed: ref<boolean>(false),
      selectedKeys: ref<string[]>(['1']),
    };
  },
});
</script>
<style>
/* #components-layout-demo-side .logo {
  height: 32px;
  margin: 16px;
  background: rgba(255, 255, 255, 0.3);
}

.site-layout .site-layout-background {
  background: #fff;
}
[data-theme='dark'] .site-layout .site-layout-background {
  background: #141414;
} */
</style>
