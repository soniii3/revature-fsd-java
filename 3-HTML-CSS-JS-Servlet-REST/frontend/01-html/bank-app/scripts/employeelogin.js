let email= document.getElementById("email");
let pass = document.getElementById("password");
let form = document.getElementById("form");
let login = document.getElementById("submit");



async function loginEmployee(){

try {
    let response = await fetch("http://localhost:8080/bank-app-rest/employees/"+email.value+"/"+pass.value);
     if(response.status == "401"){
        //let display = document.getElementById("dis");
         //display.innerText = "Login Failed";
         alert("error");
     }
     if(response.status == 200){
        //let display = document.getElementById("dis");
        //display.innerText = "Login Success";
        alert("Login Successful");
         document.location = "accounts.html";

        
     }
     if(response.status == "500"){
        //let display = document.getElementById("dis");
        //display.innerText = " Internal Error";
       
        alert(" error");
         //display
     }
     

} catch (err) {

}
}
login.addEventListener("click",function(){
    
    
loginEmployee();



});
// login.addEventListener("click",function(){
//     if(email.value == "" || pass.value == ""){
//         let display = document.getElementById("dis");
//         display.innerText = "Enter all the Fields";
//     }
   
// });