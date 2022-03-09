dir_path=$(pwd)
conf_path=$dir_path"/conf"
docker run -d \
 --name redis-c-7005 \
 -v $conf_path:/usr/local/etc/redis \
 -p 7005:7005 \
 -p 17005:17005 \
 redis:7.0-rc2 redis-server /usr/local/etc/redis/redis.conf