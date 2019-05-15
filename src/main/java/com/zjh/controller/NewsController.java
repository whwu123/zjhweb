package com.zjh.controller;

import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zjh.model.Affix;
import com.zjh.model.News;
import com.zjh.service.AffixService;
import com.zjh.service.NewsService;
import com.zjh.util.PageView;

/**
 * 新闻控制器
 * @author Brooke
 *
 */
@Controller
@RequestMapping("news")
public class NewsController {
	@Resource(name="NewsService")
	private NewsService newsService;
	@Resource(name="AffixService")
	private AffixService affixService;
	
	@RequestMapping(value ="getNewsList.do",produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String getNewsList(Integer pageNum,Integer type){
		PageView<News> pageView = new PageView<News>();
		if(pageNum==null){
			pageNum = 1;
		}
		if(type==null){
			type=1;
		}
		//通过数据库查询得到总页数，总条数，
		int totalCount = 0;
		int totalPage = 0;
		int pageSize = 4;
		List<News> newsList = newsService.getList(pageNum, pageSize, type);
		totalCount = newsService.getTotalCount(type);
		totalPage = (totalCount + pageSize -1)/pageSize;
		
		pageView.setPageNum(pageNum);
		pageView.setPageSize(pageSize);
		pageView.setListData(newsList);
		pageView.setTotalCount(totalCount);
		pageView.setTotalPage(totalPage);
		
		
		JSONObject json = JSONObject.fromObject(pageView);//将java对象转换为json对象
		String str = json.toString();//将json对象转换为字符串
		return str;
	}
	/**
	 * 查看新闻
	 */
	@RequestMapping(value ="newsView.do",produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String checkNewsView(Integer id){
		News news = newsService.getNewsById(id);
		JSONObject json = JSONObject.fromObject(news);//将java对象转换为json对象
		String str = json.toString();
		return str;
	}
	/**
	 * 取得上一篇新闻
	 */
	@RequestMapping(value ="newsViewPrev.do",produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String checkNewsViewPrev(Integer id){
		News news = newsService.getNewsPrev(id);
		JSONObject json = JSONObject.fromObject(news);//将java对象转换为json对象
		String str = json.toString();
		return str;
	}
	/**
	 * 取得下一篇新闻
	 */
	@RequestMapping(value ="newsViewNext.do",produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String checkNewsViewNext(Integer id){
		News news = newsService.getNewsNext(id);
		JSONObject json = JSONObject.fromObject(news);//将java对象转换为json对象
		String str = json.toString();
		return str;
	}
	
	/**
	 * 取得新闻附件
	 */
	@RequestMapping(value ="getNewsAffixById.do",produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String getNewsAffixById(Integer id){
		String str = null;
		//通过新闻ID取得附件ID
		int affixid = newsService.getNewsById(id).getAffixid();
		if(affixid>0){
			Affix affix = affixService.getAffixByIdNotContent(affixid);
			JSONObject json = JSONObject.fromObject(affix);//将java对象转换为json对象
			str = json.toString();
		}

		return str;
	}
}
