#指定所需的Cmake最低版本  
cmake_minimum_required(VERSION 3.4.1)  
  
  
#指定源码路径，即将src/main/cpp/lame路径赋值给SRC_DIR   
set(SRC_DIR src/main/cpp/lame)  
# 指定头文件路径  
include_directories(src/main/cpp/lame)  
# 将src/main/cpp/lame目录下的所有文件名赋值给SRC_LIST  
aux_source_directory(src/main/cpp/lame SRC_LIST)  
  
  
# add_library：指定生成库文件，包括三个参数：  
# LameMp3为库文件的名称；SHARED表示动态链接库；  
# src/main/cpp/LameMp3.c和${SRC_LIST}指定生成库文件所需的源文件  
#其中，${}的作用是引入src/main/cpp/lame目录下的所有源文件  
add_library(  
             LameMp3  
             SHARED  
             src/main/cpp/LameMp3.c ${SRC_LIST})  
#在指定的目录中搜索库log，并将其路径保存到变量log-lib中  
find_library( # Sets the name of the path variable.  
              log-lib  
              # Specifies the name of the NDK library that  
              # you want CMake to locate.  
              log )  
# 将库${log-lib} 链接到LameMp3动态库中，包括两个参数  
#LameMp3为目标库  
# ${log-lib}为要链接的库  
target_link_libraries( # Specifies the target library.  
                       LameMp3  
  
  
                       # Links the target library to the log library  
                       # included in the NDK.  
                       ${log-lib} )  