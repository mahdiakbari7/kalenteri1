package kalenteri;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class kalenteri 
{

	public static void main(String[] args)
	{
		Scanner scn = new Scanner (System.in);
		System.out.println("Anna vuosi : ");
		int selectedYear = scn.nextInt();
		System.out.println("Anna kuukausi : ");
		int selectMonth = scn.nextInt()-1; // April
		
		Calendar cal = new GregprianCalendar();
		int cDay = cal.get(Calendar.DATE);
		int cMonth = cal.get(Calendar.MONTH);
		int cYear = cal.get(Calendar.YEAR);
		
		GregorianCalendar gCal = new GregorianCalendar(selectedYear, selectMonth, 1);
		int days = gCal.getActualMaximum(Calendar.DATE);
		int startInWeek = gCal.get(Calendar.DAY_OF_WEEK);
		
		gCal = new GregorianCalendar(selectedYear, selectMonth,days);
		int totalweeks = gCal.getActualMaximum(Calendar.WEEK_OF_MONTH);
		
		int count = 1; // count the days¨
		String [] months = {"Tammikuu","Helmikuu","Maaliskuu","Huhtikuu","Toukokuu","Kesäkuu","Heinäkuu","Elokuu","Syyskyy","Lokakuu","Marraskuu","Joulukuu"};
		System.err.println(months[selectMonth]+"-"+selectedYear);
		System.out.println();
		System.out.print("SU MA TI KE TO PER LA ");
		for (int i = 1; i <= totalweeks; i++)
		{
			System.out.println(); // to next line
			for (int j =1; j <= 7; j++) 
			{
				if (count < startInWeek || (count - startInWeek + 1)> 31)
				{
					System.out.print("__");
					System.out.print(" ");
				}
				else
				{
					if(cDay == (count - startInWeek + 1)
							&& cMonth == selectMonth  
							&& cYear == selectedYear)
					{
					System.out.print("'"+getDay(count - startInWeek + 1)+"'");
					System.out.print(" ");
					}
					else
					{
						System.out.print(getDay(count - startInWeek + 1));
						System.out.print(" ");
					}
				}
				count++;
			}
		}
		
	}
	private static String getDay(int i) 
	{
		String sDate = Integer.toString(i);
		if (sDate.length()== 1)
		{
			sDate = "0"+sDate;
			return sDate;
		}
		return sDate;
	}

}
