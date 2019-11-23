$(function () {
    var loc = location.href;
    var n1 = loc.length;
    var n2 = loc.indexOf("=");
    var id = parseInt(loc.substr(n2+1,n1-n2));
    getProducts();
    getInfo(id);
})

function getInfo(id) {
    $.ajax({
        url:"/store/" + id,
        type:"get",
        success:function (data) {
            console.log(data);
            $("#name").val(data.name);
            console.log(data.listProduct[0].id);
            for(var i = 0; i < data.listProduct.length; i++) {
                $("#" + data.listProduct[i].id).prop("checked",true);
            }
        }
    })
}

function getProducts() {
    $.ajax({
        url:"/products",
        type:"get",
        success:function(data) {
            var html = "选择商品:<br>";
            for(var i = 0; i < data.length; i++) {
                if(i && i % 3 == 0) {
                    html += "<br>";
                }
                html += "<input type='checkbox' id='" + data[i].id + "' name='checks' value='" + data[i].id + "'/>" +
                    data[i].id + "." + data[i].name + "&nbsp";
            }
            $("#products").html(html);
        }
    })
}

function edit() {
    if($("#name").val() == "") {
        return;
    }

    var loc = location.href;
    var n1 = loc.length;
    var n2 = loc.indexOf("=");
    var id = parseInt(loc.substr(n2+1,n1-n2));

    var checkedBox = $("[name='checks']");
    console.log(typeof (checkedBox));
    var products = [];
    for(i in checkedBox) {
        if(checkedBox[i].checked) {
            products.push(parseInt(checkedBox[i].value));
        }
    }

   $.ajax({
       url:"/store/" + id,
       type:"put",
       traditional:true,
       data:{"name":$("#name").val(),productsId:products},
       success:function () {
           alert("修改成功");
           window.location.href='/storePage';
       }
   })
}

function f1() {
    if($("#name").val() == "") {
        $("#nameInfo").css("color","red");
        $("#nameInfo").html("不能为空");
    } else {
        $("#nameInfo").html("");
    }
}