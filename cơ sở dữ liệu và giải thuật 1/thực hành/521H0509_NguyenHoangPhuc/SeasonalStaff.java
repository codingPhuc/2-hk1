public  class  SeasonalStaff extends Staff {
    private int hourlyWage;

    public SeasonalStaff(String sID, String sName,int hourlyWage) {
        super(sID , sName);
        setHourlyWage(hourlyWage);

    }

    public int getHourlyWage() {
        return hourlyWage;
    }

    public void setHourlyWage(int hourlyWage) {
        this.hourlyWage = hourlyWage;
    }

    public double paySalary(int workedHours)
    {
        return hourlyWage * workedHours;
    }

    @Override
    public String toString() {
        return super.sID + "_" + super.sName+"_"+ this.hourlyWage ;
    }
}