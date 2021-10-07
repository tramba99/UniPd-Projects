#include "../include/components.h"
#include "../include/component.h"
#include <iostream>
#include <iterator>
#include <map>
#include <string>
#include <utility>
#include <vector>

using namespace std;

Components::Components(vector<string> vect) {
  for (int i = 0; i < vect.size(); i = i + 6) {
    components.insert(std::pair<unsigned int, Component>(
        stoi(vect[i]),
        Component(stoi(vect[i]), vect[i + 1], stoi(vect[i + 2]),
                  stoi(vect[i + 3]), stoi(vect[i + 4]), stoi(vect[i + 5]))));
  }
}

Component &Components::get_component(unsigned int component_id) {
  map<unsigned int, Component>::iterator it;
  it = components.find(component_id);
  if (it == components.end())
    cerr << "**ERRORE**/n";
  return it->second;
}
