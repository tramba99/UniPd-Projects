#include "../include/orders.h"
#include "../include/order.h"
#include <string>
#include <vector>

Orders::Orders(std::vector<std::string> v) {
  for (int i = 1; i < v.size(); i = i + 4) {
    future_order.push_front(
        Order(stoi(v[i]), stoi(v[i + 1]), stoi(v[i + 2]), stoi(v[i + 3])));
  }
}

std::list<Order> Orders::get_next_order(int month) {
  std::list<Order> new_order;
  std::list<Order>::iterator it;
  for (it = future_order.begin(); it != future_order.end(); ++it) {
    if (it->get_time_stamp() == month)
      new_order.push_front(*it);
  }

  return new_order;
}

void Orders::update_status(std::list<Order> new_order) {
  std::list<Order>::iterator it;
  for (it = new_order.begin(); it != new_order.end(); ++it) {
    future_order.remove(*it);
    current_order.push_front(*it);
  }
}

void Orders::update_order(std::list<Order> order_rejected) {
  std::list<Order>::iterator it;
  std::list<Order>::iterator it2;
  for (it = order_rejected.begin(); it != order_rejected.end(); ++it) {
    for (it2 = future_order.begin(); it2 != future_order.end(); ++it2) {
      if (it2->get_id() == it->get_id())
        it2->postpone_order();
    }
  }
}

void Orders::done(unsigned int ord) {
  std::list<Order>::iterator it;
  for (it = current_order.begin(); it != current_order.end(); ++it) {
    if (it->get_id() == ord) {
      done_order.push_front(*it);
      current_order.remove(*it);
    }
  }
}
