create table Nation (
    Id bigint(20) not null auto_increment,
    Name nvarchar(128) not null,

    primary key (Id),
    unique key uk_Nation_Name (Name)
);
