$(function () {
    findStores();
})

function findStores() {
    $.ajax({
        url:"/stores",
        type:"get",
        success: function(data){
            console.log(data);
            var html = "";
            for(var i=0;i<data.length;i++) {
                    html+="<option>"+data[i].name+"</option>";
            }
            $('#stores').html(html);
        },
    });
}

function addEmployee() {
    if($("#firstName").val() == ""){
        return;
    }
    if($("#lastName").val() == ""){
        return;
    }
    $.post("/employee",
        {"lastName":$("#lastName").val(),"firstName":$("#firstName").val(),"storeName":$("#stores").val()},
        function(data){
        alert("添加成功");
        window.location.href = '/employeePage';
    })
}

function f2() {
    if($("#firstName").val() == ""){
        $("#firstInfo").css("color","red");
        $("#firstInfo").html("不能为空");
    } else {
        $("#firstInfo").html("");
    }
}

function f1() {
    if($("#lastName").val() == ""){
        $("#lastInfo").css("color","red");
        $("#lastInfo").html("不能为空");
    } else {
        $("#lastInfo").html("");
    }
}