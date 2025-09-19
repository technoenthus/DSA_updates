class Spreadsheet {
private int[][] grid;

    public Spreadsheet(int rows) {
        grid=new int[rows][26];
    }

    public void setCell(String cell,int value) {
        grid[Integer.parseInt(cell.substring(1))-1][cell.charAt(0)-'A']=value;
    }

    public void resetCell(String cell) {
        grid[Integer.parseInt(cell.substring(1))-1][cell.charAt(0)-'A']=0;
    }

    public int getValue(String formula) {
        String[] parts=formula.substring(1).split("\\+");
        int sum=0;
        for(String part:parts){
            if(Character.isLetter(part.charAt(0))){
                sum+=grid[Integer.parseInt(part.substring(1))-1][part.charAt(0)-'A'];
            }else{
                sum+=Integer.parseInt(part);
            }
        }
        return sum;}
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */