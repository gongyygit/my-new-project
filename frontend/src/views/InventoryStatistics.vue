<template>
  <div>
    <div class="page-header">
      <span>库存统计</span>
      <el-button type="primary" @click="loadList">刷新</el-button>
    </div>

    <el-table :data="list" stripe style="background: #fff;">
      <el-table-column prop="productName" label="商品名称" />
      <el-table-column prop="warehouseName" label="仓库" />
      <el-table-column prop="totalIn" label="入库总量" width="120" />
      <el-table-column prop="totalOut" label="出库总量" width="120" />
      <el-table-column prop="available" label="可用库存" width="120" />
    </el-table>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import { ElMessage } from 'element-plus'
import { inventoryApi } from '../api'

const list = ref([])

const loadList = async () => {
  try {
    list.value = await inventoryApi.list()
  } catch (error) {
    ElMessage.error('加载库存统计失败')
  }
}

onMounted(loadList)
</script>

<style scoped>
.page-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 16px;
}
</style>
