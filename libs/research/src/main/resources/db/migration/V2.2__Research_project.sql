create table ResearchProject (
    Id bigint(20) not null auto_increment,
    EntityId int not null,
    TechnologyId bigint(20) not null,
    Progress double not null default 0.0,
    IsComplete bit not null default 0,

    primary key (Id),
    unique key uk_ResearchProject_EntityId_TechnologyId (EntityId, TechnologyId),
    constraint fk_ResearchProject_TechnologyId foreign key (TechnologyId) references Technology (Id)
);
