package org.github.swsz2.springproxytutorial.app.v3;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v3")
public class OrderControllerV3 {

  private final OrderServiceV3 orderService;

  public OrderControllerV3(final OrderServiceV3 orderService) {
    this.orderService = orderService;
  }

  @RequestMapping("request")
  public String request(final String itemId) {
    orderService.orderItem(itemId);
    return "ok";
  }

  @RequestMapping("no-log")
  public String noLog() {
    return "ok";
  }
}
