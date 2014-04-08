package utils;

import org.testng.Reporter;

public class ReportUtil extends Util {

	private static long start;
	private static String name;

	public void startLog(String functionName) {
		name = functionName;
		// Get the Start Time
		long startTime = System.currentTimeMillis();
		start = startTime;
		Reporter.log("<tr><td> Start - " + name + "<td>"  + start + "</td> </td>");
	}

	public void addLog(String item) {

		// Get the Start Time
		long itemTime = System.currentTimeMillis();

		// Measure total time
		long itemTotalTime = (itemTime - start) / 1000;
		Reporter.log("<td>  - " + item +  itemTotalTime + " </td>");
	}

	public void stopLog() {
		long endTime = System.currentTimeMillis();

		// Measure total time
		long totalTime = (endTime - start) / 1000;

		// cutom display of times in the html report
		Reporter.log("<td> end- " + name + "<td>" +  endTime + " </td></td>");
		Reporter.log("<td>Total Time " + totalTime + " </td></tr>");
	//	Reporter.log("</tr></table>");
	}

	public void endLog() {
		Reporter.log("</tr>");
		Reporter.log("</table>");
	}

}
