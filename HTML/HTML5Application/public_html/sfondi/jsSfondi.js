
document.querySelector("#paesaggio").onmousemove = function (e) {
    console.log(e.clientX, e.clientY);
    let x = e.clientX ;
    let y = e.clientY ;
    document.querySelector("#lente").style.backgroundPositionX = -x -(150*x/100) + "px";
    document.querySelector("#lente").style.backgroundPositionY = -y - (80*x/100) + "px";
};

