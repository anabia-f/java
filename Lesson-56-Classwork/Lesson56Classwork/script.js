let data,customers;
function init(){
  $.ajaxSetup({async: false});
  
  let link = "https://Lesson48DemoDBServer.ernestoporchett.repl.co";
  let route= "/customers"
  customers = $.getJSON(link+route).responseJSON;

  generateCards(customers)


}

function generateCards(customers){
  let centerpanel = document.getElementById("centerpanel");
  centerpanel.innerHTML = ""; //clear out the container
  
  let front ="";
  let back ="";

  for(let i=0; i<customers.length; i++){
    let customer = customers[i]
    front  = `<div class="card" >`;
    front +=   `<h3> Customer ID : ${customer.CustomerId}</h3>`;
    front +=   `<div> First Name : ${customer.FirstName}</div>`;
    front +=   `<div> Last Name : ${customer.LastName}</div>`;
    front +=   `<p> Email : ${customer.Email}</p>`;
    front += `</div>`;    
    back  = `<div class="card" >`;
    back +=   `<div> Country : ${customer.Country}</div>`;
    back +=   `<img src='countries/${customer.Country}.PNG'>`;
    back +=   `<hr>`;
    back += `</div>`;
    let card = new FlipCard(front,back);
    card.render("centerpanel");// render Flip card in container
  }
}

function filter(){
  let country = document.getElementById("country").value;
  console.log(country);

  let customerList = []; //create a list of songs searched for
  
  for(let i=0; i<customers.length;i++){
    let customer = customers[i] //get each sog
    //make sure the list is no
    if( customer.Country == country ) {
          //add to the new list
          customerList.push(customer);
       }
  }
  console.log(`number found ${customerList.length}`)
  generateCards(customerList);
  
}