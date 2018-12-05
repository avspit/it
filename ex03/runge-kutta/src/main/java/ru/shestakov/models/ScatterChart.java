package ru.shestakov.models;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.charts.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBoolean;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTLineSer;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea;

import java.util.List;

public class ScatterChart {
    private static final String FUNC_NAME = "func";  //TODO when func calculations come
    private static final String RK_NAME = "runge-kutta";
    private static final  int SHIFT = 2;
    private XSSFWorkbook wb = new XSSFWorkbook();
    private XSSFSheet sheet = this.wb.createSheet("Лист 1");
    private int rowIndex = 0;

    public XSSFWorkbook getWorkbook() {
        return this.wb;
    }

    private void createSheetRows(RKManager sm) {
        //createSheetRowsByFuncMap(sm.getFunc()); //TODO when func calculations come
        createSheetRowsByRungeKuttaFuncMap(sm.getRungeKuttaCalculations());
    }

    private void createSheetRowsByRungeKuttaFuncMap(List<RKEntity> list) {
        int rowIndex = this.rowIndex;
        for(RKEntity entity : list) {
            Row row = this.sheet.createRow((short) rowIndex);
            createCell(row, (short) 0, entity.getX());
            createCell(row, (short) 1, entity.getY());
            rowIndex++;
        }
    }

    private void createHeaderRows() {
        CellStyle style = createHeaderStyle();
        Row row = this.sheet.createRow((short) this.rowIndex);
        createCell(row, (short) 0, this.RK_NAME, style);
        //createCell(row, (short) 3, this.FUNC_NAME, style); //TODO when func calculations come
        increaseRowIndex();
    }

    private void createTableHeaderRows() {
        CellStyle style = createTableHeaderStyle();
        Row row = this.sheet.createRow((short) this.rowIndex);
        createCell(row, (short) 0, "x", style);
        createCell(row, (short) 1, "y", style);
        //createCell(row, (short) 3, "x", style); //TODO func when calculations come
        //createCell(row, (short) 4, "y", style); //TODO func when calculations come
        increaseRowIndex();
    }

    private void createCell(Row row, short index, String value, CellStyle style) {
        Cell cell = createCell(row, index, value);
        cell.setCellStyle(style);
    }

    private Cell createCell(Row row, short index, String value) {
        Cell cell = row.createCell(index);
        cell.setCellValue(value);
        return cell;
    }

    private Cell createCell(Row row, short index, double value) {
        Cell cell = row.createCell(index);
        cell.setCellValue(value);
        return cell;
    }

    private void increaseRowIndex() {
        this.rowIndex++;
    }

    public CellStyle createHeaderStyle() {
        XSSFCellStyle style = this.wb.createCellStyle();
        XSSFFont fontHeader = this.wb.createFont();
        fontHeader.setBold(true);
        style.setFont(fontHeader);
        return style;
    }

    public CellStyle createTableHeaderStyle() {
        XSSFCellStyle style = this.wb.createCellStyle();
        XSSFFont fontHeader = this.wb.createFont();
        fontHeader.setBold(true);
        style.setFont(fontHeader);
        style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        return style;
    }

    public void prepareData(RKManager sm) {
        createHeaderRows();
        createTableHeaderRows();
        createSheetRows(sm);
        drawExcelData(sm);
    }

    private void drawExcelData(RKManager sm) {
        Drawing drawing = this.sheet.createDrawingPatriarch();
        Chart chart = drawing.createChart( drawing.createAnchor(0, 0, 0, 0, 7, 3, 25, 20) );
        ChartLegend legend = chart.getOrCreateLegend();
        legend.setPosition(LegendPosition.RIGHT);
        LineChartData data = chart.getChartDataFactory().createLineChartData();
        ChartAxis bottomAxis = chart.getChartAxisFactory().createCategoryAxis(AxisPosition.BOTTOM);
        ValueAxis leftAxis = chart.getChartAxisFactory().createValueAxis(AxisPosition.LEFT);
        leftAxis.setCrosses(AxisCrosses.AUTO_ZERO);
        LineChartSeries series1 = data.addSeries(
                DataSources.fromNumericCellRange(sheet, new CellRangeAddress(2, sm.getRungeKuttaCalculations().size() + this.SHIFT - 1, 0, 0)),
                DataSources.fromNumericCellRange(sheet, new CellRangeAddress(2, sm.getRungeKuttaCalculations().size() + this.SHIFT - 1, 1, 1))
        );
        series1.setTitle(this.RK_NAME);
        /*LineChartSeries series2 = data.addSeries(
                DataSources.fromNumericCellRange(sheet, new CellRangeAddress(2, sm.getFunc().size() + this.SHIFT - 1, 3, 3)),
                DataSources.fromNumericCellRange(sheet, new CellRangeAddress(2, sm.getFunc().size() + this.SHIFT - 1, 4, 4))
        );
        series2.setTitle(this.FUNC_NAME);*/ //TODO when func calculations come
        chart.plot(data, bottomAxis, leftAxis);
        XSSFChart xssfChart = (XSSFChart) chart;
        CTPlotArea plotArea = xssfChart.getCTChart().getPlotArea();
        plotArea.getLineChartArray()[0].getSmooth();
        CTBoolean ctBool = CTBoolean.Factory.newInstance();
        ctBool.setVal(false);
        plotArea.getLineChartArray()[0].setSmooth(ctBool);
        for (CTLineSer ser : plotArea.getLineChartArray()[0].getSerArray()) {
            ser.setSmooth(ctBool);
        }
    }

}
