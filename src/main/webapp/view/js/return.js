/**
 * 还书页面js
 */

function getBorrowInfo(target){
	var bookId = $("#bookId").val();
	if(bookId==null || ''==bookId){
		alert("请输入图书条形码.");
		return;
	}
	
	  jQuery.ajax( {  
	        type : 'GET',  
	        contentType : 'application/json; charset=utf-8',  
	        url : target+'/circulation/getCirculationByBookId?bookId='+bookId, 
	        dataType : 'json',  
	        async:false,  
	        cache:false, 
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
	        	  
	        	  var cit= $("#"+readerBorrowTab);
	              if(cit.size()>0) {
	                  cit.find("tr:not(:first)").remove();
	              }
	        	  
	            $.each(data.circulationList, function(i, item) {  
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
	            	var tr = "<tr><td>"+item.borrowId+"</td><td>"+item.staffName+"</td><td>"+item.readerName+"</td><td>"+item.bookName+
	            	"</td><td>"+rborrowDate+"</td><td>"+rreturnDate+"</td><td>"+rexpectDate+"</td><td>"+item.statusName+
	            	"</td><td>"+item.continueTimes+"</td><td>"+item.operationTypeName+"</td>";
	            	addTr(readerBorrowTab,-1,tr);
	            });  
	          }else{
	        	  alert("找不到读者，请重新输入读者编号！"); 
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
	alert(bookId);
	
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
	            	alert(tr);
	            	addTr(readerReturnTab,-1,tr);
	            	alert("还书成功！");
	        	  
//	        	  var cit= $("#"+readerBorrowTab);
//	              if(cit.size()>0) {
//	                  cit.find("tr:not(:first)").remove();
//	              }
	        	  
//	            $.each(data.circulationList, function(i, item) {  
//	            	var rborrowDate="";
//	            	var rreturnDate="";
//	            	var rexpectDate="";
//	            	if(item.borrowDate){
//	            		rborrowDate = (new Date(item.borrowDate)).Format("yyyy-MM-dd");
//		        	  }
//	            	if(item.returnDate){
//	            		rreturnDate=(new Date(item.returnDate)).Format("yyyy-MM-dd");
//		        	  }
//	            	if(item.expectDate){
//	            		rexpectDate = (new Date(item.expectDate)).Format("yyyy-MM-dd");
//		        	  }
//	            	var tr = "<tr><td>"+item.borrowId+"</td><td>"+item.staffName+"</td><td>"+item.readerName+"</td><td>"+item.bookName+
//	            	"</td><td>"+rborrowDate+"</td><td>"+rreturnDate+"</td><td>"+rexpectDate+"</td><td>"+item.statusName+
//	            	"</td><td>"+item.continueTimes+"</td><td>"+item.operationTypeName+"</td>";
//	            	addTr(readerBorrowTab,-1,tr);
//	            }); 
	            
	          }else{
	        	  alert("找不到图书，请重新输入图书条形码！"); 
	          }    
	        },  
	        error : function() {  
	          alert("系统错误！")  
	        }  
	      });
}
