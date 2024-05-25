//ADDItemPage JS

$("select").on("change", function() {
	$(this).nextAll("input, label").remove();
	if ($(this).prop("value") === "Shirt" || $(this).prop("value") === "T-Shirt" || $(this).prop("value") === "Jacket") {
		var sizeNumeric = document.getElementById("sizeNumeric");
		sizeNumeric.style.display = "none";

		var sizeAlphaNumeric = document.getElementById("sizeAlphaNumeric");
		sizeAlphaNumeric.style.display = "";
	}
	else if($(this).prop("value") === "Jeans") {

		var sizeNumeric = document.getElementById("sizeNumeric");
		sizeNumeric.style.display = "";

		var sizeAlphaNumeric = document.getElementById("sizeAlphaNumeric");
		sizeAlphaNumeric.style.display = "none";
	}
});