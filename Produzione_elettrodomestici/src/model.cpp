#include "../include/model.h"
#include <string>
#include <utility>

Model::Model(const std::vector<std::string> &v) {

  id = std::stoi(v[0]);
  name = v[1];
  price = std::stoi(v[2]);

  for (int i = 3; i < v.size(); i += 3) {
    components.insert(std::pair<unsigned int, unsigned int>(
        std::stoi(v[i]), std::stoi(v[i + 2])));
  }
}

unsigned int Model::get_component_quantity(unsigned int component_id) const {
  return components.at(component_id);
}

std::map<unsigned int, unsigned int> &Model::get_components() {
  return components;
}
