<template>
  <a-layout style="min-height: 100vh">
    <a-layout-sider v-model:collapsed="collapsed" collapsible>
      <a-menu :selectedKeys="selectedKeys" theme="dark" mode="inline">
        <a-menu-item key="home">
          <a href="/">
            <home-outlined />
            <span>Introduction</span>
          </a>
        </a-menu-item>
        <a-menu-item key="table">
          <a href="/table">
            <pie-chart-outlined />
            <span>Table</span>
          </a>
        </a-menu-item>
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
<script lang="ts" setup>
import {PieChartOutlined, HomeOutlined} from '@ant-design/icons-vue';
import {onMounted, ref} from 'vue';
import {useRoute} from 'vue-router';

const collapsed = ref<boolean>(false);

const selectedKeys = ref<string[]>(['home']);
onMounted(() => {
  const route = useRoute();
  console.log(route.hash, route.path, route.name);
});
</script>
<style>
#components-layout-demo-side .logo {
  height: 32px;
  margin: 16px;
  background: rgba(255, 255, 255, 0.3);
}

.site-layout .site-layout-background {
  background: #fff;
}
[data-theme='dark'] .site-layout .site-layout-background {
  background: #141414;
}
</style>
