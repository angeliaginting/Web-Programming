    var id= new URL(location.href).searchParams.get("id");
    var photo;
    var nama;
    var harga;
    var ram;
    var rom;
    var processor;
$(document).ready(function(){
    $.ajax({
        type:"GET",
        url:"http://localhost:9082/shoppingcart/produk/"+id,
        contentType:"application/json",
        success: function(data){
            var dat= JSON.parse(JSON.stringify(data));
                photo=dat.photo;
                nama=dat.nama;
                harga=dat.harga;
                stok=dat.stok;
                $("#data").append("\
                <table border = '0' align = 'center'>\
                <tr>\
                    <td colspan = '2'><h3 style='text-align:center;'>"+dat.nama+" </h3></td>\
                </tr>\
                <tr>\
                    <td><img src='foto_produk/"+dat.photo+"'></img></td>\
                    <td><h5>Harga : Rp. "+dat.harga+"</h5>\
                    <h5>Spesifikasi Laptop</h5>\
                    <h5>RAM: "+dat.ram+"</h5>\
                    <h5>ROM: "+dat.rom+"</h5>\
                    <h5>Processor: "+dat.processor+"</h5>\
                    </td>\
                </tr>\
                <tr>\
                </tr>\
                <tr>\
                <td><div class='col-md-10'>\
                    <a  class = 'btn btn-primary' onclick='add()'>Add to Cart</a>\
                </div></td>\
                </tr>\
                </table>\
                ")
            
        },
        error: function (err){
        }
    })

                  

});
function add(){
    console.log(id)
    console.log(photo)
    console.log(nama)
    console.log(harga)
    console.log(stok)
    var jsonVar={
        "kode":id,
        "nama":nama,
        "harga":harga,
        "photo":photo
        }
        

    $.ajax({
        type:"POST",
        url:"http://localhost:9082/shoppingcart/keranjang/save",
        contentType:"application/json",
        data: JSON.stringify(jsonVar),
        success: function(datas){
            alert("produk berhasil ditambahkan ke keranjang");
        },
        error: function (err){
            alert(err);
        }
    })
}
