$(function () {

})

function findAll() {
    $.ajax({
        url:"/stores",
        success:function (data) {
            console.log(data);
            console.log(data[0].id);
            console.log(data[0].name);
            console.log(data[0].listEmployee.length);
            var html = "";
            for(var i = 0;i < data.length; i++) {
                html += "<tr align='center'>" + "<td>" + data[i].id + "</td>";
                html += "<td>" + data[i].name + "</td>";
                html += "<td>";
                for(var j = 0; j < data[i].listEmployee.length; j++) {
                    if(j) {
                        html += "&nbsp&nbsp";
                    }
                    html += "<span>" + data[i].listEmployee[j].id + "." +data[i].listEmployee[j].lastName + data[i].listEmployee[j].firstName + "</span>";
                }
                html += "</td>";
                html += "<td>";
                for(var j = 0; j < data[i].listProduct.length; j++) {
                    if(j) {
                        html += "&nbsp&nbsp";
                    }
                    html += "<span>" + data[i].listProduct[j].id + "." + data[i].listProduct[j].name + "</span>";
                }
                html += "</td>"
                html += "<td>" + "<button onclick='editStore()'>编辑</button>" + "</td>";
                html += "<td>" + "<button onclick='deleteStore()'>删除</button>" + "</td>";
                html += "</tr>";
            }
            $("#content").html(html);
        }
    })
}

function addStore() {
    window.location.href="/storeAdd";
}

function editStore() {
    console.log("edit");
    $("#content").on("click","button",function () {
        var cid = parseInt($(this).closest("tr").find("td").eq(0).text());
        window.location.href='/storeEdit?id=' + cid;
    })
}

function deleteStore() {
    console.log("delete");
    if(confirm("确定删除？") == true) {
        $("#content").on("click","button",function () {
            var cid = parseInt($(this).closest("tr").find("td").eq(0).text());
            console.log(cid);
            $.ajax({
                url:"/store/" + cid,
                type:"delete",
                success:function () {
                    window.location.href="/storePage";
                }
            })
        })
    } else {
        return false;
    }
}