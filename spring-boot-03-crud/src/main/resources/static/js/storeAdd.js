$(function () {
    $.ajax({
        url:"/products",
        success:function (data) {
            console.log(data);
            var html = "可添加商品:<br>";
            for(var i = 0; i < data.length; i++) {
                if(i != 0 && i % 3 == 0) {
                    html += "<br>";
                }
                html += "<input type='checkbox' value='" + data[i].id + "' name='checks' />" +data[i].id + "." + data[i].name + "&nbsp";
            }
            $("#products").html(html);
        }
    })
})

function addStore() {
    if($("#name").val() == ""){
        return ;
    }

    var checkedBox = $("[name='checks']");
    console.log(typeof (checkedBox));
    var products = [];
    for(i in checkedBox) {
        if(checkedBox[i].checked) {
            products.push(parseInt(checkedBox[i].value));
        }
    }

    console.log(typeof(products[0]));
    console.log(products);
    $.ajax({
        url:"/store",
        type:"post",
        // 指定参数不做深度序列化
        traditional:true,
        data:{"name":$("#name").val(),productsId:products},
        success:function () {
            alert("添加成功");
            window.location.href='/storePage'
        }
    });
}

function nameHint() {
    if($("#name").val() == "") {
        $("#nameInfo").css("color","red");
        $("#nameInfo").html("不能为空");
    } else {
        $("#nameInfo").html("");
    }
}
