public  class order {
    int orderID;
    String type;
    int Nomenu;
    String sizeOfCup;
    double price;
    int num;

    public order(int orderID,String type,int Nomenu,String sizeOfCup,double price,int num) {
        this.orderID = orderID;
        this.type = type;
       this.Nomenu=Nomenu;
        this.sizeOfCup = sizeOfCup;
        this.price = price;
        this.num = num;
    }
    
}
