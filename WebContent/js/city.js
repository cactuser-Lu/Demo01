$(function() {
	$("#pro").change(function(){
		var cid=$(this).val();
		$.post("/Demo16/cityServlet",{cid:cid},function(data,status){
			$("#city").html("<option value='' >"+"---请选择-");
			$(data).find("city").each(function(){
				var id=$(this).children("id").text();
				var cname=$(this).children("cname").text();
				//alert(cname+"upup!"+id);
				$("#city").append("<option value='"+id+"' >"+cname);
			});
		});
	});
});