prompt Importing table W_RIGHT...
set feedback off
set define off
insert into W_RIGHT (ID, PARENTID, NAME, MODULEID, ICON, AUTHORITYURL, VISITURL, SEQ, VISIBLE, TYPE, CATALOGID, ISWRITELOG)
values (9900000000, null, '主菜单', 99, null, null, null, 1, 0, -1, 0, 'N');

insert into W_RIGHT (ID, PARENTID, NAME, MODULEID, ICON, AUTHORITYURL, VISITURL, SEQ, VISIBLE, TYPE, CATALOGID, ISWRITELOG)
values (9901000001, -1, '登录页面', 99, null, '/mgr/logon.jsp', null, 1, 0, -2, 0, 'N');

insert into W_RIGHT (ID, PARENTID, NAME, MODULEID, ICON, AUTHORITYURL, VISITURL, SEQ, VISIBLE, TYPE, CATALOGID, ISWRITELOG)
values (9901000002, -1, '验证码', 99, null, '/mgr/public/jsp/logoncheckimage.jsp', null, 2, 0, -2, 0, 'N');

insert into W_RIGHT (ID, PARENTID, NAME, MODULEID, ICON, AUTHORITYURL, VISITURL, SEQ, VISIBLE, TYPE, CATALOGID, ISWRITELOG)
values (9901000003, -1, '最外围页面', 99, null, '/mgr/frame/framepage.jsp', null, 3, 0, -3, 0, 'N');

insert into W_RIGHT (ID, PARENTID, NAME, MODULEID, ICON, AUTHORITYURL, VISITURL, SEQ, VISIBLE, TYPE, CATALOGID, ISWRITELOG)
values (9901000004, -1, '没有头部的主页面', 99, null, '/mgr/frame/mainframe_nohead.jsp', null, 4, 0, -3, 0, 'N');

insert into W_RIGHT (ID, PARENTID, NAME, MODULEID, ICON, AUTHORITYURL, VISITURL, SEQ, VISIBLE, TYPE, CATALOGID, ISWRITELOG)
values (9901000006, -1, '无权限页面', 99, null, '/mgr/public/jsp/noright.jsp', null, 6, 0, -2, 0, 'N');

insert into W_RIGHT (ID, PARENTID, NAME, MODULEID, ICON, AUTHORITYURL, VISITURL, SEQ, VISIBLE, TYPE, CATALOGID, ISWRITELOG)
values (9901000007, -1, 'session失效页面', 99, null, '/mgr/public/jsp/nosession.jsp', null, 7, 0, -2, 0, 'N');

insert into W_RIGHT (ID, PARENTID, NAME, MODULEID, ICON, AUTHORITYURL, VISITURL, SEQ, VISIBLE, TYPE, CATALOGID, ISWRITELOG)
values (9901000008, -1, '错误页面', 99, null, '/mgr/public/jsp/error.jsp', null, 8, 0, -3, 0, 'N');

insert into W_RIGHT (ID, PARENTID, NAME, MODULEID, ICON, AUTHORITYURL, VISITURL, SEQ, VISIBLE, TYPE, CATALOGID, ISWRITELOG)
values (9901000009, -1, '存放用户AU系统中sessionID', 99, null, '/mgr/public/jsp/session.jsp', null, 9, 0, -3, 0, 'N');

insert into W_RIGHT (ID, PARENTID, NAME, MODULEID, ICON, AUTHORITYURL, VISITURL, SEQ, VISIBLE, TYPE, CATALOGID, ISWRITELOG)
values (9901000010, -1, '主页面', 99, null, '/mgr/frame/mainframe.jsp', null, 10, 0, -3, 0, 'N');

insert into W_RIGHT (ID, PARENTID, NAME, MODULEID, ICON, AUTHORITYURL, VISITURL, SEQ, VISIBLE, TYPE, CATALOGID, ISWRITELOG)
values (9901000011, -1, '靠上页面', 99, null, '/mgr/frame/topframe.jsp', null, 11, 0, -3, 0, 'N');

insert into W_RIGHT (ID, PARENTID, NAME, MODULEID, ICON, AUTHORITYURL, VISITURL, SEQ, VISIBLE, TYPE, CATALOGID, ISWRITELOG)
values (9901000012, -1, '展示主页面', 99, null, '/mgr/frame/rightframe.jsp', null, 12, 0, -3, 0, 'N');

insert into W_RIGHT (ID, PARENTID, NAME, MODULEID, ICON, AUTHORITYURL, VISITURL, SEQ, VISIBLE, TYPE, CATALOGID, ISWRITELOG)
values (9901000013, -1, '展示上页面', 99, null, '/mgr/frame/rightframe_top.jsp', null, 13, 0, -3, 0, 'N');

insert into W_RIGHT (ID, PARENTID, NAME, MODULEID, ICON, AUTHORITYURL, VISITURL, SEQ, VISIBLE, TYPE, CATALOGID, ISWRITELOG)
values (9901000014, -1, '展示下页面', 99, null, '/mgr/frame/rightframe_bottom.jsp', null, 14, 0, -3, 0, 'N');

insert into W_RIGHT (ID, PARENTID, NAME, MODULEID, ICON, AUTHORITYURL, VISITURL, SEQ, VISIBLE, TYPE, CATALOGID, ISWRITELOG)
values (9901000015, -1, '分栏页面', 99, null, '/mgr/frame/shrinkbar.jsp', null, 15, 0, -3, 0, 'N');

insert into W_RIGHT (ID, PARENTID, NAME, MODULEID, ICON, AUTHORITYURL, VISITURL, SEQ, VISIBLE, TYPE, CATALOGID, ISWRITELOG)
values (9901000016, -1, '菜单显示页面', 99, null, '/mgr/frame/leftMenu.jsp', null, 16, 0, -3, 0, 'N');

insert into W_RIGHT (ID, PARENTID, NAME, MODULEID, ICON, AUTHORITYURL, VISITURL, SEQ, VISIBLE, TYPE, CATALOGID, ISWRITELOG)
values (9901000017, -1, '菜单页面', 99, null, '/menu/menuList.action', null, 17, 0, -3, 0, 'N');

insert into W_RIGHT (ID, PARENTID, NAME, MODULEID, ICON, AUTHORITYURL, VISITURL, SEQ, VISIBLE, TYPE, CATALOGID, ISWRITELOG)
values (9901000018, -1, '快捷菜单设置跳转', 99, null, '/myMenu/getMyMenu.action', null, 18, 0, -3, 0, 'N');

insert into W_RIGHT (ID, PARENTID, NAME, MODULEID, ICON, AUTHORITYURL, VISITURL, SEQ, VISIBLE, TYPE, CATALOGID, ISWRITELOG)
values (9901000019, -1, '快捷菜单设置修改', 99, null, '/myMenu/updateMyMenu.action', null, 19, 0, -3, 9901, 'N');

insert into W_RIGHT (ID, PARENTID, NAME, MODULEID, ICON, AUTHORITYURL, VISITURL, SEQ, VISIBLE, TYPE, CATALOGID, ISWRITELOG)
values (9901000020, -1, 'activemq访问路径', 99, null, '/amq', null, 20, 0, -3, 0, 'N');

insert into W_RIGHT (ID, PARENTID, NAME, MODULEID, ICON, AUTHORITYURL, VISITURL, SEQ, VISIBLE, TYPE, CATALOGID, ISWRITELOG)
values (9901000021, -1, '登陆', 99, null, '/user/logon.action', null, 21, 0, -2, 0, 'N');

insert into W_RIGHT (ID, PARENTID, NAME, MODULEID, ICON, AUTHORITYURL, VISITURL, SEQ, VISIBLE, TYPE, CATALOGID, ISWRITELOG)
values (9901000022, -1, '用户退出', 99, null, '/user/logout.action', null, 22, 0, -2, 9901, 'N');

insert into W_RIGHT (ID, PARENTID, NAME, MODULEID, ICON, AUTHORITYURL, VISITURL, SEQ, VISIBLE, TYPE, CATALOGID, ISWRITELOG)
values (9901000023, -1, '修改风格页面', 99, null, '/mgr/frame/shinstyle.jsp', null, 23, 0, -3, 0, 'N');

insert into W_RIGHT (ID, PARENTID, NAME, MODULEID, ICON, AUTHORITYURL, VISITURL, SEQ, VISIBLE, TYPE, CATALOGID, ISWRITELOG)
values (9901000024, -1, '修改风格', 99, null, '/user/saveShinStyle.action', null, 24, 0, -3, 9901, 'N');

insert into W_RIGHT (ID, PARENTID, NAME, MODULEID, ICON, AUTHORITYURL, VISITURL, SEQ, VISIBLE, TYPE, CATALOGID, ISWRITELOG)
values (9901000025, -1, '修改登录密码跳转', 99, null, '/self/passwordSelfMod.action', null, 25, 0, -3, 0, 'N');

insert into W_RIGHT (ID, PARENTID, NAME, MODULEID, ICON, AUTHORITYURL, VISITURL, SEQ, VISIBLE, TYPE, CATALOGID, ISWRITELOG)
values (9901000026, -1, '修改登录密码', 99, null, '/self/passwordSelfSave.action', null, 26, 0, -3, 9901, 'N');

insert into W_RIGHT (ID, PARENTID, NAME, MODULEID, ICON, AUTHORITYURL, VISITURL, SEQ, VISIBLE, TYPE, CATALOGID, ISWRITELOG)
values (9901000027, -1, '查询数据库时间', 99, null, '/sysDate/getDate.action', null, 27, 0, -3, 0, 'N');

insert into W_RIGHT (ID, PARENTID, NAME, MODULEID, ICON, AUTHORITYURL, VISITURL, SEQ, VISIBLE, TYPE, CATALOGID, ISWRITELOG)
values (9901000028, -1, '等待跳转页面', 99, null, '/mgr/frame/waiting.jsp', null, 28, 0, -3, 0, 'N');

insert into W_RIGHT (ID, PARENTID, NAME, MODULEID, ICON, AUTHORITYURL, VISITURL, SEQ, VISIBLE, TYPE, CATALOGID, ISWRITELOG)
values (1201000000, 9900000000, '管理员管理', 12, null, null, null, 1, 0, -1, 0, 'N');

insert into W_RIGHT (ID, PARENTID, NAME, MODULEID, ICON, AUTHORITYURL, VISITURL, SEQ, VISIBLE, TYPE, CATALOGID, ISWRITELOG)
values (1201010000, 1201000000, '用户管理', 12, '42_42.gif', null, null, 1, 0, -1, 0, 'N');

insert into W_RIGHT (ID, PARENTID, NAME, MODULEID, ICON, AUTHORITYURL, VISITURL, SEQ, VISIBLE, TYPE, CATALOGID, ISWRITELOG)
values (1201010100, 1201010000, '用户设置', 12, '29_29.gif', '/user/*', '/user/list.action?sortColumns=order+by+userId', 1, 0, 0, 0, 'N');

insert into W_RIGHT (ID, PARENTID, NAME, MODULEID, ICON, AUTHORITYURL, VISITURL, SEQ, VISIBLE, TYPE, CATALOGID, ISWRITELOG)
values (1201010101, 1201010100, '添加用户权限', 12, null, '/user/add*', null, 1, 0, 1, 0, 'N');

insert into W_RIGHT (ID, PARENTID, NAME, MODULEID, ICON, AUTHORITYURL, VISITURL, SEQ, VISIBLE, TYPE, CATALOGID, ISWRITELOG)
values (1201010102, 1201010100, '修改用户权限', 12, null, '/user/update*', null, 2, 0, 1, 0, 'N');

insert into W_RIGHT (ID, PARENTID, NAME, MODULEID, ICON, AUTHORITYURL, VISITURL, SEQ, VISIBLE, TYPE, CATALOGID, ISWRITELOG)
values (1201010103, 1201010100, '删除用户权限', 12, null, '/user/delete*', null, 3, 0, 1, 0, 'N');

insert into W_RIGHT (ID, PARENTID, NAME, MODULEID, ICON, AUTHORITYURL, VISITURL, SEQ, VISIBLE, TYPE, CATALOGID, ISWRITELOG)
values (1201010104, 1201010100, '关联角色查看权限', 12, null, '/user/forwardRelatedRight.action', null, 4, 0, 1, 0, 'N');

insert into W_RIGHT (ID, PARENTID, NAME, MODULEID, ICON, AUTHORITYURL, VISITURL, SEQ, VISIBLE, TYPE, CATALOGID, ISWRITELOG)
values (1201010105, 1201010104, '关联角色修改权限', 12, null, '/user/updateRelatedRight.action', null, 1, 0, 1, 0, 'N');

insert into W_RIGHT (ID, PARENTID, NAME, MODULEID, ICON, AUTHORITYURL, VISITURL, SEQ, VISIBLE, TYPE, CATALOGID, ISWRITELOG)
values (1201010106, 1201010100, '系统用户密码查看权限', 12, null, '/user/forwardUpdatePassword.action', null, 5, 0, 1, 0, 'N');

insert into W_RIGHT (ID, PARENTID, NAME, MODULEID, ICON, AUTHORITYURL, VISITURL, SEQ, VISIBLE, TYPE, CATALOGID, ISWRITELOG)
values (1201010107, 1201010106, '系统用户密码修改权限', 12, null, '/user/updatePassword.action', null, 1, 0, 1, 0, 'N');

insert into W_RIGHT (ID, PARENTID, NAME, MODULEID, ICON, AUTHORITYURL, VISITURL, SEQ, VISIBLE, TYPE, CATALOGID, ISWRITELOG)
values (1201010200, 1201010000, '角色管理', 12, '29_29.gif', '/role/*', '/role/roleList.action?sortColumns=order+by+id', 2, 0, 0, 0, 'N');

insert into W_RIGHT (ID, PARENTID, NAME, MODULEID, ICON, AUTHORITYURL, VISITURL, SEQ, VISIBLE, TYPE, CATALOGID, ISWRITELOG)
values (1201010201, 1201010200, '添加角色', 12, null, '/role/add*', '/role/addRole.action', 1, 0, 1, 1201, 'N');

insert into W_RIGHT (ID, PARENTID, NAME, MODULEID, ICON, AUTHORITYURL, VISITURL, SEQ, VISIBLE, TYPE, CATALOGID, ISWRITELOG)
values (1201010202, 1201010200, '修改角色', 12, null, '/role/update*', '/role/updateRole.action', 2, 0, 1, 1201, 'N');

insert into W_RIGHT (ID, PARENTID, NAME, MODULEID, ICON, AUTHORITYURL, VISITURL, SEQ, VISIBLE, TYPE, CATALOGID, ISWRITELOG)
values (1201010203, 1201010200, '删除角色', 12, null, '/role/delete*', '/role/deleteRole.action', 3, 0, 1, 1201, 'N');

insert into W_RIGHT (ID, PARENTID, NAME, MODULEID, ICON, AUTHORITYURL, VISITURL, SEQ, VISIBLE, TYPE, CATALOGID, ISWRITELOG)
values (1201010300, 1201010000, '用户解锁', 12, '29_29.gif', '/user/errorLogonLog/*', '/user/errorLogonLog/list.action?sortColumns=order+by+userID', 3, 0, 0, 0, 'N');

insert into W_RIGHT (ID, PARENTID, NAME, MODULEID, ICON, AUTHORITYURL, VISITURL, SEQ, VISIBLE, TYPE, CATALOGID, ISWRITELOG)
values (1201010301, 1201010300, '查看异常登录权限', 12, null, '/user/errorLogonLog/getDetail.action', null, 1, 0, 1, 0, 'N');

insert into W_RIGHT (ID, PARENTID, NAME, MODULEID, ICON, AUTHORITYURL, VISITURL, SEQ, VISIBLE, TYPE, CATALOGID, ISWRITELOG)
values (1201010302, 1201010300, '修改异常登录权限', 12, null, '/user/errorLogonLog/active*', null, 2, 0, 1, 0, 'N');

insert into W_RIGHT (ID, PARENTID, NAME, MODULEID, ICON, AUTHORITYURL, VISITURL, SEQ, VISIBLE, TYPE, CATALOGID, ISWRITELOG)
values (1201010400, 1201010000, '管理员操作日志', 12, '29_29.gif', '/log/*', '/log/list.action?sortColumns=order+by+operateTime+desc', 4, 0, 0, 0, 'N');

insert into W_RIGHT (ID, PARENTID, NAME, MODULEID, ICON, AUTHORITYURL, VISITURL, SEQ, VISIBLE, TYPE, CATALOGID, ISWRITELOG)
values (1202000000, 9900000000, '仓单管理', 12, null, null, null, 2, 0, -1, 0, 'N');

insert into W_RIGHT (ID, PARENTID, NAME, MODULEID, ICON, AUTHORITYURL, VISITURL, SEQ, VISIBLE, TYPE, CATALOGID, ISWRITELOG)
values (1202010000, 1202000000, '仓单管理', 12, '42_42.gif', null, null, 1, 0, -1, 0, 'N');

insert into W_RIGHT (ID, PARENTID, NAME, MODULEID, ICON, AUTHORITYURL, VISITURL, SEQ, VISIBLE, TYPE, CATALOGID, ISWRITELOG)
values (1202010100, 1202010000, '可用仓单管理', 12, '29_29.gif', '/stock/list/*', '/stock/list/stockList.action?sortColumns=order+by+stockId', 1, 0, 0, 0, 'N');

insert into W_RIGHT (ID, PARENTID, NAME, MODULEID, ICON, AUTHORITYURL, VISITURL, SEQ, VISIBLE, TYPE, CATALOGID, ISWRITELOG)
values (1202010101, 1202010100, '查看权限', 12, null, '/stock/list/stockDetails.action', null, 1, 0, 1, null, 'N');

insert into W_RIGHT (ID, PARENTID, NAME, MODULEID, ICON, AUTHORITYURL, VISITURL, SEQ, VISIBLE, TYPE, CATALOGID, ISWRITELOG)
values (1202010102, 1202010100, '仓单添加权限', 12, null, '/stock/list/add*', null, 2, 0, 1, null, 'N');

insert into W_RIGHT (ID, PARENTID, NAME, MODULEID, ICON, AUTHORITYURL, VISITURL, SEQ, VISIBLE, TYPE, CATALOGID, ISWRITELOG)
values (1202010103, 1202010100, '查看品名权限', 12, null, '/stock/addStock/jsonForStock/getBreedByCategoryID.action', '/stock/addStock/jsonForStock/getBreedByCategoryID.action', 3, 0, 1, null, 'N');

insert into W_RIGHT (ID, PARENTID, NAME, MODULEID, ICON, AUTHORITYURL, VISITURL, SEQ, VISIBLE, TYPE, CATALOGID, ISWRITELOG)
values (1202010104, 1202010100, '查看属性权限', 12, null, '/stock/addStock/jsonForStock/getPropertyValueByBreedID.action', '/stock/addStock/jsonForStock/getPropertyValueByBreedID.action', 4, 0, 1, null, 'N');

insert into W_RIGHT (ID, PARENTID, NAME, MODULEID, ICON, AUTHORITYURL, VISITURL, SEQ, VISIBLE, TYPE, CATALOGID, ISWRITELOG)
values (1202010200, 1202010000, '拆单申请管理', 12, '29_29.gif', '/stock/apart/*', '/stock/apart/list.action?sortColumns=order+by+id', 2, 0, 0, 0, 'N');

insert into W_RIGHT (ID, PARENTID, NAME, MODULEID, ICON, AUTHORITYURL, VISITURL, SEQ, VISIBLE, TYPE, CATALOGID, ISWRITELOG)
values (1202010201, 1202010200, '查看仓单详情权限', 12, null, '/stock/apart/stockDetails*', '/stock/apart/stockDetails.action', 1, 0, 1, 0, 'N');

insert into W_RIGHT (ID, PARENTID, NAME, MODULEID, ICON, AUTHORITYURL, VISITURL, SEQ, VISIBLE, TYPE, CATALOGID, ISWRITELOG)
values (1202010202, 1202010200, '拆仓单修改权限', 12, null, '/stock/apart/update*', null, 2, 0, 1, null, 'N');

insert into W_RIGHT (ID, PARENTID, NAME, MODULEID, ICON, AUTHORITYURL, VISITURL, SEQ, VISIBLE, TYPE, CATALOGID, ISWRITELOG)
values (1202010300, 1202010000, '已拆仓单列表', 12, '29_29.gif', '/stock/dismantlelist*', '/stock/dismantlelist/stockDismantleList.action?sortColumns=order+by+dismantleId&isQueryDB=true', 3, 0, 0, 0, 'N');

insert into W_RIGHT (ID, PARENTID, NAME, MODULEID, ICON, AUTHORITYURL, VISITURL, SEQ, VISIBLE, TYPE, CATALOGID, ISWRITELOG)
values (1202010301, 1202010300, '查看仓单详情权限', 12, null, '/stock/dismantlelist/dismantleDetails*', '/stock/dismantlelist/dismantleDetails.action', 1, 0, 1, 0, 'N');

insert into W_RIGHT (ID, PARENTID, NAME, MODULEID, ICON, AUTHORITYURL, VISITURL, SEQ, VISIBLE, TYPE, CATALOGID, ISWRITELOG)
values (1202010400, 1202010000, '出库申请管理', 12, '29_29.gif', '/stock/exitlist/*', '/stock/exitlist/stockOutApplyList.action?sortColumns=order+by+stockId', 4, 0, 0, 0, 'N');

insert into W_RIGHT (ID, PARENTID, NAME, MODULEID, ICON, AUTHORITYURL, VISITURL, SEQ, VISIBLE, TYPE, CATALOGID, ISWRITELOG)
values (1202010401, 1202010400, '查看仓单详情权限', 12, null, '/stock/exitlist/stockOut*', '/stock/exitlist/stockOutReal.action', 1, 0, 1, 0, 'N');

insert into W_RIGHT (ID, PARENTID, NAME, MODULEID, ICON, AUTHORITYURL, VISITURL, SEQ, VISIBLE, TYPE, CATALOGID, ISWRITELOG)
values (1202010500, 1202010000, '出库仓单列表', 12, '29_29.gif', '/stock/exitlist*', '/stock/exitlist/stockList.action?sortColumns=order+by+stockId&isQueryDB=true', 5, 0, 0, 0, 'N');
commit;

prompt Done.
