package test;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DatasetUtilities;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 2016/4/2.
 */
public class TestJFreeChart {
    public static void main(String[] args) {
      /*  Map<String, Object> resultMap = null;
        try {
            resultMap = getDateSet("2016-03-31 12:25:24_116.357428_39.90923_10,2016-03-31 12:52:24_116.397428_39.90923_11");
            double[][] data = new double[][]{(double[]) resultMap.get("speed")};
            String[] rowKeys = {"速度"};
            String[] columnKeys = (String[]) resultMap.get("mileage");
            CategoryDataset dataSet = DatasetUtilities.createCategoryDataset(rowKeys, columnKeys, data);
            JFreeChart chart = createLineChart("测试", "km", "km/时", dataSet);
            saveToPicture(chart);
        } catch (ParseException e) {
            e.printStackTrace();
        }*/

        /*double[][] data = new double[][]{{533, 214, 614, 542, 724}};
        String[] rowKeys = {""};
        String[] columnKeys = {"北京", "上海", "广州", "成都", "深圳",};
        CategoryDataset dataSet = DatasetUtilities.createCategoryDataset(rowKeys, columnKeys, data);*/
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(0,"测试","0");
        dataset.addValue(1,"测试","2");
        dataset.addValue(2,"测试","3");
        dataset.addValue(3,"测试","4");
        JFreeChart chart = createLineChart("测试", "x轴", "y轴", dataset);
        saveToPicture(chart);
    }

    public static JFreeChart createLineChart(String chartTitle, String xTitle, String yTitle, CategoryDataset dataset) {
        // 构建一个chart
        JFreeChart chart = ChartFactory.createLineChart(chartTitle, xTitle, yTitle, dataset, PlotOrientation.VERTICAL, true, true, false);
        //字体清晰
        chart.setTextAntiAlias(false);
        // 设置背景颜色
        chart.setBackgroundPaint(Color.WHITE);

        // 设置图标题的字体
        Font font = new Font("隶书", Font.BOLD, 25);
        chart.getTitle().setFont(font);

        // 设置面板字体
        Font labelFont = new Font("SansSerif", Font.TRUETYPE_FONT, 12);
        // 设置图示的字体
        chart.getLegend().setItemFont(labelFont);

        CategoryPlot categoryplot = (CategoryPlot) chart.getPlot();
        // x轴 // 分类轴网格是否可见
        categoryplot.setDomainGridlinesVisible(true);
        // y轴 //数据轴网格是否可见
        categoryplot.setRangeGridlinesVisible(true);
        categoryplot.setRangeGridlinePaint(Color.WHITE);// 虚线色彩
        categoryplot.setDomainGridlinePaint(Color.WHITE);// 虚线色彩
        categoryplot.setBackgroundPaint(Color.lightGray);// 折线图的背景颜色
        // 横轴 x
        CategoryAxis domainAxis = categoryplot.getDomainAxis();
        domainAxis.setLabelFont(labelFont);// 轴标题
        domainAxis.setTickLabelFont(labelFont);// 轴数值
        // domainAxis.setLabelPaint(Color.BLUE);//轴标题的颜色
        // domainAxis.setTickLabelPaint(Color.BLUE);//轴数值的颜色

        // 横轴 lable 的位置 横轴上的 Lable 45度倾斜 DOWN_45
        domainAxis.setCategoryLabelPositions(CategoryLabelPositions.STANDARD);
        // 设置距离图片左端距离
        domainAxis.setLowerMargin(0.0);
        // 设置距离图片右端距离
        domainAxis.setUpperMargin(0.0);
        // 纵轴 y
        NumberAxis numberaxis = (NumberAxis) categoryplot.getRangeAxis();
        numberaxis.setLowerBound(0.0);
        numberaxis.setLowerMargin(0.0);
        numberaxis.setLabelFont(labelFont);
        numberaxis.setTickLabelFont(labelFont);
        numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        numberaxis.setAutoRangeIncludesZero(true);

        // 获得renderer 注意这里是下嗍造型到lineandshaperenderer！！
        LineAndShapeRenderer lineandshaperenderer = (LineAndShapeRenderer) categoryplot.getRenderer();
        lineandshaperenderer.setBaseShapesVisible(true); // series 点（即数据点）可见
        lineandshaperenderer.setBaseLinesVisible(true); // series 点（即数据点）间有连线可见

        // 显示折点数据
        lineandshaperenderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        lineandshaperenderer.setBaseItemLabelsVisible(true);

        return chart;
    }

    public static void saveToPicture(JFreeChart chart) {
        String CHART_PATH = "e://";
        FileOutputStream fosChart = null;
        try {
            //文件夹不存在则创建
            File file = new File(CHART_PATH);
            if (!file.exists()) {
                file.mkdirs();
            }
            String chartName = CHART_PATH + "test_jFreeChart.png";
            fosChart = new FileOutputStream(chartName);
            //高宽的设置影响椭圆饼图的形状
            ChartUtilities.writeChartAsPNG(fosChart, chart, 500, 230);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fosChart.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static Map<String, Object> getDateSet(String traces) throws ParseException {
        Map<String, Object> dataSet = new HashMap<String, Object>();
        String[] datas = traces.split(",");
        double[] alt = new double[datas.length];
        double[] speed = new double[datas.length];
        speed[0] = 0.0;
        String[] mileage = new String[datas.length];
        mileage[0] = "0";
        for (int i = 0; i < datas.length; i++) {
            if (i + 1 >= datas.length) {
                alt[i] = doubleFormat(datas[i].split("_")[3], 2);
                break;
            }
            String[] first = datas[i].split("_");
            String[] last = datas[i + 1].split("_");
            double length = BaiduMap.GetShortDistance(Double.parseDouble(first[1]), Double.parseDouble(first[2]), Double.parseDouble(last[1]), Double.parseDouble(last[2]));
            BigDecimal gbLength = new BigDecimal(length);
            BigDecimal lengthUnit = new BigDecimal(1000);
            gbLength = gbLength.divide(lengthUnit, 3, RoundingMode.HALF_UP);
            mileage[i + 1] = gbLength.setScale(2, RoundingMode.HALF_UP).toString();
            alt[i] = doubleFormat(datas[i].split("_")[3], 2);
            speed[i + 1] = getSpeed(first[0], last[0], length);
        }
        dataSet.put("speed", speed);
        dataSet.put("alt", alt);
        dataSet.put("mileage", mileage);
        return dataSet;
    }

    public static String doubleFormat(double value, int accuracy) {
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(accuracy, RoundingMode.HALF_UP);
        return bd.toString();
    }

    public static double doubleFormat(String value, int accuracy) {
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(accuracy, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public static double getSpeed(String timeBegin, String timeEnd, double length) throws ParseException {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date dateBegin = format.parse(timeBegin);
        Date dateEnd = format.parse(timeEnd);
        long balance = dateEnd.getTime() - dateBegin.getTime();
        BigDecimal milliseconds = new BigDecimal(balance);
        BigDecimal timeUnit = new BigDecimal(1000 * 60 * 60);
        BigDecimal seconds = milliseconds.divide(timeUnit, 3, RoundingMode.HALF_UP);
        BigDecimal gbLength = new BigDecimal(length);
        BigDecimal lengthUnit = new BigDecimal(1000);
        gbLength = gbLength.divide(lengthUnit, 3, RoundingMode.HALF_UP);
        BigDecimal speed = gbLength.divide(seconds, 3, RoundingMode.HALF_UP);
        //BigDecimal hourSpeed = speed.multiply(new BigDecimal(60*60));
        speed = speed.setScale(2, RoundingMode.HALF_UP);
        return speed.doubleValue();
    }
}
