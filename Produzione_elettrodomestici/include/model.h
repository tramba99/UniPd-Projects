//dalle palle riccardo
#ifndef MODEL_H
#define MODEL_H
#include <map>
#include <string>
#include <vector>

class Model {
  unsigned int id;
  std::string name;
  unsigned int price;
  std::map<unsigned int, unsigned int> components;

public:
  Model(const std::vector<std::string> &v);
  unsigned int get_id() const { return id; };
  std::string get_name() const { return name; };
  unsigned int get_price() const { return price; };
  unsigned int get_component_quantity(unsigned int component_id) const;
  std::map<unsigned int, unsigned int> &get_components();
};
#endif
