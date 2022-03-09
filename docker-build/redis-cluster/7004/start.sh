dir_path=$(pwd)
conf_path=$dir_path"/conf"
docker run -d \
 --name redis-c-7004 \
 -v $conf_path:/usr/local/etc/redis \
 -p 7004:7004 \
 -p 17004:17004 \
 redis:7.0-rc2 redis-server /usr/local/etc/redis/redis.conf