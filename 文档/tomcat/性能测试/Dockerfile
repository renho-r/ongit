FROM java:8
ENV JMETER_HOME /root/apache-jmeter-5.1.1
ENV PATH $JMETER_HOME/bin:$PATH
WORKDIR /root
ADD apache-jmeter-5.1.1 /root/apache-jmeter-5.1.1
EXPOSE 1099
CMD ["jmeter-server"]