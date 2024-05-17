//ADDItemPage JS

$("select").on("change", function() {
	$(this).nextAll("input, label").remove();
	if ($(this).prop("value") === "Upper Body") {
		var text = document.getElementById("UpperBodyProductType");
		text.style.display = "block";

		var text1 = document.getElementById("LowerBody");
		text1.style.display = "none";

		var UpperBodySize = document.getElementById("sizeUpperBody");
		UpperBodySize.style.display = "";

		var UpperBodySize = document.getElementById("sizeLowerBody");
		UpperBodySize.style.display = "none";
	}
	else if($(this).prop("value") === "Lower Body") {
		var text = document.getElementById("LowerBody");
		text.style.display = "block";

		var text2 = document.getElementById("UpperBodyProductType");
		text2.style.display = "none";

		var UpperBodySize = document.getElementById("sizeLowerBody");
		UpperBodySize.style.display = "";

		var UpperBodySize = document.getElementById("sizeUpperBody");
		UpperBodySize.style.display = "none";
	}
});