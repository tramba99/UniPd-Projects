//dalle palle riccardo
#ifndef MODELS_H
#define MODELS_H
#include "model.h"
#include <map>
#include <string>

class Models
{
  std::map<unsigned int, Model> models;

public:
  Models(std::vector<std::string> v);
  Model &get_model(unsigned int model_id);
};
#endif
