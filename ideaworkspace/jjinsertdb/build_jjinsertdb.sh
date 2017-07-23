#!/bin/bash 
workspace=/Users/renho/software/github/ongit/ideaworkspace/jjinsertdb
deploypath=/Users/renho/Desktop/jjinsertdb
cd ${workspace}

rm -rf ${workspace}/target
rm -rf ${deploypath}/*
mvn clean package

cp -r ${workspace}/target/libs ${deploypath}/libs
cp -r ${workspace}/target/jjinsertdb.jar ${deploypath}/
cp -r ${workspace}/etc ${deploypath}/etc