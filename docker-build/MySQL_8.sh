docker run -d --name mysql_8 \
  -p 3306:3306 \
  -p 33060:33060 \
  -e MYSQL_ROOT_PASSWORD=Mysql@123456 \
  --character-set-server=utf8mb4 \
  --collation-server=utf8mb4_unicode_ci \
  -v /var/lib/mysql:/var/lib/mysql \
  --restart=always \
  mysql:8