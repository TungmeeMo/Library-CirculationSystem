/**
 * 
 */
/*将一个表单的数据返回成JSON对象  */
$.fn.serializeObject = function() {  
  var o = {};  
  var a = this.serializeArray();  
  $.each(a, function() {  
    if (o[this.name]) {  
      if (!o[this.name].push) {  
        o[this.name] = [ o[this.name] ];  
      }  
      o[this.name].push(this.value || '');  
    } else {  
      o[this.name] = this.value || '';  
    }  
  });  
  return o;  
};  

$("#submit").click(function() {  
	var jsonuserinfo = $.toJSON($('#form').serializeObject());  
    alert(jsonuserinfo);
    postadd();
    
});

function postadd(){ 
	   jQuery.ajax( {  
	          type : 'POST',  
	          contentType : 'application/json; charset=utf-8',  
	          url : 'http://localhost:8080/Library-CirculationSystem/user/add',  
	          data : jsonuserinfo,  
	          dataType : 'json',  
	          success : function(data) {  
	            alert("新增成功！");  
	          },  
	          error : function(data) {  
	            alert("新增失败")  
	          }  
	        });
  
}
  
$(document).ready(  
    function() {  
      jQuery.ajax( {  
        type : 'GET',  
        contentType : 'application/json; charset=utf-8',  
        url : 'http://localhost:8080/Library-CirculationSystem/user/list',  
        dataType : 'json',  
        success : function(data) {  
          if (data && data.success == "true") {  
            $('#info').html("共" + data.total + "条数据。<br/>");  
            $.each(data.data, function(i, item) {  
              $('#info').append(  
                  "编号：" + item.readerId + "，姓名：" + item.readerAddress  
                      + "，年龄：" + item.readerTelephone);  
            });  
          }  
        },  
        error : function() {  
          alert("error")  
        }  
      });  
      /*
      $("#submit").click(function() {  
        var jsonuserinfo = $.toJSON($('#form').serializeObject());  
        alert(jsonuserinfo);  
        jQuery.ajax( {  
          type : 'POST',  
          contentType : 'application/json; charset=utf-8',  
          url : 'http://localhost:8080/Library-CirculationSystem/user/add',  
          data : jsonuserinfo,  
          dataType : 'json',  
          success : function(data) {  
            alert("新增成功！");  
          },  
          error : function(data) {  
            alert("新增失败")  
          }  
        });  
      }); */ 
    });  