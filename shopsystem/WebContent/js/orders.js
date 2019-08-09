/* 
退款点击操作 
 */
var refundbox = "refundBox";
$(".refund").click(function(){
	showblack();
	showBox();
});


/*退出弹出框*/
$(document).on("click",".close.active",function(){
	closeblack();
	closeBox();
});

/* 弹出退款框 */
function showBox(){
	$("#"+refundbox).fadeIn("fast");
	$("#"+refundbox).find(".close").addClass("active");
}
function closeBox(){
	$("#"+refundbox).fadeOut("fast");
	$("#"+refundbox).find(".close").removeClass("active");
}