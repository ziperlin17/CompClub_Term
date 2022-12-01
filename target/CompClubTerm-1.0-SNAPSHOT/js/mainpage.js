setInterval(function(){
    blink()
}, 3000);


function blink() {
    $("#keep").fadeTo(500, 0.1).fadeTo(500, 1.0);
}