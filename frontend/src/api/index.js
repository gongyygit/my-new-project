import axios from 'axios'

const client = axios.create({
  baseURL: '/api',
  timeout: 10000
})

const getData = response => response.data

export const warehouseApi = {
  list: () => client.get('/warehouses').then(getData),
  get: id => client.get(`/warehouses/${id}`).then(getData),
  create: data => client.post('/warehouses', data).then(getData),
  update: (id, data) => client.put(`/warehouses/${id}`, data).then(getData),
  remove: id => client.delete(`/warehouses/${id}`)
}

export const productApi = {
  list: () => client.get('/products').then(getData),
  get: id => client.get(`/products/${id}`).then(getData),
  create: data => client.post('/products', data).then(getData),
  update: (id, data) => client.put(`/products/${id}`, data).then(getData),
  remove: id => client.delete(`/products/${id}`)
}

export const inboundApi = {
  list: () => client.get('/inbound').then(getData),
  get: id => client.get(`/inbound/${id}`).then(getData),
  create: data => client.post('/inbound', data).then(getData),
  update: (id, data) => client.put(`/inbound/${id}`, data).then(getData),
  remove: id => client.delete(`/inbound/${id}`)
}

export const outboundApi = {
  list: () => client.get('/outbound').then(getData),
  get: id => client.get(`/outbound/${id}`).then(getData),
  create: data => client.post('/outbound', data).then(getData),
  update: (id, data) => client.put(`/outbound/${id}`, data).then(getData),
  remove: id => client.delete(`/outbound/${id}`)
}

export const inventoryApi = {
  list: () => client.get('/inventory/statistics').then(getData)
}
