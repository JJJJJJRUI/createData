package other;

import java.util.*;

import static other.EcStatic.*;
import static other.Users.*;
import static util.Excel.addAppWebsiteToList;
import static util.Excel.addDataToList;

/**
 * @Author: jurui
 * @ProjectName: simdata
 * @Package: other
 * @Description:
 * @Date: Created in 17:29 2019-03-18
 */
public class TradeData {
    //交易总数据
    //交易总金额-所有区域total
    public static double[][] totalAmount = new double[4][month.length];
    public static double toTotalAmount[] = new double[month.length];
    public static double[][] totalAmountAppWebsite = new double[3][month.length];


    //交易总笔数
    public static int[][] totalTradeNum = new int[4][month.length];
    public static int toTotalTradeNum[] = new int[month.length];
    public static int[][] totalTradeNumAppWebsite = new int[3][month.length];


    //电商模块
    //电商交易金额---区分新老用户--所有区域总和
    public static double[][] onlineRetAmount = new double[4][month.length];
    public static double toOnlineRetAmount[] = new double[month.length];
    public static double[][] onlineRetAmountAppWebsite = new double[3][month.length];

    //电商交易人数---区分新老用户--所有区域总和
    public static int[][] onlineRetTrPeople = new int[4][month.length];
    public static int toOnlineRetTrPeople[] = new int[month.length];
    public static int[][] onlineRetTrPeopleAppWebsite = new int[3][month.length];

    //电商交易笔数---区分新老用户--所有区域总和
    public static int[][] onlineRetTrNum = new int[4][month.length];
    public static int toOnlineRetTrNum[] = new int[month.length];
    public static int[][] onlineRetTrNumAppWebsite = new int[3][month.length];


    //金融模块
    //金融交易金额---区分新老用户--所有区域总和
    public static double[][] FinanceAmount = new double[4][month.length];
    public static double toFinanceAmount[] = new double[month.length];
    public static double[][] FinanceAmountAppWebsite = new double[3][month.length];

    //金融购买人数---区分新老用户--所有区域总和
    public static int[][] FinanceTrPeople = new int[4][month.length];
    public static int toFinanceTrPeople[] = new int[month.length];
    public static int[][] FinanceTrPeopleAppWebsite = new int[3][month.length];

    //金融交易笔数---区分新老用户--所有区域总和
    public static int[][] FinanceTrNum = new int[4][month.length];
    public static int toFinanceTrNum[] = new int[month.length];
    public static int[][] FinanceTrNumAppWebsite = new int[3][month.length];

    //获取总金额
    public static double[][] getTotalAmount() {
        //getAmount();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < month.length; j++) {
                for (int k = 0; k < month.length; k++) {
                    for (int m = 0; m < 2; m++) {
                        totalAmount[i][j] += amountNum[m][i][k][j];
                    }

                }
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < month.length; j++) {
                totalAmount[i][j] = (double) Math.round(totalAmount[i][j] * 100) / 100;

            }
        }
        return totalAmount;
    }

    public static double[][] getTotalAmountAppWebsite() {
        for (int n = 0; n < month.length; n++) {
            for (int m = 0; m < month.length; m++) {
                for (int j = 0; j < 4; j++) {
                    for (int i = 0; i < 2; i++) {
                        for (int k = 0; k < 2; k++) {
                            totalAmountAppWebsite[0][n] += appAndWebAmountNum[i][k][j][m][n];
                        }
                        totalAmountAppWebsite[1][n] += appAndWebAmountNum[i][1][j][m][n];
                        totalAmountAppWebsite[2][n] += appAndWebAmountNum[i][0][j][m][n];
                    }
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < month.length; j++) {
                totalAmountAppWebsite[i][j] = (double) Math.round(totalAmountAppWebsite[i][j] * 100) / 100;

            }
        }

        return totalAmountAppWebsite;
    }

    //获取交易总笔数
    public static int[][] getTotalTradeNum() {
        //getCount();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < month.length; j++) {
                for (int k = 0; k < month.length; k++) {
                    for (int m = 0; m < 2; m++) {
                        totalTradeNum[i][j] += orderNum[m][i][k][j];
                    }
                }
            }
        }
        //交易总次数遍历

        //System.out.println("交易总次数遍历：");
        //eachInt(totalTradeNum);


        return totalTradeNum;
    }

    public static int[][] getTotalTradeNumAppWebsite() {
        for (int n = 0; n < month.length; n++) {
            for (int m = 0; m < month.length; m++) {
                for (int j = 0; j < 4; j++) {
                    for (int i = 0; i < 2; i++) {
                        for (int k = 0; k < 2; k++) {
                            totalTradeNumAppWebsite[0][n] += appAndWebOrderNum[i][k][j][m][n];
                        }
                        totalTradeNumAppWebsite[1][n] += appAndWebOrderNum[i][1][j][m][n];
                        totalTradeNumAppWebsite[2][n] += appAndWebOrderNum[i][0][j][m][n];
                    }
                }
            }
        }

        return totalTradeNumAppWebsite;
    }

    //获取电商模块相关数据
    public static double[][] getOnlineRetAmount() {
        //getAmount();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < month.length; j++) {
                for (int k = 0; k < month.length; k++) {
                    onlineRetAmount[i][j] += amountNum[0][i][k][j];
                }
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < month.length; j++) {
                onlineRetAmount[i][j] = (double) Math.round(onlineRetAmount[i][j] * 100) / 100;

            }
        }
        return onlineRetAmount;
    }

    public static double[][] getOnlineRetAmountAppWebsite() {
        for (int n = 0; n < month.length; n++) {
            for (int m = 0; m < month.length; m++) {
                for (int j = 0; j < 4; j++) {

                    for (int k = 0; k < 2; k++) {
                        onlineRetAmountAppWebsite[0][n] += appAndWebAmountNum[0][k][j][m][n];
                    }
                    onlineRetAmountAppWebsite[1][n] += appAndWebAmountNum[0][1][j][m][n];
                    onlineRetAmountAppWebsite[2][n] += appAndWebAmountNum[0][0][j][m][n];

                }
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < month.length; j++) {
                onlineRetAmountAppWebsite[i][j] = (double) Math.round(onlineRetAmountAppWebsite[i][j] * 100) / 100;

            }
        }


        return onlineRetAmountAppWebsite;
    }

    public static int[][] getOnlineRetTrPeople() {
        //getPeopleNumber();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < month.length; j++) {
                for (int k = 0; k < month.length; k++) {
                    onlineRetTrPeople[i][j] += peopleNum[0][i][k][j];
                }
            }
        }
        //System.out.println("电商交易人数遍历：");
        //eachInt(onlineRetTrPeople);

        return onlineRetTrPeople;
    }

    public static int[][] getOnlineRetTrNum() {
        //getCount();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < month.length; j++) {
                for (int k = 0; k < month.length; k++) {
                    onlineRetTrNum[i][j] += orderNum[0][i][k][j];
                }
            }
        }
        //System.out.println("电商交易次数遍历：");
        //eachInt(onlineRetTrNum);

        return onlineRetTrNum;
    }

    public static int[][] getOnlineRetTrNumAppWebsite() {
        for (int n = 0; n < month.length; n++) {
            for (int m = 0; m < month.length; m++) {
                for (int j = 0; j < 4; j++) {

                    for (int k = 0; k < 2; k++) {
                        onlineRetTrNumAppWebsite[0][n] += appAndWebOrderNum[0][k][j][m][n];
                    }
                    onlineRetTrNumAppWebsite[1][n] += appAndWebOrderNum[0][1][j][m][n];
                    onlineRetTrNumAppWebsite[2][n] += appAndWebOrderNum[0][0][j][m][n];

                }
            }
        }
        return onlineRetTrNumAppWebsite;
    }

    //获取金融模块相关数据
    public static double[][] getFinanceAmount() {
        //getAmount();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < month.length; j++) {
                for (int k = 0; k < month.length; k++) {
                    FinanceAmount[i][j] += amountNum[1][i][k][j];
                }
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < month.length; j++) {
                FinanceAmount[i][j] = (double) Math.round(FinanceAmount[i][j] * 100) / 100;

            }
        }
        return FinanceAmount;
    }

    public static double[][] getFinanceAmountAppWebsite() {
        for (int n = 0; n < month.length; n++) {
            for (int m = 0; m < month.length; m++) {
                for (int j = 0; j < 4; j++) {

                    for (int k = 0; k < 2; k++) {
                        FinanceAmountAppWebsite[0][n] += appAndWebAmountNum[1][k][j][m][n];
                    }
                    FinanceAmountAppWebsite[1][n] += appAndWebAmountNum[1][1][j][m][n];
                    FinanceAmountAppWebsite[2][n] += appAndWebAmountNum[1][0][j][m][n];

                }
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < month.length; j++) {
                FinanceAmountAppWebsite[i][j] = (double) Math.round(FinanceAmountAppWebsite[i][j] * 100) / 100;

            }
        }

        return FinanceAmountAppWebsite;
    }

    public static int[][] getFinanceTrPeople() {
        //getPeopleNumber();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < month.length; j++) {
                for (int k = 0; k < month.length; k++) {
                    FinanceTrPeople[i][j] += peopleNum[1][i][k][j];
                }
            }
        }
        //System.out.println("金融交易人数遍历：");
        //eachInt(FinanceTrPeople);
        return FinanceTrPeople;
    }

    public static int[][] getFinanceTrNum() {
        //getCount();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < month.length; j++) {
                for (int k = 0; k < month.length; k++) {
                    FinanceTrNum[i][j] += orderNum[1][i][k][j];
                }
            }
        }
        //System.out.println("金融交易次数遍历：");
        //eachInt(FinanceTrNum);
        return FinanceTrNum;
    }

    public static int[][] getFinanceTrNumAppWebsite() {
        for (int n = 0; n < month.length; n++) {
            for (int m = 0; m < month.length; m++) {
                for (int j = 0; j < 4; j++) {

                    for (int k = 0; k < 2; k++) {
                        FinanceTrNumAppWebsite[0][n] += appAndWebOrderNum[1][k][j][m][n];
                    }
                    FinanceTrNumAppWebsite[1][n] += appAndWebOrderNum[1][1][j][m][n];
                    FinanceTrNumAppWebsite[2][n] += appAndWebOrderNum[1][0][j][m][n];

                }
            }
        }
        return FinanceTrNumAppWebsite;
    }


    public static List<Map> getTradeDataList() {
        List<Map> listTrade = new ArrayList<Map>();
        Map<String, Object> mapNull = new HashMap<String, Object>();
        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("数据类型", "交易总数据：");
        listTrade.add(map1);

        //获取交易总金额
        getTotalAmount();
        toTotalAmount = getTotal(totalAmount);
        addDataToList("交易总金额", totalAmount, toTotalAmount, listTrade);
        getTotalAmountAppWebsite();
        addAppWebsiteToList("total", totalAmountAppWebsite, listTrade);

        //获取交易总笔数
        getTotalTradeNum();
        toTotalTradeNum = getTotal(totalTradeNum);
        addDataToList("交易总笔数", totalTradeNum, toTotalTradeNum, listTrade);
        getTotalTradeNumAppWebsite();
        addAppWebsiteToList(totalTradeNumAppWebsite, listTrade);
        listTrade.add(mapNull);
        listTrade.add(mapNull);


        //获取电商模块
        Map<String, Object> map2 = new HashMap<String, Object>();
        map2.put("数据类型", "电商模块：");
        listTrade.add(map2);
        //交易金额
        getOnlineRetAmount();
        toOnlineRetAmount = getTotal(onlineRetAmount);
        addDataToList("交易金额", onlineRetAmount, toOnlineRetAmount, listTrade);
        getOnlineRetAmountAppWebsite();
        addAppWebsiteToList("total", onlineRetAmountAppWebsite, listTrade);
        //交易人数
        getOnlineRetTrPeople();
        toOnlineRetTrPeople = getTotal(onlineRetTrPeople);
        addDataToList("交易人数", onlineRetTrPeople, toOnlineRetTrPeople, listTrade);
        //onlineRetTrPeopleAppWebsite = getAppWebsite(toOnlineRetTrPeople);
        //addAppWebsiteToList(onlineRetTrPeopleAppWebsite, listTrade);
        //交易笔数
        getOnlineRetTrNum();
        toOnlineRetTrNum = getTotal(onlineRetTrNum);
        addDataToList("交易笔数", onlineRetTrNum, toOnlineRetTrNum, listTrade);
        getOnlineRetTrNumAppWebsite();
        addAppWebsiteToList(onlineRetTrNumAppWebsite, listTrade);
        listTrade.add(mapNull);
        listTrade.add(mapNull);


        //获取金融模块
        Map<String, Object> map3 = new HashMap<String, Object>();
        map3.put("数据类型", "金融模块：");
        listTrade.add(map3);
        //交易金额
        getFinanceAmount();
        toFinanceAmount = getTotal(FinanceAmount);
        addDataToList("交易金额", FinanceAmount, toFinanceAmount, listTrade);
        getFinanceAmountAppWebsite();
        addAppWebsiteToList("total", FinanceAmountAppWebsite, listTrade);
        //交易人数
        getFinanceTrPeople();
        toFinanceTrPeople = getTotal(FinanceTrPeople);
        addDataToList("交易人数", FinanceTrPeople, toFinanceTrPeople, listTrade);

        //交易笔数
        getFinanceTrNum();
        toFinanceTrNum = getTotal(FinanceTrNum);
        addDataToList("交易笔数", FinanceTrNum, toFinanceTrNum, listTrade);
        getFinanceTrNumAppWebsite();
        addAppWebsiteToList(FinanceTrNumAppWebsite, listTrade);


        return listTrade;
    }

    public static void main(String[] args) {

    }
}
