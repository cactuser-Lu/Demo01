$(function() {
	$("#pro").change(function(){
		var cid=$(this).val();
		$.post("/Demo16/cityServlet",{cid:cid},
				function(data,status){
			$("#city").html("<option value='' >"+"---请选择-");
			$(data).each(function(index,c){
				//alert(c.cname);
				$("#city").append("<option value='"+c.id+"' >"+c.cname);
			});
		    },"json");
	});
});