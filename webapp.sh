#!/bin/sh
# ./webapp.sh start 启动 stop 停止 restart 重启 status 状态

AppName=webapp.jar
ActiveProfiles=stage
# ActiveProfiles=dev

# 日志路径
# JVM参数 - 内存
# JVM参数 - GC
# JVM参数 - 堆栈溢出日志
# pid文件

# JVM参数
JVM_OPTS="-Dname=$AppName  -Duser.timezone=Asia/Shanghai -Xms512m -Xmx1024m -XX:MetaspaceSize=128m -XX:MaxMetaspaceSize=512m -XX:+HeapDumpOnOutOfMemoryError  -XX:+PrintGCDetails -XX:NewRatio=1 -XX:SurvivorRatio=30 -XX:+UseParallelGC -XX:+UseParallelOldGC"
APP_HOME=$(pwd)
LOG_PATH=$APP_HOME/logs/$AppName.log

if [ "$1" = "" ]; then
  echo -e "\033[0;31m 未输入操作名 \033[0m  \033[0;34m {start|stop|restart|status} \033[0m"
  exit 1
fi

if [ "$AppName" = "" ]; then
  echo -e "\033[0;31m 未输入应用名 \033[0m"
  exit 1
fi

function start() {
  PID=$(ps -ef | grep java | grep $AppName | grep -v grep | awk '{print $2}')

  if [ x"$PID" != x"" ]; then
    echo "$AppName is running..."
  else
    nohup java $JVM_OPTS -jar $AppName --spring.profiles.active=$ActiveProfiles &
    echo "Start $AppName success..."
  fi
}

function stop() {
  echo "Stop $AppName"

  PID=""
  query() {
    PID=$(ps -ef | grep java | grep $AppName | grep -v grep | awk '{print $2}')
  }

  query
  if [ x"$PID" != x"" ]; then
    kill -TERM $PID
    echo "$AppName (pid:$PID) exiting..."
    while [ x"$PID" != x"" ]; do
      sleep 1
      query
    done
    echo "$AppName exited."
  else
    echo "$AppName already stopped."
  fi
}

function restart() {
  stop
  sleep 2
  start
}

function status() {
  PID=$(ps -ef | grep java | grep $AppName | grep -v grep | wc -l)
  if [ $PID != 0 ]; then
    echo "$AppName is running..."
  else
    echo "$AppName is not running..."
  fi
}

case $1 in
start)
  start
  ;;
stop)
  stop
  ;;
restart)
  restart
  ;;
status)
  status
  ;;
*) ;;

esac

