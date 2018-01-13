function loadNoteBooksAction(){
	console.log('loadNoteBooksAction()');
	var url="notebook/list.do";
	var data={userId:getCookie('userId')};
	console.log(url);
	console.log(data);
	$.getJSON(url,data,function(result){
		if(result.state==SUCCESS){
			var list=result.data;
			console.log(list);
			//更新model对象中的数据
			model.updateNoteBooks(list);
		}
	});
}

model.updateNoteBooks=function(list){//该方法接收一个list参数
	var template='<li class="online"><a> '
		+'<i class="fa fa-book" title="online" rel="tooltip-bottom"></i>'
		+'[notebook.name]</a></li>';
	this.noteBooks=list;//本来model对象没有该属性,此时赋值同时添加该属性
	console.log(this);
	var $ul=$("#notebooks").empty();
	for(var i=0;i<this.noteBooks.length;i++){
		var notebook=this.noteBooks[i];
		var li=template.replace('[notebook.name]',notebook.name);
		$li=$(li);
		console.log(li);
		console.log($ul);
		//i标签为一个字体图标
		$ul.append($li);	
	}
	
	
};