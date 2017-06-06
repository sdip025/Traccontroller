$(document).ready(
		function() {

			$("#pwsubmit").click(
					function() {
						var oldpassword = $("#Existedpw").val();
						var newpassword = $("#newpw").val();
						var confpassword = $("#confirmpw").val();
						if (oldpassword.length == 0 || newpassword.length == 0
								|| confpassword.length == 0) {
							alert("Please Enter Valid Password" + oldpassword
									+ "" + newpassword + "" + confpassword);
                        
						}
						else if(oldpassword == newpassword ){
							alert("Please Enter a new Password");
							
						}else if(newpassword !=confpassword )
							alert("Password Does Not Match.");

					});

		});
