
//alert("works!!");

function setCookie(name, value, options) {
    options = options || {};

    var expires = options.expires;

    if (typeof expires == "number" && expires) {
        var d = new Date();
        d.setTime(d.getTime() + expires * 1000);
        expires = options.expires = d;
    }
    if (expires && expires.toUTCString) {
        options.expires = expires.toUTCString();
    }

    value = encodeURIComponent(value);

    var updatedCookie = name + "=" + value;

    for (var propName in options) {
        updatedCookie += "; " + propName;
        var propValue = options[propName];
        if (propValue !== true) {
            updatedCookie += "=" + propValue;
        }
    }

    document.cookie = updatedCookie;
}

function deleteCookie(name) {
    setCookie(name, "", {
        expires: -1
    })
}

function goOut() {
    deleteCookie("login");
    deleteCookie("password");
}


function check_equals() {
    var password2 = document.getElementById("password2");
    var password1 = document.getElementById("password1");
    var error = document.getElementById("error_label");
    var button = document.getElementById("submit_button");
    if (password1.value !== password2.value){
        error.innerHTML = "incorrect password";
        button.disabled = true;
    }
    else{
        error.innerHTML = "";
        button.disabled = false;
    }
}
function check_login(){
    //alert("FGfxd");
    var login = document.getElementById("login");
    var error = document.getElementById("error_label1");
    var button = document.getElementById("submit_button");
    var http_request = new XMLHttpRequest();
    if (window.XMLHttpRequest) {
        http_request = new XMLHttpRequest();
    }
    http_request.open('POST', "check_login", true);
    http_request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    http_request.send("login="+login.value);
    http_request.onreadystatechange = function () {
        if(http_request.readyState === XMLHttpRequest.DONE && http_request.status === 200) {
            if (http_request.responseText === "true"){
                error.innerHTML = "Such login already exists";
                button.disabled = true;
            }
            else {
                error.innerHTML = "";
                button.disabled = false;
            }
        }
    };

}