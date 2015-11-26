var add = function(a, b) {
	return a + b;
};
var myObject = {
	value: 3
};
myObject.double = function() {
	var that = this;
	var helper = function() {
		this.value = add(this.value, this.value);
		that.value = add(that.value, that.value);
	};
	helper();
}

myObject.double();
console.info(myObject.value);