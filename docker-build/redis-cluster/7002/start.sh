dir_path=$(pwd)
conf_path=$dir_path"/conf"
docker run -d \
 --name redis-c-7002 \
 -v $conf_path:/usr/local/etc/redis \
 -p 7002:7002 \
 -p 17002:17002 \
 redis:7.0-rc2 redis-server /usr/local/etc/redis/redis.conf