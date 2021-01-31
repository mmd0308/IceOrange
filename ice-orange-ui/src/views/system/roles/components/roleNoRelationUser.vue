<template>
  <el-dialog :title="dialogTitle" :visible.sync="dialogVisible" width="70%" :before-close="handleClose">
    <div>
      <el-table :data="tableData" ref="tableData" v-loading="tableLoading" fit highlight-current-row style="width: 100%">
        <el-table-column type="selection" width="55" />
        <el-table-column prop="username" label="登陆账号">
        </el-table-column>
        <el-table-column prop="phone" label="电话">
        </el-table-column>
        <el-table-column prop="email" label="邮箱" />
        <el-table-column prop="update_time" label="更新时间">
        </el-table-column>
      </el-table>
      <div style="padding:20px 0px 10px; text-align:right">
        <el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="pageQuery.pageNum" :page-sizes="[10, 20, 30, 40]" :page-size="pageQuery.pageSize" style="float:left;" layout="total, sizes, prev, pager, next, jumper" :total="total">
        </el-pagination>
        <div>
          <el-button type="primary" size="small" icon="el-icon-check" @click="saveData">保存</el-button>
          <el-button type="info" size="small" icon="el-icon-close" @click="handleCancel">取消</el-button>
        </div>
      </div>
    </div>
  </el-dialog>
</template>

<script>
import { pageNotByRoleId, createBatchUserRole } from '@/api/users/index'
export default {
  data() {
    return {
      dialogVisible: false,
      tableLoading: false,
      dialogTitle: '',
      pageQuery: {
        pageNum: 1,
        pageSize: 8,
        roleId: ''
      },
      dataFrom: {
        userId: '',
        roleId: ''
      },
      tableData: []
    }
  },
  methods: {
    saveData() {
      this.dataFrom.userId = this.$refs.tableData.selection
        .map(item => item.id)
        .toString()
      createBatchUserRole(this.dataFrom).then(() => {
        this.handleCancel()
      })
    },
    getUserPage(roleId) {
      this.dialogVisible = true
      this.dialogTitle = '关联用户'
      this.pageQuery.roleId = roleId
      this.dataFrom.roleId = roleId
      this.handlePage()
    },
    handlePage() {
      this.tableLoading = true
      pageNotByRoleId(this.pageQuery).then(res => {
        this.tableData = res.attributes.records
        this.total = res.attributes.total
        this.tableLoading = false
      })
    },
    handleSizeChange(val) {
      this.pageQuery.pageSize = val
      this.handlePage()
    },
    handleCurrentChange(val) {
      this.pageQuery.pageNum = val
      this.handlePage()
    },
    handleCancel() {
      this.dialogVisible = false
      this.$emit('refreshList')
    }
  }
}
</script>

<style>
.el-dialog__body {
  padding: 10px 20px;
}
</style>
