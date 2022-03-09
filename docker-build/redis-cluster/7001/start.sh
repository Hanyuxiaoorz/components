dir_path=$(pwd)
conf_path=$dir_path"/conf"
docker run -d \
 --name redis-c-7001 \
 -v $conf_path:/usr/local/etc/redis \
 -p 7001:7001 \
 -p 17001:17001 \
 redis:7.0-rc2 redis-server /usr/local/etc/redis/redis.conf