#!/usr/bin/env bash
for dir in *-builder
do
  cd  $dir
  mvnci
  cd ..
done
