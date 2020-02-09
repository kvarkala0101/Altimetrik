function submitAction() {
	
    var tableId = document.getElementById("content");
    $("#content").empty();
	var number = document.getElementById("vin").value;
	var url = "/getDetails/"+number;
	
	$.get(url, function(data, status){
		if(status === "success") {
    	   var str = "<table><tr><th>Make</th><th>Model</th><th>Year</th><th>Plant Country</th><th>Plant State</th></tr><tr><td>"+data.Make+"</td><td>"+data.Model+"</td><td>"+data.Year+"</td><td>"+data.PlantCountry+"</td><td>"+data.PlantState+"</td></tr></table>";
    	   tableId.innerHTML = str; 
    	}
  	});
	
}