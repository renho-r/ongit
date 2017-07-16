#/bin/bash
ORACLE_FILE_BASE="/u01/app/oracle"
ORACLE_FILE_VAR="/var/opt/oracle"
ORACLE_FILE_HOME="$ORACLE_FILE_BASE/product/10.2.0/db_1"

for directory in $ORACLE_FILE_BASE $ORACLE_FILE_VAR $ORACLE_FILE_HOME ; do
       if [ -d $directory ]; then
            echo " Directory $directory   already existed"
       else
            mkdir -p $directory
            chown -R oracle.dba $directory
            echo " Change directory $directory owner and group success"
       fi
done
