<template>
  <el-container style="min-height: 100vh;">
    <el-header class="header">
      <div class="title">仓库管理系统</div>
      <el-button type="primary" size="mini" class="logout" @click="logout">退出</el-button>
    </el-header>
    <el-container>
      <el-aside width="220px" class="sidebar">
        <el-menu :default-active="$route.path" router class="menu">
          <el-menu-item index="/warehouses">仓库管理</el-menu-item>
          <el-menu-item index="/products">商品管理</el-menu-item>
          <el-menu-item index="/inbound">入库管理</el-menu-item>
          <el-menu-item index="/outbound">出库管理</el-menu-item>
          <el-menu-item index="/inventory">库存统计</el-menu-item>
        </el-menu>
      </el-aside>
      <el-main class="content">
        <router-view />
      </el-main>
    </el-container>
  </el-container>
</template>

<script setup>
import { useRouter } from 'vue-router'
import { ElMessage } from 'element-plus'

const router = useRouter()

const logout = () => {
  localStorage.removeItem('warehouse-authenticated')
  ElMessage.success('已退出登录')
  router.replace('/login')
}
</script>

<style scoped>
.header {
  background: #409eff;
  color: #ffffff;
  padding: 0 24px;
  display: flex;
  align-items: center;
  justify-content: space-between;
  height: 64px;
  font-size: 18px;
  font-weight: 600;
}
.title {
  line-height: 64px;
}
.sidebar {
  background: #ffffff;
  border-right: 1px solid #ebeef5;
}
.content {
  padding: 24px;
  background: #f5f7fa;
}
.menu {
  height: 100%;
  border-right: none;
}
.logout {
  margin-top: 12px;
}
</style>
