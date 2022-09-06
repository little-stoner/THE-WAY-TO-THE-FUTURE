# This is a minimal CMakeLists file which includes the Yoctopuce C++ lib.
cmake_minimum_required(VERSION 3.16)

project(ISOCPP)

# specify the C++ standard
set(CMAKE_CPP_STANDARD 11)

#SET(CMAKE_C_COMPILER   /usr/local/Cellar/gcc/11.2.0_3/bin/gcc-11)
#
#SET(CMAKE_CXX_COMPILER /usr/local/Cellar/gcc/11.2.0_3/bin/g++-11)


set(CMAKE_CPP_STANDARD_REQUIRED True)

# Adds the executable called "demo" that is built from the source files "main.cpp".
add_executable(a main.cpp)
