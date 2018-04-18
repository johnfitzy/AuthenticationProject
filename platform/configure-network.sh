#!/bin/bash
set -e

#only set proxy if at jq (delete file if not at jq)
file=/vagrant/jq

if [ -f "$file" ];then

    if ! grep -q "proxy" /etc/yum.conf; then
        echo proxy=http://jos-repo-server.datacom.co.nz:3128 >> /etc/yum.conf
    fi
    export http_proxy=http://jos-repo-server.datacom.co.nz:3128
    export https_proxy=http://jos-repo-server.datacom.co.nz:3128
    export no_proxy=localhost,127.0.0.1

fi

sudo sh -c  "echo export JAVA_HOME=/usr/lib/jvm/java-1.8.0-openjdk-1.8.0.161-0.b14.el7_4.x86_64/jre >> /etc/environment"

sudo nmcli con del enp0s8 | true
sudo nmcli con add type ethernet ifname enp0s8 con-name enp0s8
sudo nmcli con mod enp0s8 ipv4.addresses '10.255.255.2,10.255.255.3,10.255.255.4,10.255.255.11' ipv4.method manual ipv4.routes 10.0.0.0/16
sudo systemctl restart network


#flyway -url=jdbc:mysql://10.255.255.4:3306/database -user=root -password=password -locations=filesystem:/tmp/mysql/database/migration/ migrate

