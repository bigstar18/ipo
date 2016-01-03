/*==============================================================*/
/* DBMS name:      ORACLE Version 11g                           */
/* Created on:     2016/1/3 18:27:53                            */
/*==============================================================*/


DROP TABLE IPO_UNDERWRITER_SUBSCRIBE CASCADE CONSTRAINTS;

/*==============================================================*/
/* Table: IPO_UNDERWRITER_SUBSCRIBE                             */
/*==============================================================*/
CREATE TABLE IPO_UNDERWRITER_SUBSCRIBE 
(
   SUBSCRIBEID          VARCHAR2(32)         NOT NULL,
   UNDERWRITERID        VARCHAR2(32),
   COMMODITYID          VARCHAR2(32),
   SUBSCRIBECOUNTS      NUMBER(12),
   PROPORTION           NUMBER(8,2),
   CONSTRAINT PK_IPO_UNDERWRITER_SUBSCRIBE PRIMARY KEY (SUBSCRIBEID)
);

create sequence SEQ_IPO_UNDERWRITER_SUB
minvalue 1
maxvalue 999999999999999999999999
start with 31
increment by 1
cache 20;