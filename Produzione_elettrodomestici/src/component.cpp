#include "../include/component.h"
#include <iostream>
#include <string>

using namespace std;

Component::Component(unsigned int id, string name, unsigned int delivery_time, unsigned int onetoten_pieces, unsigned int eleventofifty_pieces, unsigned int fiftyoneormore_pieces)
{
    this->id = id;
    this->name = name;
    this->delivery_time = delivery_time;
    this->onetoten_pieces = onetoten_pieces;
    this->eleventofifty_pieces = eleventofifty_pieces;
    this->fiftyoneormore_pieces = fiftyoneormore_pieces;
}

int Component::get_id()
{
    return id;
}

string Component::get_name()
{
    return name;
}

int Component::get_delivery_time()
{
    return delivery_time;
}

int Component::get_price(int quantity)
{
    if (quantity<=10)
        return onetoten_pieces;
    else if (quantity>=11 && quantity<=50)
        return eleventofifty_pieces;
    else
        return fiftyoneormore_pieces;
}
