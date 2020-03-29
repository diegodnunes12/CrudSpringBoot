/**
 * 
 */
function eliminar(id){
	swal({
		  title: "Tem certeza que deseja excluir?",
		  text: "Once deleted, you will not be able to recover this imaginary file!",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		})
		.then((OK) => {
		  if (OK) {
			  $.ajax({
				  url: "/deletar/" + id,
				  success: function(res){
					  console.log(res);
				  }
			  });
		    swal("Poof! Your imaginary file has been deleted!", {
		      icon: "success",
		    }).then((ok)=>{
		    	if(ok){
		    		location.href="/home";
		    	}
		    });
		  } else {
		    swal("Your imaginary file is safe!");
		  }
		});
}