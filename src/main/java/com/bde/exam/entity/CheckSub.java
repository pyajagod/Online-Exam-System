package com.bde.exam.entity;

import java.util.List;

public class CheckSub {

    public static int checkSubAns(String myAns, String baseAns){
       int count = 0;

       List<String> ans = ChineseSplit.chineseSplitFunction(myAns, 2);
       List<String> corrAns = ChineseSplit.chineseSplitFunction(baseAns, 2);

       String[] ansArr = new String[ans.size()];
       ans.toArray(ansArr);

       String[] ansCorrArr = new String[corrAns.size()];
       corrAns.toArray(ansCorrArr);

//       if(ansArr.length > ansCorrArr.length){
//           return 0;
//       }
      String aaa="a";
      for (int i=0; i<ansCorrArr.length; i++){
          for (int j=0; j<ansArr.length; j++) {
              if (!aaa.equals(ansCorrArr[i])) {
                  if (ansArr[j].equals(ansCorrArr[i])) {
                      count += 1;
                      j++;
                      aaa = ansCorrArr[i];
                      break;
                  } else {
                      continue;
                  }
              }
          }
//              if (ansArr[i].equals(ansCorrArr[i])){
//                  count += 1;
//          }
      }
       return count;
    }

//    public static void main(String[] args) {
//        String s1 = "Java";
//        String s2 = "Java";
//        CheckSub checkSub = new CheckSub();
//        double x = (double)checkSub.checkSubAns(s1, s2)/s2.length();
//
//        System.out.println(checkSub.checkSubAns(s1, s2) + "====" + s2.length() + "====" + x);
//    }
}
