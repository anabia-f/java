
let data,songs;
async function init(){
  let link = "https://ideal-winner-9759vx4gx6grhwqr-8500.app.github.dev";
  let route = "/songs";
  info = await fetch(link+route);
  songs = await info.json();
  console.log(songs);

  generateCards(songs);

  
 
}

function generateCards(songs){
  let output = document.getElementById("output");
  let build = "";

  for(let i=0; i<songs.length; i++){
    let song = songs[i];
    build += `<div class="card>`;
    build += `<h3>Song Name</h3>`;
    build += `<p>${song.Name}</p>`;
    build += `<div>Album</div>`;
    build += `<h3>${song.Title}</h3>`;
    build += `<div>Composer</div>`;
    build += `<h3>${song.Composer}</h3>`;
    build += `<hr>`;
    build += `</div>`;
  }

  output.innerHTML = build;
}


