//edit_init.js 初始化
var SUCCESS=0;
var model={};
$(function(){//页面加载完毕后执行
	console.log("init.js");
	//页面加载后,立即加载笔记本列表
	loadNoteBooksAction();//在edit_notebook.js里
});