### Kernel
FROM mysql:5.7

### Author
MAINTAINER haohao<hh18622073649@gmail.com>

### environment
ENV INIT_PATH /data/mysql/init
#定义会被容器自动执行的目录
ENV AUTO_RUN_DIR /docker-entrypoint-initdb.d
#定义sql文件名
ENV FILE_0 myspace-init.sql
#定义shell文件名
ENV INSTALL_DATA_SHELL install_data.sh

###Project
RUN mkdir -p $INIT_PATH
#把数据库初始化数据的文件复制到工作目录下
COPY ./$FILE_0 $INIT_PATH/
#把要执行的shell文件放到/docker-entrypoint-initdb.d/目录下，容器会自动执行这个shell
COPY ./$INSTALL_DATA_SHELL $AUTO_RUN_DIR/
#给执行文件增加可执行权限
RUN chmod a+x $AUTO_RUN_DIR/$INSTALL_DATA_SHELL