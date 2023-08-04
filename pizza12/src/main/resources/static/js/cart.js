const buttonValidationCart = document.querySelector(".button-cart-validation")
const validationModal = document.querySelector(".validation-modal")
const validationClose = document.querySelector(".validation-close")

if (buttonValidationCart != null) {
    buttonValidationCart.addEventListener("click", (e) => validateCart(e))
}
validationClose.addEventListener("click", () => closeValidationModal())


async function validateCart(e) {
    console.log("click")
    let orderId = e.target.id

    let dataToSend = {
        orderId: orderId
    }

    let dataStringified = JSON.stringify(dataToSend)

    await fetch("/cartValidation", {
        method: 'POST',
        body: dataStringified,
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    })
        .then(openValidationModal())
}

function openValidationModal() {
    validationModal.style.display = "flex"
}

function closeValidationModal() {
    validationModal.style.display = "none"
}