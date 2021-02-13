<template>
  <div class="index-container">
    <div class="filter-container">
      <div style="padding-bottom:15px;">
        <el-input v-model="pageQuery.username" style="width:200px; padding-right:10px;" size="small" placeholder="请输入内容" @keyup.enter.native="handleFilter" />
        <el-button size="small" type="primary" icon="el-icon-search" @click="handleFilter">搜索</el-button>
        <el-button size="small" type="primary" icon="el-icon-plus" @click="handleCreate">注册服务</el-button>
      </div>
    </div>
    <el-table :data="tableData" fit v-loading="tableLoading" highlight-current-row style="width: 100%">
      <el-table-column prop="name" label="服务名称">
      </el-table-column>
      <el-table-column prop="showName" label="显示名称">
      </el-table-column>
      <el-table-column prop="remark" label="备注">
      </el-table-column>
      <el-table-column prop="createTime" label="创建时间">
      </el-table-column>

      <el-table-column label="操作" align="center" width="300" class-name="small-padding fixed-width">
        <template slot-scope="{row}">
          <el-button size="small" type="text" @click="handleUpdate(row)">编辑</el-button>
          <el-button size="small" type="text" @click="handleDelete(row.id)">卸载</el-button>
        </template>
      </el-table-column>
    </el-table>
    <div class="pagination-container">
      <el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="pageQuery.pageNum" :page-sizes="[10, 20, 30, 40]" :page-size="pageQuery.pageSize" layout="total, sizes, prev, pager, next, jumper" :total="total">
      </el-pagination>
    </div>
    <service-form ref="dataForm" @refreshList="refreshList" />
  </div>
</template>

<script>
import ServiceForm from './form/index'
import { list, deleteById } from '@/api/common/index'
export default {
  props: {},
  data() {
    return {
      moudle: 'services',
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
    ServiceForm
  },
  created() {
    this.handlePage()
  },
  methods: {
    handlePage() {
      this.tableLoading = true
      list(this.moudle, this.pageQuery).then(res => {
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
