// Trambaiollo Luca 1196021
#ifndef COMPONENTS_H
#define COMPONENTS_H
#include "component.h"
#include <map>
#include <string>
#include <vector>

class Components {
  std::map<unsigned int, Component> components;

public:
  Components(std::vector<std::string> vect);

  Component &get_component(unsigned int component_id);
};
#endif
