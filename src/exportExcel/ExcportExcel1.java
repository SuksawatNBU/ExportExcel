package exportExcel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;

import entity.RoomBooking;

public class ExcportExcel1 {
	
	static RoomBooking roomBooking;
	static List<RoomBooking> roomBookings;
	static HashMap<String,String> typeRooms;
	
	public static void addRoomBooking(){
		
		List<RoomBooking> rBookings = new ArrayList<RoomBooking>();
		
		for(int i=1 ; i <= 4 ; i++){	
			RoomBooking rBooking = new RoomBooking();
			if(i <= 2){
				rBooking.setName("ห้องประชุม 1");
				rBooking.setSubject("Angular");
				rBooking.setStartDate("11-03-2561");
				rBooking.setStartTime("11.00");
				rBooking.setCreateUserName("สุขสวัสดิ์");
				rBooking.setUserBookName("พี่โอ๋");
				
			}else{
				rBooking.setName("ห้องประชุม 2");
				rBooking.setSubject("Java");
				rBooking.setStartDate("12-05-2561");
				rBooking.setStartTime("09.00");
				rBooking.setCreateUserName("สุขสวัสดิ์");
				rBooking.setUserBookName("พี่เต๋า");
				rBookings.add(rBooking);
			}
			rBookings.add(rBooking);
		}
		roomBookings = rBookings;
	}
	
	
	public static void exportExcel(){
		// Create Excel -----------------------------------------------------------------
		XSSFWorkbook workbook = new XSSFWorkbook(); 
		XSSFSheet spreadsheet = workbook.createSheet("รายงานการใช้งานห้องประชุม");
		XSSFRow row;
		XSSFCell cell;
			    
		// Setting Page --------------------------------------------------------------------
		spreadsheet.getPrintSetup().setPaperSize(XSSFPrintSetup.A4_PAPERSIZE);
		spreadsheet.getPrintSetup().setLandscape(true);
		spreadsheet.setMargin(Sheet.TopMargin, 0.5);
		spreadsheet.setMargin(Sheet.BottomMargin, 0.5);
		spreadsheet.setMargin(Sheet.RightMargin, 0.25);
		spreadsheet.setMargin(Sheet.LeftMargin, 0.25);
		spreadsheet.setMargin(Sheet.HeaderMargin, 0);
		spreadsheet.setMargin(Sheet.FooterMargin, 0);
			    
			    //[1] หัวเรื่อง ------------------------------------------------------------------------------
			    row = spreadsheet.createRow((short) 0);
			    cell = (XSSFCell) row.createCell((short) 0);
			    /* Merge Cell */
			    spreadsheet.addMergedRegion( 
			    	new CellRangeAddress(
			    		0, //first row
			            0, //last row
			            0, //first column
			            6 //last column
			    	)
			    );
			    /* Style */
			    XSSFFont fontTitle = workbook.createFont();
			      fontTitle.setFontHeightInPoints((short) 20);
			      fontTitle.setFontName("TH SarabunPSK");
			      fontTitle.setBold(true);
			    XSSFCellStyle styleTitle = workbook.createCellStyle();
//			      styleTitle.setAlignment(XSSFCellStyle.ALIGN_CENTER);
//			      styleTitle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
			      styleTitle.setFont(fontTitle);
			    /* Value */
			    cell.setCellValue("รายงานการใช้งานห้องประชุม");
			    cell.setCellStyle(styleTitle);
			    
			    //[2] ประจำวันที่  -----------------------------------------------------------------------------
			    row = spreadsheet.createRow((short) 1);
			    cell = (XSSFCell) row.createCell((short) 2);
			    /* Merge Cell */
			    spreadsheet.addMergedRegion( 
			    	new CellRangeAddress(
			    		1, //first row
			            1, //last row
			            2, //first column
			            4 //last column
			    	)
			    );
			    /* Style */
			    XSSFFont fontDate = workbook.createFont();
			      fontDate.setFontHeightInPoints((short) 18);
			      fontDate.setFontName("TH SarabunPSK");
			      fontDate.setBold(true);
			    XSSFCellStyle styleDate = workbook.createCellStyle();
			      styleDate.setFont(fontDate);
			    /* Value */
			    cell.setCellValue("ประจำวันที่");
			    cell.setCellStyle(styleDate);
			    
			    //[3] row ที่ว่าง  -----------------------------------------------------------------------------
			    row = spreadsheet.createRow((short) 2);
			    cell = (XSSFCell) row.createCell((short) 0);
			    /* Style */
			    XSSFFont fontNull = workbook.createFont();
			      fontNull.setFontHeightInPoints((short) 16);
			      fontNull.setFontName("TH SarabunPSK");
			    XSSFCellStyle styleNull = workbook.createCellStyle();
			      styleNull.setFont(fontNull);
			    /* วนลูปเพื่อให้ทุกช่องเป็น font TH SarabunPSK */
			    for(int j=0 ; j < 7 ; j++){
			    	cell = (XSSFCell) row.createCell((short) j);
			    	cell.setCellStyle(styleNull);
			    }
			    
			    //[4] วันที่พิมพ์  -----------------------------------------------------------------------------
			    row = spreadsheet.createRow((short) 3);
			    cell = (XSSFCell) row.createCell((short) 0);
			    /* Style */
			    XSSFFont fontPrintDate = workbook.createFont();
			      fontPrintDate.setFontHeightInPoints((short) 16);
			      fontPrintDate.setFontName("TH SarabunPSK");
			      fontPrintDate.setBold(true);
			    XSSFCellStyle stylePrintDate = workbook.createCellStyle();
			      stylePrintDate.setFont(fontPrintDate);
			    XSSFCellStyle stylePrintDate2 = workbook.createCellStyle();
//			      stylePrintDate2.setAlignment(XSSFCellStyle.ALIGN_RIGHT);
			      stylePrintDate2.setFont(fontPrintDate);
			    /* Date */
			    Calendar c = Calendar.getInstance();
			    SimpleDateFormat df = new SimpleDateFormat("dd-MM-yy");
			    String currentDate = df.format(c.getTime());
			    /* Value */
			    cell.setCellValue("วันที่พิมพ์ : " + currentDate);
			    cell.setCellStyle(stylePrintDate);
			    
			    cell = (XSSFCell) row.createCell((short) 6);
			    cell.setCellValue("ผู้พิมพ์ : ");
			    cell.setCellStyle(stylePrintDate2);
			    
			    //[5] หัวตาราง ---------------------------------------------------------------------------------
			    row = spreadsheet.createRow((short) 4);
			    /* Cell Width */
			    spreadsheet.setColumnWidth(0, 2801);
			    spreadsheet.setColumnWidth(1, 7002);
			    spreadsheet.setColumnWidth(2, 4201);
			    spreadsheet.setColumnWidth(3, 5602);
			    spreadsheet.setColumnWidth(4, 5602);
			    spreadsheet.setColumnWidth(5, 5602);
			    spreadsheet.setColumnWidth(6, 5602);
			    /* Font */
			    XSSFFont fontHead = workbook.createFont();
			    fontHead.setFontName("TH SarabunPSK");
			    fontHead.setFontHeightInPoints((short) 16);
			    fontHead.setBold(true);
			    byte uline = 1;
			    fontHead.setUnderline(uline);
			    /* Style */
			    XSSFCellStyle styleHead = workbook.createCellStyle();
//			    styleHead.setAlignment(XSSFCellStyle.ALIGN_CENTER);
//			    styleHead.setBorderTop(XSSFCellStyle.BORDER_THIN);
//			    styleHead.setBorderBottom(XSSFCellStyle.BORDER_DOUBLE);
//			    styleHead.setBorderLeft(XSSFCellStyle.BORDER_THIN);
//			    styleHead.setBorderRight(XSSFCellStyle.BORDER_THIN);
			    
			    styleHead.setFont(fontHead);
			    
			    cell = (XSSFCell) row.createCell((short) 0);
			    cell.setCellValue("ลำดับ");
			    cell.setCellStyle(styleHead);
			    
			    cell = (XSSFCell) row.createCell((short) 1);
			    cell.setCellValue("ห้อง");
			    cell.setCellStyle(styleHead);
			    
			    cell = (XSSFCell) row.createCell((short) 2);
			    cell.setCellValue("วัน");
			    cell.setCellStyle(styleHead);
			    
			    cell = (XSSFCell) row.createCell((short) 3);
			    cell.setCellValue("เวลา");
			    cell.setCellStyle(styleHead);
			    
			    cell = (XSSFCell) row.createCell((short) 4);
			    cell.setCellValue("ชั่วโมงใช้งาน");
			    cell.setCellStyle(styleHead);
			    
			    cell = (XSSFCell) row.createCell((short) 5);
			    cell.setCellValue("ผู้ขอใช้");
			    cell.setCellStyle(styleHead);
			    
			    cell = (XSSFCell) row.createCell((short) 6);
			    cell.setCellValue("ผู้แจ้ง");
			    cell.setCellStyle(styleHead);
			    
			    // ข้อมูล ----------------------------------------------------------------------------
				int i = 5;
			    Iterator<String> Vmap = typeRooms.keySet().iterator();
				while(Vmap.hasNext()){
					String key = (String)(Vmap.next());  // Key
					String val = typeRooms.get(key); // Value
					int j = 0 ;
					for(RoomBooking rBooking : roomBookings){
						if(val == rBooking.getName()){
							
							j += 1;
							row = spreadsheet.createRow((short) i);
							
							if(j < 2){
								cell = (XSSFCell) row.createCell((short) 0);
							    cell.setCellValue(i - 4);
							    
							    cell = (XSSFCell) row.createCell((short) 1);
							    cell.setCellValue(val);
							}
							
						    cell = (XSSFCell) row.createCell((short) 2);
						    cell.setCellValue(rBooking.getStartDate());
						    
						    cell = (XSSFCell) row.createCell((short) 3);
						    cell.setCellValue(rBooking.getStartTime());
						    
						    cell = (XSSFCell) row.createCell((short) 4);
						    cell.setCellValue("ชั่วโมงใช้งาน");
						    
						    cell = (XSSFCell) row.createCell((short) 5);
						    cell.setCellValue(rBooking.getCreateUserName());
						    
						    cell = (XSSFCell) row.createCell((short) 6);
						    cell.setCellValue(rBooking.getUserBookName());
						}
					}
					i++;
				}
			    
			    // OutPut ----------------------------------------------------------------------------
			    FileOutputStream output = null;
			    try {
			    	output = new FileOutputStream(new File("C:\\Users\\Suksawat\\Desktop\\MRBDEV.xlsx"));
			    	workbook.write(output);
			    }
			    catch (IOException e) {
			    	e.printStackTrace();
			    }
			    finally {
			    	if (output != null) {
			    		try {
			    			output.close();
			    		}catch (IOException e) {
			    			 e.printStackTrace();
			    		}
			    	}
			    }
	}

	public static void main(String[] args) {
		
		// Add Data
		addRoomBooking();
		
		// แยกประเภทห้อง
		typeRooms = new HashMap<String, String>();
		String newType = null;
		int i = 1;
		for(RoomBooking rBooking : roomBookings){
			newType = rBooking.getName();	
			
			if(typeRooms.size() == 0){
				typeRooms.put(String.valueOf(i) , newType);
				System.out.println("typeRooms == 0");
			}else{
				System.out.println("typeRooms != 0");
				boolean num = false;
				
				Iterator<String> Vmap = typeRooms.keySet().iterator();
				while(Vmap.hasNext()){
					String key = (String)(Vmap.next());  // Key
					String val = typeRooms.get(key); // Value

					if(newType == val || val.endsWith(newType)){
						num = true;
					}
				}
				if(num == false){
					typeRooms.put(String.valueOf(i) , newType);
				}
			}
			i++;
		}
		Iterator<String> Vmap = typeRooms.keySet().iterator();
		while(Vmap.hasNext()){
			String key = (String)(Vmap.next());  // Key
			String val = typeRooms.get(key); // Value
			System.out.println("ห้องประชุม --> " + val);
		}
		
		exportExcel();
		
		
		

	}

}
