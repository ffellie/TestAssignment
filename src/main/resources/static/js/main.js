import '../js/jquery.min.js'

const text = $("#text")

const base_url = "localhost:8080/"
$.get("message?id=1", function(data, status){
          text.append(data);
  });