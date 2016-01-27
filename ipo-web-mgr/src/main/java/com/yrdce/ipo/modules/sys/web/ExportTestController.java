package com.yrdce.ipo.modules.sys.web;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yrdce.ipo.modules.sys.service.SPOService;
import com.yrdce.ipo.modules.sys.vo.SpoCommoditymanmaagement;

@Controller
@RequestMapping("ExportTestController")
public class ExportTestController {

	static org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(SPOController.class);

	@Autowired
	private SPOService spoService;

	ExportExcel<SpoCommoditymanmaagement> excelService = new ExportExcel<SpoCommoditymanmaagement>();

	@RequestMapping(params = "method=sheetsExport")
	public void exportTest(HttpServletResponse response, SpoCommoditymanmaagement spoComm) throws IOException {
		logger.info("导出excel");
		try {
			logger.info(spoComm.getRationType());
			List<SpoCommoditymanmaagement> tempList = spoService.getSPOList("1", "100", spoComm);
			String haders[] = new String[] { "序号", "名称", "年龄", "生日", "地址", "学号" };

			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String filename = format.format(new Date().getTime()) + ".xls";
			response.setContentType("application/ms-excel;charset=UTF-8");
			response.setHeader("Content-Disposition",
					"attachment;filename=".concat(String.valueOf(URLEncoder.encode(filename, "UTF-8"))));
			OutputStream out = response.getOutputStream();
			try {
				excelService.exportExcel(haders, tempList, out);
			} catch (Exception e) {
				logger.error("导出excel异常", e);
			} finally {
				out.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("导出excel异常", e);
		}
	}
}
