/**
 * 
 */
var cur;
$('tbody tr').on('click', function() {
	$('tbody tr').removeClass('success')
	$(this).addClass('success')
	cur = $(this).attr("id");
})

$('#judege').on('click', function() {

	$.ajax({
		url : '/autojudge',
		type : 'get',
		dataType : 'text',
		data : {
			id : cur
		},
		success : function(data) {
			if (data == "OK") {
				$("#" + cur).children("#state").text("通过")
			} else {
				$("#" + cur).children("#state").text("未通过")
			}

		}
	});
})

$('#delete-project-btn').on('click', function() {
	if (cur != null) {
		if(window.confirm('确定删除该项目？')) {
			$.ajax({
				url : '/index/'+cur,
				type : 'delete',
				dataType : 'text',	
				success: function(data) {
					if (data == "OK") {
						location.reload();
					} else {
						alert("删除失败");
					}
				}
			});
	     }
	} else {
		alert("请选择要删除的项目");
	}
	
})


