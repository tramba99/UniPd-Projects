#include "../include/components.h"
#include "../include/models.h"
#include "../include/order_manager.h"
#include "../include/utils.h"

int main() {
  int month = 0;
  std::vector<std::string> vect = read_file("./input_files/orders.dat");
  unsigned int cash = stoi(vect[0]);
  Order_Manager company = Order_Manager(
      Models(read_file("./input_files/models.dat")), Orders(vect),
      Components(read_file("./input_files/components_info.dat")), cash);
  while (company.update(month)) {
    month++;
    company.status();
  }
}
