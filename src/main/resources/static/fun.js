function kopeeriMark(event) {

    var vastuseTekstiAla = document.getElementById("sisestus");

    var symbolid = ['¬', '&', '∨', '->', '~', '∀', '∃'];

    var senine = vastuseTekstiAla.value;

    var klahvikood = event.keyCode;

    if(klahvikood >= 112 && klahvikood <= 118){

        var kursoriPos = vastuseTekstiAla.selectionStart;
        var nihe = klahvikood == 115 ? 2 : 1;
        senine = senine.substr(0, kursoriPos) + symbolid[klahvikood-112] + senine.substr(kursoriPos);
        vastuseTekstiAla.value = senine;
        vastuseTekstiAla.selectionEnd = kursoriPos + nihe;
        event.preventDefault();
    }
}

