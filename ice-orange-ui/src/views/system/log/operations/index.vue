<template>
  <div class="app-container">
    <div class="filter-container">
      <div style="padding-bottom:15px;">
        <el-input style="width:200px; padding-right:10px;" size="small" v-model="pageQuery.username" placeholder="请输入内容" @keyup.enter.native="handleFilter" />
        <el-button size="small" type="primary" icon="el-icon-search" @click="handleFilter">搜索</el-button>
      </div>
    </div>
    <el-table :data="tableData" fit v-loading="tableLoading" highlight-current-row style="width: 100%">
      <el-table-column prop="loginName" label="请求账号" width="120" />
      <el-table-column prop="ip" label="登陆IP" width="150" />
      <el-table-column prop="url" label="请求路径" />
      <el-table-column prop="params" label="请求参数" />
      <el-table-column prop="createTime" label="请求时间" width="170" />
    </el-table>
    <div class="pagination-container">
      <el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="pageQuery.pageNum" :page-sizes="[10, 20, 30, 40]" :page-size="pageQuery.pageSize" layout="total, sizes, prev, pager, next, jumper" :total="total">
      </el-pagination>
    </div>
  </div>
</template>

  <script>
import { OperationLogPage } from '@/api/log/index'
export default {
  data() {
    return {
      tableLoading: false,
      pageQuery: {
        pageNum: 1,
        pageSize: 10
      },
      total: 0,
      tableData: []
    }
  },
  created() {
    this.handlePage()
  },
  methods: {
    handlePage() {
      this.tableLoading = true
      OperationLogPage(this.pageQuery).then(res => {
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
    handleFilter() {
      this.handlePage()
    }
  }
}
</script>
