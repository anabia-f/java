let searchTerm = "";
let filterGlutenFree = false;
let filterLowFat = false;

document.addEventListener("DOMContentLoaded", function () {
  displayCards(desserts); 

  document.getElementById("search-bar").addEventListener("input", function () {
    searchTerm = this.value;
    filterAndDisplay();
  });

  document.getElementById("btn-gluten-free").addEventListener("click", function(){
    filterGlutenFree = !filterGlutenFree;
    this.classList.toggle("active", filterGlutenFree);
    filterAndDisplay();
  });

  document.getElementById("btn-low-fat").addEventListener("click", function(){
    filterLowFat = !filterLowFat;
    this.classList.toggle("active", filterLowFat);
    filterAndDisplay();
  });
});

function filterAndDisplay(){
  let results = desserts; 

  if(searchTerm){
    var term = searchTerm.toLowerCase();
    results = results.filter(function(item){
      return(
        item.name.toLowerCase().includes(term)||
        item.flavor.toLowerCase().includes(term)||
        item.category.toLowerCase().includes(term)
      );
    });
  }

  if(filterGlutenFree){
    results = results.filter(function(item){
      return item.glutenFree === true;
    });
  }

  if(filterLowFat){
    results = results.filter(function(item){
      return item.lowFat === true;
    });
  }
  displayCards(results);
}

function displayCards(list){
  var grid = document.getElementById("card-grid");
  grid.innerHTML = ""; 

  if(list.length === 0){
    grid.innerHTML = "<p class='no-results'>No desserts match your search.</p>";
    return;
  }

  list.forEach(function(dessert){
    let badges = "";
    if (dessert.glutenFree) badges += "<span class='badge gf'>Gluten-Free</span>";
    if (dessert.lowFat)     badges += "<span class='badge lf'>Low Fat</span>";

    var card = document.createElement("div");
    card.className = "flip-card";
    card.innerHTML = `
      <div class="flip-card-inner">
        <div class="flip-card-front">
          <div class="card-category">${dessert.category}</div>
          <h2 class="card-name">${dessert.name}</h2>
          <p class="card-price">$${dessert.price.toFixed(2)}</p>
          <div class="card-badges">${badges}</div>
          <p class="flip-hint">Hover to see details ↩</p>
        </div>
        <div class="flip-card-back">
          <h2 class="card-name">${dessert.name}</h2>
          <p class="card-flavor">✦ ${dessert.flavor} flavor</p>
          <p class="card-description">${dessert.description}</p>
          <div class="card-badges">${badges}</div>
          <p class="card-price-back">$${dessert.price.toFixed(2)}</p>
        </div>
      </div>
    `;

    grid.appendChild(card);
  });
}
