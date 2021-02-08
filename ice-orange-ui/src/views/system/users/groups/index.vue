<template>
  <div class="index-container">
    <div class="filter-container">
      <div style="padding-bottom:15px;">
        <el-input
          v-model="pageQuery.username"
          style="width:200px; padding-right:10px;"
          size="small"
          placeholder="请输入内容"
          @keyup.enter.native="handleFilter"
        />
        <el-button size="small" type="primary" icon="el-icon-search" @click="handleFilter">搜索</el-button>
        <el-button size="small" type="primary" icon="el-icon-plus" @click="handleCreate">创建用户组</el-button>
      </div>
    </div>
    <el-table :data="tableData" fit v-loading="tableLoading" highlight-current-row style="width: 100%">
      <el-table-column prop="name" label="用户组名称">
      </el-table-column>
      <el-table-column prop="showName" label="显示名称">
      </el-table-column>
         <el-table-column prop="remark" label="备注">
      </el-table-column>
      <el-table-column prop="createTime" label="创建时间">
      </el-table-column>

      <el-table-column label="操作" align="center" width="300" class-name="small-padding fixed-width">
        <template slot-scope="{row}">
          <el-button size="small" type="text"  @click="handleToBindUsers(row)">添加组成员</el-button>
          <el-button size="small" type="text"  @click="handleToBindPerms(row)">添加权限</el-button>
          <el-button size="small" type="text"  @click="handleUpdate(row)">编辑</el-button>
          <el-button size="small" type="text"  @click="handleDelete(row.id)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <div class="pagination-container">
      <el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange"
                     :current-page="pageQuery.pageNum" :page-sizes="[10, 20, 30, 40]" :page-size="pageQuery.pageSize"
                     layout="total, sizes, prev, pager, next, jumper" :total="total">
      </el-pagination>
    </div>
    <user-form ref="dataForm" @refreshList="refreshList"/>
    <bind-users ref="bindUsersRef" />
    <bind-perms ref="bindPermsRef" />
  </div>
</template>

<script>
  import UserForm from './form/index'
  import BindUsers from './bind_users/index'
  import BindPerms from './bind_perms/index'
  import { list,deleteById } from '@/api/common/index'

  export default {
    props: {},
    data() {
      return {
         moudle:'users/groups',
        tableLoading: false,
        pageQuery: {
          pageNum: 1,
          pageSize: 10,
          name: null
        },
        total: 0,
        tableData: []
      }
    },
    components: {
      UserForm,
      BindUsers,
      BindPerms
    },
    created() {
      this.handlePage()
    },
    methods: {
      handlePage() {
        this.tableLoading = true
        list(this.moudle,this.pageQuery).then(res => {
          this.tableData = res.data
          this.total = res.total
          this.tableLoading = false
        })
      },
      handleCreate() {
        this.$refs['dataForm'].handleToCreate()
      },
      handleUpdate(row) {
        this.$refs['dataForm'].handleToUpdate(row)
      },
      handleToBindUsers(row) {
        this.$refs['bindUsersRef'].handleToBindUsers(row)
      },
      handleToBindPerms(rwo) {
  this.$refs['bindPermsRef'].handleToBindPerms(row)
      },
      handleDelete(id) {
        this.$confirm('此操作将永久删除?', '删除警告', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          typr: 'warning'
        }).then(() => {
          deleteById(this.moudle, id).then(() => {
            this.refreshList()
          })
        })
      },
      refreshList() {
        this.handlePage()
      },
      handleSizeChange(val) {
        this.pageQuery.pageSize = val
        this.handlePage()
      },
      handleCurrentChange(val) {
        this.pageQuery.pageNum = val
        this.handlePage()
      },
      handleFilter() {
        this.handlePage()
      }
    }
  }
</script>
