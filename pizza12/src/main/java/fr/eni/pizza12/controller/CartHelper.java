package fr.eni.pizza12.controller;

import java.util.ArrayList;
import java.util.List;

import fr.eni.pizza12.bo.CategoryEntity;
import fr.eni.pizza12.bo.OrderEntity;
import fr.eni.pizza12.bo.OrderItemEntity;
import fr.eni.pizza12.bo.OrderStates;
import fr.eni.pizza12.bo.ProductEntity;

public class CartHelper {

    public List<ProductEntity> generateOrderList(List<OrderItemEntity> listOrderItems,
            List<ProductEntity> listProducts) {
        List<ProductEntity> listFinalProducts = new ArrayList<>();

        for (OrderItemEntity orderItem : listOrderItems) {
            int productId = orderItem.getOrderItemId();
            int productQuantity = orderItem.getOrderItemQuantity();

            for (ProductEntity product : listProducts) {
                int productIdInList = product.getProductId();
                if (productId == productIdInList) {
                    String productName = product.getProductName();
                    int productPrice = product.getProductPrice();
                    CategoryEntity productCategory = product.getCategory();
                    boolean productActive = product.getProductActive();
                    int productOrderId = orderItem.getOrderId();

                    ProductEntity newProduct = new ProductEntity(productId, productName, productQuantity, productPrice,
                            productActive, productCategory, productOrderId);
                    listFinalProducts.add(newProduct);
                    break;
                }
            }
        }
        return listFinalProducts;
    }

    public List<OrderEntity> generateActiveOrderList(List<OrderEntity> listOrders) {
        List<OrderEntity> listOngoingOrders = new ArrayList<>();

        for (OrderEntity order : listOrders) {
            if (order.getOrderState() == OrderStates.EN_ATTENTE) {
                listOngoingOrders.add(order);
            }
        }

        return listOngoingOrders;
    }
}
