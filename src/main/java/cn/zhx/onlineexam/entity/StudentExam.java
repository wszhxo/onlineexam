package cn.zhx.onlineexam.entity;

import java.lang.String;

public class StudentExam {
    private String  questionsChoice1;
    private String  questionsChoice2;
    private String  questionsChoice3;
    private String  questionsChoice4;
    private String  questionsChoice5;//5
    private String  questionsChoice6;
    private String  questionsChoice7;
    private String  questionsChoice8;
    private String  questionsChoice9;
    private String  questionsChoice10;//10
    private String  questionsChoice11;
    private String  questionsChoice12;
    private String  questionsChoice13;
    private String  questionsChoice14;
    private String  questionsChoice15;//15
    private String  questionsChoice16;
    private String  questionsChoice17;
    private String  questionsChoice18;
    private String  questionsChoice19;
    private String  questionsChoice20;//最多20道单选题


    private String[]  questionsChoices1;
    private String[]  questionsChoices2;
    private String[]  questionsChoices3;
    private String[]  questionsChoices4;
    private String[]  questionsChoices5;//5
    private String[]  questionsChoices6;
    private String[]  questionsChoices7;
    private String[]  questionsChoices8;
    private String[]  questionsChoices9;
    private String[]  questionsChoices10;//10
    private String[]  questionsChoices11;
    private String[]  questionsChoices12;
    private String[]  questionsChoices13;
    private String[]  questionsChoices14;
    private String[]  questionsChoices15;//15
    private String[]  questionsChoices16;
    private String[]  questionsChoices17;
    private String[]  questionsChoices18;
    private String[]  questionsChoices19;
    private String[]  questionsChoices20;//最多20道单选题

    private String  questionsFill1;
    private String  questionsFill2;
    private String  questionsFill3;
    private String  questionsFill4;
    private String  questionsFill5;//5
    private String  questionsFill6;
    private String  questionsFill7;
    private String  questionsFill8;
    private String  questionsFill9;
    private String  questionsFill10;//最多10道填空题

    private String  questionsTof1;
    private String  questionsTof2;
    private String  questionsTof3;
    private String  questionsTof4;
    private String  questionsTof5;//5
    private String  questionsTof6;
    private String  questionsTof7;
    private String  questionsTof8;
    private String  questionsTof9;
    private String  questionsTof10;//最多10道判断题


    private String  questionsSubjective1;
    private String  questionsSubjective2;
    private String  questionsSubjective3;
    private String  questionsSubjective4;
    private String  questionsSubjective5;//最多5道主观题


    private String   begintime;//开始考试时间
    private String   endtime;//结束考试时间

    public String getBegintime() {
        return begintime;
    }

    public void setBegintime(String begintime) {
        this.begintime = begintime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getQuestionsChoice1() {
        return questionsChoice1;
    }

    public void setQuestionsChoice1(String questionsChoice1) {
        this.questionsChoice1 = questionsChoice1;
    }

    public String getQuestionsChoice2() {
        return questionsChoice2;
    }

    public void setQuestionsChoice2(String questionsChoice2) {
        this.questionsChoice2 = questionsChoice2;
    }

    public String getQuestionsChoice3() {
        return questionsChoice3;
    }

    public void setQuestionsChoice3(String questionsChoice3) {
        this.questionsChoice3 = questionsChoice3;
    }

    public String getQuestionsChoice4() {
        return questionsChoice4;
    }

    public void setQuestionsChoice4(String questionsChoice4) {
        this.questionsChoice4 = questionsChoice4;
    }

    public String getQuestionsChoice5() {
        return questionsChoice5;
    }

    public void setQuestionsChoice5(String questionsChoice5) {
        this.questionsChoice5 = questionsChoice5;
    }

    public String getQuestionsChoice6() {
        return questionsChoice6;
    }

    public void setQuestionsChoice6(String questionsChoice6) {
        this.questionsChoice6 = questionsChoice6;
    }

    public String getQuestionsChoice7() {
        return questionsChoice7;
    }

    public void setQuestionsChoice7(String questionsChoice7) {
        this.questionsChoice7 = questionsChoice7;
    }

    public String getQuestionsChoice8() {
        return questionsChoice8;
    }

    public void setQuestionsChoice8(String questionsChoice8) {
        this.questionsChoice8 = questionsChoice8;
    }

    public String getQuestionsChoice9() {
        return questionsChoice9;
    }

    public void setQuestionsChoice9(String questionsChoice9) {
        this.questionsChoice9 = questionsChoice9;
    }

    public String getQuestionsChoice10() {
        return questionsChoice10;
    }

    public void setQuestionsChoice10(String questionsChoice10) {
        this.questionsChoice10 = questionsChoice10;
    }

    public String getQuestionsChoice11() {
        return questionsChoice11;
    }

    public void setQuestionsChoice11(String questionsChoice11) {
        this.questionsChoice11 = questionsChoice11;
    }

    public String getQuestionsChoice12() {
        return questionsChoice12;
    }

    public void setQuestionsChoice12(String questionsChoice12) {
        this.questionsChoice12 = questionsChoice12;
    }

    public String getQuestionsChoice13() {
        return questionsChoice13;
    }

    public void setQuestionsChoice13(String questionsChoice13) {
        this.questionsChoice13 = questionsChoice13;
    }

    public String getQuestionsChoice14() {
        return questionsChoice14;
    }

    public void setQuestionsChoice14(String questionsChoice14) {
        this.questionsChoice14 = questionsChoice14;
    }

    public String getQuestionsChoice15() {
        return questionsChoice15;
    }

    public void setQuestionsChoice15(String questionsChoice15) {
        this.questionsChoice15 = questionsChoice15;
    }

    public String getQuestionsChoice16() {
        return questionsChoice16;
    }

    public void setQuestionsChoice16(String questionsChoice16) {
        this.questionsChoice16 = questionsChoice16;
    }

    public String getQuestionsChoice17() {
        return questionsChoice17;
    }

    public void setQuestionsChoice17(String questionsChoice17) {
        this.questionsChoice17 = questionsChoice17;
    }

    public String getQuestionsChoice18() {
        return questionsChoice18;
    }

    public void setQuestionsChoice18(String questionsChoice18) {
        this.questionsChoice18 = questionsChoice18;
    }

    public String getQuestionsChoice19() {
        return questionsChoice19;
    }

    public void setQuestionsChoice19(String questionsChoice19) {
        this.questionsChoice19 = questionsChoice19;
    }

    public String getQuestionsChoice20() {
        return questionsChoice20;
    }

    public void setQuestionsChoice20(String questionsChoice20) {
        this.questionsChoice20 = questionsChoice20;
    }

    public String[] getQuestionsChoices1() {
        return questionsChoices1;
    }

    public void setQuestionsChoices1(String[] questionsChoices1) {
        this.questionsChoices1 = questionsChoices1;
    }

    public String[] getQuestionsChoices2() {
        return questionsChoices2;
    }

    public void setQuestionsChoices2(String[] questionsChoices2) {
        this.questionsChoices2 = questionsChoices2;
    }

    public String[] getQuestionsChoices3() {
        return questionsChoices3;
    }

    public void setQuestionsChoices3(String[] questionsChoices3) {
        this.questionsChoices3 = questionsChoices3;
    }

    public String[] getQuestionsChoices4() {
        return questionsChoices4;
    }

    public void setQuestionsChoices4(String[] questionsChoices4) {
        this.questionsChoices4 = questionsChoices4;
    }

    public String[] getQuestionsChoices5() {
        return questionsChoices5;
    }

    public void setQuestionsChoices5(String[] questionsChoices5) {
        this.questionsChoices5 = questionsChoices5;
    }

    public String[] getQuestionsChoices6() {
        return questionsChoices6;
    }

    public void setQuestionsChoices6(String[] questionsChoices6) {
        this.questionsChoices6 = questionsChoices6;
    }

    public String[] getQuestionsChoices7() {
        return questionsChoices7;
    }

    public void setQuestionsChoices7(String[] questionsChoices7) {
        this.questionsChoices7 = questionsChoices7;
    }

    public String[] getQuestionsChoices8() {
        return questionsChoices8;
    }

    public void setQuestionsChoices8(String[] questionsChoices8) {
        this.questionsChoices8 = questionsChoices8;
    }

    public String[] getQuestionsChoices9() {
        return questionsChoices9;
    }

    public void setQuestionsChoices9(String[] questionsChoices9) {
        this.questionsChoices9 = questionsChoices9;
    }

    public String[] getQuestionsChoices10() {
        return questionsChoices10;
    }

    public void setQuestionsChoices10(String[] questionsChoices10) {
        this.questionsChoices10 = questionsChoices10;
    }

    public String[] getQuestionsChoices11() {
        return questionsChoices11;
    }

    public void setQuestionsChoices11(String[] questionsChoices11) {
        this.questionsChoices11 = questionsChoices11;
    }

    public String[] getQuestionsChoices12() {
        return questionsChoices12;
    }

    public void setQuestionsChoices12(String[] questionsChoices12) {
        this.questionsChoices12 = questionsChoices12;
    }

    public String[] getQuestionsChoices13() {
        return questionsChoices13;
    }

    public void setQuestionsChoices13(String[] questionsChoices13) {
        this.questionsChoices13 = questionsChoices13;
    }

    public String[] getQuestionsChoices14() {
        return questionsChoices14;
    }

    public void setQuestionsChoices14(String[] questionsChoices14) {
        this.questionsChoices14 = questionsChoices14;
    }

    public String[] getQuestionsChoices15() {
        return questionsChoices15;
    }

    public void setQuestionsChoices15(String[] questionsChoices15) {
        this.questionsChoices15 = questionsChoices15;
    }

    public String[] getQuestionsChoices16() {
        return questionsChoices16;
    }

    public void setQuestionsChoices16(String[] questionsChoices16) {
        this.questionsChoices16 = questionsChoices16;
    }

    public String[] getQuestionsChoices17() {
        return questionsChoices17;
    }

    public void setQuestionsChoices17(String[] questionsChoices17) {
        this.questionsChoices17 = questionsChoices17;
    }

    public String[] getQuestionsChoices18() {
        return questionsChoices18;
    }

    public void setQuestionsChoices18(String[] questionsChoices18) {
        this.questionsChoices18 = questionsChoices18;
    }

    public String[] getQuestionsChoices19() {
        return questionsChoices19;
    }

    public void setQuestionsChoices19(String[] questionsChoices19) {
        this.questionsChoices19 = questionsChoices19;
    }

    public String[] getQuestionsChoices20() {
        return questionsChoices20;
    }

    public void setQuestionsChoices20(String[] questionsChoices20) {
        this.questionsChoices20 = questionsChoices20;
    }

    public String getQuestionsFill1() {
        return questionsFill1;
    }

    public void setQuestionsFill1(String questionsFill1) {
        this.questionsFill1 = questionsFill1;
    }

    public String getQuestionsFill2() {
        return questionsFill2;
    }

    public void setQuestionsFill2(String questionsFill2) {
        this.questionsFill2 = questionsFill2;
    }

    public String getQuestionsFill3() {
        return questionsFill3;
    }

    public void setQuestionsFill3(String questionsFill3) {
        this.questionsFill3 = questionsFill3;
    }

    public String getQuestionsFill4() {
        return questionsFill4;
    }

    public void setQuestionsFill4(String questionsFill4) {
        this.questionsFill4 = questionsFill4;
    }

    public String getQuestionsFill5() {
        return questionsFill5;
    }

    public void setQuestionsFill5(String questionsFill5) {
        this.questionsFill5 = questionsFill5;
    }

    public String getQuestionsFill6() {
        return questionsFill6;
    }

    public void setQuestionsFill6(String questionsFill6) {
        this.questionsFill6 = questionsFill6;
    }

    public String getQuestionsFill7() {
        return questionsFill7;
    }

    public void setQuestionsFill7(String questionsFill7) {
        this.questionsFill7 = questionsFill7;
    }

    public String getQuestionsFill8() {
        return questionsFill8;
    }

    public void setQuestionsFill8(String questionsFill8) {
        this.questionsFill8 = questionsFill8;
    }

    public String getQuestionsFill9() {
        return questionsFill9;
    }

    public void setQuestionsFill9(String questionsFill9) {
        this.questionsFill9 = questionsFill9;
    }

    public String getQuestionsFill10() {
        return questionsFill10;
    }

    public void setQuestionsFill10(String questionsFill10) {
        this.questionsFill10 = questionsFill10;
    }

    public String getQuestionsTof1() {
        return questionsTof1;
    }

    public void setQuestionsTof1(String questionsTof1) {
        this.questionsTof1 = questionsTof1;
    }

    public String getQuestionsTof2() {
        return questionsTof2;
    }

    public void setQuestionsTof2(String questionsTof2) {
        this.questionsTof2 = questionsTof2;
    }

    public String getQuestionsTof3() {
        return questionsTof3;
    }

    public void setQuestionsTof3(String questionsTof3) {
        this.questionsTof3 = questionsTof3;
    }

    public String getQuestionsTof4() {
        return questionsTof4;
    }

    public void setQuestionsTof4(String questionsTof4) {
        this.questionsTof4 = questionsTof4;
    }

    public String getQuestionsTof5() {
        return questionsTof5;
    }

    public void setQuestionsTof5(String questionsTof5) {
        this.questionsTof5 = questionsTof5;
    }

    public String getQuestionsTof6() {
        return questionsTof6;
    }

    public void setQuestionsTof6(String questionsTof6) {
        this.questionsTof6 = questionsTof6;
    }

    public String getQuestionsTof7() {
        return questionsTof7;
    }

    public void setQuestionsTof7(String questionsTof7) {
        this.questionsTof7 = questionsTof7;
    }

    public String getQuestionsTof8() {
        return questionsTof8;
    }

    public void setQuestionsTof8(String questionsTof8) {
        this.questionsTof8 = questionsTof8;
    }

    public String getQuestionsTof9() {
        return questionsTof9;
    }

    public void setQuestionsTof9(String questionsTof9) {
        this.questionsTof9 = questionsTof9;
    }

    public String getQuestionsTof10() {
        return questionsTof10;
    }

    public void setQuestionsTof10(String questionsTof10) {
        this.questionsTof10 = questionsTof10;
    }

    public String getQuestionsSubjective1() {
        return questionsSubjective1;
    }

    public void setQuestionsSubjective1(String questionsSubjective1) {
        this.questionsSubjective1 = questionsSubjective1;
    }

    public String getQuestionsSubjective2() {
        return questionsSubjective2;
    }

    public void setQuestionsSubjective2(String questionsSubjective2) {
        this.questionsSubjective2 = questionsSubjective2;
    }

    public String getQuestionsSubjective3() {
        return questionsSubjective3;
    }

    public void setQuestionsSubjective3(String questionsSubjective3) {
        this.questionsSubjective3 = questionsSubjective3;
    }

    public String getQuestionsSubjective4() {
        return questionsSubjective4;
    }

    public void setQuestionsSubjective4(String questionsSubjective4) {
        this.questionsSubjective4 = questionsSubjective4;
    }

    public String getQuestionsSubjective5() {
        return questionsSubjective5;
    }

    public void setQuestionsSubjective5(String questionsSubjective5) {
        this.questionsSubjective5 = questionsSubjective5;
    }


    public String arrToStr(String[] strings){
        boolean b=true;
        StringBuilder stringBuilder=new StringBuilder();
        if (strings!=null){
            for (String string : strings) {
                if (b){
                    stringBuilder.append(string);
                    b=false;
                }else{
                    stringBuilder.append(","+string);
                }
            }
        }

        return stringBuilder.toString();
    }
}
