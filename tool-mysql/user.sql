
-- 创建用户
create user 'test'@'%' identified by '111111';

-- 授权/所有
grant all privileges on `demo`.* to 'bi'@'%';

-- 授权/单个
grant select on `demo`.* to test@'%' ;
grant insert on `demo`.* to test@'%' ;
grant update on `demo`.* to test@'%';
grant delete on `demo`.* to test@'%';

-- 刷新权限
flush privileges;
