<script setup lang="ts">
import CurrentPageDataTable from '../components/tables/CurrentPageDataTable.vue';
</script>

<template>
  <div class="container">
    <a-typography>
      <a-typography-title>AntD Table</a-typography-title>
      <a-typography-title :level="3"> When To Use </a-typography-title>
      <ul>
        <li>To display a collection of structured data.</li>
        <li>To sort, search, paginate, filter data.</li>
      </ul>
    </a-typography>
    <CurrentPageDataTable />
  </div>
</template>

<style>
@media (min-width: 1024px) {
  .container {
    min-height: 100vh;
    padding: 2%;
  }
}
</style>
