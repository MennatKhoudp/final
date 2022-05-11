public class McImage {
    
    String mcImageFileName;
    //BufferedImage mcImage;
    Location mcTopLeftLoc;
    int mcRows;
    int mcCols;
    
    public McImage(String mcImageFileName, Location mcTopLeftLoc, int mcRows, int mcCols){
        this.mcImageFileName = mcImageFileName;
        this.mcTopLeftLoc = mcTopLeftLoc;
        this.mcRows = mcRows;
        this.mcCols = mcCols;
    }
    
    public String getMcImageFileName(){
        return mcImageFileName;
    }

    public Location getMcTopLeftLoc(){
        return mcTopLeftLoc;
    }

    public int getMcRows(){
        return mcRows;
    }

    public int getMcCols(){
        return mcCols;
    }


}