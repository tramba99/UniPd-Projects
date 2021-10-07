// Trambaiollo Luca 1196021
#ifndef COMPONENT_H
#define COMPONENT_H
#include <string>

class Component {
  unsigned int id;
  std::string name;
  unsigned int delivery_time;
  unsigned int onetoten_pieces;
  unsigned int eleventofifty_pieces;
  unsigned int fiftyoneormore_pieces;

public:
  Component(unsigned int id, std::string name, unsigned int delivery_time,
            unsigned int onetoten_pieces, unsigned int eleventofifty_pieces,
            unsigned int fiftyoneormore_pieces);

  int get_id();
  std::string get_name();
  int get_delivery_time();
  int get_price(int quantity);
};
#endif
