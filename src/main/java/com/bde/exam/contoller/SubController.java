package com.bde.exam.contoller;

import com.bde.exam.model.SubModel;
import com.bde.exam.service.Impl.SubServiceImpl;
import com.bde.exam.service.SubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@Controller
@RequestMapping("/sub")
public class SubController {

    @Autowired
    private SubService subService = new SubServiceImpl();

    @RequestMapping("/index")
    public String toIndex(Model model, String userId){
        model.addAttribute("userId", userId);
        return "subjectiveItem";
    }

    @RequestMapping("/add")
    public String toAdd(Model model, String subDesc, String subAns, String userId){
        SubModel sub = new SubModel(subDesc, subAns, Integer.parseInt(userId));
        subService.addSub(sub);
        model.addAttribute("userId", userId);
        model.addAttribute("curPage", 1);
        return "pika1";
    }

    @RequestMapping("/delete")
    public String toDelete(Model model, String subId, String userId){
        int id = Integer.parseInt(subId);
        subService.deleteSub(id);
        model.addAttribute("userId", userId);
        return "pika1";
    }

    @RequestMapping("/update")
    public String toUpdate( Model model, String subId){
        int id = Integer.parseInt(subId);
        SubModel subItem = subService.querySub(id);
        System.out.println(subItem.getSubDesc());
        model.addAttribute("subItem", subItem);
        return "updateSub";
    }

    @RequestMapping("/updateSub")
    public String toUpdateSub(Model model, SubModel subModel){
        subService.updateSub(subModel);
        model.addAttribute("userId", subModel.getSubUploaderId());
        return "pika1";
    }

    @RequestMapping("/show")
    public String toShow(Model model, Integer curPage, String userId){
        int subUploaderId = Integer.parseInt(userId);

        int pageSize = 5;
        if (curPage == null || curPage < 0){
            curPage = 1;
        }
        int totalRows = subService.querySubCounts();

        int totalPages = totalRows / pageSize;
        int left = totalRows % pageSize;
        if (left > 0){
            totalPages += 1;
        }

        if (curPage > totalPages){
            curPage = totalPages;
        }

        int startRow = (curPage - 1) * pageSize;
//        int startRow = curPage * pageSize;
        Map<String, Object> paramMap = new ConcurrentHashMap<>();
        paramMap.put("startRow", startRow);
        paramMap.put("pageSize", pageSize);
//        paramMap.put("subUploaderId", subUploaderId);

        List<SubModel> subItems = subService.querySubByPage(paramMap);
//        for (SubModel sub : subItems){
//            System.out.println(subUploaderId + "======" + sub.getSubUploaderId());
//        }

        model.addAttribute("subUploaderId", subUploaderId);
        model.addAttribute("subItems", subItems);
        model.addAttribute("curPage", curPage);
        model.addAttribute("totalPages", totalPages);
        return "subItems";
    }
}
