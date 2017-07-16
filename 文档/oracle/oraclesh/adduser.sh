#/bin/bash
ADDGROUPS="oinstall dba"
ADDUSERS="oracle"

for group in $ADDGROUPS ; do

       if [ -z "$( awk -F: '{print $1}' /etc/group |grep $group)" ]; then
                groupadd $group
                echo " Add new group $group"
       else
                echo " Group $group already existed"
       fi
done

for user in $ADDUSERS ; do

       if [ -z "$( awk -F: '{print $1}' /etc/passwd |grep $user)" ]; then
                useradd $user
                echo " Add new user $user"
       else
                echo " User $user already existed"
       fi
done

if $(usermod -g oinstall -G dba oracle) ;   then
echo " Modify user oracle account success"
else
echo " Modify user oracle account failure"
fi
