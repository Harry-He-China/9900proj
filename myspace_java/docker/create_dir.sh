# set dir
src_dir=`pwd -P .`
tar_dir=/data

# create dir
mkdir $tar_dir
cd $tar_dir
mkdir -p mysql/conf mysql/data mysql/init \
         nginx/conf nginx/html nginx/logs \
         redis/conf redis/data redis/logs #\
         #web/uploadPath/download

# move conf
mv $src_dir/redis.conf   redis/conf/redis.conf
mv $src_dir/my.cnf       mysql/conf/my.cnf
mv $src_dir/myspace_nginx.conf nginx/conf/myspace_nginx.conf

# copy template
#cp -r $src_dir/uploadPath/download/*     uploadPath/download/*
