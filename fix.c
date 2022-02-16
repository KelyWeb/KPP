#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <dirent.h>
#include <stdbool.h>
#define SIZE_PATH 100

struct SearchFlags {
    bool type_l;
    bool type_d;
    bool type_s;
    bool type_f;
} default_types;


void directory_files(const char * actually_diretory, struct SearchFlags search_flags);
void add_file_descritpion(char ** all_descriptions, int* size_desriptions, char * desription_name);


int main(int argc, char ** argv) {

    int* temp_size = malloc(sizeof(int));
    *(temp_size) = 5; 

    char ** all_desript = malloc(sizeof(char *) * *(temp_size));
    for(int i = 0; i < *(temp_size); i++){
        all_desript[i] = malloc(sizeof(char) * 100);
    }
    
    for(int i = 0; i < *(temp_size); i++){
        fgets(all_desript[i], 100, stdin);
    }

    char * to_add = (char*)malloc(100);
    fgets(to_add, 100, stdin);

    //temp_size += 1;
    //all_desript = realloc(all_desript, sizeof(char*) * temp_size);
    //all_desript[temp_size - 1] = malloc(sizeof(char) * 100);
    //strcpy(all_desript[temp_size - 1], to_add);

    add_file_descritpion(all_desript, temp_size, to_add);
    for(int i = 0; i < *(temp_size); i++){
        fputs(all_desript[i], stdout);
    }

    /*
    add_file_descritpion(all_desript, &temp_size, to_add);
    for(int i = 0; i < temp_size; i++){
        fputs(all_desript[i], stdout);
    }*/
}

void directory_files(const char * actually_file_path, struct SearchFlags search_flags) {
    /*DIR* open_actually_directory = opendir(actually_file_path);
    struct dirent* dirs = NULL;
    
    if( open_actually_directory == NULL ) {
        return;
    }

    while((dirs = readdir(open_actually_directory)) != NULL) {
        if(dirs -> d_type == DT_DIR) {
            fputs(dirs -> d_name, stdout);
            fputs("\n", stdout);
        }
    }*/
}

void add_file_descritpion(char** all_descriptions, int* size_desriptions, char* desription_name) {
    *(size_desriptions) += 1;
    all_descriptions = realloc(all_descriptions, sizeof(char *) * (*(size_desriptions)));

    all_descriptions[*(size_desriptions) - 1] = malloc(sizeof(char) * (strlen(desription_name) + 1));

    strcpy(all_descriptions[*(size_desriptions) - 1], desription_name);
}
