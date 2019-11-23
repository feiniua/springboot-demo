$(function () {
    $("#addBtn").click(function () {
        window.location.href = '/employeeAdd';
    })
})

function f3() {
    // input为空用 "" 为空字符串
    if($("#inputText").val() == ""){
        $("#spanText").css("color","red");
        $("#spanText").html("不能为空");
        return false;
    } else {
        $("#spanText").html("");
        return true;
    }
}

function updataEmployee() {
    $("#table").on("click",":button",function (enernt) {
        // 获取当前行的第一个单元格的值并解析成整数
        var cid = parseInt($(this).closest("tr").find("td").eq(0).text());
        window.location.href = '/employeeEdit?id=' + cid;
    })
}


function deleteEmployee() {
    // confirm 确认框
    if(confirm("确定删除？") == true){
        $("#table").on("click",":button",function (enernt) {
            var cid = parseInt($(this).closest("tr").find("td").eq(0).text());
            $.ajax({
                url: "/employee/"+cid,
                type: "DELETE",
                success:function (data) {
                    window.location.href = '/employeePage';
                }
            })
        })
        return true;
    } else {
        return false;
    }

}


function findAll() {
    $.get("/employees",function (data) {
        console.log(data);
        var html = "";
        for(var i = 0; i < data.length; i++) {
            html += "<tr>" +
                "<td align='center'>" + data[i].id + "</td>>" +
                "<td align='center'>" + data[i].lastName + "</td>" +
                "<td align='center'>" + data[i].firstName + "</td>" +
                "<td align='center'>" + data[i].store.id + "</td>" +
                "<td align='center'>" + data[i].store.name + "</td>" +
                "<td> <button onclick='updataEmployee()'>" + "编辑" + "</button> </td>" +
                "<td> <button onclick='deleteEmployee()'>" + "删除" + "</button> </td>" +
                "</tr>";
        }
        $("#content").html(html);
    })
}

function findById() {
    if(f3() == false){
        return;
    }
    $.get("/employee/"+$("#inputText").val(),
        function (data) {
        console.log(data);
        if(data.id == 0){
            alert("未找到");
            return;
        }
        var id = data.id
        var html = "";
        html += "<tr>" +
            "<td align='center' style='width: 25px'>" + data.id + "</td>>" +
            "<td align='center'>" + data.lastName + "</td>" +
            "<td align='center'>" + data.firstName + "</td>" +
            "<td align='center'>" + data.store.id + "</td>" +
            "<td align='center'>" + data.store.name + "</td>" +
            "<td align='right' style='width: 60px'> <button onclick='updataEmployee()'>" + "编辑" + "</button> </td>" +
            "<td> <button onclick='deleteEmployee(id)'>" + "删除" + "</button> </td>" +
            "</tr>";
        $("#content").html(html);
    })
}

function deleteById() {
    if(f3() == false){
        return;
    }
    $.ajax({
        url:"/employee/" + $("#inputText").val(),
        type:"get",
        success:function (data) {
            if(data.id == 0){
                alert("未找到");
                return false;
            }

            if (confirm("确定删除?")==true){
                $.ajax({
                    url: "/employee/"+$("#inputText").val(),
                    type: "DELETE",
                    success:function (data) {
                        window.location.href = '/employeePage';
                    }
                })
                return true;
            }else {
                return false;
            }
        }
    })
}