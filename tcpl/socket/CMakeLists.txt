cmake_minimum_required(VERSION 3.17)
project(tcpl)
set(CMAKE_C_STANDARD 11)


add_executable(ip.c ip)
add_executable(poll.c poll)
add_executable(showip.c showip)
add_executable(server.c server)