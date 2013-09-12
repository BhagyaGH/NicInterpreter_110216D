package maven.nic;

import java.util.Calendar;
import java.util.Date;

public class NicCalc {
    
    private String nic;
    private int year;
    private int month;
    private int day;
    private int numDays;
    private boolean isMale;
    private boolean isVoter;
    private int age;
    private Calendar c;

    public NicCalc(String nic) throws NicInvalidPropException{
        this.nic = nic;
        
        if(nic.length() > 10 || nic.length() < 9) {
            throw new NicInvalidPropException();
        }
        if(nic.length() == 10 && !(nic.endsWith("v")||nic.endsWith("V"))) {
            throw new NicInvalidPropException();
        }
               
        year = 1900 + Integer.parseInt(nic.substring(0,2));
        numDays = Integer.parseInt(nic.substring(2,5));
        
        if(numDays > 500){
            isMale = false;
            numDays = numDays-500;
        }else{
            isMale = true;
        }
        
        c = Calendar.getInstance();
        c.set(c.DAY_OF_YEAR, numDays);
        month= c.get(c.MONTH)+1;
        day = c.get(c.DATE)-1;
        
        Calendar dob = Calendar.getInstance();
        dob.set(year, month, day);
        Calendar now = Calendar.getInstance();
        now.setTime(new java.util.Date());
        age = (now.get(Calendar.YEAR) - dob.get(Calendar.YEAR));
        int ageMo = (now.get(Calendar.MONTH) - dob.get(Calendar.MONTH));
        if (ageMo < 0) {
            age--;
        }
        
        if(age >= 18) {
            isVoter = true;
        }
        else {
            isVoter = false;
        }
    }
    
    public String getNic() {
        return nic;
    }
    
    public int getYear(){
        return year;
    }
    
    public int getMonth(){
        return month;
    }
    
    public int getDate(){
        return day;
    }
    
    public String getGender(){
        if(isMale){
            return "Male";
        }else{
            return "Female";
        }
    }
    
    public String isVoter(){
        if(isVoter){
            return "Yes";
        }else{
            return "No";
        }
    }
      
}
