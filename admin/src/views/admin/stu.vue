<template>

    <!-- PAGE CONTENT BEGINS -->
   <div>
     <p>
       <button v-on:click="add()" class="btn btn-white btn-warning btn-bold">
       <i class="ace-icon fa fa-edit green"></i>
         新增
       </button>
       &nbsp;
       <button v-on:click="list(1)" class="btn btn-white btn-warning btn-bold">
       <i class="ace-icon fa fa-refresh bigger-120 green"></i>
         刷新
       </button>
       &nbsp;
       <button @click="exportData()" class="btn btn-white btn-warning btn-bold">
         <i class="ace-icon fa fa-share bigger-120 green"></i>
         导入
       </button>

       &nbsp;
       <button v-on:click="exportData()" class="btn btn-white btn-warning btn-bold">
         <i class="ace-icon fa fa-reply bigger-120 green"></i>
         导出
       </button>
     </p>
     <pagination ref="pagination" v-bind:list="list" ></pagination>

     <div class="row">
      <div class="col-xs-12">
        <table id="simple-table" class="table  table-bordered table-hover">
          <thead>
          <tr>
              <th>id</th>

              <th>名字</th>

              <th>身份证号</th>

              <th>手机号码</th>

              <th>性别</th>

              <th>地址</th>

              <th>年龄</th>

              <th>专业</th>



              <th>操作</th>
          </tr>
          </thead>

          <tbody>
          <tr v-for="stu in stus">
                  <td>{{stu.id}}</td>
                  <td>{{stu.name}}</td>
                  <td>{{stu.idnumber}}</td>
                  <td>{{stu.phonenb}}</td>
                  <td>{{STU_SEX | optionKV(stu.sex)}}</td>
                  <td>{{stu.address}}</td>
                  <td>{{stu.birthnb}}</td>
                  <td>{{stu.majorid}}</td>

            <td>
              <div class="hidden-sm hidden-xs btn-group">


                <button v-on:click="edit(stu)" class="btn btn-xs btn-info">
                  <i class="ace-icon fa fa-pencil bigger-120"></i>
                </button>

                <button v-on:click="del(stu.id)" class="btn btn-xs btn-danger">
                  <i class="ace-icon fa fa-trash-o bigger-120"></i>
                </button>


              </div>

              <div class="hidden-md hidden-lg">
                <div class="inline pos-rel">
                  <button class="btn btn-minier btn-primary dropdown-toggle" data-toggle="dropdown" data-position="auto">
                    <i class="ace-icon fa fa-cog icon-only bigger-110"></i>
                  </button>

                  <ul class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">


                    <li>
                      <a  v-on:click="edit(stu)" class="tooltip-success" data-rel="tooltip" title="Edit">
                                    <span class="green">
                                      <i class="ace-icon fa fa-pencil-square-o bigger-120"></i>
                                    </span>
                      </a>
                    </li>

                    <li>
                      <a v-on:click="del(stu.id)" class="tooltip-error" data-rel="tooltip" title="Delete">
                                    <span class="red">
                                      <i class="ace-icon fa fa-trash-o bigger-120"></i>
                                    </span>
                      </a>
                    </li>
                  </ul>
                </div>
              </div>
            </td>
          </tr>



          </tbody>
        </table>
        <div id = "form-modal"  class="modal fade" tabindex="-1" role="dialog">
          <div class="modal-dialog" role="document">
            <div class="modal-content">
              <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">表单</h4>
              </div>
              <div class="modal-body">
                <form class="form-horizontal">

                      <div class="form-group">
                        <label  class="col-sm-2 control-label">名字</label>
                        <div class="col-sm-10">
                          <input v-model="stu.name" type="text" class="form-control">
                        </div>
                      </div>
                      <div class="form-group">
                        <label  class="col-sm-2 control-label">身份证号</label>
                        <div class="col-sm-10">
                          <input v-model="stu.idnumber" type="text" class="form-control">
                        </div>
                      </div>
                      <div class="form-group">
                        <label  class="col-sm-2 control-label">手机号码</label>
                        <div class="col-sm-10">
                          <input v-model="stu.phonenb" type="text" class="form-control">
                        </div>
                      </div>
                        <div class="form-group">
                          <label class="col-sm-2 control-label">性别</label>
                          <div class="col-sm-10">
                            <select v-model="stu.sex" class="form-control">
                              <option v-for="o in STU_SEX" v-bind:value="o.key">{{o.value}}</option>
                            </select>
                          </div>
                        </div>
                                            <div class="form-group">
                        <label  class="col-sm-2 control-label">地址</label>
                        <div class="col-sm-10">
                          <input v-model="stu.address" type="text" class="form-control">
                        </div>
                      </div>
                      <div class="form-group">
                        <label  class="col-sm-2 control-label">年龄</label>
                        <div class="col-sm-10">
                          <input v-model="stu.birthnb" type="text" class="form-control">
                        </div>
                      </div>
                      <div class="form-group">
                        <label  class="col-sm-2 control-label">专业</label>
                        <div class="col-sm-10">
                          <input v-model="stu.majorid" type="text" class="form-control">
                        </div>
                      </div>

                </form>
              </div>
              <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button v-on:click="save()" type="button" class="btn btn-primary">保存</button>
              </div>
            </div><!-- /.modal-content -->
          </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->
      </div><!-- /.span -->
    </div><!-- /.row -->

    <!-- PAGE CONTENT ENDS -->
     </div>
</template>

<script>
  import Pagination from "../../components/pagination";
  import {exportExcel} from "../../../public/static/js/coment";

  export default {
    components:{Pagination},
    name: "business-stu",
    data:function(){
      return{
        stu:{},
        stus:[],
      STU_SEX: STU_SEX,
      }
    },
    mounted:function(){
      //this.$parent.activeSidebar("business-stu-sidebar");

      let _this = this;

      _this.list(1);
    },
    methods:{
      add(){
        let  _this = this;
        _this.stu={};
        $("#form-modal").modal("show");
      },
      edit(stu){
        let  _this = this;
        _this.stu = $.extend({},stu);
        $("#form-modal").modal("show");
      },
      save(){
        let  _this = this;
        // 保存校验
        if (1 != 1
                || !Validator.require(_this.stu.name, "名字")
                || !Validator.length(_this.stu.name, "名字", 1, 50)
                || !Validator.require(_this.stu.idnumber, "身份证号")
                || !Validator.length(_this.stu.idnumber, "身份证号", 18, 18)
                || !Validator.require(_this.stu.phonenb, "手机号码")
                || !Validator.length(_this.stu.phonenb, "手机号码", 1, 50)
                || !Validator.require(_this.stu.sex, "性别")
                || !Validator.length(_this.stu.address, "地址", 1, 100)
                || !Validator.length(_this.stu.majorid, "专业", 1, 50)
        ) {
          return;
        }

        Loading.show();
        $("#form-modal").modal("show");

        _this.$ajax.post(process.env.VUE_APP_SERVER + '/business/admin/stu/save',_this.stu).then((response)=>{
          Loading.hide();
          console.log("保存录取生源信息列表结果：", response);
          let resp = response.data;
          if (resp.success){
            $("#form-modal").modal("hide");
            _this.list(1);
            Toast.success("保存成功");
          }else{
            Toast.warning(resp.message);
          }
        })

      },
      del(id) {
        let _this = this;
        Confirm.show("删除录取生源信息后不可恢复，确认删除？", function () {
          Loading.show();
          _this.$ajax.delete(process.env.VUE_APP_SERVER + '/business/admin/stu/delete/' + id).then((response) => {
            Loading.hide();
            console.log("删除录取生源信息列表结果：", response);
            let resp = response.data;
            if (resp.success) {
              _this.list(1);
              Toast.success("删除成功！");
            }
          })
        });
      },
      list(page) {
        let _this = this;
        Loading.show();
        _this.$ajax.post(process.env.VUE_APP_SERVER + '/business/admin/stu/list',{page:page,
          size:_this.$refs.pagination.size}).then((response)=>{
        Loading.hide();
          console.log("查询录取生源信息列表结果：", response);
          let resp = response.data;
          _this.stus = resp.content.list;
          _this.$refs.pagination.render(page, resp.content.total);
        })

      },

// 调用导出方法
exportData(){
        let _this = this;
            Loading.show();
           _this.$ajax.get(process.env.VUE_APP_SERVER + '/business/admin/stu/export').then(function (res) {
             if (!res) {
               return;
             }
            Loading.hide();
            //console.log("查询录取生源信息列表结果：", response);
             //let resp = response.data;

               _this.list(1);
               Toast.success("下载成功！");
          })

}
    }
  }
</script>

<style scoped>

</style>