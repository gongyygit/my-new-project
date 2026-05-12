import { createRouter, createWebHistory } from 'vue-router'
import Login from '../views/Login.vue'
import MainLayout from '../layouts/MainLayout.vue'
import WarehouseManagement from '../views/WarehouseManagement.vue'
import ProductManagement from '../views/ProductManagement.vue'
import InboundManagement from '../views/InboundManagement.vue'
import OutboundManagement from '../views/OutboundManagement.vue'
import InventoryStatistics from '../views/InventoryStatistics.vue'

const routes = [
  { path: '/login', component: Login },
  {
    path: '/',
    component: MainLayout,
    children: [
      { path: '', redirect: '/warehouses' },
      { path: 'warehouses', component: WarehouseManagement },
      { path: 'products', component: ProductManagement },
      { path: 'inbound', component: InboundManagement },
      { path: 'outbound', component: OutboundManagement },
      { path: 'inventory', component: InventoryStatistics }
    ]
  },
  { path: '/:pathMatch(.*)*', redirect: '/warehouses' }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

const isAuthenticated = () => localStorage.getItem('warehouse-authenticated') === 'true'

router.beforeEach((to, from, next) => {
  if (to.path === '/login' && isAuthenticated()) {
    return next('/warehouses')
  }
  if (to.path !== '/login' && !isAuthenticated()) {
    return next('/login')
  }
  next()
})

export default router
