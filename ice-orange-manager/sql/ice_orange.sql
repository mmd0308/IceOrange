

drop table if exists exp_apis;
create table exp_apis
(
    id          varchar(36)  not null comment '接口主键',
    name        varchar(100) comment '接口名称',
    req_url     varchar(500) not null comment '请求 URL',
    req_method  varchar(10)  not null comment '请求方式',
    description varchar(100) comment '描述',
    remark      varchar(500) comment '备注',
    create_by   varchar(50) comment '创建者',
    create_time datetime comment '创建时间',
    update_by   varchar(50) comment '更新者',
    update_time datetime comment '更新时间',
    primary key (id)
) engine = innodb comment ='API 接口';



drop table if exists exp_date_type;
create table exp_date_type
(
    id          varchar(36) not null comment '数据类型id',
    name        varchar(50) not null comment '数据类型名称',
    category    varchar(50) not null comment '类别（原始的 primitive,结构体 structure)',
    date_type   varchar(300) comment '类型',
    description varchar(100) comment '描述',
    remark      varchar(500) comment '备注',
    create_by   varchar(50) comment '创建者',
    create_time datetime comment '创建时间',
    update_by   varchar(50) comment '更新者',
    update_time datetime comment '更新时间',
    primary key (id)
) engine = innodb comment ='数据类型';

-- ----------------------------
-- 角色和资源关联表  角色1-N菜单
-- ----------------------------
drop table if exists sys_role_res;
create table sys_role_res
(
    id      varchar(36) not null comment '主键',
    role_id varchar(36) not null comment '角色ID',
    res_id  varchar(36) not null comment '资源ID',
    primary key (id)
) engine = innodb comment = '角色和资源关联表';

drop table if exists sys_resources;
create table sys_resources
(
    id          varchar(36) not null comment '菜单ID',
    name        varchar(50) not null comment '菜单名称',
    parent_id   varchar(36) comment '父级ID',
    sort        int(4)       default 0 comment '显示顺序',
    url         varchar(200) default '#' comment '请求地址',
    target      varchar(20) comment '打开方式（menuItem页签 menuBlank新窗口）',
    menu_type   char(1) comment '资源类型（M目录 C菜单 F按钮）',
    permission  varchar(100) default null comment '权限标识',
    icon        varchar(100) default '#' comment '资源图标',
    create_by   varchar(50) comment '创建者',
    create_time datetime comment '创建时间',
    update_by   varchar(50) comment '更新者',
    update_time datetime comment '更新时间',
    remark      varchar(500) comment '备注',
    primary key (id)
) engine = innodb comment = '资源权限表';

-- ----------------------------
-- 用户和角色关联表  用户N-N角色
-- ----------------------------
drop table if exists sys_user_role;
create table sys_user_role
(
    id      varchar(36) not null comment '主键',
    user_id varchar(36) not null comment '用户ID',
    role_id varchar(36) not null comment '角色ID',
    primary key (id)
) engine = innodb comment = '用户和角色关联表';


drop table if exists sys_role;
create table sys_role
(
    id          varchar(36)  not null comment '角色ID',
    name        varchar(30)  not null comment '角色名称',
    permission  varchar(100) not null comment '角色权限字符串',
    sort        int(4)       not null comment '显示顺序',
    status      char(1)      not null comment '角色状态（0正常 1停用）',
    create_by   varchar(50) comment '创建者',
    create_time datetime comment '创建时间',
    update_by   varchar(50) comment '更新者',
    update_time datetime comment '更新时间',
    remark      varchar(500) default null comment '备注',
    primary key (id)
) engine = innodb comment = '角色信息表';




drop table if exists sys_users_groups;
create table sys_users_groups
(
    id          varchar(36)  not null comment 'ID',
    name        varchar(30)  not null comment '用户组名称',
    show_name  varchar(100) not null comment '用户组显示名称',
    sort        int(4)       not null comment '显示顺序',
    create_by   varchar(50) comment '创建者',
    create_time datetime comment '创建时间',
    update_by   varchar(50) comment '更新者',
    update_time datetime comment '更新时间',
    remark      varchar(500) default null comment '备注',
    primary key (id)
) engine = innodb comment = '用户组信息表';



-- ----------------------------
-- 2、用户信息表
-- ----------------------------
drop table if exists sys_user;
create table sys_user
(
    id          varchar(36) not null comment '用户ID',
    user_name   varchar(50) not null comment '登录账号',
    nick_name   varchar(50) comment '用户昵称',
    email       varchar(30) comment '用户邮箱',
    password    varchar(50) comment '密码',
    create_by   varchar(50) comment '创建者',
    create_time datetime comment '创建时间',
    update_by   varchar(50) comment '更新者',
    update_time datetime comment '更新时间',
    remark      varchar(500) default null comment '备注',
    primary key (id)
) engine = innodb comment = '用户信息表';
