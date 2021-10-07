#include <fstream>
#include <iostream>
#include <string>
#include <vector>

std::vector<std::string> read_file(std::string filename) {
  std::ifstream file;
  file.open(filename);
  std::vector<std::string> words;
  std::string word;

  if (!file.is_open()) {
    std::cerr << "**ERRORE** impossibile aprire " << filename << "\n";
  } else {
    while (file >> word) {
      words.push_back(word);
    }
  }

  file.close();
  return words;
}
