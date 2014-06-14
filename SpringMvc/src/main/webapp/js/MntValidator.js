//jQuery Custom Validations 

jQuery.validator.addMethod("alphabets", function(value, element) {
	return this.optional(element)
			|| /^[A-Za-z ][A-Za-z0-9!@#$%^&*\/()_+:;?><~.,+=|}{ '"]*$/.test(value);
});

jQuery.validator.addMethod("alphanumeric", function(value, element) {
	return this.optional(element)
			|| /^[A-Za-z0-9][A-Za-z0-9!@#$%^&*\/()_+:;?><~.,+=|}{ '"]*$/.test(value);
});

jQuery.validator.addMethod("specialcharacters", function(value, element) {
	return this.optional(element) || /^[0-9a-zA-Z&_ ]+$/.test(value);
});


// Date Pattern Fuction
var datePattern = null;
$.ajax({
	type : "GET",
	url : "Resources/datePattern.xml",
	dataType : "xml",
	success : function(xml) {
		$(xml).find('datePatternsBean').each(function() {
			datePattern = $(this).find('datePattern').text();
			dateFun(datePattern);

		});

	}

});
