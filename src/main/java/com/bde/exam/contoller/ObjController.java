package com.bde.exam.contoller;

import com.bde.exam.model.ObjModel;
import com.bde.exam.service.Impl.ObjServiceImpl;
import com.bde.exam.service.ObjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Controller
@RequestMapping("/obj")
public class ObjController {

    @Autowired
    private ObjService objService = new ObjServiceImpl();

    @RequestMapping("/index")
    public String toIndex(Model model, String userId){

        model.addAttribute("userId", userId);
        return "objectiveItem";
    }

    @RequestMapping("/add")
    public String toAdd(Model model, String userId, String objQues, String objDescA, String objDescB, String objDescC, String objDescD, String objAns){
        int objUploadId = Integer.parseInt(userId);
        ObjModel obj = new ObjModel(objQues, objDescA, objDescB, objDescC, objDescD, objAns, objUploadId);
        objService.addObj(obj);
        model.addAttribute("userId", userId);
        return "pika2";
    }

    @RequestMapping("/delete")
    public String toDelete(Model model, String objId, String userId){
        int id = Integer.parseInt(objId);
        objService.deleteObj(id);
        model.addAttribute("userId", userId);
        return "pika2";
    }

    @RequestMapping("/update")
    public String toUpdate(Model model, String objId){
        int id = Integer.parseInt(objId);
        ObjModel objItem = objService.queryObj(id);
//        System.out.println(objItem.getObjQues());
        model.addAttribute("objItem", objItem);
        return "updateObj";
    }

//    @RequestMapping()

    @RequestMapping("/updateObj")
    public String toUpdateObj(Model model, ObjModel objModel){
        objService.updateObj(objModel);
        System.out.println(objModel.getObjQues());
        int userId = objModel.getObjUploaderId();
        model.addAttribute("userId", userId);
        return "pika2";
    }

    @RequestMapping("/show")
    public String toShow(Model model, Integer curPage, String userId){
        int objUploaderId = Integer.parseInt(userId);
        int pageSize = 5;
        if (curPage == null || curPage < 0){
            curPage = 1;
        }
        int totalRows = objService.queryObjCounts();

        int totalPages = totalRows / pageSize;
        int left = totalRows % pageSize;
        if (left > 0){
            totalPages += 1;
        }

        if (curPage > totalPages){
            curPage = totalPages;
        }

//        System.out.println(curPage);
        int startRow = (curPage - 1) * pageSize;
//        int startRow = curPage * pageSize;

        Map<String, Object> paramMap = new ConcurrentHashMap<>();
        paramMap.put("startRow", startRow);
        paramMap.put("pageSize", pageSize);


        List<ObjModel> objItems = objService.queryObjByPage(paramMap);

//        for(ObjModel obj : objItems){
//            System.out.println(obj.getObjQues());
//        }
        model.addAttribute("objUploaderId", objUploaderId);
        model.addAttribute("objItems", objItems);
        model.addAttribute("curPage", curPage);
        model.addAttribute("totalPages", totalPages);
        return "objItems";
    }
}
