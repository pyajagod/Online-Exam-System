package com.bde.exam.contoller;

import com.bde.exam.entity.CheckSub;
import com.bde.exam.entity.ChineseSplit;
import com.bde.exam.model.*;
import com.bde.exam.service.Impl.ObjServiceImpl;
import com.bde.exam.service.Impl.PaperServiceImpl;
import com.bde.exam.service.Impl.SubServiceImpl;
import com.bde.exam.service.Impl.UserServiceImpl;
import com.bde.exam.service.ObjService;
import com.bde.exam.service.PaperService;
import com.bde.exam.service.SubService;
import com.bde.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Controller
@RequestMapping("/exam")
public class PaperController {

    @Autowired
    private UserService userService = new UserServiceImpl();
    private PaperService paperService = new PaperServiceImpl();
    private ObjService objService = new ObjServiceImpl();
    private SubService subService = new SubServiceImpl();
    private Set<Integer> obj = new HashSet<>();
    private Set<Integer> sub = new HashSet<>();

    @RequestMapping("/index")
    public String toExamination(Model model, String userId){
        UserModel userModel = new UserModel();
        userModel.setUserId(Integer.parseInt(userId));
        UserModel user = userService.queryUser(userModel);
        model.addAttribute("userId", userId);
        model.addAttribute("userName", user.getUserName());
        model.addAttribute("userIsAdmin", user.getUserProsition());
//                    System.out.println(userModel.getUserProsition());
        model.addAttribute("msg", "come on baby!");
        return "examinations";
    }

    @RequestMapping("/simulate")
    public String toSimulate(Model model){
        int subCount = subService.querySubCounts();
        int objCount = objService.queryObjCounts();
        int a, b;
        Random random = new Random();
        for (int i = 0; i < 8; i++) {
            a = random.nextInt(objCount) + 1;
            if (!obj.contains(a)){
                obj.add(a);
            }else {
                i--;
            }
        }

        Set<ObjModel> objLists = objService.queryObjById(obj);
//        for (ObjModel obj: objLists){
//            System.out.println(obj.getObjQues());
//        }
        obj.clear();
        for (int i=0; i<4; i++){
            b = random.nextInt(subCount) + 1;
            if (!sub.contains(b)){
                sub.add(b);
            }else {
                i--;
            }
        }

        Set<SubModel> subLists = subService.querySubById(sub);
//        for (SubModel sub : subLists){
//            System.out.println(sub.getSubDesc());
//        }
        sub.clear();
        model.addAttribute("objs", objLists);
        model.addAttribute("subs", subLists);
        return "simulations";
    }

    @RequestMapping("/onlineTestt")
    public String toOnlineTest(Model model, String itemId, String userId){
        ExamModel exam = paperService.queryOnePaper(Integer.parseInt(itemId));
//        System.out.println(exam.getPaperName());
        List<PaperObjModel> objs = paperService.queryObjs(Integer.parseInt(itemId));
        List<PaperSubModel> subs = paperService.querySubs(Integer.parseInt(itemId));
        model.addAttribute("objs", objs);
        model.addAttribute("subs",subs);
        model.addAttribute("paperName", exam.getPaperName());
        model.addAttribute("paperId", itemId);
        System.out.println(itemId);
        model.addAttribute("userId", userId);
//        System.out.println(itemId + "===" + userId);
        return "onlineTest";
    }

    @RequestMapping("/add")
    public String toAdd(Model model, String userId){
        model.addAttribute("userId", userId);
        return "addPaper";
    }

    @RequestMapping("/addPapers")
    public String toAddPapers(Model model, String paperUploaderId, String paperName){
        ExamModel examModel = new ExamModel(paperName, Integer.parseInt(paperUploaderId));
        paperService.addPaper(examModel);
        model.addAttribute("userId", paperUploaderId);
        return "pika3";
    }

    @RequestMapping("/addObjs")
    public String toAddObj(Model model, String itemId, String userId){
        model.addAttribute("userId", userId);
        model.addAttribute("itemId", itemId);
        int count = paperService.queryPaperObjCounts(Integer.parseInt(itemId));
        if (count < 8) {
            return "addPaperObj";
        }else{
            return "pika3";
        }
    }

    @RequestMapping("/deleteObj")
    public String toDeleteObj(Model model, String itemId, String objId){
//        System.out.println(itemId + "======" + objId);
        paperService.deleteOneObj(Integer.parseInt(objId));
        model.addAttribute("itemId", itemId);
        return "pika4";
    }

    @RequestMapping("/updateObj")
    public String toUpdateObj(Model model, String objId){
        PaperObjModel obj = paperService.queryOneObj(Integer.parseInt(objId));
        model.addAttribute("obj", obj);
        return "updatePaperObj";
    }

    @RequestMapping("/updateObjItem")
    public String toUpdateObjItem(Model model, PaperObjModel obj){
        paperService.updateOneObj(obj);
        model.addAttribute("itemId", obj.getItemId());
        return "pika4";
    }

    @RequestMapping("/showObjs")
    public String toShowObjs(Model model, String itemId){
        List<PaperObjModel> objItems = paperService.queryObjs(Integer.parseInt(itemId));
        model.addAttribute("objItems", objItems);
        return "paperObjItems";
    }

    @RequestMapping("/addObjsItems")
    public String toAddObjsItems(Model model,String userId, String itemId, String objQues, String objDescA, String objDescB, String objDescC, String objDescD, String objAns){
        PaperObjModel obj = new PaperObjModel(Integer.parseInt(itemId), objQues, objDescA, objDescB, objDescC, objDescD, objAns);
        int count = paperService.queryPaperObjCounts(Integer.parseInt(itemId));
        if (count < 7){
            paperService.addPaperObj(obj);
            model.addAttribute("itemId", itemId);
            model.addAttribute("userId", userId);
            return "addPaperObj";
        }else {
            paperService.addPaperObj(obj);
            model.addAttribute("userId", userId);
            return "pika3";
        }
    }

    @RequestMapping("/addSubs")
    public String toAddSub(Model model, String itemId, String userId){
        model.addAttribute("userId", userId);
        model.addAttribute("itemId", itemId);
        int count = paperService.queryPaperSubCounts(Integer.parseInt(itemId));
        if (count < 4) {
            return "addPaperSub";
        }else {
            return "pika3";
        }
    }

    @RequestMapping("/deleteSub")
    public String toDeleteSub(Model model, String subId, String itemId){
//        System.out.println(subId + "======" + itemId);
        paperService.deleteOneSub(Integer.parseInt(subId));
        model.addAttribute("itemId", itemId);
        return "pika5";
    }

    @RequestMapping("/updateSub")
    public String toUpdateSub(Model model, String subId){
        PaperSubModel sub = paperService.queryOneSub(Integer.parseInt(subId));
        model.addAttribute("sub", sub);
        return "updatePaperSub";
    }

    @RequestMapping("/updateSubItem")
    public String toUpdateSubItem(Model model, String subDesc, String subAns, String id, String itemId){
        PaperSubModel subModel = new PaperSubModel(Integer.parseInt(id), Integer.parseInt(itemId), subDesc, subAns);
        paperService.updateOneSub(subModel);
        model.addAttribute("itemId", itemId);
        return "pika5";
    }

    @RequestMapping("/showSubs")
    public String toShowSubs(Model model, String itemId){
        List<PaperSubModel> subItems = paperService.querySubs(Integer.parseInt(itemId));
        model.addAttribute("subItems",subItems);
        return "paperSubItems";
    }

    @RequestMapping("/addSubsItems")
    public String toAddSubsItems(Model model, String userId, String itemId, String subDesc, String subAns){
        PaperSubModel paperSubModel = new PaperSubModel(Integer.parseInt(itemId), subDesc, subAns);
        int count = paperService.queryPaperSubCounts(Integer.parseInt(itemId));
        System.out.println(count);
        if (count < 3){
            paperService.addPaperSub(paperSubModel);
            model.addAttribute("userId", userId);
            model.addAttribute("itemId", itemId);
            return "addPaperSub";
        }else {
            model.addAttribute("userId", userId);
            paperService.addPaperSub(paperSubModel);
            return "pika3";
        }
    }

    @RequestMapping("/show")
    public String toShow(Model model, Integer curPage,  String userId){
        int paperUploaderId = Integer.parseInt(userId);

        int pageSize = 10;
        if (curPage == null || curPage < 0){
            curPage = 1;
        }
        int totalRows = paperService.queryPaperCounts();

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


//        List<SubModel> subItems = subService.querySubByPage(paramMap);
        List<ExamModel> exams = paperService.queryPapers(paramMap);

        model.addAttribute("paperUploaderId", paperUploaderId);
        model.addAttribute("exams", exams);
        model.addAttribute("curPage", curPage);
        model.addAttribute("totalPages", totalPages);
        return "showPapers";
    }

    @RequestMapping("/showWritePaper")
    public String toShowWritePaper(Model model, Integer curPage,  String userId){
        int paperUploaderId = Integer.parseInt(userId);
        UserModel userModel = new UserModel();
        userModel.setUserId(paperUploaderId);
        UserModel user = userService.queryUser(userModel);


//        System.out.println(userName);
        int pageSize = 10;
        if (curPage == null || curPage < 0){
            curPage = 10;
        }
        int totalRows = paperService.queryPaperCounts();

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


//        List<SubModel> subItems = subService.querySubByPage(paramMap);
        List<ExamModel> exams = paperService.queryPapers(paramMap);
        LinkedList<Integer> ids = new LinkedList<>();
        for (ExamModel exam :exams) {
            ids.addLast(exam.getPaperUploaderId());
        }
        LinkedList<String> names = new LinkedList<>();
        LinkedList<UserModel> users = userService.queryUserByIds(ids);
        for (UserModel user1 : users){
            names.addLast(user1.getUserName());
        }

//        model.addAttribute("userId", userId);
        model.addAttribute("names", names);
        model.addAttribute("userId", userId);
        model.addAttribute("exams", exams);
        model.addAttribute("curPage", curPage);
        model.addAttribute("totalPages", totalPages);
        return "writePapers";
    }

    @RequestMapping("/delete")
    public String toDelete(Model model, String itemId, String userId){
        paperService.deletePaper(Integer.parseInt(itemId));
        paperService.deletePaperObj(Integer.parseInt(itemId));
        paperService.deletePaperSub(Integer.parseInt(itemId));
        model.addAttribute("userId", userId);
        return "pika3";
    }

    @RequestMapping("/update")
    public String toUpdate(Model model, String itemId, String paperDesc, String userId){
//        System.out.println(itemId + "===" + paperDesc + "===" + userId);
        ExamModel paper = new ExamModel(Integer.parseInt(itemId), paperDesc, Integer.parseInt(userId));
//        System.out.println(paper.getPaperName());
//        System.out.println(paper.getPaperUploaderId());
        model.addAttribute("paper", paper);
        return "updatePaper";
    }

    @RequestMapping("/updatePaperName")
    public String toUpdatePaper(Model model, ExamModel paper){
        paperService.updatePaper(paper);
        model.addAttribute("userId", paper.getPaperUploaderId());
        return "pika3";
    }


    @ResponseBody
    @RequestMapping("/checkAns")
    public int toCheckAns(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        String[] objAns = new String[8];
        String[] subAns = new String[4];
        int i=0, j=0, count=0;
//        String itemId = request.getParameter("itemId");
        int itemId = Integer.parseInt(request.getParameter("itemId"));
        System.out.println(itemId);
        String objAnsA = request.getParameter("objAnsA");
        String objAnsB = request.getParameter("objAnsB");
        String objAnsC = request.getParameter("objAnsC");
        String objAnsD = request.getParameter("objAnsD");
        String objAnsE = request.getParameter("objAnsE");
        String objAnsF = request.getParameter("objAnsF");
        String objAnsG = request.getParameter("objAnsG");
        String objAnsH = request.getParameter("objAnsH");
        String subAnsA = request.getParameter("subAnsA");
        String subAnsB = request.getParameter("subAnsB");
        String subAnsC = request.getParameter("subAnsC");
        String subAnsD = request.getParameter("subAnsD");
        int gradeUploaderId = Integer.parseInt(request.getParameter("gradeUploaderId"));

        List<String> myObjs = new ArrayList<>();
        myObjs.add(objAnsA);
        myObjs.add(objAnsB);
        myObjs.add(objAnsC);
        myObjs.add(objAnsD);
        myObjs.add(objAnsE);
        myObjs.add(objAnsF);
        myObjs.add(objAnsG);
        myObjs.add(objAnsH);

        List<String> mySubs = new ArrayList<>();
        mySubs.add(subAnsA);
        mySubs.add(subAnsB);
        mySubs.add(subAnsC);
        mySubs.add(subAnsD);


        List<PaperObjModel> objs = paperService.queryObjs(itemId);
        for (PaperObjModel obj : objs){
//            System.out.println(i + "、" + obj.getObjAns());
            objAns[i]=obj.getObjAns();
            i++;
        }

        List<PaperSubModel> subs = paperService.querySubs(itemId);
        for (PaperSubModel sub : subs){
//            System.out.println(j + "、" + sub.getSubAns());
            subAns[j] = sub.getSubAns();
            j++;
        }
        i=0;
        j=0;
        for (String myObj : myObjs){
            if (objAns[i].equals(myObj)){
                count += 5;
            }
            i++;
        }

        double result;
        for (String mySub : mySubs){
//            if (subAns[j].equals(mySub)){
//                count += 15;
//            }
            int sum  = CheckSub.checkSubAns(mySub, subAns[j]);
            result = (double) sum/mySub.length();
            if (result >= 0.8){
                count += 15;
            }else if (result >= 0.5){
                count += 7;
            }else {
                count += 0;
            }
            j++;
        }

//        System.out.println(count);

        PaperGradeModel grade = new PaperGradeModel(itemId, count, gradeUploaderId);
        paperService.addPaperGrade(grade);

//        System.out.println(grade);
        return count;

//        System.out.println(itemId + "========" + gradeUploaderId + "=====" + subAnsA + "======" + objAnsB);

    }


    @RequestMapping("/queryGrades")
    public String toQueryGrades(Model model, String userId){
        List<GradeModel> paperGrades = paperService.queryPaperGrades(Integer.parseInt(userId));
//        for (GradeModel grade : paperGrades){
//            System.out.println(grade.getPaperName());
//        }
        model.addAttribute("paperGrades", paperGrades);
        return "paperGrades";
    }

    @RequestMapping("/queryAllGrades")
    public String toQueryAllGrades(Model model, String itemId){
        List<GradeModel> allpaperGrades = paperService.queryAllPaperGrades(Integer.parseInt(itemId));
        model.addAttribute("allGrades", allpaperGrades);
        return "allPaperGrades";
    }

}
