var id= new URL(location.href).searchParams.get("id");
var photo;
var total=0;
var nama;
var harga;
var quantity;
$(document).ready(function(){
    $.ajax({
        type:"GET",
        url:"http://localhost:9082/shoppingcart/keranjang",
        contentType:"application/json",
        success: function(data){
            var dat= JSON.parse(JSON.stringify(data));
            
            for(var i in dat){
                total+=dat[i].harga;
                $("#produk").append("\
                <div class = 'col-md-3'>\
                <div class ='thumbnail'>\
                    <img src='foto_produk/"+dat[i].photo+"'>\
                    <h3>"+dat[i].nama+" </h3>\
                    <h5>Rp. "+dat[i].harga+"</h5>\
                    <div><a  class = 'btn btn-primary' ' onclick = 'del("+dat[i].kode+")'>HAPUS</a></div>\
                    </div>\
                ")
                console.log(dat[i].kode);
            }
            $("#tot").append("\
            <div class = 'col-md-8'>\
            <div class = 'thumbnail'>\
            <h3>Total Harga</h3>\
            <h5>Rp. "+total+"</h5>\
            ");
        },
        error: function (err){
        }
    })
    $("#data").append("\<button>test</button><br>\ ")

});
function del(ids){
        $.ajax({
            type:"DELETE",
            url:"http://localhost:9082/shoppingcart/keranjang/delete/"+ids,
            contentType:"application/json",
            success: function(datas){
                location.href="keranjang.html";
                alert("pr");
            },
            error: function (err){
                alert("gagal");
            }
        })  

}
