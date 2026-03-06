document.addEventListener("DOMContentLoaded", function () {

    const form = document.getElementById("form");
    const result = document.getElementById("out");

    form.addEventListener("submit", function (e) {

        e.preventDefault(); 

        let firstName = document.getElementById("firstName").value.trim();
        let lastName = document.getElementById("lastName").value.trim();
        let email = document.getElementById("floatingInput").value.trim();
        let phone = document.getElementById("floatingContact").value.trim();
        let course = document.getElementById("course").value;
        let address = document.getElementById("floatingTextarea2").value;

        let gender = document.querySelector('input[name="inlineRadioOptions"]:checked');

        let skills = [];
        document.querySelectorAll('input[type="checkbox"]:checked').forEach(skill => {
            skills.push(skill.nextElementSibling.innerText);
        });

        // VALIDATION

        if (firstName === "" || lastName === "") {
            alert("Name cannot be empty");
            return;
        }

        if (!email.includes("@")) {
            alert("Email must contain @");
            return;
        }

        if (!/^[0-9]{10}$/.test(phone)) {
            alert("Phone number must be 10 digits");
            return;
        }

        // DISPLAY CARD

        result.innerHTML = `
        <div class="card shadow p-3">
            <div class="card-body">
                <h4 class="card-title mb-3">Submitted Details</h4>
                <p><strong>Name:</strong> ${firstName} ${lastName}</p>
                <p><strong>Email:</strong> ${email}</p>
                <p><strong>Phone:</strong> ${phone}</p>
                <p><strong>Course:</strong> ${course}</p>
                <p><strong>Gender:</strong> ${gender ? gender.nextElementSibling.innerText : "Not selected"}</p>
                <p><strong>Skills:</strong> ${skills.join(", ")}</p>
                <p><strong>Address:</strong> ${address}</p>
            </div>
        </div>
        `;
    });

});