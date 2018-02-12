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
    deleteCookie("JSESSIONID");
}

/*$(document).ready(function() {
    $(".submit").click(function() {
        $(".submit").addClass("loading");
        setTimeout(function() {
            $(".submit").addClass("hide-loading");
            // For failed icon just replace ".done" with ".failed"
            $(".done").addClass("finish");
        }, 3000);
        setTimeout(function() {
            $(".submit").removeClass("loading");
            $(".submit").removeClass("hide-loading");
            $(".done").removeClass("finish");
            $(".failed").removeClass("finish");
        }, 5000);
    })
});*/