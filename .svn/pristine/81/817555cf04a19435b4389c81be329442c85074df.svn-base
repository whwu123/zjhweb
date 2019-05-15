package com.zjh.controller;

import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zjh.model.Example;
import com.zjh.model.News;
import com.zjh.service.ExampleService;
import com.zjh.util.PageView;

/**
 * 案例控制器
 * @author Brooke
 *
 */
@Controller
@RequestMapping("case")
public class ExampleController {
	@Resource(name="ExampleService")
	private ExampleService exampleService;
	
	/**
	 * 得到所有案例
	 */
	@RequestMapping(value ="getCaseAll.do",produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String getCaseAll(Integer pageNum){
		Integer pageSize = 20;
		if(pageNum==null){
			pageNum = 1;
		}
		int totalCount = 0;
		int totalPage = 0;
		List<Example> examples = exampleService.getExamples(pageNum, pageSize);
		totalCount = exampleService.getCountExample();
		totalPage = (totalCount + pageSize -1)/pageSize;
		PageView<Example> pageView = new PageView<Example>();
		pageView.setListData(examples);
		pageView.setPageNum(pageNum);
		pageView.setPageSize(pageSize);
		pageView.setTotalCount(totalCount);
		pageView.setTotalPage(totalPage);
		JSONObject json = JSONObject.fromObject(pageView);//将java对象转换为json对象
		String str = json.toString();//将json对象转换为字符串
		//System.out.println(str);
		return str;
	}
	
	/**
	 * 查看案例
	 */
	@RequestMapping(value ="checkCaseView.do",produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String checkCaseView(Integer id){
		Example example = exampleService.getExampleById(id);
		JSONObject json = JSONObject.fromObject(example);//将java对象转换为json对象
		String str = json.toString();
		return str;
	}
	
	/**
	 * 查看案例上一篇
	 */
	@RequestMapping(value ="caseViewPrev.do",produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String checkCaseViewPrev(Integer id){
		Example example = exampleService.getExamplePrev(id);
		JSONObject json = JSONObject.fromObject(example);//将java对象转换为json对象
		String str = json.toString();
		return str;
	}
	/**
	 * 查看案例下一篇
	 */
	@RequestMapping(value ="caseViewNext.do",produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String checkCaseViewNexrt(Integer id){
		Example example = exampleService.getExampleNext(id);
		JSONObject json = JSONObject.fromObject(example);//将java对象转换为json对象
		String str = json.toString();
		return str;
	}

}
