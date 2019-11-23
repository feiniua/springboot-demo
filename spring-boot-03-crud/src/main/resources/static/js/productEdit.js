$(function () {
    var loc = location.href;
    var n1 = loc.length;
    var n2 = loc.indexOf("=");
    var cid = parseInt(loc.substr(n2+1,n1-n2));
    console.log(cid);

    $.ajax({
        url:"/product/" + cid,
        type:"get",
        success:function (data) {
            console.log(data);
            $("#name").val(data.name);
            $("#price").val(data.price);
        }
    })

    $("#submitBtn").click(function () {
        if($("#name").val() == "" || $("#price").val() == "") {
            return;
        }
        $.ajax({
            url:"/product/" + cid,
            type:"put",
            data:{"name":$("#name").val(),"price":$("#price").val()},
            success:function () {
                alert("修改成功");
                window.location.href="/productPage";
            }
        })
    })

    $("#backBtn").click(function () {
        window.location.href="/productPage";
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