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

function queryReaderById(target){
     jQuery.ajax( {  
	        type : 'GET',  
	        contentType : 'application/json; charset=utf-8',  
	        url : target+'reader/queryById?readerId='+$("#readerId").val(), 
//	        url : 'http://localhost:8080/Library-CirculationSystem/reader/queryById?readerId='+$("#readerId").val(),
//	        url : 'http://localhost:8080/Library-CirculationSystem/user/list',  
	        dataType : 'json',  
	        success : function(data) { 
	        	
	          if (data && data.success == "true") {
	        	  $('#readerName').val(data.data.readerName);
	        	  $('#readerGenderName').val(data.data.readerGenderName);
	        	  $('#readerTypeName').val(data.data.readerTypeName);
	        	  $('#readerAddress').val(data.data.readerAddress);
	        	  
	        	  $('#readerTelephone').val(data.data.readerTelephone);
	        	  $('#readerRegisterDate').val(data.data.readerRegisterDate);
	        	  $('#readerBorrowbook').val(data.data.readerBorrowbook);
	        	  $('#statusName').val(data.data.statusName);
	        	  
//	            $.each(data.data, function(i, item) {  
//	            	$('#readerName').val(item.readerName);
//	            	$('#readerAddress').val(item.readerAddress);
//	            });  
	          }  
	        },  
	        error : function() {  
	          alert("error")  
	        }  
	      });
}

function queryBookById(target){
	if($("#bookId").val()==null || ''==$("#bookId").val()){
		alert("请输入图书条形码.");
		return;
	}
    jQuery.ajax( {  
	        type : 'GET',  
	        contentType : 'application/json; charset=utf-8',  
	        url : target+'book/queryById?bookId='+$("#bookId").val(), 
	        dataType : 'json',  
	        success : function(data) { 
	        	
	          if (data && data.success == "true") {
	        	  
	        	  $('#bookTypeName').html(data.data.typeName);
	        	  $('#bookName').html(data.data.bookName);
	        	  $('#authorName').html(data.data.authorName);
	        	  $('#publishingHouse').html(data.data.publishingHouse);
	        	  if(data.data.publishingDate){
	        		  $('#publishingDate').html((new Date(data.data.publishingDate)).toLocaleDateString());
	        	  }
	        	  if((data.data.readerRegisterDate)){
	        		  $('#readerRegisterDate2').html((new Date(data.data.readerRegisterDate)).toLocaleDateString());
	        	  }
	        	  $('#isBorrowedName').html(data.data.isBorrowedName);
	          }  
	        },  
	        error : function() {  
	          alert("error")  
	        }  
	      });
}

function borrowBook(target){
	
	var bookId = $("#bookId").val();
	var readerId = $("#readerId").val();
	var staffId = $("#staffId").val();
	
	if(bookId==null || ''==bookId){
		alert("请输入图书条形码.");
		return;
	}
	var jsonStr = '{"bookId":bookId,"readerId":readerId,"staffId":staffId}';
	var params = $.toJSON(jsonStr);
	alert(params);
    jQuery.ajax( {  
	        type : 'POST',  
	        contentType : 'application/json; charset=utf-8',  
//	        url : target+'circulation/borrowBook?bookId='+bookId+'&readerId='+readerId+'&staffId='+staffId,
	        url : target+'circulation/borrowBook',
	        dataType : 'json',  
	        async:false,  
	        cache:false,  
	        data:params ,
	        success : function(data) { 
	        	
	          if (data && data.success == "true") {
	        	  alert("借书成功！");
	          }  
	        },  
	        error : function() {  
	          alert("借书失败，请重试！")  
	        }  
	      });
}
