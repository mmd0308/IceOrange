export default [
  {
    path: '/user',
    layout: false,
    routes: [
      {
        path: '/user',
        routes: [
          {
            name: 'login',
            path: '/user/login',
            component: './user/Login',
          },
        ],
      },
      {
        component: './404',
      },
    ],
  },
  {
    path: '/welcome',
    name: 'welcome',
    icon: 'smile',
    component: './Welcome',
  },
  {
    path: '/system',
    name: '系统设置',
    icon: 'crown',
    access: 'canAdmin',
    routes: [
      {
        path: '/system/user',
        name: '用户管理',
        icon: 'smile',
        component: './business/system/User',
      },
      {
        path: '/system/role',
        name: '角色管理',
        icon: 'smile',
        component: './business/system/Role',
      },
      {
        path: '/system/menu',
        name: '菜单管理',
        icon: 'smile',
        component: './TableList',
      },
      {
        path: '/system/department',
        name: '部门管理',
        icon: 'smile',
        component: './Welcome',
      },
      {
        path: '/system/dict',
        name: '字典管理',
        icon: 'smile',
        component: './Welcome',
      },
      {
        component: './404',
      },
    ],
  },
  {
    name: 'list.table-list',
    icon: 'table',
    path: '/list',
    component: './TableList',
  },
  {
    path: '/',
    redirect: '/welcome',
  },
  {
    component: './404',
  },
];
