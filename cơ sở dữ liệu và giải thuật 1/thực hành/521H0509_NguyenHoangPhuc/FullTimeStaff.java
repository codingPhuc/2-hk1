public  class FullTimeStaff extends Staff {
    protected int baseSalary ;
    protected double bonusRate ; 
    public FullTimeStaff(String sID, String sName,int baseSalary , double bonusRate) {
        super(sID , sName ); 
        setBaseSalary( baseSalary);
        setBonusRate(bonusRate);
    }
    public int getBaseSalary()
    {
        return this.baseSalary ;
    }
    public double getBonusRate()
    {
        return this.bonusRate ; 
    }
    public void setBonusRate(double bonusRate)
    {
        this.bonusRate = bonusRate ;
    }
    public void setBaseSalary(int baseSalary)
    {
        this.baseSalary= baseSalary ;
    }
    @Override
    public String toString()
    {
        return  super.sID + "_" + super.sName+ "_" + this.bonusRate + "_" + this.baseSalary; 
    }  
    public double paySalary(int workedDay)
    {
        if(workedDay <= 21)
        {
            return baseSalary * bonusRate ;
        }
        return baseSalary* bonusRate + ( workedDay -21)*100000; 
    }  
}