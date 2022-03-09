dir_path=$(pwd)
conf_path=$dir_path"/conf"
docker run -d \
 --name redis-c-7000 \
 -v $conf_path:/usr/local/etc/redis \
 -p 7000:7000 \
 -p 17000:17000 \
 redis:7.0-rc2 redis-server /usr/local/etc/redis/redis.conf