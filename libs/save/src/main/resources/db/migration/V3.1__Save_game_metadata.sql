create table SaveGameMetadata (
    Id bigint(20) not null auto_increment,
    FieldName nvarchar(128) not null,
    FieldValue nvarchar(max) null,

    primary key (Id),
    unique key uk_SaveGameMetadata_FieldName (FieldName)
);
