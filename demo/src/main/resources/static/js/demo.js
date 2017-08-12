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
			alert("123");
			if (data == "OK") {
				$("#" + cur).children("#state").text("通过")
			} else {
				$("#" + cur).children("#state").text("未通过")
			}

		}
	});
})

$('.personItem').on('click', function() {
	$('#selectPerson').text($(this).text());
})


$('.subjectItem').on('click', function() {
	$('#selectSubject').text($(this).text());
})
