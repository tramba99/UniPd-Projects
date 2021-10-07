// Davide Masserut
#ifndef ORDERS_H
#define ORDERS_H
#include "order.h"
#include <iostream>
#include <list>
#include <vector>

class Orders {
private:
  std::list<Order> done_order;
  std::list<Order> current_order;
  std::list<Order> future_order;

public:
  Orders(std::vector<std::string> v);

  std::list<Order> get_done_order() { return done_order; }
  std::list<Order> get_current_order() { return current_order; }
  std::list<Order> get_future_order() { return future_order; }
  std::list<Order> get_next_order(int month);

  void update_status(std::list<Order> new_order);
  void update_order(std::list<Order> order_rejected);
  void done(unsigned int ord);
};
#endif
