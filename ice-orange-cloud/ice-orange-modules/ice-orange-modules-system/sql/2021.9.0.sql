CREATE SCHEMA `ice_orange_modules_system` DEFAULT CHARACTER SET utf8mb4 ;

-- ----------------------------
-- 部门信息表
-- ----------------------------
USE ice_orange_modules_system;
DROP TABLE if EXISTS sys_department;
CREATE TABLE `sys_department` (
    `id`                    varchar(32)         NOT NULL                    COMMENT '表的主键',
    `name`                  varchar(255)        NOT NULL DEFAULT ''         COMMENT '名称',
    `parent_id`             varchar(32)         NOT NULL DEFAULT '0'        COMMENT '父级id,根节点的id为0',
    `sort`                  int(4)              DEFAULT 0                   COMMENT '显示顺序',
    `del_flag`              char(1)             DEFAULT '0'                 COMMENT '删除标志（0:存在 1:删除）',
    `created_by`            varchar(45)         DEFAULT NULL                COMMENT '创建人',
    `created_at`            bigint(20)          DEFAULT NULL                COMMENT '创建时间',
    `updated_by`            varchar(45)         DEFAULT NULL                COMMENT '更新人',
    `updated_at`            bigint(20)          DEFAULT NULL                COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='部门表';

-- ----------------------------
-- 用户信息表
-- ----------------------------
USE ice_orange_modules_system;
DROP TABLE if EXISTS sys_user;
CREATE TABLE `sys_user` (
    `id`                    varchar(32)         NOT NULL                    COMMENT '表的主键',
    `dept_id`               varchar(32)         DEFAULT NULL                COMMENT '部门ID',
    `account`               varchar(45)         NOT NULL                    COMMENT '用户账号',
    `name`                  varchar(45)         NOT NULL                    COMMENT '用户昵称',
    `email`                 varchar(45)         DEFAULT NULL                COMMENT '邮箱',
    `sex`                   char(1)             DEFAULT NULL                COMMENT '用户性别（0男 1女 2未知）',
    `password`              varchar(256)        DEFAULT NULL                COMMENT '密码',
    `remark`                varchar(256)        DEFAULT NULL                COMMENT '备注',
    `del_flag`              char(1)             DEFAULT '0'                 COMMENT '删除标志（0:存在 1:删除）',
    `created_by`            varchar(45)         DEFAULT NULL                COMMENT '创建人',
    `created_at`            bigint(20)          DEFAULT NULL                COMMENT '创建时间',
    `updated_by`            varchar(45)         DEFAULT NULL                COMMENT '更新人',
    `updated_at`            bigint(20)          DEFAULT NULL                COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户信息表';

-- ----------------------------
-- 角色信息表
-- ----------------------------
USE ice_orange_modules_system;
DROP TABLE if EXISTS sys_role;
CREATE TABLE sys_role (
    `id`                    varchar(32)         NOT NULL                    COMMENT '表的主键',
    `name`                  varchar(30)         NOT NULL                    COMMENT '角色名称',
    `permission`            varchar(100)        NOT NULL                    COMMENT '权限编码',
    `sort`                  int(4)              DEFAULT 0                   COMMENT '显示顺序',
    `data_scope`            char(1)             DEFAULT '0'                 COMMENT '数据范围（0：全部数据权限 1：自定数据权限 2：本部门数据权限 3：本部门及以下数据权限）',
    `status`                char(1)             DEFAULT '0'                 COMMENT '角色状态（0:正常 1:停用）',
    `role_type`             char(1)             DEFAULT '1'                 COMMENT '角色类型（0:预置 1:自定义）',
    `remark`                varchar(256)        DEFAULT NULL                COMMENT '备注',
    `del_flag`              char(1)             DEFAULT '0'                 COMMENT '删除标志（0:存在 1:删除）',
    `created_by`            varchar(45)         DEFAULT NULL                COMMENT '创建人',
    `created_at`            bigint(20)          DEFAULT NULL                COMMENT '创建时间',
    `updated_by`            varchar(45)         DEFAULT NULL                COMMENT '更新人',
    `updated_at`            bigint(20)          DEFAULT NULL                COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色信息表';

-- ----------------------------
-- 系统访问记录
-- ----------------------------
USE ice_orange_modules_system;
DROP TABLE if EXISTS sys_login_log;
CREATE TABLE sys_login_log (
    `id`                    varchar(32)         NOT NULL                    COMMENT '表的主键',
    `account`               varchar(50)         DEFAULT ''                  COMMENT '用户账号',
    `ip`                    varchar(128)        DEFAULT ''                  COMMENT '登录IP地址',
    `status`                char(1)             DEFAULT '0'                 COMMENT '登录状态（0成功 1失败）',
    `remark`                varchar(256)        DEFAULT ''                  COMMENT '备注',
    `created_by`            varchar(45)         DEFAULT NULL                COMMENT '创建人',
    `created_at`            bigint(20)          DEFAULT NULL                COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='系统登录记录';

-- ----------------------------
-- 操作日志记录
-- ----------------------------
USE ice_orange_modules_system;
DROP TABLE if EXISTS sys_oper_log;
CREATE TABLE sys_oper_log (
    `id`                    varchar(32)         NOT NULL                    COMMENT '表的主键',
    `title`                 varchar(50)         DEFAULT ''                  COMMENT '模块标题',
    `method`                varchar(10)         DEFAULT ''                  COMMENT '请求方式:POST,GET,PUT,DELETE',
    `url`                   varchar(255)        DEFAULT ''                  COMMENT '请求URL',
    `ip`                    varchar(128)        DEFAULT ''                  COMMENT '主机地址',
    `param`                 varchar(2000)       DEFAULT ''                  COMMENT '请求参数',
    `result`                varchar(2000)       DEFAULT ''                  COMMENT '返回结果',
    `status`                char(1)             DEFAULT 0                   COMMENT '操作状态（0正常 1异常）',
    `created_by`            varchar(45)         DEFAULT NULL                COMMENT '创建人',
    `created_at`            bigint(20)          DEFAULT NULL                COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='操作日志记录';

-- ----------------------------
-- 字典类型表
-- ----------------------------
USE ice_orange_modules_system;
DROP TABLE if EXISTS sys_dict_type;
CREATE TABLE sys_dict_type
(
    `id`                    varchar(32)         NOT NULL                    COMMENT '表的主键',
    `name`                  varchar(100)        default ''                  COMMENT '字典名称',
    `dict_type`             varchar(100)        default ''                  COMMENT '字典类型',
    `status`                char(1)             default '0'                 COMMENT '状态（0正常 1停用）',
    `remark`                varchar(256)        DEFAULT NULL                COMMENT '备注',
    `del_flag`              char(1)             DEFAULT '0'                 COMMENT '删除标志（0:存在 1:删除）',
    `created_by`            varchar(45)         DEFAULT NULL                COMMENT '创建人',
    `created_at`            bigint(20)          DEFAULT NULL                COMMENT '创建时间',
    `updated_by`            varchar(45)         DEFAULT NULL                COMMENT '更新人',
    `updated_at`            bigint(20)          DEFAULT NULL                COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='字典类型表';


-- ----------------------------
-- 字典数据表
-- ----------------------------
USE ice_orange_modules_system;
drop table if exists sys_dict_data;
create table sys_dict_data
(
    `id`                    varchar(32)         NOT NULL                    COMMENT '表的主键',
    `sort`                  int(4)              DEFAULT 0                   COMMENT '字典排序',
    `dict_label`            varchar(100)        DEFAULT ''                  COMMENT '字典标签',
    `dict_value`            varchar(100)        DEFAULT ''                  COMMENT '字典键值',
    `dict_type`             varchar(100)        DEFAULT ''                  COMMENT '字典类型',
    `default_flag`          char(1)             DEFAULT '0'                 COMMENT '是否默认（0：否 1：是）',
    `status`                char(1)             DEFAULT '0'                 COMMENT '状态（0正常 1停用）',
    `remark`                varchar(256)        DEFAULT NULL                COMMENT '备注',
    `created_by`            varchar(45)         DEFAULT NULL                COMMENT '创建人',
    `created_at`            bigint(20)          DEFAULT NULL                COMMENT '创建时间',
    `updated_by`            varchar(45)         DEFAULT NULL                COMMENT '更新人',
    `updated_at`            bigint(20)          DEFAULT NULL                COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='字典数据表';

-- ----------------------------
-- 参数配置表
-- ----------------------------
USE ice_orange_modules_system;
drop table if exists sys_config;
create table sys_config (
    `id`                    varchar(32)         NOT NULL                    COMMENT '表的主键',
    `name`                  varchar(100)        DEFAULT ''                  COMMENT '参数名称',
    `config_key`            varchar(100)        DEFAULT ''                  COMMENT '参数键名',
    `config_value`          varchar(500)        DEFAULT ''                  COMMENT '参数键值',
    `config_type`           char(1)             DEFAULT '1'                 COMMENT '配置类型（0:预置 1:自定义）',
    `remark`                varchar(256)        DEFAULT NULL                COMMENT '备注',
    `created_by`            varchar(45)         DEFAULT NULL                COMMENT '创建人',
    `created_at`            bigint(20)          DEFAULT NULL                COMMENT '创建时间',
    `updated_by`            varchar(45)         DEFAULT NULL                COMMENT '更新人',
    `updated_at`            bigint(20)          DEFAULT NULL                COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='参数配置表';

