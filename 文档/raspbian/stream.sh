#!/bin/sh

#This is Web-streaming server start up script.for raspi
#No warrantly.

# Config
PORT=""
ID="" # 需要修改
PW="" # 需要修改
MJPG_STREAMER=/home/pi/mjpg-streamer-master/mjpg-streamer-experimental/mjpg_streamer

export LD_LIBRARY_PATH=/usr/local/lib
$MJPG_STREAMER -i "/home/pi/mjpg-streamer-master/mjpg-streamer-experimental/input_raspicam.so" -o "/home/pi/mjpg-streamer-master/mjpg-streamer-experimental/output_http.so -w /home/pi/mjpg-streamer-master/mjpg-streamer-experimental/www -p $PORT -c $ID:$PW" -b
