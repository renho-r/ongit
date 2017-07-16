#/bin/bash
# echo 250 32000 100 128 > /proc/sys/kernel/sem
# echo 536870912 > /proc/sys/kernel/shmmax
# echo 4096 > /proc/sys/kernel/shmmni
# echo 2097152 > /proc/sys/kernel/shmall
# echo 65536 > /proc/sys/fs/file-max
# echo 1024 65000 > /proc/sys/net/ipv4/ip_local_port_range

SYSCTL_FILE="/etc/sysctl.conf"
RCLOCAL_FILE="/etc/rc.local"


if [ -f "$SYSCTL_FILE" ] ; then
       if [ -z "$(grep "Oracle" $SYSCTL_FILE)" ] ; then
            cat >>$SYSCTL_FILE << END
#Oracle configure kernel parameters
kernel.shmmax = 4294967296
kernel.shmmni = 4096
kernel.shmall = 2097152
kernel.sem = 250 32000 100 128
fs.file-max = 65536
net.ipv4.ip_local_port_range = 1024 65000
net.core.rmem_default = 262144
net.core.rmem_max = 262144
net.core.wmem_default = 262144
net.core.wmem_max = 262144

END
            /sbin/sysctl -p
            echo " Add Oracle configure kernel parameters success"
       else
            echo " Oracle configure kernel parameters already existed"
       fi
else
       if [ -z "$(grep "Oracle" $RCLOCAL_FILE)" ] ; then
            cat >>$RCLOCAL_FILE << END
#Oracle configure kernel parameters
echo 536870912 > /proc/sys/kernel/shmmax
echo 4096 > /proc/sys/kernel/shmmni
echo 2097152 > /proc/sys/kernel/shmall
echo 250 32000 100 128 > /proc/sys/kernel/sem
echo 65536 > /proc/sys/fs/file-max
echo 1024 65000 > /proc/sys/net/ipv4/ip_local_port_range
END
            . $RCLOCAL_FILE
            echo " Add Oracle configure kernel parameters success"
       else
            echo " Oracle configure kernel parameters already existed"
       fi
fi
