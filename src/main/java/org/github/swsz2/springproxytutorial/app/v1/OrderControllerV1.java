package org.github.swsz2.springproxytutorial.app.v1;

import org.github.swsz2.springproxytutorial.app.OrderController;
import org.github.swsz2.springproxytutorial.app.OrderService;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("v1")
public class OrderControllerV1 implements OrderController {

  private final OrderService orderService;

  public OrderControllerV1(final OrderService orderService) {
    this.orderService = orderService;
  }

  @Override
  public String request(String itemId) {
    orderService.orderItem(itemId);
    return "ok";
  }

  @Override
  public String noLog() {
    return "ok";
  }
}
