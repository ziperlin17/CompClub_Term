let pic = document.querySelectorAll('.imgB1')
let pici = []
for (let i = 0; i < pic.length; i++) {
    pici[i] = false;
}
function countChoosen(array) {
    var resoult = 0;
    for (let i = 0; i < array.length; i++) {
        if (array[i]) {
            resoult++;
        }
    }
    return resoult;
}
let button = document.getElementById('submit')
button.textContent = "Book "+countChoosen(pici).toString() + " seats";


console.log(pici);
// console.log(pic.style.opacity)
for (let i = 0; i < pic.length; i++) {
    pic[i].addEventListener('click', () => {
        // console.log(pic.style.opacity)
        if (pic[i].getAttribute('src').split('/')[3]==('no1.png') || pic[i].getAttribute('src').split('/')[3]==('novip1.png')){
            console.log('занято')
        }
        if (pic[i].style.opacity == 0.65 && pic[i].getAttribute('src').split('/')[3]!=('no1.png') && pic[i].getAttribute('src').split('/')[3]!=('novip1.png') ) {
            // console.log(pic[i].getAttribute('src').split('/')[2]== ('no1.png' || 'novip1.png'))
            pic[i].style.opacity = 1
            pici[i] = true;
            button.textContent = "Book "+countChoosen(pici).toString() + " seats for "+ toPay(pici) + " rub";
        } else if (pic[i].style.opacity == 1) {
            pic[i].style.opacity = 0.65
            pici[i] = false;
            button.textContent = "Book "+countChoosen(pici).toString() + " seats for "+ toPay(pici) + " rub";

        }

    })
}

function sendIds (array) {
    let sendArray = []
    for (let i = 0; i < array.length; i++) {
        if (array[i]) {
            sendArray.push(i+1);
        }
    }
    return sendArray;
}
console.log(sessionStorage.getItem("user"))
function toPay (array) {
    var count = document.getElementById('hourvalue').value
    var sum = 0;
    for (let i = 1; i < 21; i++) {
        if (array[i-1]) {
            sum = sum + 60*count;
        }
    }
    for (let i = 21; i < 27; i++) {
        if (array[i-1]) {
            sum = sum + 90*count;
        }
    }
    for (let i = 27 ; i < 33; i++) {
        if (array[i-1]) {
            sum = sum + 60*count;
        }
    }
    return sum.toString();
}


$(document).ready(function() {
    $('#submit').click(function() {
        var count = document.getElementById('hourvalue').value
        $.ajax({
            method: 'post',
            url : '/focused/payment',
            data : {
                toPay: toPay(pici),
                chosenPlaces : sendIds(pici).toString(),
                chosenHours : count.toString()
            },
            success : function(response) {
                document.location.href = "/focused/payment"
            }
        });
    });
});