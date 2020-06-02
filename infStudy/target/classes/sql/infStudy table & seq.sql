drop table qna_reply;
drop table review_reply;
drop table qna;
drop table wish_list;
drop table review;
drop table paid_lec;
drop table finish;
drop table curriculum;
drop table lecture;
drop table category;
drop table users;


drop sequence users_seq;
drop sequence instructor_seq;
drop sequence curriculum_seq;
drop sequence paid_lec_seq;
drop sequence qna_seq;
drop sequence qna_reply_seq;
drop sequence review_seq;
drop sequence review_reply_seq;
drop sequence wish_list_seq;
drop sequence category_seq;
drop sequence lecture_seq;




create table users(
    u_no number(5) primary key,
    email varchar2(100) not null unique,
    password varchar2(200) not null,
    nickname varchar2(50) not null,
    img varchar2(500),
    i_no number(5) unique
);

create table category(
    ctg_no number(3) primary key,
    name varchar2(100) not null
);

create table lecture(
    l_no number(5) primary key,
    i_no number(5) not null,
    ctg_no number(5) not null,
    title varchar2(50) not null,
    content CLOB not null,
    price number(10) not null,
    difficulty varchar(10) not null,
    img varchar2(500) not null,
    rel_dt date default sysdate,
    CONSTRAINT FK_I_NO FOREIGN KEY(i_no)
    REFERENCES users(i_no),
    constraint FK_CTG_NO FOREIGN KEY(ctg_no)
    REFERENCES category(ctg_no)
);

create table curriculum (
    c_no number(5) primary key,
    l_no number(5) not null,
    section varchar2(100) not null,
    title varchar2(100) not null,
    url varchar2(500) not null,
    playtime number(10) not NULL,
    FOREIGN KEY(l_no)
    REFERENCES lecture(l_no)
);

create table paid_lec(
    p_no number(5) primary key,
    u_no number(5) not null,
    l_no number(5) not null,
    paid_dt date default sysdate,
    CONSTRAINT FK_U_NO FOREIGN KEY(u_no)
    REFERENCES users(u_no),
    CONSTRAINT FK_L_NO FOREIGN KEY(l_no)
    REFERENCES lecture(l_no)
);

create table qna(
    q_no number(5) primary key,
    u_no number(5) not null,
    l_no number(5) not null,
    reg_dt date default sysdate,
    title varchar2(100) not null,
    content clob not null,
    FOREIGN KEY(u_no)
    REFERENCES users(u_no),
    FOREIGN KEY(l_no)
    REFERENCES lecture(l_no)
);


create table qna_reply(
    qr_no number(5) primary key,
    q_no number(5) not null,
    u_no number(5) not null,
    reg_dt date default sysdate,
    content clob not null,
    FOREIGN KEY(q_no)
    REFERENCES qna(q_no),
    FOREIGN KEY(u_no)
    REFERENCES users(u_no)
);

create table review(
    r_no number(5) primary key,
    l_no number(5) not null,
    u_no number(5) not null,
    reg_dt date default sysdate,
    rank number(1) not null,
    content clob not null,
    FOREIGN KEY(l_no)
    REFERENCES lecture(l_no),
    FOREIGN KEY(u_no)
    REFERENCES users(u_no)
);

create table review_reply(
    rr_no number(5) primary key,
    r_no number(5) not null,
    u_no number(5) not null,
    reg_dt date default sysdate,
    content clob not null,
    FOREIGN KEY(r_no)
    REFERENCES review(r_no),
    FOREIGN KEY(u_no)
    REFERENCES users(u_no)
);

create table wish_list(
    w_no number(5) primary key,
    u_no number(5) not null,
    l_no number(5) not null,
    select_order date default sysdate,
    FOREIGN KEY(u_no)
    REFERENCES users(u_no),
    FOREIGN KEY(l_no)
    REFERENCES lecture(l_no)
);

create table finish(
    u_no number(5) not null,
    l_no number(5) not null,
    c_no number(5) not null,
    finish_time date default sysdate,
    FOREIGN KEY(u_no)
    REFERENCES users(u_no),
    FOREIGN KEY(c_no)
    REFERENCES curriculum(c_no),
    FOREIGN KEY(l_no)
    REFERENCES lecture(l_no)
);


create sequence users_seq;
create sequence lecture_seq;
create sequence instructor_seq;
create sequence curriculum_seq;
create sequence paid_lec_seq;
create sequence qna_seq;
create sequence qna_reply_seq;
create sequence review_seq;
create sequence review_reply_seq;
create sequence wish_list_seq;
create sequence category_seq;


