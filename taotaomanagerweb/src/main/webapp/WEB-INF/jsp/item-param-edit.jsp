<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<table cellpadding="5" style="margin-left: 30px" id="itemParamEditTable" class="itemParam">
	<tr>
		<td>商品类目:</td>
		<td><div id="itemCatName">
		</div><input type="hidden" name="itemParamId" style="width: 280px;" id="itemParamId"/>
		</td>
	</tr>
	<tr class="hide addGroupTrEdit">
		<td>规格参数:</td>
		<td>
			<ul>
				<li><a href="javascript:void(0)" class="easyui-linkbutton addGroupEdit">添加分组</a></li>
			</ul>
		</td>
	</tr>
	<tr>
		<td></td>
		<td>
			<a href="javascript:void(0)" class="easyui-linkbutton submit">提交</a>
		</td>
	</tr>
</table>
<div  class="itemParamEditTemplate" style="display: none;">
	<li class="paramEdit">
		<ul>
			<li>
				<input class="easyui-textbox" style="width: 150px;" name="group"/>&nbsp;<a href="javascript:void(0)" class="easyui-linkbutton addParam"  title="添加参数" data-options="plain:true,iconCls:'icon-add'"></a>
			</li>
			<li>
				<span>|-------</span><input  style="width: 150px;" class="easyui-textbox" name="param"/>&nbsp;<a href="javascript:void(0)" class="easyui-linkbutton delParam" title="删除" data-options="plain:true,iconCls:'icon-cancel'"></a>						
			</li>
		</ul>
	</li>
</div>
<script style="text/javascript">
	$(function(){
		$(".addGroupEdit").click(function(){
			  var temple = $(".itemParamEditTemplate li").eq(0).clone();
			  $(this).parent().parent().append(temple);
			  temple.find(".addParam").click(function(){
				  var li = $(".itemParamEditTemplate li").eq(2).clone();
				  li.find(".delParam").click(function(){
					  $(this).parent().remove();
				  });
				  li.appendTo($(this).parentsUntil("ul").parent());
			  });
			  temple.find(".delParam").click(function(){
				  $(this).parent().remove();
			  });
		 });

		$("#itemParamEditTable .submit").click(function(){
			var params = [];
			var groups = $("#itemParamEditTable [name=group]");
			groups.each(function(i,e){
				var p = $(e).parentsUntil("ul").parent().find("[name=param]");
				var _ps = [];
				p.each(function(_i,_e){
					var _val = $(_e).siblings("input").val();
					if($.trim(_val).length>0){
						_ps.push(_val);						
					}
				});
				var _val = $(e).siblings("input").val();
				if($.trim(_val).length>0 && _ps.length > 0){
					params.push({
						"group":_val,
						"params":_ps
					});					
				}
			});
			console.log($("#itemParamId").val());
			var url = "/item/param/update/"+$("#itemParamEditTable [name=itemParamId]").val();
			$.post(url,{"paramData":JSON.stringify(params)},function(data){
				if(data.status == 200){
					$.messager.alert('提示','修改商品规格成功!',undefined,function(){
                        $("#itemParamEditWindow").window('close');
    					$("#itemParamList").datagrid("reload");
    				});
				}
			},"json");
		});
	});
</script>