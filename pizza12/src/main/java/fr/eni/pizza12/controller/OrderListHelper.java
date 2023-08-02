package fr.eni.pizza12.controller;

import java.math.BigDecimal;

import org.apache.tomcat.util.descriptor.LocalResolver;
import org.springframework.cglib.core.Local;
import org.springframework.context.i18n.LocaleContext;
import org.thymeleaf.util.StringUtils;

import fr.eni.pizza12.bo.OrderEntity;
import fr.eni.pizza12.bo.OrderItemEntity;
import fr.eni.pizza12.bo.OrderItemsStatus;
import fr.eni.pizza12.utils.Constants;
import fr.eni.pizza12.utils.MathUtils;

public class OrderListHelper {

  public String displayOrderTitle(OrderEntity orderEntity) {
    StringBuffer sb = new StringBuffer();
    sb.append(Constants.ORDERLIST_ORDERTITLE_PREFIX);
    sb.append(Constants.SPACE);
    if (orderEntity != null) {
      if (orderEntity.getTableNumber() > 0) {
        sb.append(Constants.ORDERLIST_ORDERTITLE_TARGET_TABLE);
        sb.append(Constants.SPACE);
        sb.append(orderEntity.getTableNumber());
      } else {
        sb.append(Constants.ORDERLIST_ORDERTITLE_TARGET_CUSTOMER);
        sb.append(Constants.SPACE);
        sb.append(orderEntity.getAccount().getAccountLastName().toUpperCase());
        sb.append(Constants.SPACE);
        sb.append(orderEntity.getAccount().getAccountFirstName());
      }

    }

    return sb.toString();
  }

  public Integer getNonCancelledItemCount(OrderEntity orderEntity) {
    Integer count = 0;
    for (OrderItemEntity item : orderEntity.getOrderItems()) {
      if (item.getOrderItemsStatus() != OrderItemsStatus.ANNULEE) {
        count++;
      }
    }
    return count;
  }

  public String getCancelledItemCount(OrderEntity orderEntity) {
    StringBuffer sb = new StringBuffer();
    Integer count = 0;
    for (OrderItemEntity item : orderEntity.getOrderItems()) {
      if (item.getOrderItemsStatus() == OrderItemsStatus.ANNULEE) {
        count++;
      }
    }
    if (count > 0) {
      sb.append(" - ");
      sb.append(count);
      sb.append(" annulé");
      if (count > 1) {
        sb.append("s");
      }
    }
    return sb.toString();
  }

  public Integer getRemainingItemCount(OrderEntity orderEntity) {
    Integer count = 0;
    for (OrderItemEntity item : orderEntity.getOrderItems()) {
      if (item.getOrderItemsStatus() == OrderItemsStatus.COMMANDEE
          || item.getOrderItemsStatus() == OrderItemsStatus.EN_PREPARATION
          || item.getOrderItemsStatus() == OrderItemsStatus.PREPAREE
          || item.getOrderItemsStatus() == OrderItemsStatus.CUISSON) {
        count++;
      }
    }
    return count;
  }

  public String getItemToDeliverCount(OrderEntity orderEntity) {
    StringBuffer sb = new StringBuffer();
    Integer count = 0;
    for (OrderItemEntity item : orderEntity.getOrderItems()) {
      if (item.getOrderItemsStatus() == OrderItemsStatus.PRETE) {
        count++;
      }
    }
    if (count > 0) {
      sb.append(" - ");
      sb.append(count);
      sb.append(" à livrer");
    }
    return sb.toString();
  }

  public BigDecimal getTotalPrice(OrderEntity orderEntity) {
    BigDecimal total = new BigDecimal(0);
    for (OrderItemEntity item : orderEntity.getOrderItems()) {
      if (item.getOrderItemsStatus() != OrderItemsStatus.ANNULEE) {
        total = total.add(item.getOrderItem().getProductPrice().multiply(new BigDecimal(item.getOrderItemQuantity())));
      }
    }
    return total;
  }
}
