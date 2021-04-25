drop table if exists `TABLE_NAME`;
create table `TABLE_NAME` (
                           `F_NAME` integer primary key comment '注释'
)engine=InnoDB default charset=utf8mb4 comment '表注释';

create index `TABLE_INDEX_NAME` on account(F_NAME);
