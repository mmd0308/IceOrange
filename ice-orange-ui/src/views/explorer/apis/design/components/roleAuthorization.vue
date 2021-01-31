<template>
  <el-dialog class="roleAuth" :title="dialogTitle" :visible.sync="dialogVisible" width="70%" :before-close="handleClose">
    <el-row style="height: 35em;overflow-y: auto">
      <el-col :span="5">
        <el-menu style="margin-bottom: 10px;">
          <el-menu-item class="menuTitle" index="1">
            <i class="el-icon-menu">&nbsp;&nbsp;服务授权</i>
          </el-menu-item>
        </el-menu>
        <!-- 服务树 -->
        <el-tree ref="serveTreeRef" :data="serveTableData" :props="servetreeProps" check-strictly show-checkbox highlight-current default-expand-all node-key="id" @node-click="clickServeTree" @check-change="checkServeTree" />
      </el-col>
      <el-col :span="5">
        <el-menu style="margin-bottom: 10px;margin-left: 10px">
          <el-menu-item class="menuTitle" index="1">
            <i class="el-icon-menu">&nbsp;&nbsp;功能授权</i>
          </el-menu-item>
        </el-menu>
        <!-- 菜单树 -->
        <el-tree ref="menuTreeRef" :data="menuTreeData" :props="menutreeProps" show-checkbox highlight-current default-expand-all node-key="id" @node-click="clickMenuTree" @check-change="checkMenuTree" />
      </el-col>
      <el-col :span="14">
        <el-row style="margin-bottom: 30px;margin-left: 10px">
          <el-menu>
            <el-menu-item class="menuTitle" index="1">
              <i class="el-icon-menu">&nbsp;&nbsp;资源授权</i>
            </el-menu-item>
          </el-menu>
          <el-table ref="buttonTable" :data="elementTableData" border fit highlight-current-row style="width: 100%;margin-top: 10px" @select="handleSelectionChange" @select-all="handleSelectionAll">
            <el-table-column align="center" type="selection" width="61" />
            <el-table-column align="center" label="资源编码">
              <template slot-scope="scope">
                <span>{{ scope.row.permission }}</span>
              </template>
            </el-table-column>
            <el-table-column align="center" label="资源名称">
              <template slot-scope="scope">
                <span> {{ scope.row.name }}</span>
              </template>
            </el-table-column>
          </el-table>
        </el-row>
      </el-col>
    </el-row>

  </el-dialog>
</template>
<script>
import { list } from '@/api/common/index'
// import { tree } from '@/api/menu/index'
import {
  createRoleResource,
  listResourceByRoleId,
  updateBatchRoleResources
} from '@/api/system/roles/index'
export default {
  data() {
    return {
      active: 0,
      dialogVisible: false,
      tableLoading: false,
      dialogTitle: '',
      serveTableData: [],
      servetreeProps: {
        label: 'name'
      },
      menuTreeData: [],
      menutreeProps: {
        label: 'name'
      },
      elementTableData: [],
      elementQuery: {
        menuId: ''
      },
      roleId: '',
      serveId: '',
      dataForm: {
        roleId: '',
        serveId: '',
        menuId: '',
        elementId: ''
      },
      resourceData: [],
      // 服务状态，页面初始为false,数据加载回填完成后变为true
      serveStatus: false,
      menuStatus: false,
      menuSaveTimeOut: null
    }
  },
  created() {
    this.handleServeAll()
  },
  methods: {
    handleQueryResource(id) {
      this.serveStatus = false
      listResourceByRoleId(id)
        .then(res => {
          this.resourceData = res.attributes
          // 加载完成资源自由,默认选中已经拥有的服务
          this.$refs.serveTreeRef.setCheckedKeys(
            res.attributes.map(item => item.serveId)
          )
        })
        .then(() => {
          // 回填后状态改变
          this.serveStatus = true
        })
    },
    handleSave(message) {
      createRoleResource(this.dataForm).then(() => {
        this.$notify({
          type: 'success',
          message: message,
          duration: 2000
        })
      })
    },
    handleAuth(id) {
      this.dialogVisible = true
      this.dialogTitle = '权限分配'
      this.roleId = id
      // 获取该角色已经拥有的资源
      this.handleQueryResource(id)
      // 角色id
      this.dataForm.roleId = id
    },
    handleServeAll() {
      list('serves', null).then(res => {
        this.serveTableData = res.attributes
      })
    },
    clickServeTree(item) {
      this.serveId = item.id
      // 根据服务id,获取菜单
      this.handleMenuTree(item.id)
    },
    checkServeTree(row, checkStatus) {
      if (this.serveStatus) {
        // 表示选中,保存数据
        if (checkStatus) {
          this.dataForm.serveId = row.id
          this.handleSave('服务添加成功')
        } else {
          // 删除绑定关系
          this.$notify({
            type: 'success',
            message: '删除,待做!',
            duration: 2000
          })
        }
      }
    },

    // clickServerTableRow(row) {
    //   this.$refs.serveTableData.toggleRowSelection(row)
    //   // 根据服务id,获取菜单
    //   this.handleMenuTree(row.id)
    // },
    handleMenuTree(serveId) {
      this.menuStatus = false
      tree(serveId)
        .then(res => {
          this.menuTreeData = res.attributes
          // 加载完成服务下面的所有资源之后,选中该角色已经拥有的菜单
          this.$refs.menuTreeRef.setCheckedKeys(
            this.resourceData.map(item => item.menuId)
          )
        })
        .then(() => {
          this.menuStatus = true
        })
    },
    clickMenuTree(data) {
      // 根据菜单id,获取资源
      this.elementQuery.menuId = data.id
      this.menuId = data.id
      this.handleElement()
    },
    checkMenuTree(row, checkStatus) {
      if (this.menuStatus) {
        if (checkStatus) {
          // 判断是否选中服务
          console.log('l')

          // 判断该菜单的服务是否选中,如果没有选中,进行选中在保存
          var menuForm = {
            serveId: row.serveId,
            menuId: row.id,
            roleId: this.roleId
          }
          createRoleResource(menuForm).then(() => {
            if (this.menuSaveTimeOut != null) {
              clearTimeout(this.menuSaveTimeOut)
            }
            var that = this
            this.menuSaveTimeOut = setTimeout(function() {
              that.$notify({
                type: 'success',
                message: '菜单添加成功!',
                duration: 2000
              })
            }, 500)
          })
        } else {
          // 删除
        }
      }
    },
    handleElement() {
      list('elements', this.elementQuery).then(res => {
        this.elementTableData = res.attributes
      })
    },
    handleSelectionChange(selection, row) {
      // 被选中的row在select中即为被选中，否则为取消选中
      var buttonForm = {
        serveId: this.serveId,
        menuId: row.menuId,
        roleId: this.roleId,
        elementId: row.id
      }
      // 添加按钮resource
      createRoleResource(buttonForm).then(() => {
        this.$notify({
          type: 'success',
          message: '按钮添加成功',
          duration: 2000
        })
      })
    },
    handleSelectionAll(selection) {
      const ids = selection.map(item => item.id).join()
      var buttonForm = {
        serveId: this.serveId,
        menuId: this.menuId,
        roleId: this.roleId,
        elementId: ids
      }
      // 根据角色,服务,菜单id,批量新增获取修改资源
      updateBatchRoleResources(buttonForm).then(() => {
        this.$notify({
          type: 'success',
          message: '批量修改成功',
          duration: 2000
        })
      })
    }
  }
}
</script>

<style scoped>
.el-menu-item[class*='menuTitle'] {
  line-height: 40px;
  height: 40px;
}
.el-menu {
  margin: 0;
  padding-left: 0;
  background-color: #eef1f6;
}
</style>
