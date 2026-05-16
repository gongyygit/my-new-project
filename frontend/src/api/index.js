import axios from 'axios'

// 所有请求均通过 /api 前缀代理到后端 Spring Boot 服务
const client = axios.create({
  baseURL: '/api',
  timeout: 10000
})

const unwrapResult = response => {
  const result = response.data
  if (result && result.code === 200) {
    return result.data
  }
  const message = result && result.message ? result.message : '请求失败'
  return Promise.reject(new Error(message))
}

client.interceptors.response.use(
  unwrapResult,
  error => {
    const message = error.response?.data?.message || error.message || '网络错误'
    return Promise.reject(new Error(message))
  }
)

export const warehouseApi = {
  list: () => client.get('/warehouses'),
  get: id => client.get(`/warehouses/${id}`),
  create: data => client.post('/warehouses', data),
  update: (id, data) => client.put(`/warehouses/${id}`, data),
  remove: id => client.delete(`/warehouses/${id}`)
}

export const productApi = {
  list: () => client.get('/products'),
  get: id => client.get(`/products/${id}`),
  create: data => client.post('/products', data),
  update: (id, data) => client.put(`/products/${id}`, data),
  remove: id => client.delete(`/products/${id}`)
}

export const inboundApi = {
  list: () => client.get('/inbound'),
  get: id => client.get(`/inbound/${id}`),
  create: data => client.post('/inbound', data),
  update: (id, data) => client.put(`/inbound/${id}`, data),
  remove: id => client.delete(`/inbound/${id}`)
}

export const outboundApi = {
  list: () => client.get('/outbound'),
  get: id => client.get(`/outbound/${id}`),
  create: data => client.post('/outbound', data),
  update: (id, data) => client.put(`/outbound/${id}`, data),
  remove: id => client.delete(`/outbound/${id}`)
}

export const inventoryApi = {
  list: () => client.get('/inventory/statistics')
}
