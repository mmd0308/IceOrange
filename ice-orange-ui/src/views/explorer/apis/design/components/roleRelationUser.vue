<template>
  <el-card style="margin-top:20px" body-style="padding: 10px 20px 20px;" class="box-card">
    <div slot="header" class="clearfix">
      <span style="line-height: 32px;">关联用户</span>
      <div style=" float:right;padding-right:15px;">
        <el-input style="width:200px; padding-right:10px;" size="small" v-model="pageQuery.name" placeholder="请输入内容"></el-input>
        <el-button size="small" type="primary" icon="el-icon-search" @click="handleFilter">搜索</el-button>
        <el-button size="small" type="primary" icon="el-icon-user-solid" @click="handleRelation">关联用户</el-button>
      </div>
    </div>
    <div class="button-container">
      <el-table :data="tableData" v-loading="tableLoading" fit highlight-current-row style="width: 100%">
        <el-table-column prop="username" label="用户名称">
        </el-table-column>
        <el-table-column prop="email" label="用户邮箱">
        </el-table-column>
        <el-table-column prop="phone" label="用户电话">
        </el-table-column>
        <el-table-column label="操作" align="center" width="160" class-name="small-padding fixed-width">
          <template slot-scope="{row}">
            <el-button size="mini" type="danger" icon="el-icon-delete" @click="handleDelete(row.id)"></el-button>
          </template>
        </el-table-column>
      </el-table>
      <div class="pagination-container">
        <el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="pageQuery.pageNum" :page-sizes="[5, 10, 15, 20]" :page-size="pageQuery.pageSize" layout="total, sizes, prev, pager, next, jumper" :total="total">
        </el-pagination>
      </div>
      <role-no-relation-user ref="roleNoRelationUser" @refreshList="refreshList" />
    </div>
  </el-card>
</template>

  <script>
import { deleteById } from '@/api/common/index'
import { pageByRoleId } from '@/api/users/index'
import RoleNoRelationUser from './roleNoRelationUser'
export default {
  data() {
    return {
      moudle: 'users',
      pageQuery: {
        pageNum: 1,
        pageSize: 5,
        name: '',
        roleId: ''
      },
      total: 0,
      tableData: [],
      tableLoading: false,
      roleId: ''
    }
  },
  components: {
    RoleNoRelationUser
  },
  methods: {
    genRoleId(id) {
      // 获取角色id
      this.roleId = id
      this.pageQuery.roleId = id
      this.handlePage()
    },
    handlePage() {
      this.tableLoading = true
      pageByRoleId(this.pageQuery).then(res => {
        this.tableData = res.attributes.records
        this.total = res.attributes.total
        this.tableLoading = false
      })
    },
    handleRelation() {
      this.$refs['roleNoRelationUser'].getUserPage(this.roleId)
    },
    handleUpdate(row) {
      this.$refs['roleNoRelationUser'].handleUpdate(row)
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
    handleClose() {
      this.handlePage()
      this.dialogVisible = false
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
    },
    refreshList() {
      this.handlePage()
    }
  }
}
</script>
