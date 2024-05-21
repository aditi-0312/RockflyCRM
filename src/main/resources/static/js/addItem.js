//ADDItemPage JS

$("select").on("change", function() {
	$(this).nextAll("input, label").remove();
	if ($(this).prop("value") === "Shirt" && "T-Shirt") {
		var sizeNumeric = document.getElementById("sizeNumeric");
		sizeNumeric.style.display = "none";

		var sizeAlphaNumeric = document.getElementById("sizeAlphaNumeric");
		sizeAlphaNumeric.style.display = "";
	}
	else if($(this).prop("value") === "Jeans" && "Pants" && "Pajamas") {

		var sizeNumeric = document.getElementById("sizeNumeric");
		sizeNumeric.style.display = "";

		var sizeAlphaNumeric = document.getElementById("sizeAlphaNumeric");
		sizeAlphaNumeric.style.display = "none";
	}
});