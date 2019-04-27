package other;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static other.EcStatic.*;
import static other.RandomGenerator.getRandom;
import static util.Excel.addDataToList;

/**
 * @Author: jurui
 * @ProjectName: simdata
 * @Package: other
 * @Description:
 * @Date: Created in 14:08 2019-03-18
 */

public class Users {
    //数据时间2016-12-1----2019-1-1

    //比例系数
    //新增用户
    public static final double D = 1.1451;
    //月活用户比例系数
    public static final double D1 = 3.434;
    //累计注册用户基数（交易用户数量）比例 
    public static final double D2 = 8.98;

    //新增用户数（当前月新增交易数*比例系数变量d(d>1),注明参数可修改就行）
    public static int[][] newUsers = new int[4][month.length];

    //累计注册用户数（上月老用户加上本月新用户）
    public static int[][] allUsers = new int[4][month.length];

    //月活用户（老用户的交易+新用户交易）*比例系数d(d>1)
    public static int[][] mauUsers = new int[4][month.length];

    //日活用户(月活人数/天数)
    public static int[][] dayUsers = new int[4][month.length];

    //每日登陆时长（定义一组基础数，然后成比例随机产生）
    public static int[] baseNum = {13, 20};
    public static double[][] dayHours = new double[4][month.length];

    //交易用户数（老交易+新交易）
    public static int[] tradeUsers = new int[month.length];

    //交易频次（当月产生的交易次数）（交易次数表中按列相加）
    public static int[] tradeNum = new int[month.length];

    public static void readData(int[][] a) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < month.length; j++) {
                System.out.print(a[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public static int[][] getNewUsers() {
        //getPeopleNumber();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < month.length; j++) {
                newUsers[i][j] = (int) ((peopleNum[0][i][j][j] + peopleNum[1][i][j][j]) * D);
            }
        }
        //System.out.println("新增用户数：");
        //readData(newUsers);
        return newUsers;
    }

    public static int[][] getAllUsers() {
        //getPeopleNumber();
        getNewUsers();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < month.length; j++) {
                if (j == 0) {
                    allUsers[i][j] = (int) ((peopleNum[0][i][0][0]+peopleNum[1][i][0][0])*D2);
                    continue;
                }
                allUsers[i][j] =(allUsers[i][j - 1] + newUsers[i][j]);
            }
        }
        //System.out.println("累计注册用户数：");
        //readData(allUsers);

        return allUsers;
    }

    public static int[][] getMauUsers() {
        //getPeopleNumber();
    	//修正月活用户与累计注册用户的比例
        for (int i=0;i<4;i++){
            for (int j=0;j<month.length;j++){
            	 //float ratio = 0.25f + new Random().nextFloat() * (0.35f-0.25f);
            	double ratio = 0.25 + getRandom(EcStatic.randomIndex) * (0.35-0.25);
            	EcStatic.randomIndex++;
            	 mauUsers[i][j]=(int)((allUsers[i][j])*(ratio));
               /* for (int k=0;k<month.length;k++){
                    for (int m=0;m<2;m++){
                    	
                        	 mauUsers[i][j]+=((peopleNum[m][i][k][j])*(D1));
                      

                    }
                }*/
            }
        }
        //System.out.println("月活用户数：");
        //readData(mauUsers);

        return mauUsers;
    }

    //根据字符串时间求出这个月有多少天   字符串必须为"yyyy-MM-dd"
    public static int getDayOfMon(String mon) throws ParseException {

        Calendar a = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date1 = sdf.parse(mon);
        a.setTime(date1);
        a.set(Calendar.DAY_OF_MONTH, a.getActualMaximum(Calendar.DAY_OF_MONTH));
        int day = a.get(Calendar.DAY_OF_MONTH);
        return day;
    }

    public static int[][] getDayUsers() throws ParseException {
        int[][] monUsers = getMauUsers();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < month.length; j++) {
                dayUsers[i][j] = monUsers[i][j] / getDayOfMon(month[j]);
            }
        }
        //System.out.println("日活用户数：");
        //readData(dayUsers);

        return dayUsers;
    }

    public static double[][] getDayHours() {
        //保留两位小数后
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < month.length; j++) {
                randomIndex++;
                dayHours[i][j] = baseNum[0] + getRandom(randomIndex) * (baseNum[1] - baseNum[0]);
            }
        }
        //System.out.println("每日登录时长：");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < month.length; j++) {
                //System.out.print((double) Math.round((dayHours[i][j]) * 100) / 100 + "  ");
                dayHours[i][j] = ((double) Math.round((dayHours[i][j]) * 100) / 100);
            }
            System.out.println();
        }
        return dayHours;
    }

    public static int[] getTradeUsers() {
        //getPeopleNumber();
        for (int j = 0; j < month.length; j++) {
            for (int i = 0; i < 4; i++) {
                for (int k = 0; k < month.length; k++) {
                    for (int m=0;m<2;m++){
                        tradeUsers[j]+=peopleNum[m][i][k][j];
                    }
                }
            }
        }
        //System.out.println("交易用户数：");
        //for (int i = 0; i < tradeUsers.length; i++) {
        //    System.out.print(tradeUsers[i] + "  ");
        //}
        //System.out.println();
        return tradeUsers;
    }

    public static int[] getTradeNum() {
        //getCount();
        for (int j = 0; j < month.length; j++) {
            for (int i = 0; i < 4; i++) {
                for (int k = 0; k < month.length; k++) {
                    for (int m=0;m<2;m++){
                        tradeNum[j]+=orderNum[m][i][k][j];
                    }
                }
            }
        }
        //System.out.println("交易频次：");
        //for (int i = 0; i < tradeNum.length; i++) {
        //    System.out.print(tradeNum[i] + "  ");
        //}
        //System.out.println();
        return tradeNum;
    }

    public static int[] getTotal(int[][] num) {
        int b[] = new int[month.length];
        for (int i = 0; i < month.length; i++) {
            for (int j = 0; j < 4; j++) {
                b[i] += num[j][i];
            }
        }
        return b;
    }
    public static double[] getTotal(double[][] num) {
        double b[] = new double[month.length];
        for (int i = 0; i < month.length; i++) {
            for (int j = 0; j < 4; j++) {
                b[i] += num[j][i];
            }
        }
        return b;
    }



    public static List<Map> getUsersList() throws ParseException {
        List<Map> listUsers = new ArrayList<Map>();
        //获取新增注册用户
        getNewUsers();
        int newUsersTotal[] = getTotal(newUsers);
        addDataToList("新增注册用户", newUsers, newUsersTotal, listUsers);

        //获取累计注册用户
        getAllUsers();
        int allUsersTotal[] =new int[month.length];
        for (int i=0;i<month.length;i++){
            if (i==0){
                allUsersTotal[i]=(allUsers[0][0]+allUsers[1][0]+allUsers[2][0]+allUsers[3][0]);
           continue;
            }
            allUsersTotal[i]= (allUsersTotal[i-1]+newUsersTotal[i]);
        }
        addDataToList("累计注册用户", allUsers, allUsersTotal, listUsers);
        //月活用户
        getMauUsers();
        int mauUsersTotal[] = getTotal(mauUsers);
        tradeUsers = getTradeUsers();
        //修正月活用户数量 大于交易用户的情况 2019-4-11
        for(int i=0; i<mauUsersTotal.length && i<tradeUsers.length; i++) {
        	double ratio = ((double)tradeUsers[i]) / ((double)mauUsersTotal[i]);
        	if(ratio<0.15 || ratio>0.8) {
        		//float rnd = 0.45f + new Random().nextFloat() * (0.55f-0.45f);
        		double rnd = 0.45 + getRandom(EcStatic.randomIndex) * (0.55-0.45);
        		EcStatic.randomIndex++;
        		mauUsersTotal[i] = (int)(tradeUsers[i] / rnd);
        		mauUsers[0][i] = (int)(mauUsersTotal[i] * EcStatic.us[0]);
        		mauUsers[1][i] = (int)(mauUsersTotal[i] * EcStatic.uk[0]);
        		mauUsers[2][i] = (int)(mauUsersTotal[i] * EcStatic.sa[0]);
        		mauUsers[3][i] = mauUsersTotal[i] - mauUsers[0][i] - mauUsers[1][i] - mauUsers[2][i];
        		
        	}
        }
        addDataToList("月活用户", mauUsers, mauUsersTotal, listUsers);
       
        //日活用户
        getDayUsers();
        int dayUsersTotal[] = getTotal(dayUsers);
        addDataToList("日活用户", dayUsers, dayUsersTotal, listUsers);



        double dayHoursTotal[] = new double[month.length];
        for (int i = 0; i < month.length; i++) {
            for (int j = 0; j < 4; j++) {
                dayHoursTotal[i] += dayHours[j][i];
                dayHoursTotal[i] = ((double) Math.round((dayHoursTotal[i]) * 100) / 100);
            }
        }
        double dayHoursAverage[] = new double[month.length];
        for (int i=0;i<month.length;i++){
            dayHoursAverage[i]=dayHoursTotal[i]/4.00;
        }


        for (int i = 0; i < 5; i++) {

            Map<String, Object> map = new HashMap<String, Object>();
            if (i == 0) {
                map.put("数据类型", "");
                map.put("区域", "average");
                for (int j = 0; j < month.length; j++) {
                    map.put(month[j], dayHoursAverage[j]);
                }
                listUsers.add(map);
                continue;
            } else if (i == 2) {
                map.put("数据类型", "每日登录时长");
                map.put("区域", country[i - 1]);
            } else {
                map.put("数据类型", "");
                map.put("区域", country[i - 1]);
            }

            for (int j = 0; j < month.length; j++) {
                map.put(month[j],dayHours[i - 1][j]);
            }
            listUsers.add(map);
        }
        Map<String, Object> mapNull = new HashMap<String, Object>();
        listUsers.add(mapNull);

        //获取交易用户数
       // tradeUsers = getTradeUsers();
       
        Map<String, Object> mapTdUsers = new HashMap<String, Object>();

        mapTdUsers.put("数据类型", "交易用户数");
        mapTdUsers.put("区域", "total");
        for (int j = 0; j < month.length; j++) {
            mapTdUsers.put(month[j], tradeUsers[j]);
        }
        listUsers.add(mapTdUsers);
        listUsers.add(mapNull);


        //获取交易频次
        tradeNum = getTradeNum();
        Map<String, Object> mapTdNum = new HashMap<String, Object>();

        mapTdNum.put("数据类型", "交易频次");
        mapTdNum.put("区域", "total");
        for (int j = 0; j < month.length; j++) {
            mapTdNum.put(month[j], tradeNum[j]);
        }
        listUsers.add(mapTdNum);
        listUsers.add(mapNull);


        return listUsers;
    }

    public static void main(String[] args) {
    }
}