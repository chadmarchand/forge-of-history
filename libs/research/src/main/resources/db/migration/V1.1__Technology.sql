create table Technology (
    Id bigint(20) not null auto_increment,
    Name nvarchar(64) not null,

    primary key (Id),
    unique key uk_Technology_Name (Name)
);
