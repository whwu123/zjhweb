package com.zjh.controller;

import java.util.List;
import javax.annotation.Resource;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zjh.model.Affix;
import com.zjh.model.Example;
import com.zjh.model.Items;
import com.zjh.model.News;
import com.zjh.service.AffixService;
import com.zjh.service.ExampleService;
import com.zjh.service.ItemsService;
import com.zjh.service.NewsService;
import com.zjh.util.PageView;

@Controller
@RequestMapping("index")
public class IndexController {
	@Resource(name="NewsService")
	private NewsService newsService;
	@Resource(name="ExampleService")
	private ExampleService exampleService;
	@Resource(name="AffixService")
	private AffixService affixService;
	@Resource(name="ItemsService")
	private ItemsService itemsService;

    @RequestMapping(value ="getNews.do",produces = "text/json;charset=UTF-8")
    @ResponseBody
    /**
     * 加载首页新闻模块
     * @return
     */
    public String getNews() {
    	List<News> list = newsService.getList();
    	JSONArray json = JSONArray.fromObject(list);//将java对象转换为json对象
		String str = json.toString();//将json对象转换为字符串
		//System.out.println(str);
		return str;
    }
    
    @RequestMapping(value ="getExample.do",produces = "text/json;charset=UTF-8")
    @ResponseBody
    /**
     * 加载首页成功案例模块
     * @return
     */
    public String getExample() {
    	List<Example> examples = exampleService.getExamples(1,6);
    	JSONArray json = JSONArray.fromObject(examples);//将java对象转换为json对象
		String str = json.toString();//将json对象转换为字符串
		//System.out.println(str);
		return str;
    }
    /**
     * 加载友情链接
     */
    @RequestMapping(value ="getItems.do",produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String getItems() {
    	List<Items> list = itemsService.getList();
    	JSONArray json = JSONArray.fromObject(list);//将java对象转换为json对象
		String str = json.toString();//将json对象转换为字符串
		//System.out.println(str);
		return str;
    }
    @RequestMapping(value ="getAffix.do",produces = "text/json;charset=UTF-8")
    @ResponseBody
    /**
     * 加载首页附件模块
     * @return
     */
    public String getAffix() {
    	List<Affix> affixs = affixService.getAffixs(1, 3);
    	JSONArray json = JSONArray.fromObject(affixs);//将java对象转换为json对象
		String str = json.toString();//将json对象转换为字符串
		//System.out.println(str);
		return str;
    }
    /**
     * 加载首页附件模块
     * @return
     */
    @RequestMapping(value ="getAffixAll.do",produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String getAffixAll(Integer pageNum) {
    	//通过数据库查询得到总页数，总条数，
		int totalCount = 0;
		int totalPage = 0;
		int pageSize = 5;
		totalCount = affixService.getAffixCount();
    	List<Affix> affixs = affixService.getAffixsAll(pageNum, pageSize);
    	totalPage = (totalCount + pageSize -1)/pageSize;
    	
    	PageView<Affix> pageView = new PageView<Affix>();
    	pageView.setListData(affixs);
    	pageView.setPageNum(pageNum);
    	pageView.setTotalCount(totalCount);
    	pageView.setPageSize(pageSize);
    	pageView.setTotalPage(totalPage);
    
		JSONObject json = JSONObject.fromObject(pageView);//将java对象转换为json对象
		String str = json.toString();//将json对象转换为字符串
		//System.out.println(str);
		return str;
    }
   
}
