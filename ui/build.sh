#!/bin/sh

# This script is used to build the front app and put it in the dist directory.

bower install
rm -rf dist
cp -R app distC