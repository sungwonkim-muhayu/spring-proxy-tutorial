package org.github.swsz2.springproxytutorial.app.v1;

import org.github.swsz2.springproxytutorial.app.OrderRepository;
import org.github.swsz2.springproxytutorial.app.OrderService;

public class OrderServiceV1 implements OrderService {

  private final OrderRepository orderRepository;

  public OrderServiceV1(final OrderRepository orderRepository) {
    this.orderRepository = orderRepository;
  }

  @Override
  public void orderItem(final String itemId) {
    orderRepository.save(itemId);
  }
}
