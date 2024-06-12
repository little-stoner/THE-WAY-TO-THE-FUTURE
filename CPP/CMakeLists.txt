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
add_executable(b primer/ch01/main.cpp)
add_executable(ex1 primer/ch01/ex1.cpp)
add_executable(ex3 primer/ch01/ex3-while.cpp)
add_executable(ex5 primer/ch01/ex5-flow.cpp)
add_executable(ex6 primer/ch01/ex6-if.cpp)
add_executable(ex8 primer/ch01/ex8-book.cpp)

add_executable(ex-alias primer/ch02/ex-alias.cpp)
add_executable(ex-decltype primer/ch02/ex-decltype.cpp)


add_executable(ex-pointer-arithmetic primer/ch03/ex-pointer-arithmetic.cpp)
add_executable(ex-multi primer/ch03/ex-multidimension.cpp)


add_executable(ex-assign primer/ch04/ex-assign.cpp)

add_executable(ex-bitwise primer/ch04/ex-bitwise.cpp)


add_executable(ex-func primer/ch06/ex-func.cpp)
add_executable(ex-array primer/ch06/ex-array.cpp)
add_executable(ex-varying primer/ch06/ex-varying.cpp)


add_executable(ex-adt primer/ch07/ex-adt.cpp)
add_executable(ex-clz primer/ch07/ex-clz.cpp)
add_executable(ex-constructor primer/ch07/ex-constructor.cpp)
add_executable(ex-static primer/ch07/ex-static.cpp)


add_executable(ex-io primer/ch08/ex-io.cpp)
add_executable(ex-string primer/ch08/ex-string.cpp)

add_executable(1.10 primer/ch01/1.10.cpp)
add_executable(1.11 primer/ch01/1.11.cpp)
add_executable(1.12 primer/ch01/1.12.cpp)
add_executable(1.14 primer/ch01/1.14.cpp)
add_executable(1.23 primer/ch01/1.23.cpp)

add_executable(2.36 primer/ch02/2.36.cpp)

add_executable(c primer/ch03/main.cpp)
add_executable(f primer/ch07/main.cpp)
add_executable(d primer/ch15/main.cpp)
add_executable(e primer/ch16/main.cpp)


#
add_executable(learncpp_a learncpp/exp.cpp)
add_executable(learncpp_goto learncpp/goto.cpp)
add_executable(learncpp_cast learncpp/cast.cpp)
add_executable(learncpp_func learncpp/func.cpp)
add_executable(learncpp_struct learncpp/struct.cpp)
add_executable(learncpp_class_template learncpp/class-template.cpp)
add_executable(learncpp_ctad learncpp/ctad.cpp)
add_executable(learncpp_class learncpp/class.cpp)


add_executable(ex-dynamic primer/ch12/ex-dynamic.cpp)
add_executable(ex-free primer/ch12/ex-new-free.cpp)
add_executable(ex-unique primer/ch12/ex-unique.cpp)
add_executable(ex-allocator primer/ch12/ex-allocator.cpp)

add_executable(ex-ccopy primer/ch13/ex-copy.cpp)

add_executable(ex-operator-overloading primer/ch14/ex-operator-overloading.cpp)


add_executable(ex-tuple primer/ch17/ex-tuple.cpp)
add_executable(ex-random primer/ch17/ex-random.cpp)


add_executable(crtp primer/ch16/crtp.cpp)
