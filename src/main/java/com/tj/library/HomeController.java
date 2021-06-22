package com.tj.library;

import java.io.File;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	@Autowired
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Resource(name="uploadPath")
     String uploadPath;   

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	private static final String CURR_IMAGE_REPO_PATH = null;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("/input")
	public String goinput()
	{
		return "input";
	}
	
	@RequestMapping(value="/saveprocess", method=RequestMethod.GET)
	public String callsave(LibDTO libDTO)
	{
		String book = libDTO.getBook();
		String name = libDTO.getName();
		String num = libDTO.getNum();
		int price = libDTO.getPrice();
		
		InterfaceDAO dao = sqlSession.getMapper(InterfaceDAO.class);
		dao.write(book, name, num, price);
		
		return "redirect:out";
				
	}
	
	@RequestMapping("/write")
	public String gowrite(HttpServletRequest hs, Model model)
	{
		InterfaceDAO dao = sqlSession.getMapper(InterfaceDAO.class);
		dao.write(hs.getParameter("book"), hs.getParameter("name"), 
				hs.getParameter("num"), Integer.parseInt(hs.getParameter("price")));
		return ("redirect:out");
	}
	
	@RequestMapping("/delete")
	public String godelete(HttpServletRequest hs)
	{
		InterfaceDAO dao = sqlSession.getMapper(InterfaceDAO.class);
		dao.delete(hs.getParameter("book"));
		return ("redirect:out");
	}
	
	@RequestMapping("/modify")
	public String callmodifyview(HttpServletRequest hs, Model model)
	{
		model.addAttribute("book",hs.getParameter("book"));
		return "modify_view";
	}
	
	@RequestMapping("/modifysave")
	public String gomodi(HttpServletRequest hs)
	{
		InterfaceDAO dao = sqlSession.getMapper(InterfaceDAO.class);
		dao.update(Integer.parseInt(hs.getParameter("price")),hs.getParameter("book"));
		return "redirect:out";
	}
	
	@RequestMapping("/out")
	public String goout(Model model)
	{
		InterfaceDAO dao = sqlSession.getMapper(InterfaceDAO.class);
		model.addAttribute("list",dao.list());
		return "output";
		
	}
	
//	@RequestMapping(value="/upload",method = RequestMethod.POST)
//	public ModelAndView upload(MultipartHttpServletRequest multipartRequest,HttpServletResponse response)
//	  throws Exception{
//		multipartRequest.setCharacterEncoding("utf-8");
//		Map map = new HashMap();
//		Enumeration enu=multipartRequest.getParameterNames();
//		while(enu.hasMoreElements()){
//			String name=(String)enu.nextElement();
//			String value=multipartRequest.getParameter(name);
//			//System.out.println(name+", "+value);
//			map.put(name,value);
//		}
//		
//		List fileList= fileProcess(multipartRequest);
//		map.put("fileList", fileList);
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("map", map);
//		mav.setViewName("result");
//		return mav;
//	}
//	
//	private List<String> fileProcess(MultipartHttpServletRequest multipartRequest) throws Exception{
//		List<String> fileList= new ArrayList<String>();
//		Iterator<String> fileNames = multipartRequest.getFileNames(); //iterator:열거형
//		while(fileNames.hasNext()){
//			String fileName = fileNames.next();
//			MultipartFile mFile = multipartRequest.getFile(fileName);
//			String originalFileName=mFile.getOriginalFilename();
//			fileList.add(originalFileName);
//			File file = new File(CURR_IMAGE_REPO_PATH +"\\"+ fileName);
//			if(mFile.getSize()!=0){ //File Null Check
//				if(! file.exists()){ //경로상에 파일이 존재하지 않을 경우
//					if(file.getParentFile().mkdirs()){ //경로에 해당하는 디렉토리들을 생성
//						file.createNewFile(); //이후 파일 생성
//					}
//				}
//				mFile.transferTo(new File(CURR_IMAGE_REPO_PATH +"\\"+ originalFileName)); //임시로 저장된 multipartFile을 실제 파일로 전송
//			}
//		}
//		return fileList;
//	}
	
	
	
	
}
