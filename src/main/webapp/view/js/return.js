/**
 * 还书页面js
 */

function getBorrowInfoForReturn(target,readerReturnTab){
	var bookId = $("#bookId").val();
	if(bookId==null || ''==bookId){
		alert("请输入图书条形码.");
		return;
	}
	
	  jQuery.ajax( {  
	        type : 'GET',  
	        contentType : 'application/json; charset=utf-8',  
	        url : target+'/circulation/getBorrowInfoForReturn?bookId='+bookId, 
	        dataType : 'json',  
	        async:false,  
	        cache:false, 
	        success : function(data) { 
	        	
	          if (data && data.success == "true") {
	        	  $('#readerName').html(data.reader.readerName);
	        	  $('#readerGenderName').html(data.reader.readerGenderName);
	        	  $('#readerTypeName').html(data.reader.readerTypeName);
	        	  $('#readerAddress').html(data.reader.readerAddress);
	        	  
	        	  $('#readerTelephone').html(data.reader.readerTelephone);
	        	  $('#readerRegisterDate').html(data.reader.readerRegisterDate);
	        	  $('#readerBorrowbook').html(data.reader.readerBorrowbook);
	        	  $('#statusName').html(data.reader.statusName);
	        	  
	        	  //清空图书信息表格
	        	  var cit= $("#"+readerReturnTab);
	              if(cit.size()>0) {
	                  cit.find("tr:not(:first)").remove();
	              }
	        	  
	        	  var item = data.readercirculation;
	        	  var rborrowDate="";
	            	var rreturnDate="";
	            	var rexpectDate="";
	            	if(item.borrowDate){
	            		rborrowDate = (new Date(item.borrowDate)).Format("yyyy-MM-dd");
		        	  }
	            	if(item.returnDate){
	            		rreturnDate=(new Date(item.returnDate)).Format("yyyy-MM-dd");
		        	  }
	            	if(item.expectDate){
	            		rexpectDate = (new Date(item.expectDate)).Format("yyyy-MM-dd");
		        	  }
	            	var tr = "<tr><td>"+data.reader.readerName+"</td><td>"+item.bookName+
	            	"</td><td>"+rborrowDate+"</td><td>"+rreturnDate+"</td><td>"+rexpectDate+"</td><td>"+item.statusName+
	            	"</td><td>"+item.continueTimes+"</td><td>"+item.operationTypeName+"</td>";
//	            	alert(tr);
	            	addTr(readerReturnTab,-1,tr);
	          
	          }else{
	        	  alert("找不到图书信息，请重新输入图书条形码！"); 
	          }    
	        },  
	        error : function() {  
	          alert("error")  
	        }  
	      });
}
function returnBook(target,readerReturnTab){
	var bookId = $("#bookId").val();
	if(bookId==null || ''==bookId){
		alert("请输入图书条形码.");
		return;
	}
//	alert(bookId);
	
	  jQuery.ajax( {  
	        type : 'GET',  
	        contentType : 'application/json; charset=utf-8',  
	        url : target+'/circulation/returnBook?bookId='+bookId, 
	        dataType : 'json',  
	        async:false,  
	        cache:false, 
	        success : function(data) { 
	        	
	          if (data && data.success == "true") {
	        	  $('#readerName').html(data.reader.readerName);
	        	  $('#readerGenderName').html(data.reader.readerGenderName);
	        	  $('#readerTypeName').html(data.reader.readerTypeName);
	        	  $('#readerAddress').html(data.reader.readerAddress);
	        	  
	        	  $('#readerTelephone').html(data.reader.readerTelephone);
	        	  $('#readerRegisterDate').html(data.reader.readerRegisterDate);
	        	  $('#readerBorrowbook').html(data.reader.readerBorrowbook);
	        	  $('#statusName').html(data.reader.statusName);
	        	  
	        	  var item = data.readercirculation;
	        	  var rborrowDate="";
	            	var rreturnDate="";
	            	var rexpectDate="";
	            	if(item.borrowDate){
	            		rborrowDate = (new Date(item.borrowDate)).Format("yyyy-MM-dd");
		        	  }
	            	if(item.returnDate){
	            		rreturnDate=(new Date(item.returnDate)).Format("yyyy-MM-dd");
		        	  }
	            	if(item.expectDate){
	            		rexpectDate = (new Date(item.expectDate)).Format("yyyy-MM-dd");
		        	  }
	            	var tr = "<tr><td>"+data.reader.readerName+"</td><td>"+item.bookName+
	            	"</td><td>"+rborrowDate+"</td><td>"+rreturnDate+"</td><td>"+rexpectDate+"</td><td>"+item.statusName+
	            	"</td><td>"+item.continueTimes+"</td><td>"+item.operationTypeName+"</td>";
//	            	alert(tr);
	            	addTr(readerReturnTab,-1,tr);
	            	alert("还书成功！");
	            
	          }else{
	        	  alert("找不到图书，请重新输入图书条形码！"); 
	          }    
	        },  
	        error : function() {  
	          alert("系统错误！")  
	        }  
	      });
}
