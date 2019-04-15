$(function(){
    $("table").css({
        "background-color":"red"
    });
//   $("tr").forEach(r => {
//       r.css({"background-color":"blue"})
//   })
    $("table td").html(function (i,old) {
        return parseInt(Math.random()*100);
    }).click(function () {
        let x = $(this).html();
        $(this).html(parseInt(x)+1);
    });

    $(".provaDiv").html("prova").click(function(){
        $(".provaDiv").css({"background-color":"white"});
        $(this).css({"background-color":"black"});
    });
});
