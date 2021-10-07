#include "../include/order_manager.h"
#include "../include/models.h"
#include "../include/orders.h"
#include <list>

Order_Manager::Order_Manager(const Models &models, const Orders &orders,
                             const Components &components, unsigned int cash)
    : models(models), orders(orders), components(components), cash(cash) {}

bool Order_Manager::update(unsigned int current_month) {
  std::list<Order> current_orders = orders.get_current_order();
  if (current_orders.empty() && orders.get_future_order().empty())
    return false;
  while (!current_orders.empty()) {
    Order order = current_orders.front();
    current_orders.pop_front();
    order.decrease_time();
    if (order.get_time_stamp() == 0) {
      orders.done(order.get_id());
      cash += (models.get_model(order.get_model_id())).get_price() *
              order.get_quantity();
    }
  }
  std::list<Order> new_order = orders.get_next_order(current_month);
  std::list<Order> new_order_accepted;
  std::list<Order> new_order_rejected;
  while (!new_order.empty()) {
    int total_price_order = 0;
    Order order = current_orders.front();
    current_orders.pop_front();
    std::map<unsigned int, unsigned int> component =
        (models.get_model(order.get_model_id())).get_components();
    std::map<unsigned int, unsigned int>::iterator itr;
    int max_time = 0;
    for (itr = component.begin(); itr != component.end(); ++itr) {
      int component_id = itr->first;
      int component_quantity = itr->second;
      Component component_info = components.get_component(component_id);
      if (component_info.get_delivery_time() > max_time) {
        max_time = component_info.get_delivery_time();
      }
      total_price_order +=
          component_info.get_price(component_quantity) * component_quantity;
    }
    if (cash - total_price_order * order.get_quantity() >= 0) {
      order.set_remaining_time(max_time);
      new_order_accepted.push_front(order);
      cash -= total_price_order;
    } else
      new_order_rejected.push_front(order);
  }

  orders.update_status(new_order_accepted);
  orders.update_order(new_order_rejected);

  return true;
}

void Order_Manager::status() {
  std::cout << "ordini evasi\n";
  std::list<Order> order_done = orders.get_done_order();
  while (!order_done.empty()) {
    std::cout << order_done.front().get_id() << " ";
    order_done.pop_front();
  }

  std::cout << "\npezzi ordinati ma non arrivati\n";
  std::list<Order> current_order = orders.get_done_order();
  std::map<unsigned int, unsigned int> excepted_component_number;
  while (!current_order.empty()) {
    Order order = current_order.back();
    current_order.pop_back();
    int quantity_order = order.get_quantity();
    Model model = models.get_model(order.get_model_id());
    std::map<unsigned int, unsigned int> component_list =
        model.get_components();
    std::map<unsigned int, unsigned int>::iterator itr;
    for (itr = component_list.begin(); itr != component_list.end(); ++itr) {
      if (components.get_component(itr->first).get_delivery_time() <=
          order.get_remaining_time())
        ;
      std::map<unsigned int, unsigned int>::iterator itr2 =
          excepted_component_number.find(itr->first);
      if (itr2 != excepted_component_number.end()) {
        itr2->second = itr2->second + itr->second * quantity_order;
      }
    }

    for (itr = excepted_component_number.begin();
         itr != excepted_component_number.end(); ++itr) {
      std::cout << '\t' << itr->first << '\t' << itr->second << '\n';
    }
  }
}
