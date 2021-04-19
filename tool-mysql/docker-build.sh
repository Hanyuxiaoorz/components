mysql_name=mysql_master
mysql_version=8
mysql_port_main=3306
mysql_port_slave=33060
mysql_data_path=/var/opt/$mysql_name
mysql_root_password=Mysql@13579
mysql_character=utf8mb4
mysql_character_collation=utf8mb4_unicode_ci

docker run -d --name $mysql_name \
  -p $mysql_port_main:3306 \
  -p $mysql_port_slave:33060 \
  -e MYSQL_ROOT_PASSWORD=$mysql_root_password \
  --character-set-server=$mysql_character \
  --collation-server=$mysql_character_collation \
  -v $mysql_data_path:/var/lib/mysql \
  --restart=always \
  mysql:$mysql_version