//ADDItemPage JS

$("select").on("change", function() {
	$(this).nextAll("input, label").remove();
	if ($(this).prop("value") === "T-Shirt" ) {
		var sizeNumeric = document.getElementById("sizeNumeric");
		sizeNumeric.style.display = "none";

		var sizeAlphaNumeric = document.getElementById("sizeAlphaNumeric");
		sizeAlphaNumeric.style.display = "";


		//product Specification
		let tShirtSpecification = document.getElementById("TshirtSpecification");
		tShirtSpecification.style.display = ""

		let ShirtSpecification = document.getElementById("shirtSpecification");
		ShirtSpecification.style.display = "none"

		let jeansSpecification = document.getElementById("JeansSpecification");
		jeansSpecification.style.display = "none"

	}else if($(this).prop("value") === "Shirt"){
		var sizeNumeric = document.getElementById("sizeNumeric");
		sizeNumeric.style.display = "none";

		var sizeAlphaNumeric = document.getElementById("sizeAlphaNumeric");
		sizeAlphaNumeric.style.display = "";

		
		//product Specification
		let ShirtSpecification = document.getElementById("shirtSpecification");
		ShirtSpecification.style.display = ""

		let TshirtSpecification = document.getElementById("TshirtSpecification");
		TshirtSpecification.style.display = "none"

		let jeansSpecification = document.getElementById("JeansSpecification");
		jeansSpecification.style.display = "none"
	}
	else if($(this).prop("value") === "Jeans") {

		var sizeNumeric = document.getElementById("sizeNumeric");
		sizeNumeric.style.display = "";

		var sizeAlphaNumeric = document.getElementById("sizeAlphaNumeric");
		sizeAlphaNumeric.style.display = "none";


		//product Specification
		let jeansSpecification = document.getElementById("JeansSpecification");
		jeansSpecification.style.display = ""

		let ShirtSpecification = document.getElementById("shirtSpecification");
		ShirtSpecification.style.display = "none"

		let TshirtSpecification = document.getElementById("TshirtSpecification");
		TshirtSpecification.style.display = "none"

		
	}
});



function filterFunction() {
	const input = document.getElementById("myInput");
	const filter = input.value.toUpperCase();
	const div = document.getElementById("myDropdown");
	const a = div.getElementsByTagName("option");
	for (let i = 0; i < a.length; i++) {
	  txtValue = a[i].textContent || a[i].innerText;
	  if (txtValue.toUpperCase().indexOf(filter) > -1) {
		a[i].style.display = "";
	  } else {
		a[i].style.display = "none";
	  }
	}
  }