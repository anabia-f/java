
let employees;
function init(){
  $.ajaxSetup({async: false});
  
  let link = "https://Lesson48ClassworkDBServer.ernestoporchett.repl.co";
  let route= "/employees"
  employees = $.getJSON(link+route).responseJSON;

  generateCards(employees);

  
}

function generateCards(employees){

  let mainpanel = document.getElementById("centerpanel");
  mainpanel.innerHTML = ""; //clear out the container
  let text ="";
  let content ="";
   
  for(let i=0; i<employees.length; i++){
    let employee = employees[i]
    text  = `<div class="card" >`
    text += `<h3> Employee ID : ${employee.EmployeeId}</h3>`;
    text += `<div> First Name : ${employee.FirstName}</div>`;
    text += `<div> Last Name : ${employee.LastName}</div>`;
    text += `<hr>`;
    text += `</div>`;
    content  = `<div class="card" >`
    content += `<p> City : ${employee.City}</p>`;
    content += `<img src="cities/${employee.City}.PNG">`;
    content += `<hr>`;
    content += `</div>`;
    let modal = new Modal(text,content);
    modal.render("centerpanel"); 
}

function filter(){
  let city = document.getElementById("city").value;
  console.log(city);

  let newEmployees = []; //create a list of songs searched for
  
  for(let i=0; i<employees.length;i++){
    let employee = employees[i] //get each sog
    //make sure the list is no
    if( employee.City == city ) {
          //add to the new list
          newEmployees.push(employee);
       }
  }
  console.log(`number found ${newEmployees.length}`)
  generateCards(newEmployees);
  
}}