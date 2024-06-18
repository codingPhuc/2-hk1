public  class Manager extends FullTimeStaff {
    private int allowance ;
    public Manager(String sID, String sName,int baseSalary , double bonusRate, int allowance) {
        super(sID,sName,baseSalary,bonusRate); 
        this.allowance = allowance ;
        
    }
    public int getAllowance()
    {
        return this.allowance ;
    }
    
    @Override
    public String toString()
    {
        return  super.sID + "_" + super.sName+ "_" + super.bonusRate + "_" + super.baseSalary+ "_" + this.allowance; 
    }  
    public double paySalary(int workedDay)
    {   
        
        return super.paySalary(workedDay) + allowance ;
        
    }  
}