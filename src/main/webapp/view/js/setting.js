//流通权限参数设置

//定义权限对象
function newStaffAuthority(){  
	var newAuthorityName = $("#newAuthorityName").val();
	var newRemarks = $("#newRemarks").val();
    this.authorityName = newAuthorityName;  
    this.remarks = newRemarks;  
}

//定义权限对象
function editStaffAuthority(){  
	var editAuthorityId = $("#editAuthorityId").val();
	var newAuthorityName = $("#editAuthorityName").val();
	var newRemarks = $("#editRemarks").val();
	this.authorityId = editAuthorityId;  
    this.authorityName = newAuthorityName;  
    this.remarks = newRemarks;  
}

function newAuthority(target){
	var authority = new newStaffAuthority();
	var jsonStringRef = JSON.stringify(authority); 
	   jQuery.ajax( {  
	        type : 'POST',  
	        contentType : 'application/json; charset=utf-8',  
	        url : target+'/staffAuthority/new',
	        dataType : 'json',  
	        async:false,  
	        cache:false,  
	        data:jsonStringRef ,
	        success : function(data) { 
	          if (data && data.success == "true") {
	        	  alert(data.message);
	        	  //刷新权限列表
	        	  listAuthority(target,'authorityinfo','light2','fade'); 
	        	  
	          }else{
	        	  alert(data.message);
	          }  
	        },  
	        error : function() {  
	          alert("新增失败，请重试！")  
	        }  
	      });
}


function updateAuthority(target){
	var authority = new editStaffAuthority();
	var jsonStringRef = JSON.stringify(authority); 
	   jQuery.ajax( {  
	        type : 'POST',  
	        contentType : 'application/json; charset=utf-8',  
	        url : target+'/staffAuthority/update',
	        dataType : 'json',  
	        async:false,  
	        cache:false,  
	        data:jsonStringRef ,
	        success : function(data) { 
	          if (data && data.success == "true") {
	        	  alert(data.message);
	        	  //刷新权限列表
	        	  listAuthority(target,'authorityinfo','light2','fade');  
	        	  
	          }else{
	        	  alert(data.message);
	          }  
	        },  
	        error : function() {  
	          alert("加载失败，请重试！")  
	        }  
	      });
}

function deleteAuthority(target,authorityId){
	
	if(!window.confirm("确实要删除吗？")){
        return;
    }
	
	   jQuery.ajax( {  
	        type : 'Get',  
	        contentType : 'application/json; charset=utf-8',  
	        url : target+'/staffAuthority/delete?authorityId='+authorityId,
	        dataType : 'json',  
	        async:false,  
	        cache:false,  
	        success : function(data) { 
	          if (data && data.success == "true") {
	        	  alert(data.message);
	        	  //刷新权限列表
	        	  listAuthority(target,'authorityinfo','light2','fade');  
	        	  
	          }else{
	        	  alert(data.message);
	          }  
	        },  
	        error : function() {  
	          alert("加载失败，请重试！")  
	        }  
	      });
}

function listAuthority(target,authorityinfo,light,fade){
	   jQuery.ajax( {  
	        type : 'GET',  
	        contentType : 'application/json; charset=utf-8',  
	        url : target+'/staffAuthority/toShowlist',
	        dataType : 'json',  
	        async:false,  
	        cache:false,  
	        success : function(data) { 
		          if (data && data.success == "true") {
		        	  //刷新权限列表
		        	  //清空权限信息表格
		        	  var cit= $("#"+authorityinfo);
		        	  if(cit.size()>0) {
		        	    cit.find("tr:not(:first)").remove();
		        	  }
		        	  $.each(data.list, function(i, item) {  
		        		  
		        	  var popTab =  "popTab('"+light+"','"+fade+"','"+item.authorityId+"','"+item.authorityName+"','"+item.remarks+"')";
		        	  var toDeleteAuthority = "deleteAuthority('"+target+"','"+item.authorityId+"')";
		        	  var tr = "<tr><td>"+item.authorityName+"</td><td>"+item.remarks+'</td><td><a href="javascript:void(0)" onclick="'+popTab+'">修改</a></td>'
		        	  +' <td><a href="#" onclick="'+toDeleteAuthority+'" >删除</a></td>';
		        	  addTr(authorityinfo,-1,tr);
		        	  });
		        	  
		          }else{
		        	  
		          }  
		        },  
		        error : function() {  
		          alert("加载失败，请重试！")  
		        }  
		      });
	}
	   
function popTab(light,fade,value1,value2,value3){
	var element = document.getElementById(light);
	element.style.display='block';
	var fade = document.getElementById(fade);
	fade.style.display='block';
	$("#editAuthorityId").val(value1);
	$("#editAuthorityName").val(value2);
	$("#editRemarks").val(value3);
}

function popTabForNew(light,fade){
	var element = document.getElementById(light);
	element.style.display='block';
	var fade = document.getElementById(fade);
	fade.style.display='block';
	$("#newAuthorityName").val("");
	$("#newRemarks").val("");
	
}
