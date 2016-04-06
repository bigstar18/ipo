/*==============================================================*/
/* DBMS name:      ORACLE Version 11g                           */
/* Created on:     2016-04-01 11:29:03                          */
/*==============================================================*/


DROP TABLE SYS_FIRM_PERMISSION CASCADE CONSTRAINTS;

/*==============================================================*/
/* Table: SYS_FIRM_PERMISSION                                   */
/*==============================================================*/
CREATE TABLE SYS_FIRM_PERMISSION 
(
   ID                   NUMBER               NOT NULL,
   FIRMID               VARCHAR(16),
   MODEID               VARCHAR(16),
   CONSTRAINT PK_SYS_FIRM_PERMISSION PRIMARY KEY (ID)
);

-- Create sequence 
create sequence SEQ_SYS_FIRM_PERMISSION
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;
