create database smartclub;

-- 创建表 user、role、permission;
create table sys_user(
    id int(10) AUTO_INCREMENT primary key,
    username varchar(50),
    password varchar(50),
    salt varchar(50),
    email varchar(50),
    phoneNum char(11),
    status int(2)
)ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

create table sys_role(
    id int(10) AUTO_INCREMENT primary key,
    roleName varchar(50),
    roleDesc varchar(50)
)ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

create table sys_permission(
    id int(10) AUTO_INCREMENT primary key,
    permissionName varchar(50),
    url varchar(50)
)ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- 权限关联表
create table sys_user_role(
    userId int(10),
    roleId int(10),
    PRIMARY KEY(userId,roleId),
    FOREIGN KEY (userId) REFERENCES sys_user(id),
    FOREIGN KEY (roleId) REFERENCES sys_role(id)
);

create table sys_role_permission(
    roleId int(10),
    permissionId int(10),
    PRIMARY KEY(roleId,permissionId),
    FOREIGN KEY (roleId) REFERENCES sys_role(id),
    FOREIGN KEY (permissionId) REFERENCES sys_permission(id)
);

-- 创建图片数据表
create table sys_apple_data(
    id int(10) AUTO_INCREMENT primary key,
    experiment varchar(50),
    rgb varchar(50),
    nir varchar(50),
    views int(10)
)ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

create table sys_apple_result(
    id int(10) AUTO_INCREMENT primary key,
    ndviName varchar(50),
    ndvi varchar(50),
    ndviData decimal(10,3),
    views int(10)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- 创建病虫害图片数据表
create table apple_ill_first(
     id int(10) AUTO_INCREMENT primary key,
     experiment varchar(50),
     img varchar(50),
     views int(10)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

create table apple_ill_second(
     id int(10) AUTO_INCREMENT primary key,
     experiment varchar(50),
     img varchar(50),
     views int(10)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

create table apple_ill_third(
    id int(10) AUTO_INCREMENT primary key,
    experiment varchar(50),
    img varchar(50),
    views int(10)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- 其他数据
create table sys_other_data(
    id int(10) AUTO_INCREMENT primary key,
    description varchar(50),
    url varchar(50)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;