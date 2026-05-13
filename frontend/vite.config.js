import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

export default defineConfig({
  // 启用 Vue 插件以支持 Vue 单文件组件
  plugins: [vue()],
  server: {
    proxy: {
      '/api': {
        // 开发时将 /api 请求代理到本地后端服务
        target: 'http://localhost:8080',
        changeOrigin: true,
        rewrite: path => path.replace(/^\/api/, '/api')
      }
    }
  }
})
