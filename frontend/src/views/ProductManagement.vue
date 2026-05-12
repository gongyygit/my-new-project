<template>
  <div>
    <div class="page-header">
      <span>商品管理</span>
      <el-button type="primary" @click="openCreate">新增商品</el-button>
    </div>

    <el-table :data="list" stripe style="background: #fff;">
      <el-table-column prop="id" label="ID" width="80" />
      <el-table-column prop="sku" label="SKU" />
      <el-table-column prop="name" label="商品名称" />
      <el-table-column prop="unit" label="单位" width="100" />
      <el-table-column prop="quantity" label="库存" width="100" />
      <el-table-column label="仓库" width="180">
        <template #default="{ row }">{{ getWarehouseName(row.warehouseId) }}</template>
      </el-table-column>
      <el-table-column label="操作" width="220">
        <template #default="{ row }">
          <el-button type="primary" size="small" @click="openEdit(row)">编辑</el-button>
          <el-button type="danger" size="small" @click="confirmDelete(row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <el-dialog title="商品信息" :model-value="dialogVisible" width="520px" @close="closeDialog">
      <el-form :model="form" label-width="100px">
        <el-form-item label="SKU">
          <el-input v-model="form.sku" />
        </el-form-item>
        <el-form-item label="商品名称">
          <el-input v-model="form.name" />
        </el-form-item>
        <el-form-item label="单位">
          <el-input v-model="form.unit" />
        </el-form-item>
        <el-form-item label="数量">
          <el-input-number v-model="form.quantity" :min="0" />
        </el-form-item>
        <el-form-item label="仓库">
          <el-select v-model="form.warehouseId" placeholder="选择仓库">
            <el-option v-for="item in warehouses" :key="item.id" :label="item.name" :value="item.id" />
          </el-select>
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
import { productApi, warehouseApi } from '../api'

const list = ref([])
const warehouses = ref([])
const dialogVisible = ref(false)
const isEdit = ref(false)
const currentId = ref(null)
const form = reactive({ warehouseId: null, sku: '', name: '', unit: '', quantity: 0 })

const loadList = async () => {
  try {
    list.value = await productApi.list()
    warehouses.value = await warehouseApi.list()
  } catch (error) {
    ElMessage.error('加载商品或仓库列表失败')
  }
}

const getWarehouseName = warehouseId => {
  const item = warehouses.value.find(i => i.id === warehouseId)
  return item ? item.name : '-'
}

const openCreate = () => {
  isEdit.value = false
  currentId.value = null
  form.warehouseId = null
  form.sku = ''
  form.name = ''
  form.unit = ''
  form.quantity = 0
  dialogVisible.value = true
}

const openEdit = row => {
  isEdit.value = true
  currentId.value = row.id
  form.warehouseId = row.warehouseId
  form.sku = row.sku
  form.name = row.name
  form.unit = row.unit
  form.quantity = row.quantity
  dialogVisible.value = true
}

const closeDialog = () => {
  dialogVisible.value = false
}

const submitForm = async () => {
  try {
    if (isEdit.value) {
      await productApi.update(currentId.value, { ...form })
      ElMessage.success('商品已更新')
    } else {
      await productApi.create({ ...form })
      ElMessage.success('商品已创建')
    }
    dialogVisible.value = false
    await loadList()
  } catch (error) {
    ElMessage.error('保存商品信息失败')
  }
}

const confirmDelete = row => {
  ElMessageBox.confirm('确认删除该商品吗？', '请确认', { type: 'warning' })
    .then(async () => {
      await productApi.remove(row.id)
      ElMessage.success('商品已删除')
      await loadList()
    })
    .catch(() => {})
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
