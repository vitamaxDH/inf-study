drop table ck;

drop sequence ck_seq;
create sequence ck_seq;

create table ck (
    id number primary key,
    title varchar2(100) not null,
    content clob not null
);

insert into ck (id, title, content) values
(ck_seq.nextval, '제목입니다', '내용입니다');

select * from ck;