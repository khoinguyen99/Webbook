function ShowHelp(img, title, desc)
{
	img = gde(img);
	div = document.createElement('div');
	div.id = 'help';
	div.style.display = 'inline';
	div.style.position = 'absolute';
	div.style.width = '300';
	div.style.backgroundColor = '#FEFCD5';
	div.style.border = 'solid 1px #E7E3BE';
	div.style.padding = '10px';
	div.innerHTML = '<span class=helpTip><strong>' + title + '<\/strong><\/span><div class=helpTip>' + desc + '<\/div>';

	//img.parentNode.appendChild(div);
	var parent = img.parentNode;
	if(img.nextSibling)
		parent.insertBefore(div, img.nextSibling);
	else
		parent.appendChild(div)
}

function HideHelp(img)
{
	img = gde(img);
	div = gde('help');
	if (div) {
		img.parentNode.removeChild(div);
	}
}

function gde(Id) {
	return document.getElementById(Id);
}

function ValidateForm(callback) {
	returnValue = callback();
	if(typeof(returnValue) == 'undefined') {
		returnValue = true;
	}
	if(window.event) {
		window.event.returnValue = returnValue;
	}
	else {
		return returnValue;
	}
}

function addQuery(url, newparam)
{
	if(url.indexOf('?') != -1)
	{
		pr = '&';
	}
	else
	{
		pr = '?';
	}		
	return url + pr + newparam;
}

function clearText(field)
{
	if (field.defaultValue == field.value) field.value = '';
	else if (field.value == '') field.value = field.defaultValue;

}