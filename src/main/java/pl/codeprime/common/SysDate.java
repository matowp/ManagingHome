/**
 * 
 */
package pl.codeprime.common;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author MOwsians
 *
 */
public class SysDate {
	
	public static SysDate create(String dateAsString) {
		return  new SysDate(dateAsString);
	}
	
	private String dateAsString;
	private String formatAsString = "yyyy-MM-dd HH:mm:ss";
	private Date date;
	private LocalDateTime localDateTime;
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatAsString);
	private Date nowDate;
	private LocalDateTime nowLocalDateTime;
	
	
	protected SysDate(String dateAsString) {
		this.dateAsString = dateAsString;
		convertDate();
		date = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
		nowDate = new Date();
		nowLocalDateTime = LocalDateTime.now();
	}
	
	private void convertDate() {
		
		try {
			
			localDateTime = LocalDateTime.parse(dateAsString, formatter);
			
		}catch(java.time.DateTimeException e) {
			
			dateAsString+=" 00:00:00";
			localDateTime = LocalDateTime.parse(dateAsString, formatter);
		}
		
	}
	
	public String getFormatAsString() {
		return formatAsString;
	}
	public void setFormatAsString(String formatAsString) {
		this.formatAsString = formatAsString;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}
	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}
	public DateTimeFormatter getFormatter() {
		return formatter;
	}
	public void setFormatter(DateTimeFormatter formatter) {
		this.formatter = formatter;
	}
	public Date getNowDate() {
		return nowDate;
	}
	public void setNowDate(Date nowDate) {
		this.nowDate = nowDate;
	}
	public LocalDateTime getNowLocalDateTime() {
		return nowLocalDateTime;
	}
	public void setNowLocalDateTime(LocalDateTime nowLocalDateTime) {
		this.nowLocalDateTime = nowLocalDateTime;
	}
	public String getDateAsString() {
		return dateAsString;
	}
	
}
