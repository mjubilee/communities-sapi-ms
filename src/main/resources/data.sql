insert into person(id, first_name,last_name, dob, email)
values(1000, 'Mahalunggu', 'Jubilee', current_date(), 'MJ@gmail.com');
insert into person(id, first_name,last_name, dob, email)
values(1001, 'Siman', 'Li', current_date(), 'siman@gmail.com');
insert into person(id, first_name,last_name, dob, email)
values(1002, 'Landon', 'Jubilee', current_date(), 'landon@gmail.com');
insert into person(id, first_name,last_name, dob, email)
values(1003, 'Louie', 'Jubilee', current_date(), 'louie@gmail.com');


insert into community (id, name, active)
values (2000, 'Banting ecole', 1);
insert into community (id, name, active)
values (2001, 'Hyack swimming club', 1);
insert into community (id, name, active)
values (2002, 'Shark Swimming club', 1);
insert into community (id, name, active)
values (2003, 'Nestor ecole', 1);

insert into community_group (id, name, active)
values (3000, 'Grade 7', 1);
insert into community_group (id, name, active)
values (3001, 'Grade 1', 1);
insert into community_group (id, name, active)
values (3002, 'LMR', 1);
insert into community_group (id, name, active)
values (3003, 'Mini shark', 1);

insert into category (id, name, active)
values (4000, 'Parent', 1);
insert into category (id, name, active)
values (4001, 'Student', 1);
insert into category (id, name, active)
values (4002, 'Swimmer', 1);


insert into person_category (person_id, category_id)
values (1000, 4000);
insert into person_category (person_id, category_id)
values (1001, 4000);
insert into person_category (person_id, category_id)
values (1002, 4001);
insert into person_category (person_id, category_id)
values (1002, 4002);
insert into person_category (person_id, category_id)
values (1003, 4001);
insert into person_category (person_id, category_id)
values (1003, 4002);


insert into community_community_group (community_group_id, community_id)
values (3000, 2000);
insert into community_community_group (community_group_id, community_id)
values (3001, 2000);
insert into community_community_group (community_group_id, community_id)
values (3001, 2003);
insert into community_community_group (community_group_id, community_id)
values (3001, 2003);
insert into community_community_group (community_group_id, community_id)
values (3002, 2001);
insert into community_community_group (community_group_id, community_id)
values (3003, 2002);

