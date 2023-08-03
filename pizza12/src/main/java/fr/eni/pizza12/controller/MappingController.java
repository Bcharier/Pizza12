package fr.eni.pizza12.controller;

import fr.eni.pizza12.dal.OrderRepository;
import fr.eni.pizza12.dal.ProductRepository;
import fr.eni.pizza12.bll.OrderService;
import fr.eni.pizza12.bo.OrderEntity;
import fr.eni.pizza12.bo.ProductEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.eni.pizza12.bo.AccountEntity;
import fr.eni.pizza12.bo.OrderEntity;
import fr.eni.pizza12.bo.OrderItemEntity;
import fr.eni.pizza12.bo.OrderStatus;
import fr.eni.pizza12.dal.AccountRepository;
import fr.eni.pizza12.dal.OrderItemRepository;
import fr.eni.pizza12.dal.OrderRepository;

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
  public String addProductToCart(@RequestBody DTO variables, Model model) {
    ProductEntity product = productRepository.getProductById(variables.getProductId());
    AccountEntity account = accountRepository.getAccountbyId(variables.getAccountId());
    int itemsInCart = 0;

    if (orderRepository.getOrderByAccountIdAndByOrderState(variables.getAccountId(),
        OrderStatus.EN_ATTENTE)
        .isEmpty()) {

      OrderEntity order = new OrderEntity(21, 0, null, OrderStatus.EN_ATTENTE,
          account);

      orderRepository.addOrder(order);

      OrderItemEntity orderItemEntity = new OrderItemEntity(order.getOrderId(),
          product, 1, null);

      orderItemRepository.addOrderItem(orderItemEntity);

      itemsInCart = 1;
    } else {
      OrderEntity order = orderRepository
          .getOrderByAccountIdAndByOrderState(variables.getAccountId(),
              OrderStatus.EN_ATTENTE)
          .get(0);

      OrderItemEntity orderItemEntity = new OrderItemEntity(order.getOrderId(),
          product, 1, null);

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
      ProductEntity productEntity = productRepository.getProductById(orderItem.getOrderItem().getProductId());
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

    Logger logger = LoggerFactory.getLogger(MappingController.class);
    logger.trace("A TRACE Message");
    logger.debug("A DEBUG Message");
    logger.info("An INFO Message");
    logger.warn("A WARN Message");
    logger.error("An ERROR Message");

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
