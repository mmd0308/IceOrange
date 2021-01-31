<template>
  <div class="app-container">

    <el-col :span="5" style="padding-right:20px;">
      <el-input style="padding-bottom:10px"
                placeholder="输入关键字进行过滤">
      </el-input>

      <el-card>
        <el-tree
          v-loading="treeLoading"
          ref="treeData"
          :data="treeDate"
          :props="treeProps"
          element-loading-text="拼命加载中..."
          element-loading-spinner="el-icon-loading"
          node-key="id"
          default-expand-all
          @node-click="handleNodeClick"/>
      </el-card>
    </el-col>
    <el-col :span="19">
      <data-form ref="dataForm" :formStatus="formStatus"  @handleRefreshTree="handleRefreshTree"/>
      <role-user-list ref="roleRelationUserList" />
    </el-col>
  </div>
</template>
<script>
  import DataForm from './components/form'
  import RoleUserList from './components/roleRelationUser'
  import { tree } from '@/api/system/roles/index'
  export default {
    components: {
      DataForm,
      RoleUserList
    },
    data() {
      return {
        serveDatas: [],
        treeProps: {
          label: 'name',
        },
        formStatus: 'see',
        treeDate: [],
        treeLoading: false,
        top: false
      }
    },
    created() {
      // 加载角色
      this.handlerTree()
    },
    methods: {
      handlerTree(){
        tree().then(res => {
          this.treeDate = res.attributes
          this.top = true
          // 加载完成数据,默认查看第一个
          this.handleNodeClick(this.treeDate[0])
          this.top = false
        })
      },
      handleNodeClick(data) {
        // 更新右边查看详情
        this.$refs.dataForm.handleSee(data,this.top)
        this.$refs.roleRelationUserList.genRoleId(data.id)
      },
      handleRefreshTree() {
        this.handlerTree()
      }
    }
  }
</script>
