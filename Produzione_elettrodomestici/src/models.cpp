#include "../include/models.h"
#include "../include/model.h"
#include "../include/utils.h"

Models::Models(std::vector<std::string> v) {
  while (!v.empty()) {
    std::string nome_file = "./input_files/" + v.back();
    v.pop_back();
    std::vector<std::string> vect = read_file(nome_file);
    Model new_model = Model(vect);
    models.insert(
        std::pair<unsigned int, Model>(new_model.get_id(), new_model));
  }
}

Model &Models::get_model(unsigned int model_id) { return models.at(model_id); }
