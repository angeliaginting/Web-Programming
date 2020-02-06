$(document).ready(function(){
        $.ajax({
            type:"GET",
            url:"http://localhost:9081/shoppingcart/orders/",
            contentType:"application/json",
            success: function(data){
                var dat= JSON.parse(JSON.stringify(data));
                for(var i in dat){
                    $("#data").append("\
                    <button>"+dat[i].kode+"</button><br>\
                    ")
                    console.log(dat[i].kode);
                }
            },
            error: function (err){
                alert(err);
            }
        })


});


function add(){
    var jsonVar={
        kode:"BUY0135",
        id_transaksi:"IDe01eeFF",
        nama_barang:"ASUeS A456U",
        harga_barang:20000000,
        total_pembayaran:22000000
        }
        

    $.ajax({
        type:"POST",
        url:"http://localhost:9081/shoppingcart/orders/save",
        contentType:"application/json",
        data: JSON.stringify(jsonVar),
        success: function(datas){
            alert("sukses");
        },
        error: function (err){
            alert(err);
        }
    })
    alert("testing");
}
