const http = require("http");
const url = require("url");
const desserts = require("./database.js");

const PORT = 3000;

function sendJSON(res, data){
  res.writeHead(200, {
    "Content-Type": "application/json",
    "Access-Control-Allow-Origin": "*"  
  });
  res.end(JSON.stringify(data));
}

const server = http.createServer(function(req, res){
  const parsedUrl = url.parse(req.url, true);
  const pathname = parsedUrl.pathname;
  const query = parsedUrl.query;

  if (pathname === "/desserts" && req.method === "GET"){
    let results = desserts;

    if (query.search) {
      const term = query.search.toLowerCase();
      results = results.filter(function (item) {
        return (
          item.name.toLowerCase().includes(term) ||
          item.flavor.toLowerCase().includes(term) ||
          item.category.toLowerCase().includes(term)
        );
      });
    }

    if (query.glutenFree === "true") {
      results = results.filter(function (item) {
        return item.glutenFree === true;
      });
    }

    if (query.lowFat === "true") {
      results = results.filter(function (item) {
        return item.lowFat === true;
      });
    }

    sendJSON(res, results);

  } else if(pathname.startsWith("/desserts/") && req.method === "GET"){
    const id = parseInt(pathname.split("/")[2]);
    const dessert = desserts.find(function (item) {
      return item.id === id;
    });

    if (dessert){
      sendJSON(res, dessert);
    } else{
      res.writeHead(404, {"Content-Type": "application/json"});
      res.end(JSON.stringify({error: "Dessert not found"}));
    }

  } else{
    res.writeHead(404, {"Content-Type": "application/json"});
    res.end(JSON.stringify({error: "Route not found"}));
  }
});

server.listen(PORT, function(){
  console.log("ButterVeil Bakery server is running at http://localhost:" + PORT);
  console.log("Try visiting: http://localhost:" + PORT + "/desserts");
});
