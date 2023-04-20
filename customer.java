




public class customer {
    String name;
    int orderID;
    String memberID;
    int memberType;
    
    public customer( String name,int orderID,String memberID, int memberType){
        this.name = name;
        this.orderID = orderID;
        this.memberID=memberID;
        this.memberType = memberType;
    }
    public String toString(){
        return "Order ID:" + orderID + " Name:"+name+"\n";
    }
}
