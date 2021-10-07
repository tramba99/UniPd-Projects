// Trambaiollo Luca 1196021
#ifndef ORDER_H
#define ORDER_H
#include <iostream>

class Order {
  unsigned int order_id;
  unsigned int time_stamp;
  unsigned int model_id;
  unsigned int quantity;
  unsigned int remaining_time;

public:
  Order(unsigned int order_id, unsigned int time, unsigned int model,
        unsigned int quantity);

  void postpone_order() { time_stamp++; }
  unsigned int get_id() const { return order_id; }
  unsigned int get_time_stamp() const { return time_stamp; }
  unsigned int get_model_id() const { return model_id; }
  unsigned int get_quantity() const { return quantity; }
  unsigned int get_remaining_time() const { return remaining_time; }
  unsigned int decrease_time() { return --remaining_time; }
  void set_remaining_time(unsigned int remaining_time);
  bool operator==(const Order &order) const {
    return order.get_id() == get_id();
  }
};

#endif
