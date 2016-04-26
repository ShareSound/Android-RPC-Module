#!/usr/bin/env bash

for f in $(ls *.thrift); do
    thrift --out ../java --gen java:android ${f}
done

#export THRIFTY_PATH_PREFIX=../../../../thrifty-compiler

#java -jar ${THRIFTY_PATH_PREFIX}/build/libs/thrifty-compiler.jar --out=../java ./*.thrift
