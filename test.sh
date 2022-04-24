#!/bin/bash
shopt -s expand_aliases
source ~/.bash_aliases

# Compile & Run script

filename=$1

gta3sc "$filename" && \
sudo cp "${filename::-3}.cs" .. && \
echo "Compiled and moved to previous directory!"
