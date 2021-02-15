// Showing/Hiding drop-down menu
function scrollFunction() {
	if (document.body.scrollTop > 100 || document.documentElement.scrollTop > 100) 
	{
		document.getElementById("SecondMenuDisplay").style.display = "block";
	} 
	else 
	{
		document.getElementById("SecondMenuDisplay").style.display = "none";
	}
}

//Hiding drop-down menu 
document.getElementById("SecondMenuDisplay").style.display = "none";

//Calling function at 100px
window.onscroll = function() {
    scrollFunction()
};