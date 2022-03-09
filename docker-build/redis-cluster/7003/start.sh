dir_path=$(pwd)
conf_path=$dir_path"/conf"
docker run -d \
 --name redis-c-7003 \
 -v $conf_path:/usr/local/etc/redis \
 -p 7003:7003 \
 -p 17003:17003 \
 redis:7.0-rc2 redis-server /usr/local/etc/redis/redis.conf