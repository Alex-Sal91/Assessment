function alphabetToNumber(text) {
    var result = "";
    for (var i = 0; i < text.length; i++){
        var code = text.toUpperCase().charCodeAt(i)
        if (code > 64 && code < 91) result += (code - 64) + " ";
    }

    return result.slice(0, result.length-1)}

    console.log(alphabetToNumber("Hello My name is Alex"))