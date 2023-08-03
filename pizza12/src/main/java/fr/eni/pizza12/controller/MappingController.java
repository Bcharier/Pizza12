package fr.eni.pizza12.controller;

import fr.eni.pizza12.dal.ProductRepository;
import fr.eni.pizza12.bo.ProductEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import fr.eni.pizza12.bo.AccountEntity;
import fr.eni.pizza12.bo.OrderEntity;
import fr.eni.pizza12.bo.OrderItemEntity;
import fr.eni.pizza12.bo.OrderStates;
import fr.eni.pizza12.dal.OrderItemRepository;
import fr.eni.pizza12.dal.OrderRepository;

@Controller
public class MappingController {

    private OrderRepository orderRepository;
    private OrderItemRepository orderItemRepository;
    private ProductRepository productRepository;

    public MappingController(ProductRepository productRepository, OrderRepository orderRepository,
            OrderItemRepository orderItemRepository) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
    }

    @GetMapping("/")
    public String showMenu(Model model) {
        List<ProductEntity> menu;
        menu = productRepository.getAllProductsAndCategories();

        List<String> categories = new ArrayList<>();

        for (ProductEntity item : menu) {
            String itemCategory = item.getCategory().getCategoryName();
            if (!categories.contains(itemCategory)) {
                categories.add(itemCategory);
            }
        }
        model.addAttribute("categories", categories);
        model.addAttribute("products", menu);
        return "index";
    }

    @PostMapping("/addItemToCart")
    public String addProductToCart(@RequestBody DTO variables, Model model) {
        ProductEntity product = productRepository.getProductById(variables.getProductId());
        int itemsInCart = 0;

        if (orderRepository.getOrderByAccountIdAndByOrderState(variables.getAccountId(),
                OrderStates.EN_ATTENTE)
                .isEmpty()) {

            OrderEntity order = new OrderEntity(21, 0, null, OrderStates.EN_ATTENTE,
                    variables.getAccountId());

            orderRepository.addOrder(order);

            OrderItemEntity orderItemEntity = new OrderItemEntity(order.getOrderId(),
                    product.getProductId(), 1, null);

            orderItemRepository.addOrderItem(orderItemEntity);

            itemsInCart = 1;
        } else {
            OrderEntity order = orderRepository
                    .getOrderByAccountIdAndByOrderState(variables.getAccountId(),
                            OrderStates.EN_ATTENTE)
                    .get(0);

            OrderItemEntity orderItemEntity = new OrderItemEntity(order.getOrderId(),
                    product.getProductId(), 1, null);

            orderItemRepository.addOrderItem(orderItemEntity);

            itemsInCart = order.getOrderItems().size();
        }

        model.addAttribute("itemsInCart", itemsInCart);
        return "index";
    }

    @GetMapping("/designSystem")
    public String designSystem() {
        return "designSystem";
    }

    @GetMapping("orderTool")
    public String orderTool() {
        return "orderTool";
    }

    @GetMapping("/account")
    public String openAccount() {
        return "account";
    }

    @GetMapping("/cart")
    public String openCart(Model model) {
        CartHelper cartHelper = new CartHelper();

        List<OrderEntity> orderEntity = orderRepository.getOrderByAccountId(1);

        List<OrderEntity> listActiveOrders = cartHelper.filterOngoingOrders(orderEntity);

        List<OrderItemEntity> orderItemEntity = new ArrayList<>();
        for (OrderEntity order : listActiveOrders) {
            List<OrderItemEntity> orderItemEntityTemp = orderItemRepository.getOrderItemByOrderId(order.getOrderId());
            for (OrderItemEntity orderItem : orderItemEntityTemp) {
                orderItemEntity.add(orderItem);
            }
        }

        List<ProductEntity> listProductsInOrder = new ArrayList<>();

        for (OrderItemEntity orderItem : orderItemEntity) {
            ProductEntity productEntity = productRepository.getProductById(orderItem.getOrderItemId());
            listProductsInOrder.add(productEntity);
        }

        List<ProductEntity> listProductsInCart = cartHelper.generateOrderList(orderItemEntity, listProductsInOrder);

        model.addAttribute("listProducts", listProductsInCart);
        model.addAttribute("order", listActiveOrders);

        return "cart";
    }

    @PostMapping("/orderValidation")
    public String orderValidation(OrderEntity orderEntity) {

        return "cart";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/employeeRedirect")
    public String serviceTools() {
        return "serviceTools";
    }

    @GetMapping("/listOrders")
    public String listOrders() {
        return "listOrders";
    }
}
