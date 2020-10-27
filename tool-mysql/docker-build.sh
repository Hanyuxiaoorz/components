docker run \
--name mysql_name \
-p 3306:3306 \
--restart=always \
-e MYSQL_ROOT_PASSWORD=Mysql@654321 -d mysql:8.0 \
--character-set-server=utf8mb4 \
--collation-server=utf8mb4_unicode_ci