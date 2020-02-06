$(document).ready(function(){
    $.ajax({
        type:"GET",
        url:"http://localhost:9082/shoppingcart/produk",
        contentType:"application/json",
        success: function(data){
            var dat= JSON.parse(JSON.stringify(data));
            for(var i in dat){
                $("#data").append("\
                <div class = 'col-md-3'>\
                <div class ='thumbnail'>\
      <img src='foto_produk/"+dat[i].photo+"'>\
      <div class='caption'>\
       <h3>"+dat[i].nama+" </h3>\
        <div><a href='cart.html?id="+dat[i].kode+"' class = 'btn btn-primary' '>Detail</a></div>\
      </div>\
                ")
                console.log(dat[i].kode);
            }
        },
        error: function (err){
            // alert(err);
        }
    })
    


});
