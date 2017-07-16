#/bin/bash
PROFILES="/home/oracle/.bashrc"
for PROFILE in $PROFILES ; do
if [ -f "$PROFILE" ] ; then
       if [ -z "$(grep "Oracle" $PROFILE)" ] ; then
            cat >>$PROFILE << END
# Oracle configure profile parameters success
export ORACLE_BASE=/u01/app/oracle
export ORACLE_HOME=\$ORACLE_BASE/product/10.2.0/db_1
export PATH=\$ORACLE_HOME/bin:\$PATH
export ORACLE_OWNER=oracle
export ORACLE_SID=orcl
export ORACLE_TERM=vt100
export THREADS_FLAG=native
export LD_LIBRARY_PATH=\$ORACLE_HOME/lib:\$LD_LIBRARY_PATH
export PATH=\$ORACLE_HOME/bin:\$PATH
#
# change this NLS settings to suit your country:
# example:
# german_germany.we8iso8859p15, american_america.we8iso8859p2 etc.
#
export LANG=en_US 
END
            echo " Add Oracle configure $PROFILE parameters success"
       else
            echo " Oracle configure $PROFILE parameters already existed"
       fi
else
       echo "$0: $PROFILE not found "
fi
done
