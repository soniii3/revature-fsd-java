let submit = document.getElementById("submit");
// let form = document.forms[0];
let firstname = document.getElementById("firstname");
let lastname = document.getElementById("lastname");
let email_id = document.getElementById("email");
let password = document.getElementById("password");
// success.style.display = "none";
// error.style.display = "none";




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

