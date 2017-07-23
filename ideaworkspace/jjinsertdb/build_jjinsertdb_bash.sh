#!/bin/bash 
workspace=/cygdrive/d/dev/workspace/ongit/ideaworkspace/jjinsertdb
deploypath=/cygdrive/c/Users/renho/Desktop/jjinsertdb
cd ${workspace}
rm -rf ${workspace}/target
rm -rf ${deploypath}/*
mvn clean package

cp -r ${workspace}/target/libs ${deploypath}/libs
cp -r ${workspace}/target/jjinsertdb.jar ${deploypath}/
cp -r ${workspace}/etc ${deploypath}/etc

cd ${deploypath}
thisdate=$(date +%Y_%m_%d)
zip -r "deploy_jjinserdb_${thisdate}".zip *
scp "deploy_jjinserdb_${thisdate}".zip renho@192.168.1.111:deploy/"deploy_jjinserdb_${thisdate}".zip
ssh renho@192.168.1.111 '/bin/bash deploy.sh'
exit