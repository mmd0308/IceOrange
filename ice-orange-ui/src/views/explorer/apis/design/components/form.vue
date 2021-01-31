<template>
  <el-card class="box-card">
    <div slot="header" class="clearfix">
      <span style="line-height: 32px;">角色详情</span>
      <div style=" float:right;padding-right:15px;">
        <el-button v-if="formStatus === 'see'" size="small" type="primary" icon="el-icon-plus" @click="handleCreate">新增</el-button>
        <el-button v-if="formStatus === 'see'" size="small" type="primary" icon="el-icon-user-solid" @click="handleAuth">权限分配</el-button>
        <el-button v-if="formStatus === 'see'" size="small" type="success" icon="el-icon-edit" @click="handleUpdate">修改</el-button>
        <el-button v-if="formStatus === 'see'" size="small" type="danger" icon="el-icon-delete" @click="handleDelete">删除</el-button>
        <el-button v-if="formStatus === 'see'" size="small" type="info" icon="el-icon-refresh" @click="handleReset">重置</el-button>
        <el-button v-if="formStatus != 'see'" type="primary" size="small" icon="el-icon-check" @click="formStatus==='create'?createData():updateData()">保存</el-button>
        <el-button v-if="formStatus != 'see'" type="info" size="small" icon="el-icon-close" @click="handleCancel">取消</el-button>
      </div>
    </div>
    <div>
      <el-form :ref="roleFormRef" :rules="rules" :model="roleForm" label-position="left" label-width="120px" style="margin:0px 50px;">
        <el-form-item label="角色名称" prop="name">
          <el-input v-if="formStatus === 'see'" :disabled="true" v-model="roleForm.name" placeholder="请输入角色名称" />
          <el-input v-else v-model="roleForm.name" placeholder="请输入角色名称" />
        </el-form-item>

        <el-form-item label="是否为系统角色" prop="title">
          <el-radio v-if="formStatus === 'see'" :disabled="true" v-model="roleForm.sysFlag" label="1">是</el-radio>
          <el-radio v-else v-model="roleForm.sysFlag" label="1">是</el-radio>
          <el-radio v-if="formStatus === 'see'" :disabled="true" v-model="roleForm.sysFlag" label="0">否</el-radio>
          <el-radio v-else v-model="roleForm.sysFlag" label="0">否</el-radio>
        </el-form-item>
        <el-form-item label="备注说明">
          <el-input v-if="formStatus === 'see'" :disabled="true" type="textarea" v-model="roleForm.remarks" />
          <el-input v-else type="textarea" v-model="roleForm.remarks" />
        </el-form-item>
      </el-form>
    </div>
    <role-authorization ref="roleAuthorization" />
  </el-card>
</template>

<script>
import { create, update } from '@/api/system/roles/index'
import { deleteById } from '@/api/common/index'
import RoleAuthorization from './roleAuthorization'
export default {
  props: ['dialogStatus'],
  data() {
    return {
      moudle: 'roles',
      roleForm: this.initForm(),
      roleFormRef: 'roleFormRef',
      formStatus: 'see',
      rules: {
        name: [{ required: true, trigger: 'blur', message: '名称不能唯空!' }]
      }
    }
  },
  components: { RoleAuthorization },
  methods: {
    initForm() {
      return {
        id: null,
        parentId: '',
        parentIds: '',
        sysFlag: '',
        name: '',
        remarks: ''
      }
    },
    handleAuth() {
      this.$refs.roleAuthorization.handleAuth(this.roleForm.id)
    },
    handleCreate() {
      this.formStatus = 'create'
      var parentId = this.roleForm.id
      var parentIds = this.roleForm.parentIds + ',' + this.roleForm.id
      this.resetForm()
      if (this.top) {
        // 没有点击左侧树木,添加的是顶级菜单
        parentId = 0
        parentIds = 0
      }
      this.roleForm.parentId = parentId
      this.roleForm.parentIds = parentIds
    },
    createData() {
      this.$refs[this.roleFormRef].validate(validate => {
        if (validate) {
          create(this.roleForm).then(() => {
            this.handleCancel()
          })
        } else {
          return false
        }
      })
    },
    handleUpdate() {
      this.formStatus = 'update'
    },
    updateData() {
      this.$refs[this.roleFormRef].validate(validate => {
        if (validate) {
          update(this.roleForm).then(() => {
            this.handleCancel()
          })
        } else {
          return false
        }
      })
    },
    handleSee(data, top) {
      this.resetForm()
      this.formStatus = 'see'
      if (data !== undefined) {
        this.roleForm = JSON.parse(JSON.stringify(data))
      }
      this.top = top
      //   this.menuForm.appId = appId
      //   this.top = top
      //   this.menuFormLoading = false
      //   if (this.top) {
      //     this.menuForm.parentName = '无上级菜单'
      //   } else {
      //     if (this.menuForm.parentId !== '-1') {
      //       this.menuForm.parentName = this.$parent.$parent.$refs.treeData.getNode(this.menuForm.parentId).data.name
      //     } else {
      //       this.menuForm.parentName = '无上级菜单'
      //     }
      //   }
    },
    handleDelete() {
      this.$confirm('此操作将永久删除?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        typr: 'warning'
      }).then(() => {
        deleteById(this.moudle, this.roleForm.id).then(() => {
          this.refreshTree()
        })
      })
    },
    handleReset() {
      this.refreshTree()
    },
    refreshTree() {
      // 更新树
      this.$emit('handleRefreshTree')
    },
    resetForm() {
      this.roleForm = this.initForm()
    },
    updateForm(row) {
      this.roleForm = row
    },
    handleCancel() {
      this.formStatus = 'see'
      this.refreshTree()
    }
  }
}
</script>

<style>
</style>
