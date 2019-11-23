$(function () {

    // 要等待页面加载完成后才绑定的事件
    $("#findBtn").click(function () {
        $.ajax({
            url:"/products",
            type:"get",
            success:function (data) {
                console.log(data);
                var html = "";
                for(var i = 0; i < data.length; i++) {
                    html += "<tr align='center'>";
                    html += "<td>" + data[i].id + "</td>";
                    html += "<td>" + data[i].name + "</td>";
                    html += "<td>" + data[i].price + "</td>";
                    html += "<td>";
                    for(var j = 0; j < data[i].listStore.length; j++) {
                        if(j) {
                            html += "&nbsp&nbsp";
                        }
                        html +="<span>" + data[i].listStore[j].id +
                            "." + data[i].listStore[j].name + "</span>";
                    }
                    html += "</td>";
                    html += "<td><button onclick='editStore()'>编辑</button></td>";
                    html += "<td><button onclick='deleteStore()'>删除</button></td>";
                    html += "</tr>";
                }
                $("#productTable").html(html);
            }
        })
    })

    $("#addBtn").click(function () {
        window.location.href="/productAdd";
    })

    $("#backBtn").on("click",function () {
        window.location.href="/";
    })
})

function deleteStore() {
    if(confirm("确定删除？") == true) {
        $("#productTable").on("click","button",function () {
            var cid = parseInt($(this).closest("tr").find("td").eq(0).text());
            console.log(cid);
            $.ajax({
                url:"/product/" + cid,
                type:"delete",
                success:function () {
                    alert("删除成功");
                    window.location.href="/productPage";
                }
            })
        })
    }
}

function editStore() {
    $("#productTable").on("click","button",function () {
        var cid = parseInt($(this).closest("tr").find("td").eq(0).text());
        window.location.href='/productEdit?id=' + cid;
    })
}