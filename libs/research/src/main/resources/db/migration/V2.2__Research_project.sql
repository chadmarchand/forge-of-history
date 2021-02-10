create table ResearchProject (
    Id bigint(20) not null auto_increment,
    NationId bigint(20) not null,
    TechnologyId bigint(20) not null,
    Progress double not null default 0.0,
    IsComplete bit not null default 0,

    primary key (Id),
    unique key uk_ResearchProject_NationId_TechnologyId (NationId, TechnologyId),
    constraint fk_ResearchProject_NationId foreign key (NationId) references Nation (Id),
    constraint fk_ResearchProject_TechnologyId foreign key (TechnologyId) references Technology (Id)
);
