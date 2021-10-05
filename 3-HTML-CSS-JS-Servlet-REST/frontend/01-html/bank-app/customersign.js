let submit = document.getElementById("submit");
// let form = document.forms[0];
let firstname = document.getElementById("firstname");
let lastname = document.getElementById("lastname");
let email_id = document.getElementById("email");
let password = document.getElementById("password");
// success.style.display = "none";
// error.style.display = "none";


function validation() {

    firstname = firstname.value;
    lastname = lastname.value;
    email_id = email.value;
    password = password.value;


    if(firstname == "") {
        document.getElementById('first').innerHTML=" please enter the first name";
        return false;
    }

    if((firstname.length <= 2) || (firstname.length > 20)){
        document.getElementById('first').innerHTML = "First name must be between 3 and 20"
    }

    if(!isNaN(firstname)) {
        document.getElementById('first').innerHTML = "Only characters are allowed"
    }

    if(lastname == "") {
        document.getElementById('last').innerHTML=" please enter the last name";
        return false;
    }

    if((lastname.length <= 2) || (lastname.length > 20)){
        document.getElementById('last').innerHTML = "Last name must be between 3 and 20"
    }

    if(!isNaN(lastname)) {
        document.getElementById('last').innerHTML = "Only characters are allowed"
    }

    if(email_id == "") {
        document.getElementById('emailid').innerHTML=" please enter the email id";
        return false;
    }

    if(email_id.indexOf('@') <= 0){
        document.getElementById('emailid').innerHTML="@ at Invalid position";
        return false;
    }

    if((email_id.charAt(email_id.length-4)!='.') && (email_id.charAt(email_id.length-3)!=".")) {
        document.getElementById('emailid').innerHTML=". at Invalid position";
        return false;
    }

    if(password == "") {
        document.getElementById('pass').innerHTML=" please enter the password";
        return false;
    }



    if((password.length >= 6) || (password.length <= 10 )){
        document.getElementById('pass').innerHTML = "Password must be between 6 and 10"
    }

}


submit.addEventListener("click", function () {
    console.log("before add");
    addCustomer();
    console.log("after add");
});


async function addCustomer() {
    let customer = {
        firstName: firstname.value,
        lastName: lastname.value,
        email: email_id.value,
        password: password.value
        
    };

    var options = {
        method: 'POST',
        headers: { "Content-Type": "application/json"},
        body: JSON.stringify(customer)
    };
    try {
        let response = await fetch("http://localhost:8080/bank-app-rest/customers", options);
        console.log("after getting data");
        window.location.href="customerlogin.html";
        // clearFormData();
        console.log("after clearing form");
        
        
    } catch (err) {
        // error.style.display = "block";
        // error.innerText = "Failed to add employee. Retry or report to site administrator.";
    }
}


// function clearFormData() {
//     form.firstname.value = "";
//     form.lastname.value = "";
//     form.email.value = "";
//     form.password.value = "";
