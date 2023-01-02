package org.github.swsz2.springproxytutorial.app.v2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@RequestMapping("v2")
@ResponseBody
public class OrderControllerV2 {

  private final OrderServiceV2 orderService;

  public OrderControllerV2(final OrderServiceV2 orderService) {
    this.orderService = orderService;
  }

  @GetMapping("request")
  public String request(String itemId) {
    orderService.orderItem(itemId);
    return "ok";
  }

  @GetMapping("no-log")
  public String noLog() {
    return "ok";
  }
}
