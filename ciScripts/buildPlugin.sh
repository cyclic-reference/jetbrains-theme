#!/bin/bash
./ciScripts/preBuild.sh
./gradlew clean buildPlugin
git add .
git stash
git stash clear
