#/bin/bash
LIMITS_FILE="/etc/security/limits.conf"
if [ -f "$LIMITS_FILE" ] ; then
       if [ -z "$(grep "Oracle" $LIMITS_FILE)" ] ; then
            cat >>$LIMITS_FILE << END
#Oracle configure   shell parameters
oracle soft nofile 65536
oracle hard nofile 65536
oracle soft nproc 16384
oracle hard nproc 16384
END
            echo " Add Oracle configure   shell parameters success"
       else
            echo " Oracle configure   shell parameters already existed"
       fi
else
       echo "$0: $LIMITS_FILE not found "
fi
