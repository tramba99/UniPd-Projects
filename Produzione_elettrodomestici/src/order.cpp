#include "../include/order.h"

Order::Order(unsigned int order_id, unsigned int time_stamp,
             unsigned int model_id, unsigned int quantity)
    : order_id(order_id), time_stamp(time_stamp), model_id(model_id),
      quantity(quantity), remaining_time(0) {}

void Order::set_remaining_time(unsigned int remaining_time) {
  this->remaining_time = remaining_time;
}
