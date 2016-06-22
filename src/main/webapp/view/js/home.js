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


////////添加一行的装方法///////
/**
 * 为table指定行添加一行
 *
 * tab 表id
 * row 行数，如：0->第一行 1->第二行 -2->倒数第二行 -1->最后一行
 * trHtml 添加行的html代码
 *
 */
function addTr(tab, row, trHtml){
   //获取table最后一行 $("#tab tr:last")
   //获取table第一行 $("#tab tr").eq(0)
   //获取table倒数第二行 $("#tab tr").eq(-2)
   var $tr=$("#"+tab+" tr").eq(row);
   if($tr.size()==0){
      alert("指定的table id或行数不存在！");
      return;
   }
   $tr.after(trHtml);
}


//对Date的扩展，将 Date 转化为指定格式的String
//月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符， 
//年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字) 
//例子： 
//(new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423 
//(new Date()).Format("yyyy-M-d h:m:s.S")      ==> 2006-7-2 8:9:4.18 
Date.prototype.Format = function (fmt) { //author: meizz 
 var o = {
     "M+": this.getMonth() + 1, //月份 
     "d+": this.getDate(), //日 
     "h+": this.getHours(), //小时 
     "m+": this.getMinutes(), //分 
     "s+": this.getSeconds(), //秒 
     "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
     "S": this.getMilliseconds() //毫秒 
 };
 if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
 for (var k in o)
 if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
 return fmt;
}

//调用示例：
/*
var time1 = new Date().Format("yyyy-MM-dd");
var time2 = new Date().Format("yyyy-MM-dd HH:mm:ss");  
*/

    



function addTr2(tab, row){
    var trHtml="<tr align='center'><td width='30%'><input type='checkbox' name='ckb'/></td><td width='30%'>地理</td><td width='30%'>60</td></tr>";
    addTr(tab, row, trHtml);
  }

/**
 * @param target url 地址头
 * @param readerBorrowTab 显示读者已借书的信息的table
 */
function queryReaderById(target,readerBorrowTab){
     jQuery.ajax( {  
	        type : 'GET',  
	        contentType : 'application/json; charset=utf-8',  
	        url : target+'/reader/queryById?readerId='+$("#readerId").val(), 
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

function emptyTab(){
	$('#bookTypeName').html("");
	  $('#bookName').html("");
	  $('#authorName').html("");
	  $('#publishingHouse').html("");
	  $('#publishingDate').html("");
	  $('#readerRegisterDate2').html("");
	  $('#isBorrowedName').html("");
}

function queryBookById(target){
	
	if($("#bookId").val()==null || ''==$("#bookId").val()){
		alert("请输入图书条形码.");
		return;
	}
	
	emptyTab();
	
    jQuery.ajax( {  
	        type : 'GET',  
	        contentType : 'application/json; charset=utf-8',  
	        url : target+'/book/queryById?bookId='+$("#bookId").val(), 
	        dataType : 'json',  
	        success : function(data) { 
	        	
	          if (data && data.success == "true") {
	        	  
	        	  $('#bookTypeName').html(data.data.typeName);
	        	  $('#bookName').html(data.data.bookName);
	        	  $('#authorName').html(data.data.authorName);
	        	  $('#publishingHouse').html(data.data.publishingHouse);
	        	  if(data.data.publishingDate){
	        		  $('#publishingDate').html((new Date(data.data.publishingDate)).Format("yyyy-MM-dd"));
	        	  }
	        	  if((data.data.readerRegisterDate)){
	        		  $('#readerRegisterDate2').html((new Date(data.data.readerRegisterDate)).Format("yyyy-MM-dd"));
	        	  }
	        	  $('#isBorrowedName').html(data.data.isBorrowedName);
	        	  $('#isBookBorrowed').val(data.data.isBorrowed);
	          }else{
	        	  alert("找不到图书，请重新输入图书条形码！"); 
	          }  
	        },  
	        error : function() {  
	          alert("查询失败，请重试！");
	        }  
	      });
}


function circulation(){  
	var bookId = $("#bookId").val();
	var readerId = $("#readerId").val();
	var staffId = $("#staffId").val();
    this.staffId = staffId;  
    this.readerId = readerId;  
    this.bookId = bookId;  
}  

function borrowBook(target){
	
	var bookId = $("#bookId").val();
	if(bookId==null || ''==bookId){
		alert("请输入图书条形码.");
		return;
	}
	
	if($("#isBookBorrowed").val()=='1'){
		alert("该图书已借出！");
		return;
	}
	
	if($('#readerName')==null || ''==$('#readerName').val()){
		alert("请先输入读者信息！");
		return;
	}
	
	var cir = new circulation();
	 var jsonStringRef = JSON.stringify(cir);  
//	 alert(jsonStringRef);
    jQuery.ajax( {  
	        type : 'POST',  
	        contentType : 'application/json; charset=utf-8',  
	        url : target+'/circulation/borrowBook',
	        dataType : 'json',  
	        async:false,  
	        cache:false,  
	        data:jsonStringRef ,
	        success : function(data) { 
	        	
	          if (data && data.success == "true") {
	        	  alert("借书成功！");
	        	  queryReaderById(target,"readerBorrowInfo");
	          }  
	        },  
	        error : function() {  
	          alert("借书失败，请重试！")  
	        }  
	      });
}
