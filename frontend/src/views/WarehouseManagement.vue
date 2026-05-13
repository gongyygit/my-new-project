<template>
  <div>
    <div class="page-header">
      <span>仓库管理</span>
      <el-button type="primary" @click="openCreate">新增仓库</el-button>
    </div>

    <el-table :data="list" stripe style="background: #fff;">
      <el-table-column prop="id" label="ID" width="80" />
      <el-table-column prop="name" label="仓库名称" />
      <el-table-column prop="location" label="地址" />
      <el-table-column prop="contact" label="联系人" />
      <el-table-column label="操作" width="220">
        <template #default="{ row }">
          <el-button type="primary" size="small" @click="openEdit(row)">编辑</el-button>
          <el-button type="danger" size="small" @click="confirmDelete(row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <el-dialog title="仓库信息" :model-value="dialogVisible" width="520px" @close="closeDialog">
      <el-form :model="form" label-width="100px">
        <el-form-item label="仓库名称">
          <el-input v-model="form.name" />
        </el-form-item>
        <el-form-item label="地址">
          <el-input v-model="form.location" />
        </el-form-item>
        <el-form-item label="联系人">
          <el-input v-model="form.contact" />
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
import { warehouseApi } from '../api'

const list = ref([])
const dialogVisible = ref(false)
const isEdit = ref(false)
const currentId = ref(null)
const form = reactive({ name: '', location: '', contact: '' })

const loadList = async () => {
  try {
    list.value = await warehouseApi.list()
  } catch (error) {
    ElMessage.error('加载仓库列表失败')
  }
}

const openCreate = () => {
  isEdit.value = false
  currentId.value = null
  form.name = ''
  form.location = ''
  form.contact = ''
  dialogVisible.value = true
}

const openEdit = row => {
  isEdit.value = true
  currentId.value = row.id
  form.name = row.name
  form.location = row.location
  form.contact = row.contact
  dialogVisible.value = true
}

const closeDialog = () => {
  dialogVisible.value = false
}

const submitForm = async () => {
  try {
    if (isEdit.value) {
      await warehouseApi.update(currentId.value, { ...form })
      ElMessage.success('仓库已更新')
    } else {
      await warehouseApi.create({ ...form })
      ElMessage.success('仓库已创建')
    }
    dialogVisible.value = false
    await loadList()
  } catch (error) {
    ElMessage.error('保存仓库信息失败')
  }
}

const confirmDelete = row => {
  ElMessageBox.confirm('确认删除该仓库吗？', '请确认', { type: 'warning' })
    .then(async () => {
      try {
        await warehouseApi.remove(row.id)
        ElMessage.success('仓库已删除')
        await loadList()
      } catch (error) {
        ElMessage.error('删除仓库失败')
      }
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
