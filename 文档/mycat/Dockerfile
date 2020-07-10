FROM openjdk:8
ADD Mycat-server-1.6.5-release-20180122220033-linux.tar.gz /usr/local/
ENV MYCAT_HOME=/usr/local/mycat
EXPOSE 8066 9066
CMD ["/usr/local/mycat/bin/mycat", "console","&"]