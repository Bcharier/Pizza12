const navigationLinks = document.querySelectorAll(".navigation-link");
const menuCategories = document.querySelectorAll(".category-container");

navigationLinks.forEach(e => {
    e.addEventListener("click", () => showMenuCategory(e))
})

function showMenuCategory(e) {
    let clickedElement = e
    let targetElement = document.querySelector("." + e.innerText)
    if (clickedElement.innerText === 'Tout') {
        menuCategories.forEach(e => {
            e.style.display = "inline-block";
        })
    } else {
        menuCategories.forEach(e => {
            e.style.display = "none";
        })
        targetElement.style.display = "inline-block"
    }
}

const addIcons = document.querySelectorAll('.product-add-icon');

addIcons.forEach(e => {
    e.addEventListener("click", () => addItemToCart(e))
})

async function addItemToCart(e) {
    let productId = e.id;
    let accountId = 2;

    let dataToSend = {
        productId: productId,
        accountId: accountId
    }

    let dataStringified = JSON.stringify(dataToSend);


    await fetch("/addItemToCart", {
        method: "POST",
        body: dataStringified,
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    })
}

