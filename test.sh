#!/bin/bash
shopt -s expand_aliases
source ~/.bash_aliases

# Compile & Run script

filename=$1

gta3sc "$filename" && \
echo "Script $filename successfully compiled!"
