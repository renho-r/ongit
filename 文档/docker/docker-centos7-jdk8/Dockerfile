FROM centos:7
MAINTAINER renho "rho_i_xx@163.com"

#安装JDK
RUN mkdir /usr/local/jdk
ADD jdk-8u144-linux-x64.tar.gz /usr/local/jdk
#RUN tar xzf /usr/local/jdk/jdk-8u144-linux-x64.tar.gz -C /usr/local/jdk
#RUN rm -rf /usr/local/jdk/jdk-8u144-linux-x64.tar.gz

#安装tomcat
RUN mkdir /var/tmp/tomcat
#RUN wget -P /var/tmp/tomcat http://mirrors.hust.edu.cn/apache/tomcat/tomcat-8/v8.5.31/bin/apache-tomcat-8.5.31.tar.gz
#RUN tar xzf /var/tmp/tomcat/apache-tomcat-8.5.31.tar.gz -C /var/tmp/tomcat
ADD apache-tomcat-8.5.31.tar.gz /var/tmp/tomcat
#RUN rm -rf /var/tmp/tomcat/apache-tomcat-8.5.31.tar.gz

#安装maven
#RUN mkdir /var/tmp/maven
#RUN wget -P /var/tmp/maven  http://apache.fayea.com/maven/maven-3/3.3.9/binaries/apache-maven-3.3.9-bin.tar.gz
#RUN tar xzf /var/tmp/maven/apache-maven-3.3.9-bin.tar.gz -C /var/tmp/maven
#RUN rm -rf /var/tmp/maven/apache-maven-3.3.9-bin.tar.gz

#设置环境变量
ENV JAVA_HOME /usr/local/jdk/jdk1.8.0_144
ENV CATALINA_HOME /var/tmp/tomcat/apache-tomcat-8.5.31
#ENV M2_HOME /var/tmp/maven/apache-maven-3.3.9
ENV PATH $PATH:$JAVA_HOME/bin:$CATALINA_HOME/bin

#打包项目并拷贝到tomcat webapps目录
RUN mkdir /var/tmp/webapp
ADD ./ /var/tmp/webapp
#RUN cd /var/tmp/webapp && mvn package && cp /var/tmp/webapp/target/CIJD.war /var/tmp/tomcat/apache-tomcat-8.5.31/webapps
#RUN cd /var/tmp/webapp && cp /var/tmp/webapp/target/CIJD.war /var/tmp/tomcat/apache-tomcat-8.5.31/webapps

#开启内部服务端口
EXPOSE 8080

#启动tomcat服务器
CMD ["./var/tmp/tomcat/apache-tomcat-8.5.31/bin/catalina.sh","run"] 
