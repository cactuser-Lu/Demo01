$(function(){
	$("#word").keyup(function(){
		var word=$(this).val();
		//alert(word);
		$.post("/Demo16/findWordServlet",{word:word},function(data,status){
			//alert(data);
			if(word!=""&&data!=null){
				$("#div01").show();
				$("#div01").html(data);
			}else{
				$("#div01").hide();
			}
			
		});
	})
});