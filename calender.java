/****************************************************************
* calender.java
* Author: Himanshu Sharma
* Contact: 9818805401hs@gmail.com
* Discription : In this program you can check the calender of any year after 1972.
*				You have to Enter Year and Month of your choice.
* 
/******************************************************************/

import java.util.Scanner;
class calender
{	
	public String month_name=new String();
	
	/*used to Calcution and display calender*/
	public void display()
	{	
		Scanner sc=new Scanner(System.in);

		int left,user_year,start_year,day=1,r=0,leap_y=0,i=0,month,last_day,first_day;
		
		start_year=1973;
		
		System.out.println("  *Instruction :- This program will give you calender of any year after 1972");

		//enter year to check calender
		System.out.println("\nEnter year: ");
		user_year=sc.nextInt();

		if(start_year>user_year)
		{
			left=start_year-user_year;
		}
		else
		{
			left=user_year-start_year;
		}

		//counting number of leap year
		for(i=start_year;i<user_year;i++)
		{
			if(i%4==0)
			{	if(user_year==1000 || user_year==2000 || user_year==3000 || user_year==4000 || user_year==5000 )
				{
					if(user_year%4==0 && user_year%400==0)	
						leap_y=leap_y+1;
				}
				else
				leap_y=leap_y+1;
			
			}
		}
		left=left+leap_y;
		r=left%7;
		r=r+1;
		

		System.out.println("Enter month(1-12): ");
		month=sc.nextInt();
		
		if(user_year%4==0)
		{	if(user_year==1000 || user_year==2000 || user_year==3000 || user_year==4000 || user_year==5000 )
			{	if(user_year%400==0)
				{
					first_day=29;
					last_day=29;
				}
				else
				{
					first_day=28;	
					last_day=28;
				}
			}
			else
			{
				first_day=29;			
				last_day=29;
			}
		}	
		else
		{
			first_day=28;
			last_day=28;
		}

		/*used to get the month name*/
		switch(month)
		{	case 1:
				month_name="JANUARY";
				last_day=31;

			break;
			case 2:
				r=r+31;r=r%7;month_name="FEBRUARY";
			break;
			case 3:
				r=r+first_day+31;r=r%7;
				month_name="MARCH";
				last_day=31;
			break;
			case 4:
				r=r+(31*2)+first_day;r=r%7;
				month_name="APRIL";
				last_day=30;
				break;
			case 5:r=r+30+first_day+(31*2);r=r%7;month_name="MAY";last_day=31;break;
			case 6:r=r+30+first_day+(31*3);r=r%7;month_name="JUNE";last_day=30;break;
			case 7:r=r+(30*2)+first_day+(31*3);r=r%7;month_name="JULY";last_day=31;break;
			case 8:r=r+(30*2)+first_day+(31*4);r=r%7;month_name="AUGUST";last_day=31;break;
			case 9:r=r+(30*2)+first_day+(31*5);r=r%7;month_name="SEPTEMBER";last_day=30;break;
			case 10:r=r+(30*3)+first_day+(31*5);r=r%7;month_name="OCTOBER";last_day=31;break;
			case 11:r=r+(30*3)+first_day+(31*6);r=r%7;month_name="NOVEMBER";last_day=30;break;
			case 12:r=r+(30*4)+first_day+(31*6);r=r%7;month_name="DECEMBER";last_day=31;break;
			default:System.out.println("\n\t*******Wrong Input*******");System.exit(0);break;
		}

		/*printing calender*/
		System.out.println("\t\t\t\t"+month_name+" "+user_year+"\n");
		if(user_year>3000)
		{	
			r=r-1;
		}
		print_cal(r,last_day);


	}

	/*printing dates*/
	public void print_cal(int r,int last_day)
	{

		int i=0,day=1;

		System.out.println("\tSun\tMon\tTue\tWed\tThu\tFri\tSat\n\n");	

		
		while(i<r)
		{
				System.out.print("\t*");
				i++;
		}	
		for(i=r;i<7;i++)
		{
			System.out.print("\t"+day);
			day++;
		}

		while(day<=last_day)
		{
			System.out.println();
			for(i=1;i<=7;i++)
			{	if(day==last_day+1)
				{
						break;
				}
				System.out.print("\t"+day);
				day++;
				
			}
		}
			
			System.out.println("\n\n\t***********************************************************");	

			


	}
	
	
}
class main
{
	public static void main(String args[])
	{
		calender obj=new calender();

			obj.display();
	}

}