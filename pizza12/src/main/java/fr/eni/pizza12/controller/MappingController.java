package fr.eni.pizza12.controller;

import fr.eni.pizza12.dal.OrderRepository;
import fr.eni.pizza12.dal.ProductRepository;
import fr.eni.pizza12.bll.OrderService;
import fr.eni.pizza12.bo.OrderEntity;
import fr.eni.pizza12.bo.ProductEntity;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import fr.eni.pizza12.bo.AccountEntity;
import fr.eni.pizza12.bo.OrderItemEntity;
import fr.eni.pizza12.bo.OrderItemsStatus;
import fr.eni.pizza12.bo.OrderStatus;
import fr.eni.pizza12.dal.AccountRepository;
import fr.eni.pizza12.dal.OrderItemRepository;

@Controller
public class MappingController {

    private OrderRepository orderRepository;
    private OrderItemRepository orderItemRepository;
    private ProductRepository productRepository;
    private AccountRepository accountRepository;
    private OrderService orderService;

    public MappingController(ProductRepository productRepository, OrderRepository orderRepository,
            OrderItemRepository orderItemRepository, AccountRepository accountRepository, OrderService orderService) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
        this.accountRepository = accountRepository;
        this.orderService = orderService;
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
    public String addProductToCart(@RequestBody DTOCart variables, Model model) {
        ProductEntity product = productRepository.getProductById(variables.getProductId());
        AccountEntity account = accountRepository.getAccountbyId(variables.getAccountId());
        List<ProductEntity> itemsInCart = new ArrayList<>();

        if (orderRepository.getOrderByAccountIdAndByOrderState(variables.getAccountId(),
                OrderStatus.EN_ATTENTE)
                .isEmpty()) {

            OrderEntity order = new OrderEntity(23, 0, null, OrderStatus.EN_ATTENTE,
                    account);

            orderRepository.addOrder(order);

            OrderItemEntity orderItemEntity = new OrderItemEntity(order.getOrderId(),
                    product, 1, null);

            orderItemRepository.addOrderItem(orderItemEntity);
            for (OrderItemEntity orderItem : orderItemRepository.getOrderItemByOrderId(order.getOrderId())) {
                itemsInCart.add(orderItem.getOrderItem());
            }

        } else {
            OrderEntity order = orderRepository
                    .getOrderByAccountIdAndByOrderState(variables.getAccountId(),
                            OrderStatus.EN_ATTENTE)
                    .get(0);

            OrderItemEntity orderItemEntity = new OrderItemEntity(order.getOrderId(),
                    product, 1, null);

            orderItemRepository.addOrderItem(orderItemEntity);

            for (OrderItemEntity orderItem : orderItemRepository.getOrderItemByOrderId(order.getOrderId())) {
                itemsInCart.add(orderItem.getOrderItem());
            }
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

        List<OrderEntity> orderEntity = orderRepository.getOrderByAccountId(2);

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
            ProductEntity productEntity = productRepository.getProductById(orderItem.getOrderItem().getProductId());
            listProductsInOrder.add(productEntity);
        }

        List<ProductEntity> listProductsInCart = cartHelper.generateOrderList(orderItemEntity, listProductsInOrder);

        model.addAttribute("listProducts", listProductsInCart);
        model.addAttribute("order", listActiveOrders);

        return "cart";
    }

    @PostMapping("/cartValidation")
    public String orderValidation(@RequestBody DTOCart variables, Model model) {
        OrderEntity orderEntity = orderRepository.getOrderByOrderId(variables.getOrderId());

        orderEntity.setOrderState(OrderStatus.A_PREPARER);
        orderEntity.setDeliveryTime(LocalDateTime.now().withHour(12).withMinute(00));
        orderRepository.updateOrder(orderEntity);

        return "cart";
    }

    @PostMapping("/orderItemStatusUpdate")
    public String orderItemStatusUpdate(@RequestBody DTOListOrders variables, Model model) {

        orderItemRepository.updateOrderItemByOrderIdAndOrderItemCategory(variables.getOrderId(),
                variables.getOrderItemCategory(), OrderItemsStatus.PRETE);

        return "listOrders";
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
    public String listOrders(Model model) {
        List<OrderEntity> orderList = orderService.getAllPendingOrdersAndAssociatedOrderItems();
        model.addAttribute("orderList", orderList);
        return "listOrders";
    }
}
