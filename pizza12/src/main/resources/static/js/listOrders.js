const orderStatusIcons = document.querySelectorAll(".general-order-actions > img")

orderStatusIcons.forEach(e => {
    e.addEventListener("click", () => orderStatusUpdate(e))
})

async function orderStatusUpdate(e) {

    let orderItemCategory = e.id;
    let orderId = e.closest('.order-stump-content').id

    let dataToSend = {
        orderId: orderId,
        orderItemCategory: orderItemCategory
    }

    let dataStringified = JSON.stringify(dataToSend)

    await fetch("/orderItemStatusUpdate", {
        method: 'POST',
        body: dataStringified,
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    })
        .then(highlightPreparedItems(orderItemCategory))
}

function highlightPreparedItems(orderItemCategory) {
    let orderItemsToShow = document.querySelectorAll('.cat-' + orderItemCategory)

    orderItemsToShow.forEach(e => {
        e.classList.add("yellowed")
    })

    setTimeout(() => {
        orderItemsToShow.forEach(e => {
            e.classList.remove("yellowed")
            e.classList.add("greyed")
        })
    }, 1500)
    return true
}

