<template>
  <div class="login-page">
    <el-card class="login-card">
      <div class="login-title">仓库管理系统登录</div>
      <el-form :model="form" :rules="rules" ref="loginForm" status-icon>
        <el-form-item prop="username">
          <el-input v-model="form.username" placeholder="用户名" autocomplete="username" />
        </el-form-item>
        <el-form-item prop="password">
          <el-input v-model="form.password" placeholder="密码" show-password autocomplete="current-password" />
        </el-form-item>
        <el-form-item>
          <el-button type="primary" class="login-button" @click="submitLogin">登录</el-button>
        </el-form-item>
      </el-form>
    </el-card>
  </div>
</template>

<script setup>
import { reactive, ref } from 'vue'
import { useRouter } from 'vue-router'
import { ElMessage } from 'element-plus'

const router = useRouter()
const loginForm = ref(null)
const form = reactive({ username: '', password: '' })
const rules = {
  username: [
    { required: true, message: '请输入用户名', trigger: 'blur' }
  ],
  password: [
    { required: true, message: '请输入密码', trigger: 'blur' }
  ]
}

const submitLogin = () => {
  loginForm.value.validate(valid => {
    if (!valid) {
      return
    }
    if (form.username === 'admin' && form.password === '123456') {
      localStorage.setItem('warehouse-authenticated', 'true')
      router.replace('/warehouses')
      ElMessage.success('登录成功')
    } else {
      ElMessage.error('用户名或密码错误')
    }
  })
}
</script>

<style scoped>
.login-page {
  min-height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
  background: #f5f7fa;
}

.login-card {
  width: 380px;
  padding: 32px;
}

.login-title {
  text-align: center;
  font-size: 20px;
  font-weight: 600;
  margin-bottom: 24px;
}

.login-button {
  width: 100%;
}
</style>
