//ADDItemPage JS

$("select").on("change", function() {
	$(this).nextAll("input, label").remove();
	if ($(this).prop("value") === "Numeric") {
		var sizeNumeric = document.getElementById("sizeNumeric");
		sizeNumeric.style.display = "";

		var sizeAlphaNumeric = document.getElementById("sizeAlphaNumeric");
		sizeAlphaNumeric.style.display = "none";
	}
	else if($(this).prop("value") === "Alpha Numeric") {

		var sizeAlphaNumeric = document.getElementById("sizeAlphaNumeric");
		sizeAlphaNumeric.style.display = "";

		var sizeNumeric = document.getElementById("sizeNumeric");
		sizeNumeric.style.display = "none";
	}
});