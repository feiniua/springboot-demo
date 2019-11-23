$(function () {
    $("#backBtn").click(function () {
        window.location.href="/productPage";
    })

    $("#submitBtn").click(function () {
        if($("#name").val() == "" || $("#price").val() == "") {
            return;
        }
        console.log("submit");
        $.ajax({
            url:"/product",
            type:"post",
            data:{"name":$("#name").val(),"price":$("#price").val()},
            success:function () {
                alert("添加成功");
                window.location.href=("/productPage");
            }
        })
    })


})

function nameWarn() {
    if($("#name").val() == "") {
        $("#nameInfo").css("color","red");
        $("#nameInfo").html("不能为空");
    } else {
        $("#nameInfo").html("");
    }
}

function priceWarn() {
    if($("#price").val() == "") {
        $("#priceInfo").css("color","red");
        $("#priceInfo").html("不能为空");
    } else {
        $("#priceInfo").html("");
    }
}