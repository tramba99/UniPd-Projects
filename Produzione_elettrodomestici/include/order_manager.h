// Davide Masserut
#ifndef ORDER_MANAGER_H
#define ORDER_MANAGER_H
#include "components.h"
#include "models.h"
#include "orders.h"
#include <iostream>
#include <list>

class Order_Manager {
  Models models;
  Components components;
  Orders orders;
  int cash;

public:
  bool update(unsigned int current_month);
  Order_Manager(const Models &models, const Orders &orders,
                const Components &components, unsigned int cash);
  void status();
};
#endif
