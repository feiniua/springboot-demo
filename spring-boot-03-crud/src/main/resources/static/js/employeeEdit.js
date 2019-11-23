$(function () {
    // 获取地址上的传入的值
    var loc = location.href;
    var n1 = loc.length;//地址的总长度
    var n2 = loc.indexOf("=");//取得=号的位置
    var value = decodeURI(loc.substr(n2+1, n1-n2));//从=号后面的内容
    var id = parseInt(value);
    getInfo(id);

})

function updata() {
    if($("#lastName").val() == ""){
        $("#lastInfo").css("color","red");
        $("#lastInfo").html("不能为空");
        return;
    }
    $("#lastInfo").html("");
    if($("#firstName").val() == ""){
        $("#firstInfo").css("color","red");
        $("#firstInfo").html("不能为空");
        return;
    }
    $("#firstInfo").html("");

    // 获取span里的值并解析
    var id = parseInt($("#idText").text());
    console.log(id);
    $.ajax({
        url:"/employee/" + id,
        data:{"lastName":$("#lastName").val(),"firstName":$("#firstName").val(),"storeName":$("#stores").val()},
        type:"PUT",
        success:function () {
            alert("修改成功");
            window.location.href = '/employeePage';
        }
    })
}

function getStores(storeId) {
    $.ajax({
        url:"/stores",
        type:"get",
        success: function(data){
            var html = "";
            console.log("-----------");
            for(var i=0;i<data.length;i++) {
                if(data[i].id == storeId){
                    console.log(data[i].id);
                    html+="<option>"+data[i].name+"</option>";
                }
            }
            console.log("-----------");
            for(var i=0;i<data.length;i++) {
                if(data[i].id != storeId){
                    console.log(data[i].id);
                    html+="<option>"+data[i].name+"</option>";
                }
            }

            $('#stores').html(html);
        },
    });
}

function getInfo (id) {
    $.ajax({
        url:"/employee/" + id,
        type:"get",
        success:function (data) {
            // 修改span标签里的值
            $("#idText").html(data.id);
            $("#lastName").val(data.lastName);
            $("#firstName").val(data.firstName);
            var storeId = data.store.id;
            console.log(storeId);
            getStores(storeId);
        }
    })
}

