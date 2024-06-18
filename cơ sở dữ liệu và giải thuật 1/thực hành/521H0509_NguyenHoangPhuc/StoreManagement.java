import java.io.*;
import java.util.*;

public class StoreManagement {
    private ArrayList<Staff> staffs;
    private ArrayList<String> workingTime;
    private ArrayList<Invoice> invoices;
    private ArrayList<InvoiceDetails> invoiceDetails;
    private ArrayList<Drink> drinks;

    public StoreManagement(String staffPath, String workingTimePath, String invoicesPath, String detailsPath, String drinksPath) {
        this.staffs = loadStaffs(staffPath);
        this.workingTime = loadFile(workingTimePath);
        this.invoices = loadInvoices(invoicesPath);
        this.invoiceDetails = loadInvoicesDetails(detailsPath);
        this.drinks = loadDrinks(drinksPath);
    }

    public ArrayList<Staff> getStaffs() {
        return this.staffs;
    }

    public void setStaffs(ArrayList<Staff> staffs){
        this.staffs = staffs;
    }
    
    public ArrayList<Drink> loadDrinks(String filePath) {
        ArrayList<Drink> drinksResult = new ArrayList<Drink>();
        ArrayList<String> drinks = loadFile(filePath);

        for (String drink : drinks) {
            String[] information = drink.split(",");
            drinksResult.add(new Drink(information[0], Integer.parseInt(information[1])));
        }

        return drinksResult;
    }

    public ArrayList<Invoice> loadInvoices(String filePath) {
        ArrayList<Invoice> invoiceResult = new ArrayList<Invoice>();
        ArrayList<String> invoices = loadFile(filePath);

        for (String invoice : invoices) {
            String[] information = invoice.split(",");
            invoiceResult.add(new Invoice(information[0], information[1], information[2]));
        }

        return invoiceResult;
    }

    public ArrayList<InvoiceDetails> loadInvoicesDetails(String filePath) {
        ArrayList<InvoiceDetails> invoiceResult = new ArrayList<InvoiceDetails>();
        ArrayList<String> invoices = loadFile(filePath);

        for (String invoice : invoices) {
            String[] information = invoice.split(",");
            invoiceResult.add(new InvoiceDetails(information[0], information[1],Integer.parseInt(information[2])));

        }

        return invoiceResult;
    }

    // requirement 1
    public ArrayList<Staff> loadStaffs(String filePath) {
        
        ArrayList<Staff> invoiceResult = new ArrayList<Staff>();
        ArrayList<String> invoices = loadFile(filePath);

        for (String invoice : invoices) {
            String[] information = invoice.split(",");
            if(information.length ==5  )
                invoiceResult.add(new Manager(information[0], information[1],Integer.parseInt(information[2]),Double.parseDouble(information[3]), Integer.parseInt(information[4])));
            else if(information.length ==4 )
                invoiceResult.add(new FullTimeStaff(information[0], information[1],Integer.parseInt(information[2]),Double.parseDouble(information[3])));
            else 
                invoiceResult.add(new SeasonalStaff(information[0], information[1],Integer.parseInt(information[2])));

       }
        return invoiceResult;
    }

    // requirement 2
    public ArrayList<SeasonalStaff> getTopFiveSeasonalStaffsHighSalary() {
        ArrayList<SeasonalStaff> sesonal = new ArrayList<SeasonalStaff>() ;
       for (Staff tmp : staffs) {
            String[] information = tmp.toString().split("_");
            if (information.length==3)
            {
                
                sesonal.add(new SeasonalStaff(information[0], information[1],Integer.parseInt(information[2])));
            }
        }
        ArrayList<Double> contractValue = new ArrayList<Double>(); 
        for (SeasonalStaff workS :sesonal ) {
            for(String workT : workingTime )
            {
                
                String[] information = workT.toString().split(",");  
                if(workS.getsID().equals(information[0])) 
                    contractValue.add(workS.paySalary(Integer.parseInt(information[1])));
            }
        }
        for (int i = 0; i < contractValue.size(); i++) {
 
            
            for (int j = i + 1; j < contractValue.size(); j++) {
 
                
                double temp = 0;
                
                if (contractValue.get(j) > contractValue.get(i)) {
 
                    // Swapping
                      Collections.swap(contractValue, i, j);
                      Collections.swap(sesonal,i,j);
                }
            }
        }
    sesonal.subList(5, sesonal.size()).clear();
    return sesonal;
    }           
    // requirement 3
    public ArrayList<FullTimeStaff> getFullTimeStaffsHaveSalaryGreaterThan(int lowerBound) {
        ArrayList<FullTimeStaff> fullStaff= new ArrayList<FullTimeStaff>() ;
        for (Staff tmp : staffs) {
            String[] information = tmp.toString().split("_");
            if (information.length ==4)
            {
                
                fullStaff.add(new FullTimeStaff(information[0], information[1],Integer.parseInt(information[3]),Double.parseDouble(information[2])));
            }
            else if (information.length ==5)
            {
                fullStaff.add(new Manager(information[0], information[1],Integer.parseInt(information[3]),Double.parseDouble(information[2]), Integer.parseInt(information[4])));
            }
        }

        ArrayList<Double> contractValue = new ArrayList<Double>(); 
        for (FullTimeStaff workS :fullStaff ) {
            for(String workT : workingTime )
            {
                
                String[] information = workT.toString().split(",");  
                if(workS.getsID().equals(information[0])) 
                    contractValue.add(workS.paySalary(Integer.parseInt(information[1])));
            }
        }
        for(int i =0 ; i<fullStaff.size(); i++)
        {
            if(contractValue.get(i)< lowerBound)
            {   
                contractValue.remove(i);
                fullStaff.remove(i);
                i-- ;
            }
        }
        return  fullStaff;
    }

    // requirement 4
    public Double totalInQuarter(int quarter) {
        double total = 0;
        ArrayList<Invoice> invoc = new ArrayList<Invoice>() ;
        for(Invoice del  : invoices)
        {  
            String[] information =  del.getDate().split("/");
            if(quarter ==1 && ( Integer.parseInt(information[1])==1 ||Integer.parseInt(information[1])==2  || Integer.parseInt(information[1])==3)  )
                invoc.add(del);
            if(quarter ==2 && ( Integer.parseInt(information[1])==4 ||Integer.parseInt(information[1])==5 || Integer.parseInt(information[1])==6)  )
                invoc.add(del);
            if(quarter ==3 && ( Integer.parseInt(information[1])==7 ||Integer.parseInt(information[1])==8  || Integer.parseInt(information[1])==9)  )
                invoc.add(del);
            if(quarter ==4 && ( Integer.parseInt(information[1])==10 ||Integer.parseInt(information[1])==11  || Integer.parseInt(information[1])==12)  )
                invoc.add(del);
        }
        for(Invoice de2  : invoc)
        {  
            for(InvoiceDetails det3 : invoiceDetails)
            {
                if(de2.getInvoiceID().equals(det3.getInvoiceID()))
                    {
                        for(Drink di  : drinks )
                        {
                            if(det3.getDName().equals(di.getdName()))
                                total += det3.getAmount() * di.getPrice();
                        }
                    }
            }
        }
        return total ;
    }

    // requirement 5
    public Staff  getStaffHighestBillInMonth(int month) {
        Staff maxStaff = null;
        double total = 0;
        ArrayList<Invoice> invoc = new ArrayList<Invoice>() ;
        for(Invoice del  : invoices)
        {  
            String[] information =  del.getDate().split("/");
            if(Integer.parseInt(information[1])==month)
            {
                invoc.add(del);
            }
        }
        ArrayList<Staff> thestaff = new ArrayList<Staff>() ;
        for(Invoice  peo  : invoc)
        {  
            for(Staff peo1 : staffs )
            {
                if(thestaff.contains(peo1))
                {
                    continue ;
                }
                else if (peo.getStaffID().equals(peo1.getsID()))
                {
                     thestaff.add(peo1);
                }
            }
        }
        ArrayList <Double> moneyId = new ArrayList<Double>(); 
        for(Staff peo1 : thestaff)
        {   
            total=0;
            for(Invoice de2  : invoc)
            {  if(peo1.getsID().equals(de2.getStaffID()))
                for(InvoiceDetails det3 : invoiceDetails)
                {
                    if(de2.getInvoiceID().equals(det3.getInvoiceID()))
                        {
                            for(Drink di  : drinks )
                            {
                                if(det3.getDName().equals(di.getdName()))
                                    total += det3.getAmount() * di.getPrice();
                            }
                        }
                }
            }
            moneyId.add(total);
        }
        double max =0 ;
        for(int i =0 ; i<thestaff.size();i++)
        {
            if(moneyId.get(i)>max)
            {
                max = moneyId.get(i);
                maxStaff= thestaff.get(i);
            }
        }
        return  maxStaff;
    }

    // load file as list
    public static ArrayList<String> loadFile(String filePath) {
        String data = "";
        ArrayList<String> list = new ArrayList<String>();

        try {
            FileReader reader = new FileReader(filePath);
            BufferedReader fReader = new BufferedReader(reader);

            while ((data = fReader.readLine()) != null) {
                list.add(data);
            }

            fReader.close();
            reader.close();

        } catch (Exception e) {
            System.out.println("Cannot load file");
        }
        return list;
    }

    public void displayStaffs() {
        for (Staff staff : this.staffs) {
            System.out.println(staff);
        }
    }

    public <E> boolean writeFile(String path, ArrayList<E> list) {
        try {
            FileWriter writer = new FileWriter(path);
            for (E tmp : list) {
                writer.write(tmp.toString());
                writer.write("\r\n");
            }

            writer.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("Error.");
            return false;
        }

        return true;
    }

    public <E> boolean writeFile(String path, E object) {
        try {
            FileWriter writer = new FileWriter(path);

            writer.write(object.toString());
            writer.close();

            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("Error.");
            return false;
        }

        return true;
    }
}