<template>
  <div>
    <div class="page-header">
      <span>出库管理</span>
      <el-button type="primary" @click="openCreate">新增出库</el-button>
    </div>

    <el-table :data="list" stripe style="background: #fff;">
      <el-table-column prop="id" label="ID" width="80" />
      <el-table-column prop="warehouseName" label="仓库" />
      <el-table-column prop="productName" label="商品" />
      <el-table-column prop="quantity" label="数量" width="100" />
      <el-table-column prop="createdAt" label="时间" />
      <el-table-column prop="remark" label="备注" />
      <el-table-column label="操作" width="220">
        <template #default="{ row }">
          <el-button type="primary" size="small" @click="openEdit(row)">编辑</el-button>
          <el-button type="danger" size="small" @click="confirmDelete(row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <el-dialog title="出库记录" :model-value="dialogVisible" width="520px" @close="closeDialog">
      <el-form :model="form" label-width="100px">
        <el-form-item label="仓库">
          <el-select v-model="form.warehouseId" placeholder="选择仓库">
            <el-option v-for="item in warehouses" :key="item.id" :label="item.name" :value="item.id" />
          </el-select>
        </el-form-item>
        <el-form-item label="商品">
          <el-select v-model="form.productId" placeholder="选择商品">
            <el-option v-for="item in products" :key="item.id" :label="item.name" :value="item.id" />
          </el-select>
        </el-form-item>
        <el-form-item label="数量">
          <el-input-number v-model="form.quantity" :min="1" />
        </el-form-item>
        <el-form-item label="备注">
          <el-input v-model="form.remark" />
        </el-form-item>
      </el-form>
      <template #footer>
        <el-button @click="closeDialog">取消</el-button>
        <el-button type="primary" @click="submitForm">保存</el-button>
      </template>
    </el-dialog>
  </div>
</template>

<script setup>
import { ref, reactive, onMounted } from 'vue'
import { ElMessage, ElMessageBox } from 'element-plus'
import { outboundApi, warehouseApi, productApi } from '../api'

const list = ref([])
const warehouses = ref([])
const products = ref([])
const dialogVisible = ref(false)
const isEdit = ref(false)
const currentId = ref(null)
const form = reactive({ warehouseId: null, productId: null, quantity: 1, remark: '' })

const loadData = async () => {
  try {
    warehouses.value = await warehouseApi.list()
    products.value = await productApi.list()
    const records = await outboundApi.list()
    list.value = records.map(item => ({
      ...item,
      warehouseName: getWarehouseName(item.warehouseId),
      productName: getProductName(item.productId)
    }))
  } catch (error) {
    ElMessage.error('加载出库记录失败')
  }
}

const getWarehouseName = warehouseId => {
  const item = warehouses.value.find(i => i.id === warehouseId)
  return item ? item.name : String(warehouseId)
}

const getProductName = productId => {
  const item = products.value.find(i => i.id === productId)
  return item ? item.name : String(productId)
}

const openCreate = () => {
  isEdit.value = false
  currentId.value = null
  form.warehouseId = null
  form.productId = null
  form.quantity = 1
  form.remark = ''
  dialogVisible.value = true
}

const openEdit = row => {
  isEdit.value = true
  currentId.value = row.id
  form.warehouseId = row.warehouseId
  form.productId = row.productId
  form.quantity = row.quantity
  form.remark = row.remark
  dialogVisible.value = true
}

const closeDialog = () => {
  dialogVisible.value = false
}

const submitForm = async () => {
  try {
    const payload = {
      warehouseId: form.warehouseId,
      productId: form.productId,
      quantity: form.quantity,
      remark: form.remark,
      createdAt: new Date().toISOString()
    }

    if (isEdit.value) {
      await outboundApi.update(currentId.value, payload)
      ElMessage.success('出库记录已更新')
    } else {
      await outboundApi.create(payload)
      ElMessage.success('出库记录已创建')
    }
    dialogVisible.value = false
    await loadData()
  } catch (error) {
    ElMessage.error('保存出库记录失败')
  }
}

const confirmDelete = row => {
  ElMessageBox.confirm('确认删除该出库记录吗？', '请确认', { type: 'warning' })
    .then(async () => {
      await outboundApi.remove(row.id)
      ElMessage.success('出库记录已删除')
      await loadData()
    })
    .catch(() => {})
}

onMounted(loadData)
</script>

<style scoped>
.page-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 16px;
}
</style>
