function returnBook(rentId) {
    let form = document.createElement("form");
    form.action = "/book/return"
    form.method = "post";

    let inputRentId = document.createElement("input")
    inputRentId.type = "hidden";
    inputRentId.name = "rent_id"
    inputRentId.value = rentId;
    form.appendChild(inputRentId);

    document.body.appendChild(form);
    form.submit();
    document.body.removeChild(form)
}

function renewBook(rentId) {
 let form = document.createElement("form");
    form.action = "/admin/renew"
    form.method = "post";

    let inputRentId = document.createElement("input")
    inputRentId.type = "hidden";
    inputRentId.name = "rent_id"
    inputRentId.value = rentId;
    form.appendChild(inputRentId);

    document.body.appendChild(form);
    form.submit();
    document.body.removeChild(form)
}

function mybookRenew(rentId) {
    let form = document.createElement("form");
    form.action = "/book/renew"
    form.method = "post";

    let inputRentId = document.createElement("input")
    inputRentId.type = "hidden";
    inputRentId.name = "rent_id"
    inputRentId.value = rentId;
    form.appendChild(inputRentId);

    document.body.appendChild(form);
    form.submit();
    document.body.removeChild(form)
}
