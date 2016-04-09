--------------------------------------------------
-- Export file for user TRADE_GNNT@SPOT.DEV.183 --
-- Created by Bob on 2016-04-07, 13:57:04 --------
--------------------------------------------------

set define off
spool package.log

prompt
prompt Creating package DATE_VIEW_PARAM
prompt ================================
prompt
create or replace package date_view_param is
  function set_start(startdate varchar2) return varchar2;
  function get_start return varchar2;
  function set_end(enddate varchar2) return varchar2;
  function get_end return varchar2;
end date_view_param;
/

prompt
prompt Creating package PKG_C_BASE
prompt ===========================
prompt
create or replace package PKG_C_Base is

    -- Author  : XUEJT
    -- Created : 2012/12/28 9:33:00
    -- Purpose : 公共包

    -- Public type declarations
    FIRM_STATUS_NORMAL constant m_firm.Status%type := 'N'; --正常 Normal
    FIRM_STATUS_DISABLE constant m_firm.Status%type := 'D'; --禁用 Disable
    FIRM_STATUS_ERASE constant m_firm.Status%type := 'E'; --删除 Erase


end PKG_C_Base;
/

prompt
prompt Creating package body DATE_VIEW_PARAM
prompt =====================================
prompt
create or replace package body date_view_param is
  startValue varchar2(16);
  endValue varchar2(16);
  function set_start(startdate varchar2) return varchar2 is
    begin
      startValue:=startdate;
      return startValue;
    end;
  function get_start return varchar2 is
    begin
      return nvl(startValue,'1900-01-01');
    end;
  function set_end(enddate varchar2) return varchar2 is
    begin
      endValue:=enddate;
      return endValue;
    end;
  function get_end return varchar2 is
    begin
      return nvl(endValue,'9900-01-01');
    end;
  end date_view_param;
/


spool off
